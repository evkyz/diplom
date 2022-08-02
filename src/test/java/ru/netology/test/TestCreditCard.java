package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.DbUtils;
import ru.netology.page.StartPage;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class TestCreditCard {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setup() throws SQLException {
        DbUtils.deleteData();
        open("http://localhost:8080/");
    }

    @Test
    @DisplayName("Кредит с карты")
    void testCardCredit() throws SQLException {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val approvedCardInformation = DataHelper.getCardApproved();
        creditPage.InfoCard(approvedCardInformation);
        creditPage.messageSuccessfully();
        assertEquals("APPROVED", DbUtils.creditStatus());
    }

    @Test
    @DisplayName("Кредит с заблокированной карты")
    void testBlockCardCredit() throws SQLException {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val declinedCardInformation = DataHelper.getCardDeclined();
        creditPage.InfoCard(declinedCardInformation);
        creditPage.messageError();
        assertEquals("DECLINED", DbUtils.creditStatus());
    }

    @Test
    @DisplayName("Неверный номер карты")
    void testErrorCardNumber() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val invalidCardInformation = DataHelper.getCardNumberInvalid();
        creditPage.InfoCard(invalidCardInformation);
        creditPage.messageError();
    }

    @Test
    @DisplayName("Невернный формат номера карты")
    void testIncorrectCardNumber() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val incorrectCardInformation = DataHelper.getCardNumberIncorrect();
        creditPage.InfoCard(incorrectCardInformation);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Номер карты с использованием букв")
    void testLetterCardNumber() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val letterCardNumber = DataHelper.getCardNumberLetter();
        creditPage.InfoCard(letterCardNumber);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Номер карты не заполнен")
    void testEmptyCardNumber() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val emptyCardInformation = DataHelper.getCardNumberEmpty();
        creditPage.InfoCard(emptyCardInformation);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Несуществующий месяц")
    void testIncorrectMonth() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val incorrectCardMonth = DataHelper.getCardIncorrectMonth();
        creditPage.InfoCard(incorrectCardMonth);
        creditPage.messageIncorrectDeadline();
    }

    @Test
    @DisplayName("Неверный формат месяца")
    void testIncorrectFormatMonth() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val incorrectFormatMonth = DataHelper.getCardIncorrectFormatMonth();
        creditPage.InfoCard(incorrectFormatMonth);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Месяц заполнен буквами")
    void testLetterFormatMonth() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val letterFormatMonth = DataHelper.getCardLetterFormatMonth();
        creditPage.InfoCard(letterFormatMonth);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Месяц не заполнен")
    void testEmptyMonth() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val emptyMonth = DataHelper.getCardEmptyMonth();
        creditPage.InfoCard(emptyMonth);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Карта просрочена на месяц")
    void testOverdueMonth() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val overdueMonth = DataHelper.getCardOverdueMonth();
        creditPage.InfoCard(overdueMonth);
        creditPage.messageIncorrectDeadline();
    }

    @Test
    @DisplayName("Неверный формат года")
    void testIncorrectFormatYear() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val incorrectFormatYear = DataHelper.getCardIncorrectFormatYear();
        creditPage.InfoCard(incorrectFormatYear);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Год заполнен буквами")
    void testLetterFormatYear() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val letterFormatYear = DataHelper.getCardLetterFormatYear();
        creditPage.InfoCard(letterFormatYear);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Истёк срок действия карты")
    void testOverdueYear() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val overdueYear = DataHelper.getCardOverdueYear();
        creditPage.InfoCard(overdueYear);
        creditPage.messageExpiredDeadline();
    }

    @Test
    @DisplayName("Неверный срок действия карты")
    void testIncorrectYear() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val incorrectYear = DataHelper.getCardIncorrectYear();
        creditPage.InfoCard(incorrectYear);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Год не заполнен")
    void testEmptyYear() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val emptyYear = DataHelper.getCardEmptyYear();
        creditPage.InfoCard(emptyYear);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Владелец заполнен строчными буквами")
    void testNameLowercase() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val nameLowercase = DataHelper.getCardEnNameLowercase();
        creditPage.InfoCard(nameLowercase);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Владелец, одна буква")
    void testNameOne() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val oneName = DataHelper.getCardOneName();
        creditPage.InfoCard(oneName);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Владелец заполнен кирилиицей")
    void testNameRus() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val nameRus = DataHelper.getCardRusName();
        creditPage.InfoCard(nameRus);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Владелец заполнен кирилиицей строчными буквами")
    void testNameRusLowercase() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val nameRusLowercase = DataHelper.getCardRusNameLowercase();
        creditPage.InfoCard(nameRusLowercase);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Владелец заполнен латиницей и кирилиицей")
    void testNameRusEn() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val nameRusEn = DataHelper.getCardRusEnName();
        creditPage.InfoCard(nameRusEn);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Владелец заполнен c использованием цифр")
    void testNameNumber() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val nameNumber = DataHelper.getCardNumberName();
        creditPage.InfoCard(nameNumber);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Владелец заполнен c использованием спец.символов")
    void testNameSymbol() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val nameSymbol = DataHelper.getCardSymbolName();
        creditPage.InfoCard(nameSymbol);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Владелец не заполнен")
    void testNameEmpty() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val nameEmpty = DataHelper.getCardEmptyName();
        creditPage.InfoCard(nameEmpty);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Неверный формат кода")
    void testIncorrectFormatCode() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val incorrectFormatCode = DataHelper.getCardIncorrectCode();
        creditPage.InfoCard(incorrectFormatCode);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Код заполнен буквами")
    void testLetterFormatCode() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val letterFormatCode = DataHelper.getCardLetterCode();
        creditPage.InfoCard(letterFormatCode);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Код не заполнен")
    void testEmptyCode() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val emptyCode = DataHelper.getCardEmptyCode();
        creditPage.InfoCard(emptyCode);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Неверный формат данных")
    void testIncorrectFormat() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val incorrectFormat = DataHelper.getCardIncorrectFormat();
        creditPage.InfoCard(incorrectFormat);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Неверные данные")
    void testIncorrect() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val incorrect = DataHelper.getCardIncorrect();
        creditPage.InfoCard(incorrect);
        creditPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Данные не заполнены")
    void testEmpty() {
        StartPage startPage = new StartPage();
        val creditPage = startPage.creditPage();
        val empty = DataHelper.getCardEmpty();
        creditPage.InfoCard(empty);
        creditPage.messageIncorrectFormat();
    }
}
