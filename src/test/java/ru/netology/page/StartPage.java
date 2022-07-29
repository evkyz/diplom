package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class StartPage {
    private SelenideElement heading = $x("//h2");
    private SelenideElement buy = $x("//span[text()='Купить']");
    private SelenideElement credit = $x("//span[text()='Купить в кредит']");

    public StartPage() {
        heading.shouldBe(Condition.visible);
    }

    public BuyPage buyPage() {
        buy.click();
        return new BuyPage();
    }

    public CreditPage creditPage() {
        credit.click();
        return new CreditPage();
    }
}

