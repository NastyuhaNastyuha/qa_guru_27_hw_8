package utils;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RandomDate {

    public static void main(String[] args) {
        RandomDate randomDate = new RandomDate();
        randomDate.getRandomBirthDateForAge(18);
    }

    public String day;
    public String month;
    public String year;

    public void getRandomBirthDate() {
        Faker faker = new Faker();
        Date date = faker.date().birthday();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        day = simpleDateFormat.format(date);

        simpleDateFormat = new SimpleDateFormat("LLLL", Locale.ENGLISH);
        month = simpleDateFormat.format(date);

        simpleDateFormat = new SimpleDateFormat("yyyy");
        year = simpleDateFormat.format(date);
    }

    public void getRandomBirthDateForAge(int age) {
        Calendar calendarFirstDayForAge = Calendar.getInstance();
        calendarFirstDayForAge.add(Calendar.YEAR, -age);

        Calendar calendarLastDayForAge = Calendar.getInstance();
        calendarLastDayForAge.add(Calendar.YEAR, -(age-1));
        calendarLastDayForAge.add(Calendar.DAY_OF_YEAR, -1);

        Faker faker = new Faker();
        Date date = faker.date().between(calendarFirstDayForAge.getTime(), calendarLastDayForAge.getTime());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        day = simpleDateFormat.format(date);

        simpleDateFormat = new SimpleDateFormat("LLLL", Locale.ENGLISH);
        month = simpleDateFormat.format(date);

        simpleDateFormat = new SimpleDateFormat("yyyy");
        year = simpleDateFormat.format(date);
    }
}