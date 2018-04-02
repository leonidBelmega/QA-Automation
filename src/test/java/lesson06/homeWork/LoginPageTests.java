package lesson06.homeWork;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

public class LoginPageTests {

    static WebDriver driver;
    public static LoginPage loginPage;
    public static AccountPage accountPage;


    String user = "test user";
    String email = "collector.sharing@gmail.com";
    String pass = "manchester-123a";
    String text = "Sign in";


    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();
    }

    @Test
    // @Ignore
    public void loginViaChainMethods() {

        loginPage.enterUsername(email);
        loginPage.enterPassword(pass);
        loginPage.clickSignInBtn();

        Assert.assertThat(accountPage.userAccountName(), containsString(user));
        accountPage.singOut();
    }


    @Test
    public void loginViaLoginMethod() {

        loginPage.logIn(email, pass);

        Assert.assertThat(accountPage.userAccountName(), containsString(user));
        accountPage.singOut();

    }

    @Test
    public void logOut() {
        loginPage.logIn(email, pass);
        accountPage.singOut();
        Assert.assertThat(loginPage.singInText(), containsString(text));
    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
