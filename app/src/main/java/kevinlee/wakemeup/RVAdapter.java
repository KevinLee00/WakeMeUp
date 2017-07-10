package kevinlee.wakemeup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.AlarmViewHolder> {
    private ArrayList<Alarm> alarmsList = AlarmHandler.getListOfAlarms();
    private static Context context;

    RVAdapter(Context context) {
        this.context = context;
    }

    public static class AlarmViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        Switch mSwitch;
        TextView exactTime;
        TextView timeOfDay;
        TextView daysOfWeek;
        Button button;

        AlarmViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            mSwitch = (Switch) itemView.findViewById(R.id.on_off);
            exactTime = (TextView) itemView.findViewById(R.id.exactTime);
            timeOfDay = (TextView) itemView.findViewById(R.id.timeOfDay);
            daysOfWeek = (TextView) itemView.findViewById(R.id.daysOfWeek);
            button = (Button) itemView.findViewById(R.id.settings);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SettingsActivity.class);
                    context.startActivity(intent);
                }
            });

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
    public void onBindViewHolder(final AlarmViewHolder holder, int position) {
        Alarm currentAlarm = alarmsList.get(position);
        int hour = currentAlarm.getHour();
        int minute = currentAlarm.getMinute();

        String time;
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
        holder.mSwitch.setChecked(currentAlarm.getEnabled());
        holder.mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AlarmHandler.enableAlarm(holder.getAdapterPosition());
                }
                else {
                    AlarmHandler.disableAlarm(holder.getAdapterPosition());
                }
            }
        });
    }
}
