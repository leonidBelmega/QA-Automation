package lesson07.homeWork;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {


    @Test
    public void firstResultShouldContainExpectedText() {
        String query1 = "Dress";
        String text = "Blouses > Blouse";

        MainPage mainPage = new MainPage(driver);
        mainPage.visit();
        mainPage.enterQuery(query1);

        assertThat(CustomExpectedConditions.listNthElementHasText(mainPage.ADVICE_LOCATOR, 6, text));

        mainPage.clear();
    }

    @Test
    public void pageIsLoaded() {
        MainPage mainPage = new MainPage(driver);
        mainPage.visit();
        String title = "My Store";
        String url = "http://automationpractice.com/index.php";

        assertThat(CustomExpectedConditions.pageIsLoaded(title, url));
    }

    @Test
    public void stalenessOfElement() {
        String query1 = "Dress";

        MainPage mainPage = new MainPage(driver);
        mainPage.visit();
        mainPage.enterQuery(query1);
        mainPage.clear();
        assertThat(CustomExpectedConditions.statelessOfElement(mainPage.ADVICE_LOCATOR));
    }
}
