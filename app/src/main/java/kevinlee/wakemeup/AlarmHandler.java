package kevinlee.wakemeup;

import java.util.ArrayList;

public class AlarmHandler {
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

    public static void enableAlarm(int index) {
        listOfAlarms.get(index).setEnabled();
//        listener.datasetChanged();
    }

    public static void disableAlarm(int index) {
        listOfAlarms.get(index).setDisabled();
//        listener.datasetChanged();
    }
    public interface ClickListener {
        void datasetChanged();
    }
}
