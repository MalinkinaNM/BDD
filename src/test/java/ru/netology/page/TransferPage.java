package ru.netology.page;

import com.codeborne.selenide.Conditional;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private final SelenideElement amountInput = $("[data-test-id='amount'] input");

    private final SelenideElement fromInput = $("[data-test-id='from'] input");

    public  TransferPage {
        SelenideElement transferHead = $(byText("Пополнение карты"));
        transferHead.shouldBe(visible);
    }

    public DashboardPage makeValidTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        makeTransfer(amountToTransfer, cardInfo);
        return new DashboardPage();
    }

    public void makeTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        amountInput.setValue(amountToTransfer);
        fromeInput.setValue(cardInfo.getCardNumber());
        trasferButton.click();
    }


    public void findErrorMessage(String expectedText) {
        errorMessage.shouldHave(text(expectedText), Duration.ofSeconds(15)).shouldBe(visible);
    }
}
