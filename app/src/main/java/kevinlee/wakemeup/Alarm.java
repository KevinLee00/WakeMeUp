package kevinlee.wakemeup;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Alarm {
    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private List<Boolean> daysOfWeek;
    private Date dateCreated;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public List<Boolean> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<Boolean> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}