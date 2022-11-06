package checkorder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.AboutRentPage;
import pom.MainPage;
import pom.OrderPage;
import java.time.Duration;
import static pom.MainPage.smallOrderButton;
import static pom.MainPage.bigOrderButton;
import static pom.AboutRentPage.dropDownListRentalPeriodElementOne;
import static pom.AboutRentPage.dropDownListRentalPeriodElementTwo;
import static pom.AboutRentPage.blackCheckbox;
import static pom.AboutRentPage.greyCheckbox;

@RunWith(Parameterized.class)
public class CheckOrderScooter {
    private final By orderButton;
    private final String name;
    private final String surname;
    private final String deliveryAddress;
    private final int metroStations;
    private final String phone;
    private final String deliveryDate;
    private final By rentalPeriodElement;
    private final String commentForTheCourier;
    private final By colorOfTheScooter;
    private WebDriver driver;

    public CheckOrderScooter(By orderButton, String name, String surname, String deliveryAddress, int metroStations, String phone, String deliveryDate, By rentalPeriodElement, String commentForTheCourier, By colorOfTheScooter) {
        this.orderButton = orderButton;
        this.name = name;
        this.surname = surname;
        this.deliveryAddress = deliveryAddress;
        this.metroStations = metroStations;
        this.phone = phone;
        this.deliveryDate = deliveryDate;
        this.rentalPeriodElement = rentalPeriodElement;
        this.commentForTheCourier = commentForTheCourier;
        this.colorOfTheScooter = colorOfTheScooter;
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                {smallOrderButton, "Антон", "Конев","город Москва, ул. Пушкинская дом 28",1,"89225353535","04.11.2022", dropDownListRentalPeriodElementOne, "Можете звонить в любое время, я страдаю бессонницей!", blackCheckbox},
                {bigOrderButton, "Василий", "Комаров","город Москва, ул. Краснознаменная дом 134",3,"89522332233","02.11.2022", dropDownListRentalPeriodElementTwo, "Позвоните пожалуйста за 15 минут до приезда", greyCheckbox},
        };
    }

    @Test
    public void orderScooterFillOutTheOrderFormAPopUpWindowWithAMessageAboutTheSuccessfulCreationOfTheOrder() {

        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .clickCookieButton()
                .clickOrderButton(orderButton);

        OrderPage orderPage = new OrderPage(driver);

        orderPage
                .enterName(name)
                .enterSurname(surname)
                .enterDeliveryAddress(deliveryAddress)
                .selectAnElementFromDropDownListOfMetroStations(metroStations)
                .enterPhone(phone)
                .clickNextButton();

        AboutRentPage aboutRentPage = new AboutRentPage(driver);

        aboutRentPage
                .chooseDeliveryDate(deliveryDate)
                .clickAndSelectDropDownListRentalPeriod(rentalPeriodElement)
                .chooseTheColorOfTheScooter(colorOfTheScooter)
                .sendInputCommentForTheCourier(commentForTheCourier)
                .clickOrderButton()
                .clickWantToPlaceAnOrder()
                .checkOrder();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
