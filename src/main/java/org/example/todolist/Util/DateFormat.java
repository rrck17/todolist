package org.example.todolist.Util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class DateFormat {
    public String formatDate(LocalDateTime modDate) {
        LocalDateTime now = LocalDateTime.now();
        long minutes = ChronoUnit.MINUTES.between(modDate, now);
        long hours = ChronoUnit.HOURS.between(modDate, now);
        long days = ChronoUnit.DAYS.between(modDate, now);
        long months = ChronoUnit.MONTHS.between(modDate, now);
        long years = ChronoUnit.YEARS.between(modDate, now);

        if (minutes < 60) {
            return minutes + "분전 등록";
        } else if (hours < 24) {
            return hours + "시간전 등록";
        } else if (days < 31) {
            return days + "일전 등록";
        } else if (months < 12) {
            return days + "개월전 등록";
        } else {
            return years + "년전 등록";
        }

    }

}
