package com.shile;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Main {
    private static final String INVALID_VALUE_MESSAGE = "invalid value";

    public static void main(String[] args) {
        System.out.println(getDurationString(65,45));
        System.out.println(getDurationString(3945L));
        System.out.println(getDurationString(-41));
        System.out.println(getDurationString(65,9));

    }

    private static String getDurationString(long minutes, long seconds) {
        if ((minutes < 0) || (seconds < 0) || (seconds > 59)) {
            return INVALID_VALUE_MESSAGE;
        }

        long hours = minutes / 60;
        long remainingMinutes = minutes % 60;

        String hourString  = hours + "h";
        if (hours < 10) {
            hourString = "0" + hourString;
        }
        String minutesString  = remainingMinutes + "m";
        if (remainingMinutes < 10) {
            minutesString = "0" + minutesString ;
        }
        String secondsString  = seconds + "s";
        if (seconds < 10) {
            secondsString = "0" + secondsString;
        }

        return hourString + " " + minutesString + " " + secondsString + " ";

    }

    private static String getDurationString(long seconds) {
        if (seconds < 0) {
            return INVALID_VALUE_MESSAGE;
        }
        long minutes = seconds / 60;
        long remainingSeconds = seconds % 60;
        return getDurationString(minutes,remainingSeconds);
    }
}
