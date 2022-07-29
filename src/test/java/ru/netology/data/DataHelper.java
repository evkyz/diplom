package ru.netology.data;

import lombok.Value;

public class DataHelper {
    static DataGenerate dataGenerate = new DataGenerate();

    @Value
    public static class InfoCard {
        String number;
        String month;
        String year;
        String name;
        String code;
    }

    //Карта
    public static InfoCard getCardApproved() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }

    //Заблокированная карта
    public static InfoCard getCardDeclined() {
        return new InfoCard(DataGenerate.getNumberCardDeclined(), dataGenerate.getMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }

    //Неверный номер
    public static InfoCard getCardNumberInvalid() {
        return new InfoCard(DataGenerate.getInvalidNumberCard(), dataGenerate.getMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }

    //Некоректный номер
    public static InfoCard getCardNumberIncorrect() {
        return new InfoCard(DataGenerate.getIncorrectNumberCard(), dataGenerate.getMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }

    //Номер, использование букв
    public static InfoCard getCardNumberLetter() {
        return new InfoCard(DataGenerate.getLetterNumberCard(), dataGenerate.getMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }

    //Пустой номер
    public static InfoCard getCardNumberEmpty() {
        return new InfoCard(DataGenerate.getEmptyNumberCard(), dataGenerate.getMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }

    //Некоректный месяц
    public static InfoCard getCardIncorrectMonth() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getIncorrectMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }

    //Некоректный формат месяца
    public static InfoCard getCardIncorrectFormatMonth() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getIncorrectFormatMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }

    //Месяц, буквы
    public static InfoCard getCardLetterFormatMonth() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getLetterFormatMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }

    //Пустой месяц
    public static InfoCard getCardEmptyMonth() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getEmptyMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }

    //Просроченный месяц
    public static InfoCard getCardOverdueMonth() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getOverdueMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }

    //Некоректный формат года
    public static InfoCard getCardIncorrectFormatYear() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getMonth().getMonth(), dataGenerate.getIncorrectFormatYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }

    //Год, буквы
    public static InfoCard getCardLetterFormatYear() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getMonth().getMonth(), dataGenerate.getLetterFormatYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }

    //Просроченная карта
    public static InfoCard getCardOverdueYear() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getMonth().getMonth(), dataGenerate.getOverdueYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }

    //Неверный срок
    public static InfoCard getCardIncorrectYear() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getMonth().getMonth(), dataGenerate.getIncorrectYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }
    //Пустой год
    public static InfoCard getCardEmptyYear() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getMonth().getMonth(), dataGenerate.getEmptyYear().getYear(),
                DataGenerate.getName(), DataGenerate.getCode());
    }
    //Владелец, кирилица
    public static InfoCard getCardRusName() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getRusName(), DataGenerate.getCode());
    }
    //Владелец, кирилица, латиница
    public static InfoCard getCardRusEnName() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getRusEnName(), DataGenerate.getCode());
    }
    //Владелец, цифры
    public static InfoCard getCardNumberName() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getNameNumber(), DataGenerate.getCode());
    }
    //Владелец, спец.символы
    public static InfoCard getCardSymbolName() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getNameSymbol(), DataGenerate.getCode());
    }
    //Владелец пусто
    public static InfoCard getCardEmptyName() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getNameEmpty(), DataGenerate.getCode());
    }
    //Неверный формат кода
    public static InfoCard getCardIncorrectCode() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getName(), DataGenerate.getIncorrectCode());
    }

    //Код, буквы
    public static InfoCard getCardLetterCode() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getName(), DataGenerate.getLetterCode());
    }

    //Код не заполнен
    public static InfoCard getCardEmptyCode() {
        return new InfoCard(DataGenerate.getNumberCardApproved(), dataGenerate.getMonth().getMonth(), dataGenerate.getYear().getYear(),
                DataGenerate.getName(), DataGenerate.getEmptyCode());
    }
}
