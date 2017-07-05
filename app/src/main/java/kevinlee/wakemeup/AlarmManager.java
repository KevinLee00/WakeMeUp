package kevinlee.wakemeup;

import java.util.ArrayList;

public class AlarmManager {
    private static ArrayList<Alarm> listOfAlarms = new ArrayList<>();
    public static ClickListener listener;

    public static ArrayList<Alarm> getListOfAlarms() {
        return listOfAlarms;
    }

    public static void addAlarm (Alarm alarm) {
        listOfAlarms.add(alarm);
        listener.datasetChanged();
    }

    public static void deleteAlarm (Alarm alarm) {
        listOfAlarms.remove(alarm);
        listener.datasetChanged();
    }

    public static void setListener(ClickListener cl) {
        listener = cl;
    }
    public interface ClickListener {
        void datasetChanged();
    }
}
