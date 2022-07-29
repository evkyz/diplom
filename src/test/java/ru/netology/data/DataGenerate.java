package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerate {
    public static String getNumberCardApproved() {
        return "4444 4444 4444 4441";
    }

    static String getNumberCardDeclined() {
        return "4444 4444 4444 4442";
    }

    static String getInvalidNumberCard() {
        return "4444 4444 4444 4444";
    }

    static String getLetterNumberCard() {
        return "QQQQ IIII XXXX OOOO";
    }

    static String getIncorrectNumberCard() {
        return "4444 4444 4444 444";
    }

    static String getEmptyNumberCard() {
        return "";
    }

    LocalDate now = LocalDate.now();
    DateTimeFormatter month = DateTimeFormatter.ofPattern("MM");
    DateTimeFormatter year = DateTimeFormatter.ofPattern("yy");

    @Value
    public static class Month {
        String month;
    }

    public Month getMonth() {
        LocalDate Month = now;
        return new Month(month.format(Month));
    }

    public Month getIncorrectMonth() {
        return new Month("13");
    }

    public Month getIncorrectFormatMonth() {
        return new Month("1");
    }

    public Month getLetterFormatMonth() {
        return new Month("JA");
    }

    public Month getEmptyMonth() {
        return new Month("");
    }

    public Month getOverdueMonth() {
        LocalDate Month = now.minusMonths(1);
        return new Month(month.format(Month));
    }

    @Value
    public static class Year {
        String year;
    }

    public Year getYear() {
        LocalDate Year = now;
        return new Year(year.format(Year));
    }

    public Year getIncorrectFormatYear() {
        return new Year("1");
    }

    public Year getLetterFormatYear() {
        return new Year("IO");
    }

    public Year getOverdueYear() {
        LocalDate Year = now.minusYears(1);
        return new Year(year.format(Year));
    }

    public Year getIncorrectYear() {
        LocalDate Year = now.plusYears(10);
        return new Year(year.format(Year));
    }

    public Year getEmptyYear() {
        return new Year("");
    }

    static String getName() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().fullName();
    }

    static String getRusName() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().fullName();
    }

    static String getRusEnName() {
        return "IVAN ИВАНОВ";
    }

    static String getNameNumber() {
        return "1VAN 1VAN0V";
    }

    static String getNameSymbol() {
        return "!V@N !V@NOV";
    }

    static String getNameEmpty() {
        return "";
    }

    static String getCode() {
        return "123";
    }

    static String getIncorrectCode() {
        return "12";
    }

    static String getLetterCode() {
        return "IOX";
    }

    static String getEmptyCode() {
        return "";
    }
}