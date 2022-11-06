package checktext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckTextInList {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void clickingOnAnArrowOpensTheCorrespondingText() {
        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .clickCookieButton()
                .checkTextElementFaqHowMuchDoesItCostAndHowToPayWhenYouClick()
                .checkTextElementFaqButtonIWantSeveralScootersSoItIsPossibleWhenYouClick()
                .checkTextElementFaqButtonHowIsTheRentalTimeCalculatedWhenYouClick()
                .checkTextElementFaqButtonIsItPossibleToOrderAScooterRightForTodayWhenYouClick()
                .checkTextElementFaqButtonCanIExtendTheOrderOrReturnTheScooterEarlierWhenYouClick()
                .checkTextElementFaqButtonDoYouBringChargersWithTheScooterWhenYouClick()
                .checkTextElementFaqButtonCanICancelAnOrderWhenYouClick()
                .checkTextElementFaqButtonILiveOutsideTheMoscowRingRoadWillYouBringItWhenYouClick();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
