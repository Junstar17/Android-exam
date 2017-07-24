package org.androidtown.exam8;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by kjy on 2017-07-19.
 */

public class ScheduleItemView extends LinearLayout {

    TextView time;
    TextView title;

    public ScheduleItemView(Context context) {
        super(context);
        init(context);
    }

    public ScheduleItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.schedule,this,true);

        time=(TextView)findViewById(R.id.hourtextView);
        title=(TextView) findViewById(R.id.titletextView2);
    }
    public void setTime(String hours){
        time.setText(hours);
    }
    public void setTitle(String titles){
        title.setText(titles);
    }
}
