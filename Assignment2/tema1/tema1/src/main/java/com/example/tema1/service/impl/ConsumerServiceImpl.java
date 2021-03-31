package com.example.tema1.service.impl;

import com.example.tema1.service.ConsumerService;
import com.example.tema1.entity.Activity;
import com.example.tema1.repository.ActivityRepository;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class ConsumerServiceImpl implements ConsumerService {

    private final static String QUEUE_NAME = "hello";
    private final ActivityRepository activityRepository;

    @Autowired
    public ConsumerServiceImpl(ActivityRepository activityRepository)
    {
        this.activityRepository = activityRepository;
    }





@Override
    public  void recieve() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");

            JSONParser parser = new JSONParser();
            JSONObject obj = null;
            try {
                obj = (JSONObject) parser.parse(message);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Long n = (Long)obj.get("patient_id");
            Long st = (Long)obj.get("startTime");
            Long et = (Long)obj.get("endTime");
            String a = (String) obj.get("activityName");


                Date startTime = new Date(st);
                Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
                format.format(startTime);

            Date endTime = new Date(et);
            Format format1 = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
            format.format(endTime);

            Activity ac =new Activity(n,startTime,endTime,a);
            activityRepository.save(ac);


            System.out.println(n + " " + startTime + " " +endTime +" " + a);

            System.out.println("Alerta pentru pacientul Codruta");
            System.out.println("Alerta pentru pacientul Emanuel");
            System.out.println("Alerta pentru pacientul Alexandru");
            System.out.println("Alerta pentru pacientul Mihai");
            System.out.println("Alerta pentru pacientul Cristian");
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });




    }

    public void Anomalus(Activity activity){
        if (activity.getActivityName().equals("Sleeping") && activity.getEndTime().getTime()-activity.getStartTime().getTime()>12L)
            System.out.println("Alerta pentru pacientul Codruta");

        if (activity.getActivityName().equals("Leaving") && activity.getEndTime().getTime()-activity.getStartTime().getTime()>12L)
            System.out.println("Alerta pentru pacientul Emanuel");
        if (activity.getActivityName().equals("Toileting") && activity.getEndTime().getTime()-activity.getStartTime().getTime()>1L)
            System.out.println("Alerta pentru pacientul Alexandru");

    }

   // public void isAnomalus(){


    }

