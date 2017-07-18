package kevinlee.wakemeup;

import android.media.Ringtone;
import java.util.ArrayList;

// A class containing static values relevant to alarm management

public class AlarmHandler {
    private static ArrayList<Alarm> listOfAlarms = new ArrayList<>();
    private static ClickListener listener;
    public static Ringtone ringtone;


    public static ArrayList<Alarm> getListOfAlarms() {
        return listOfAlarms;
    }

    public static void setListener(ClickListener cl) {
        listener = cl;
    }

    public static void enableAlarm(int index) {
        listOfAlarms.get(index).setEnabled();
    }

    public static void disableAlarm(int index) {
        listOfAlarms.get(index).setDisabled();
    }

    public interface ClickListener {
        void datasetChanged();
    }

    public static void addAlarm (Alarm alarm) {
        listOfAlarms.add(alarm);
        listener.datasetChanged();
    }

    public static void deleteAlarm (Alarm alarm) {
        listOfAlarms.remove(alarm);
        listener.datasetChanged();
    }
}
