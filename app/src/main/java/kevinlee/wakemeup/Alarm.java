package kevinlee.wakemeup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Alarm {
    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private ArrayList<Boolean> daysOfWeek;
    private Date dateCreated;
    private boolean isEnabled;

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

    public ArrayList<Boolean> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(ArrayList<Boolean> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled() {
        isEnabled = true;
    }

    public void setDisabled() {
        isEnabled = false;
    }

}