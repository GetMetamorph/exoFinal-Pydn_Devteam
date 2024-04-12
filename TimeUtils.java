import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeUtils {

    public static String getElapsedTime(LocalDateTime fromTime) {
        LocalDateTime now = LocalDateTime.now();
        long years = ChronoUnit.YEARS.between(fromTime, now);
        long months = ChronoUnit.MONTHS.between(fromTime, now);
        long weeks = ChronoUnit.WEEKS.between(fromTime, now);
        long days = ChronoUnit.DAYS.between(fromTime, now);
        long hours = ChronoUnit.HOURS.between(fromTime, now);
        long minutes = ChronoUnit.MINUTES.between(fromTime, now);

        if (years > 0) return years + " year" + (years > 1 ? "s" : "");
        else if (months > 0) return months + " month" + (months > 1 ? "s" : "");
        else if (weeks > 0) return weeks + " week" + (weeks > 1 ? "s" : "");
        else if (days > 0) return days + " day" + (days > 1 ? "s" : "");
        else if (hours > 0) return hours + " hour" + (hours > 1 ? "s" : "");
        else if (minutes > 0) return minutes + " minute" + (minutes > 1 ? "s" : "");
        else return "Just now";
    }
}
