package kind.support;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Timer {

    private Calendar startTime;
    private Calendar endTime;

    public static Timer newInstance() {
        return new Timer();
    }

    private Timer() {
    }


    public void start() {
        this.startTime = GregorianCalendar.getInstance();
    }


    public long stop() {
        this.endTime = GregorianCalendar.getInstance();
        return getMilliseconds();
    }

    public long getMilliseconds() {
        Nulls.failIfNull(this.endTime, "Time has not finished. Please stop the timer first.");
        return (this.endTime.getTimeInMillis() - this.startTime.getTimeInMillis());
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

}
