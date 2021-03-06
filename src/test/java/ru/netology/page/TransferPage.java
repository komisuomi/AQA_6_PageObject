package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.Condition;
import ru.netology.data.DataHelper;

public class TransferPage {
    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement fromCardField = $("[data-test-id=from] input");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public TransferPage() {
        amountField.shouldBe(Condition.visible);
    }

    public DashboardPage transferMoney(String cardNumber, String amount) {
        amountField.setValue(amount);
        fromCardField.setValue(cardNumber);
        transferButton.click();
        return new DashboardPage();
    }

    public void transferMoneyError(String amount) {
        amountField.setValue(amount);
        transferButton.click();
        errorNotification.shouldBe(Condition.visible);
    }
}
