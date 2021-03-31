import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataDecoder {

    private static List<MonitoredData> data = new ArrayList<MonitoredData>();
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] args) throws IOException, TimeoutException {

        read();


    }


    public static void read() throws IOException {
        Stream<String> stream = Files.lines(Paths.get("activity.txt"));
        data = stream
                .map(line -> new MonitoredData(line.substring(0, 19), line.substring(21, 40),
                        line.substring(42, line.length() - 1).trim()))
                .collect(Collectors.toList());

        stream.close();
        data.stream()
                .forEach(System.out::println);
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        Random rand = new Random();



        ObjectMapper Obj = new ObjectMapper();
        for (int i=0; i<data.size();i++){
            try {
                data.get(i).setPatient_id(list.get(rand.nextInt(list.size())));
                String jsonStr = Obj.writeValueAsString(data.get(i));
                System.out.println(jsonStr);
                ConnectionFactory factory = new ConnectionFactory();
                factory.setHost("localhost");
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel(); {
                channel.queueDeclare(QUEUE_NAME, false, false, false, null);
                channel.basicPublish("", QUEUE_NAME, null, jsonStr.getBytes());
                System.out.println(" [x] Sent '" + jsonStr + "'");
            }

        } catch (TimeoutException e) {
                e.printStackTrace();
            }

        }

    }
}


