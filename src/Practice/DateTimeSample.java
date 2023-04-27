package Practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeSample {

    public static void main(String[] args) {
        Date date = new Date();

        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM dd YYYY HH:mm a");
        simpleDateFormat.format(date);

        System.out.println(simpleDateFormat.format(date));

    }

}
