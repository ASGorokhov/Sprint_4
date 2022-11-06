package pom;

import org.openqa.selenium.*;

public class OrderPage {
    // Поле для ввода "* Имя"
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");
    // Поле для ввода "* Фамилия"
    private final By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле для ввода "* Адрес: куда привезти заказ"
    private final By inputDeliveryAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Выпадающий список "* Станция метро"
    private final By dropDownListOfMetroStations = By.xpath(".//input[@class='select-search__input']");
    // Поле для ввода "* Телефон: на него позвонит курьер"
    private final By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private final By nextButton = By.xpath(".//button[text()='Далее']");

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage enterName(String name) {
        goToElement(inputName);
        driver.findElement(inputName).sendKeys(name);
        return this;
    }

    public OrderPage enterSurname(String surname) {
        goToElement(inputSurname);
        driver.findElement(inputSurname).sendKeys(surname);
        return this;
    }

    public OrderPage enterDeliveryAddress(String deliveryAddress) {
        goToElement(inputDeliveryAddress);
        driver.findElement(inputDeliveryAddress).sendKeys(deliveryAddress);
        return this;
    }

    public OrderPage selectAnElementFromDropDownListOfMetroStations(int c) {
        goToElement(dropDownListOfMetroStations);
        driver.findElement(dropDownListOfMetroStations).click();

        for (int i = 1; i <= c; i++) {
            driver.findElement(dropDownListOfMetroStations).sendKeys(Keys.DOWN);
        }

        driver.findElement(dropDownListOfMetroStations).sendKeys(Keys.ENTER);
        return this;
    }

    public OrderPage enterPhone(String phone) {
        goToElement(inputPhone);
        driver.findElement(inputPhone).sendKeys(phone);
        return this;
    }

    public OrderPage clickNextButton() {
        goToElement(nextButton);
        driver.findElement(nextButton).click();
        return this;
    }

    public void goToElement(By byElement) {
        WebElement element = driver.findElement(byElement);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
    }
}
