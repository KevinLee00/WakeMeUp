package kevinlee.wakemeup;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.AlarmViewHolder> {
    private ArrayList<Alarm> alarmsList;

    RVAdapter() {this.alarmsList = kevinlee.wakemeup.AlarmManager.getListOfAlarms(); }
    RVAdapter(ArrayList<Alarm> alarmsList) {
        this.alarmsList = alarmsList;
    }

    public static class AlarmViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        Switch mSwitch;
        TextView exactTime;
        TextView timeOfDay;
        TextView daysOfWeek;

        AlarmViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            mSwitch = (Switch) itemView.findViewById(R.id.toggle);
            exactTime = (TextView) itemView.findViewById(R.id.exactTime);
            timeOfDay = (TextView) itemView.findViewById(R.id.timeOfDay);
            daysOfWeek = (TextView) itemView.findViewById(R.id.daysOfWeek);
        }
    }

    @Override
    public int getItemCount() {
        return alarmsList.size();
    }

    @Override
    public AlarmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.alarm_card, parent, false);
        AlarmViewHolder avh = new AlarmViewHolder(v);
        return avh;
    }

    @Override
    public void onBindViewHolder(AlarmViewHolder holder, int position) {
        Alarm currentAlarm = alarmsList.get(position);
        String time;
        int hour = currentAlarm.getHour();
        int minute = currentAlarm.getMinute();

        if (hour <= 12) {
            holder.timeOfDay.setText("AM");
            if (hour == 0) {
                time = "12:" + new DecimalFormat("00").format(minute);
            }
            else {
                time = Integer.toString(hour) + ":" + new DecimalFormat("00").format(minute);
            }
        }
        else {
            holder.timeOfDay.setText("PM");
            time = Integer.toString(hour - 12) + ":" + new DecimalFormat("00").format(minute);
        }
        holder.exactTime.setText(time);
    }
}
