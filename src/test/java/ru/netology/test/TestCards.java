package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.Db;
import ru.netology.page.StartPage;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class TestCards {

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
        Db.deleteData();
        open("http://localhost:8080/");
    }

    @Test
    @DisplayName("Тест оплаты с карты")
    void testCard() throws SQLException {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val approvedCardInformation = DataHelper.getCardApproved();
        buyPage.InfoCard(approvedCardInformation);
        buyPage.messageSuccessfully();
        assertEquals("APPROVED", Db.buyStatus());
    }

    @Test
    @DisplayName("Тест оплаты с заблокированной карты")
    void testBlockCard() throws SQLException {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val declinedCardInformation = DataHelper.getCardDeclined();
        buyPage.InfoCard(declinedCardInformation);
        buyPage.messageError();
        assertEquals("DECLINED", Db.buyStatus());
    }

    @Test
    @DisplayName("Неверный номер карты")
    void testErrorCardNumber() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val invalidCardInformation = DataHelper.getCardNumberInvalid();
        buyPage.InfoCard(invalidCardInformation);
        buyPage.messageError();
    }

    @Test
    @DisplayName("Невернный формат номера карты")
    void testIncorrectCardNumber() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val incorrectCardInformation = DataHelper.getCardNumberIncorrect();
        buyPage.InfoCard(incorrectCardInformation);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Номер карты с использованием букв")
    void testLetterCardNumber() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val letterCardNumber = DataHelper.getCardNumberLetter();
        buyPage.InfoCard(letterCardNumber);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Номер карты не заполнен")
    void testEmptyCardNumber() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val emptyCardInformation = DataHelper.getCardNumberEmpty();
        buyPage.InfoCard(emptyCardInformation);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Несуществующий месяц")
    void testIncorrectMonth() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val incorrectCardMonth = DataHelper.getCardIncorrectMonth();
        buyPage.InfoCard(incorrectCardMonth);
        buyPage.messageIncorrectDeadline();
    }

    @Test
    @DisplayName("Неверный формат месяца")
    void testIncorrectFormatMonth() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val incorrectFormatMonth = DataHelper.getCardIncorrectFormatMonth();
        buyPage.InfoCard(incorrectFormatMonth);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Месяц заполнен буквами")
    void testLetterFormatMonth() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val letterFormatMonth = DataHelper.getCardLetterFormatMonth();
        buyPage.InfoCard(letterFormatMonth);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Месяц не заполнен")
    void testEmptyMonth() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val emptyMonth = DataHelper.getCardEmptyMonth();
        buyPage.InfoCard(emptyMonth);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Карта просрочена на месяц")
    void testOverdueMonth() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val overdueMonth = DataHelper.getCardOverdueMonth();
        buyPage.InfoCard(overdueMonth);
        buyPage.messageIncorrectDeadline();
    }

    @Test
    @DisplayName("Неверный формат года")
    void testIncorrectFormatYear() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val incorrectFormatYear = DataHelper.getCardIncorrectFormatYear();
        buyPage.InfoCard(incorrectFormatYear);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Год заполнен буквами")
    void testLetterFormatYear() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val letterFormatYear = DataHelper.getCardLetterFormatYear();
        buyPage.InfoCard(letterFormatYear);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Истёк срок действия карты")
    void testOverdueYear() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val overdueYear = DataHelper.getCardOverdueYear();
        buyPage.InfoCard(overdueYear);
        buyPage.messageExpiredDeadline();
    }

    @Test
    @DisplayName("Неверный срок действия карты")
    void testIncorrectYear() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val incorrectYear = DataHelper.getCardIncorrectYear();
        buyPage.InfoCard(incorrectYear);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Год не заполнен")
    void testEmptyYear() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val emptyYear = DataHelper.getCardEmptyYear();
        buyPage.InfoCard(emptyYear);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Владелец заполнен кирилиицей") //Баг, при заполнении Успешно
    void testNameRus() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val nameRus = DataHelper.getCardRusName();
        buyPage.InfoCard(nameRus);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Владелец заполнен латиницей и кирилиицей") //Баг, при заполнении Успешно
    void testNameRusEn() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val nameRusEn = DataHelper.getCardRusEnName();
        buyPage.InfoCard(nameRusEn);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Владелец заполнен c использованием цифр") //Баг, при заполнении Успешно
    void testNameNumber() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val nameNumber = DataHelper.getCardNumberName();
        buyPage.InfoCard(nameNumber);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Владелец заполнен c использованием спец.символов") //Баг, при заполнении Успешно
    void testNameSymbol() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val nameSymbol = DataHelper.getCardSymbolName();
        buyPage.InfoCard(nameSymbol);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Владелец не заполнен")
    void testNameEmpty() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val nameEmpty = DataHelper.getCardEmptyName();
        buyPage.InfoCard(nameEmpty);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Неверный формат кода")
    void testIncorrectFormatCode() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val incorrectFormatCode = DataHelper.getCardIncorrectCode();
        buyPage.InfoCard(incorrectFormatCode);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Код заполнен буквами")
    void testLetterFormatCode() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val letterFormatCode = DataHelper.getCardLetterCode();
        buyPage.InfoCard(letterFormatCode);
        buyPage.messageIncorrectFormat();
    }

    @Test
    @DisplayName("Код не заполнен")
    void testEmptyCode() {
        StartPage startPage = new StartPage();
        val buyPage = startPage.buyPage();
        val emptyCode = DataHelper.getCardEmptyCode();
        buyPage.InfoCard(emptyCode);
        buyPage.messageIncorrectFormat();
    }
}
