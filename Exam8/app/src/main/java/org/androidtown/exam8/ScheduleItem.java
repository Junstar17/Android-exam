package org.androidtown.exam8;

/**
 * Created by kjy on 2017-07-19.
 */

public class ScheduleItem {
    String hour;
    String title;
    String min;



    public ScheduleItem(String title, String hour, String min) {

        this.title = title;
        this.hour=hour;
        this.min=min;

    }


    public String getHour() {
        return hour;
    }

    public String getMin() {
        return min;
    }

    public String getTitle() { return title;    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setMin(String min) {
        this.min = min;
}

    public void setTitle(String title) {
        this.title = title;
    }




}
