package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class CreditPage {
    private SelenideElement heading = $x("//h3[@class=\"heading heading_size_m heading_theme_alfa-on-white\"]");
    private SelenideElement numberCard = $x("//input[@placeholder=\"0000 0000 0000 0000\"]");
    private SelenideElement month = $x("//input[@placeholder=\"08\"]");
    private SelenideElement year = $x("//input[@placeholder=\"22\"]");
    private SelenideElement name = $("fieldset > div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__box > input");
    private SelenideElement code = $x("//input[@placeholder=\"999\"]");
    private SelenideElement button = $$(".button").find(exactText("Продолжить"));
    private SelenideElement successfully = $x("//div[text()='Успешно']");
    private SelenideElement error = $x("//div[text()='Ошибка']");
    private SelenideElement incorrectFormat = $x("//span[@class=\"input__sub\"]");
    private SelenideElement incorrectDeadline = $x("//span[text()='Неверно указан срок действия карты']");
    private SelenideElement expiredDeadline = $x("//span[text()='Истёк срок действия карты']");

    public CreditPage() {
        heading.shouldBe(Condition.visible);
    }

    public void InfoCard(DataHelper.InfoCard infoCard) {
        numberCard.setValue(infoCard.getNumber());
        month.setValue(infoCard.getMonth());
        year.setValue(infoCard.getYear());
        name.setValue(infoCard.getName());
        code.setValue(infoCard.getCode());
        button.click();
    }

    public void messageSuccessfully() {
        successfully.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void messageError() {
        error.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void messageIncorrectFormat() {
        incorrectFormat.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void messageIncorrectDeadline() {
        incorrectDeadline.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void messageExpiredDeadline() {
        expiredDeadline.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
}
