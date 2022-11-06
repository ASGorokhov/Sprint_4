package pom;

import org.junit.Assert;
import org.openqa.selenium.*;

import static org.hamcrest.CoreMatchers.containsString;

public class AboutRentPage {

    // Поле для ввода "* Когда привезти самокат"
    private final By inputDeliverPeriod = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Выпадающий список "* Срок аренды"
    private final By dropDownListRentalPeriod = By.xpath(".//div[@class='Dropdown-root']");
    // Элемент выпадающего списка "* Срок аренды"
    public static final By dropDownListRentalPeriodElementOne = By.xpath(".//div[@class='Dropdown-option'][1]");
    // Элемент выпадающего списка "* Срок аренды"
    public static final By dropDownListRentalPeriodElementTwo = By.xpath(".//div[@class='Dropdown-option'][2]");
    // Чекбокс для выбора черного цвета
    public static final By blackCheckbox = By.xpath(".//input[@id='black']");
    // Чекбокс для выбора серого цвета
    public static final By greyCheckbox = By.xpath(".//input[@id='grey']");
    // Поле для ввода "Комментарий для курьера"
    private final By inputCommentForTheCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка "Заказать"
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Кнопка подтверждения заказа
    private final By wantToPlaceAnOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    // Всплывающее окно с подтверждением заказа
    private final By popupOrdered = By.xpath(".//div[text()='Заказ оформлен']");

    private WebDriver driver;

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public AboutRentPage chooseDeliveryDate(String deliveryDate) {
        goToElement(inputDeliverPeriod);
        driver.findElement(inputDeliverPeriod).sendKeys(deliveryDate);
        driver.findElement(inputDeliverPeriod).sendKeys(Keys.ENTER);
        return this;
    }

    public AboutRentPage clickAndSelectDropDownListRentalPeriod(By rentalPeriodElement) {
        goToElement(dropDownListRentalPeriod);
        driver.findElement(dropDownListRentalPeriod).click();
        driver.findElement(rentalPeriodElement).click();
        return this;
    }

    public AboutRentPage chooseTheColorOfTheScooter(By colorOfTheScooter) {
        goToElement(colorOfTheScooter);
        driver.findElement(colorOfTheScooter).click();
        return this;
    }

    public AboutRentPage sendInputCommentForTheCourier(String commentForTheCourier) {
        goToElement(inputCommentForTheCourier);
        driver.findElement(inputCommentForTheCourier).sendKeys(commentForTheCourier);
        return this;
    }

    public AboutRentPage clickOrderButton() {
        goToElement(orderButton);
        driver.findElement(orderButton).click();
        return this;
    }

    public AboutRentPage clickWantToPlaceAnOrder() {
        goToElement(wantToPlaceAnOrder);
        driver.findElement(wantToPlaceAnOrder).click();
        return this;
    }

    public AboutRentPage checkOrder() {
        String expected = "Заказ оформлен";
        String actual = driver.findElement(popupOrdered).getText();
        Assert.assertThat("Окно уведомляющее о том, что заказ оформлен не появилась!", actual, containsString(expected));
        return this;
    }

    public void goToElement(By byElement) {
        WebElement element = driver.findElement(byElement);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
    }
}
