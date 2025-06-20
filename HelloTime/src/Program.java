import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Demonstrates basic usage of time in Java
 * @author Florin
 * @see <a href="https://www.tutorialspoint.com/java/java_date_time.htm">tutorialspoint/java_date_time.htm</a>
 *
 */
public class Program {

    /**
     * Prints current local date & time
     */
    public static void printCurrentTime() {
        Date date = new Date();
        System.out.println(date);
    }
    
    /**
     * Builds a Date object from a string
     */
    public static void buildDate() throws ParseException {
        SimpleDateFormat dateParser = new SimpleDateFormat("MM/dd/yyyy, hh:mm a");
        Date date = dateParser.parse("02/07/2022, 10:18 PM");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
        System.out.println(dateFormatter.format(date));
    }
    
    /**
     * Converts time in various types and compares within a time window
     */
    public static void convertAndcompareTime() {
        LocalTime t1 = LocalTime.of(11, 22, 33);
        LocalTime t2 = LocalTime.of(20, 00, 00);
        LocalTime t = LocalTime.of(12, 0, 0);
        LocalDateTime dt = t.atDate(LocalDate.now());
        ZonedDateTime zt = dt.atZone(ZoneId.systemDefault());
        Instant i = zt.toInstant();
        Date d = Date.from(i);
        
        SimpleDateFormat dateParser = new SimpleDateFormat("MM/dd/yyyy, hh:mm:ss a");
        System.out.println(dateParser.format(d));
        
        if (t.compareTo(t1) > 0 && t.compareTo(t2) < 0) {
            System.out.print("Within time window ");
        } else {
            System.out.print("Outside time window ");
        }
        
        System.out.printf("[%s - %s]\n", t1.toString(), t2.toString());
    }
    
    public static void main(String[] args) throws ParseException {
        System.out.println("Hello Time!");
        printCurrentTime();
        buildDate();
        convertAndcompareTime();
    }

}
