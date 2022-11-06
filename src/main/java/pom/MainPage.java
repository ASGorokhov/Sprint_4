package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class MainPage {

    private final String url = "https://qa-scooter.praktikum-services.ru/";
    // Маленькая кнопка "Заказать"
    public static final By smallOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    // Большая кнопка "Заказать"
    public static final By bigOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']");
    // Кнопка подтверждения использования cookie
    public static final By confirmCookieButton = By.xpath(".//button[@id='rcc-confirm-button']");
    // Кнопка выпадающего списка "Сколько это стоит? И как оплатить?"
    public static final By faqButtonHowMuchDoesItCostAndHowToPay = By.xpath(".//div[@id='accordion__heading-0']");
    // Поле с текстом отображаемое при нажатии на кнопку выпадающего списка "Сколько это стоит? И как оплатить?"
    public static final By textBelowTheFaqButtonHowMuchDoesItCostAndHowToPay = By.xpath(".//div[@id='accordion__panel-0']");
    // Кнопка выпадающего списка "Хочу сразу несколько самокатов! Так можно?"
    public static final By faqButtonIWantSeveralScootersSoItIsPossible = By.xpath(".//div[@id='accordion__heading-1']");
    // Поле с текстом отображаемое при нажатии на кнопку выпадающего списка "Хочу сразу несколько самокатов! Так можно?"
    public static final By textBelowTheFaqButtonIWantSeveralScootersSoItIsPossible = By.xpath(".//div[@id='accordion__panel-1']");
    // Кнопка выпадающего списка "Как рассчитывается время аренды?"
    public static final By faqButtonHowIsTheRentalTimeCalculated = By.xpath(".//div[@id='accordion__heading-2']");
    // Поле с текстом отображаемое при нажатии на кнопку выпадающего списка "Как рассчитывается время аренды?"
    public static final By textBelowTheFaqButtonHowIsTheRentalTimeCalculated = By.xpath(".//div[@id='accordion__panel-2']");
    // Кнопка выпадающего списка "Можно ли заказать самокат прямо на сегодня?"
    public static final By faqButtonIsItPossibleToOrderAScooterRightForToday = By.xpath(".//div[@id='accordion__heading-3']");
    // Поле с текстом отображаемое при нажатии на кнопку выпадающего списка "Можно ли заказать самокат прямо на сегодня?"
    public static final By textBelowTheFaqButtonIsItPossibleToOrderAScooterRightForToday = By.xpath(".//div[@id='accordion__panel-3']");
    // Кнопка выпадающего списка "Можно ли продлить заказ или вернуть самокат раньше?"
    public static final By faqButtonCanIExtendTheOrderOrReturnTheScooterEarlier = By.xpath(".//div[@id='accordion__heading-4']");
    // Поле с текстом отображаемое при нажатии на кнопку выпадающего списка "Можно ли продлить заказ или вернуть самокат раньше?"
    public static final By textBelowTheFaqButtonCanIExtendTheOrderOrReturnTheScooterEarlier = By.xpath(".//div[@id='accordion__panel-4']");
    // Кнопка выпадающего списка "Вы привозите зарядку вместе с самокатом?"
    public static final By faqButtonDoYouBringChargersWithTheScooter = By.xpath(".//div[@id='accordion__heading-5']");
    // Поле с текстом отображаемое при нажатии на кнопку выпадающего списка "Вы привозите зарядку вместе с самокатом?"
    public static final By textBelowTheFaqButtonDoYouBringChargersWithTheScooter = By.xpath(".//div[@id='accordion__panel-5']");
    // Кнопка выпадающего списка "Можно ли отменить заказ?"
    public static final By faqButtonCanICancelAnOrder = By.xpath(".//div[@id='accordion__heading-6']");
    // Поле с текстом отображаемое при нажатии на кнопку выпадающего списка "Можно ли отменить заказ?"
    public static final By textBelowTheFaqButtonCanICancelAnOrder = By.xpath(".//div[@id='accordion__panel-6']");
    // Кнопка выпадающего списка "Я жизу за МКАДом, привезёте?"
    public static final By faqButtonILiveOutsideTheMoscowRingRoadWillYouBringIt = By.xpath(".//div[@id='accordion__heading-7']");
    // Поле с текстом отображаемое при нажатии на кнопку выпадающего списка "Я жизу за МКАДом, привезёте?"
    public static final By textBelowTheFaqButtonILiveOutsideTheMoscowRingRoadWillYouBringIt = By.xpath(".//div[@id='accordion__panel-7']");

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(url);
        return this;
    }

    public MainPage clickCookieButton() {
        goToElement(confirmCookieButton);
        driver.findElement(confirmCookieButton).click();
        return this;
    }

    public MainPage checkTextElementFaqHowMuchDoesItCostAndHowToPayWhenYouClick() {
        goToElement(faqButtonHowMuchDoesItCostAndHowToPay);
        driver.findElement(faqButtonHowMuchDoesItCostAndHowToPay).click();
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual = driver.findElement(textBelowTheFaqButtonHowMuchDoesItCostAndHowToPay).getText();
        assertEquals("Текст не совпадает!", expected, actual);
        return this;
    }

    public MainPage checkTextElementFaqButtonIWantSeveralScootersSoItIsPossibleWhenYouClick() {
        goToElement(faqButtonIWantSeveralScootersSoItIsPossible);
        driver.findElement(faqButtonIWantSeveralScootersSoItIsPossible).click();
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String actual = driver.findElement(textBelowTheFaqButtonIWantSeveralScootersSoItIsPossible).getText();
        assertEquals("Текст не совпадает!", expected, actual);
        return this;
    }

    public MainPage checkTextElementFaqButtonHowIsTheRentalTimeCalculatedWhenYouClick() {
        goToElement(faqButtonHowIsTheRentalTimeCalculated);
        driver.findElement(faqButtonHowIsTheRentalTimeCalculated).click();
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String actual = driver.findElement(textBelowTheFaqButtonHowIsTheRentalTimeCalculated).getText();
        assertEquals("Текст не совпадает!", expected, actual);
        return this;
    }

    public MainPage checkTextElementFaqButtonIsItPossibleToOrderAScooterRightForTodayWhenYouClick() {
        goToElement(faqButtonIsItPossibleToOrderAScooterRightForToday);
        driver.findElement(faqButtonIsItPossibleToOrderAScooterRightForToday).click();
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String actual = driver.findElement(textBelowTheFaqButtonIsItPossibleToOrderAScooterRightForToday).getText();
        assertEquals("Текст не совпадает!", expected, actual);
        return this;
    }

    public MainPage checkTextElementFaqButtonCanIExtendTheOrderOrReturnTheScooterEarlierWhenYouClick() {
        goToElement(faqButtonCanIExtendTheOrderOrReturnTheScooterEarlier);
        driver.findElement(faqButtonCanIExtendTheOrderOrReturnTheScooterEarlier).click();
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String actual = driver.findElement(textBelowTheFaqButtonCanIExtendTheOrderOrReturnTheScooterEarlier).getText();
        assertEquals("Текст не совпадает!", expected, actual);
        return this;
    }

    public MainPage checkTextElementFaqButtonDoYouBringChargersWithTheScooterWhenYouClick() {
        goToElement(faqButtonDoYouBringChargersWithTheScooter);
        driver.findElement(faqButtonDoYouBringChargersWithTheScooter).click();
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String actual = driver.findElement(textBelowTheFaqButtonDoYouBringChargersWithTheScooter).getText();
        assertEquals("Текст не совпадает!", expected, actual);
        return this;
    }

    public MainPage checkTextElementFaqButtonCanICancelAnOrderWhenYouClick() {
        goToElement(faqButtonCanICancelAnOrder);
        driver.findElement(faqButtonCanICancelAnOrder).click();
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String actual = driver.findElement(textBelowTheFaqButtonCanICancelAnOrder).getText();
        assertEquals("Текст не совпадает!", expected, actual);
        return this;
    }

    public MainPage checkTextElementFaqButtonILiveOutsideTheMoscowRingRoadWillYouBringItWhenYouClick() {
        goToElement(faqButtonILiveOutsideTheMoscowRingRoadWillYouBringIt);
        driver.findElement(faqButtonILiveOutsideTheMoscowRingRoadWillYouBringIt).click();
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        String actual = driver.findElement(textBelowTheFaqButtonILiveOutsideTheMoscowRingRoadWillYouBringIt).getText();
        assertEquals("Текст не совпадает!", expected, actual);
        return this;
    }

    public MainPage clickOrderButton(By orderButton) {
        goToElement(orderButton);
        driver.findElement(orderButton).click();
        return this;
    }

    public void goToElement(By byElement) {
        WebElement element = driver.findElement(byElement);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
    }
}
