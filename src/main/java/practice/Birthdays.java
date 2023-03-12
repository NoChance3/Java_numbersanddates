package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthdays {

    public static void main(String[] args) {

        int day = 14;
        int month = 02;
        int year = 1999;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(year, month, day);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy - E", Locale.ENGLISH);
        int years = 0;
        String collectBirthdays = "";
        while (birthday.isBefore(today) || birthday.isEqual(today)) {
            collectBirthdays = collectBirthdays.concat(years + " - "  + format.format(birthday) + "\n");
            years++;
            birthday = birthday.plusYears(1);
        }
        return collectBirthdays;
    }
}

