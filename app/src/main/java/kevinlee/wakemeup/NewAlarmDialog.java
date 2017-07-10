package kevinlee.wakemeup;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class NewAlarmDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.new_alarm_dialog, null);
        builder.setView(view);

        final TimePicker tp = (TimePicker) view.findViewById(R.id.timePicker);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Alarm alarm = new Alarm();
                alarm.setHour(tp.getHour());
                alarm.setMinute(tp.getMinute());
                alarm.setEnabled();
                AlarmHandler.addAlarm(alarm);
                Toast.makeText(getActivity(), "Alarm Added", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }
}
