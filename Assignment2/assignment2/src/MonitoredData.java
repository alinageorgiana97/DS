

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MonitoredData {
    private Long patient_id;
    private Date startTime;
    private Date endTime;
    private String activityName;
    DateFormat fmt = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
    public MonitoredData(String startTime, String endTime, String activityName) {

        try {
            this.startTime = fmt.parse(startTime);
            this.endTime = fmt.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.activityName = activityName;
    }
    public MonitoredData(){}



    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }
}
