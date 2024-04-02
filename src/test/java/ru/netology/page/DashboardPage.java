package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public final SelenideElement heading = $("[data-test-id=dashboard]");
    private final ElementsCollection cards = $$(".list__item div");

    public DashboardPage(){
        heading.shouldBe(visible);

        public int getCardBalance(DataHelper.CardInfo cardInfo;
        cardInfo) {
            var text = cards.findBy(text(CardInfo.getCardNumber().substring(15))).getText();
            return extractBalance(text);
        }

        public int getCardBalance(int index) {
            var text = cards.get(index).getText();
            return extractBalance(text);
        }

        public TransferPage selectCardToTransfer(DataHelper.CardInfo cardInfo) {
            cards.findBy(attribute("data-test-id", cardInfo.getTestId())).$("button").click();
            return new TransferPage();
        }
        private int extractBalance(String text) {
            val start = text.indexOf(balanceStart);
            val finish = text.indexOf(balanceFinish);
            val value = text.substring(start + balanceStart.length(), finish);
            return Integer.parseInt(value);
        }

    }

}