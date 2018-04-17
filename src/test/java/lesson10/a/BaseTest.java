package lesson10.a;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class BaseTest extends SimpleAPI {
    private static final Logger LOG = LogManager.getLogger(FirstTest.class);
    protected static WebDriver driver;

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            captureScreenshot(description.getMethodName());
        }

        private void captureScreenshot(String methodName) {
            File screenshot = ((TakesScreenshot)driver)
                    .getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("report.path") + "/screenshots/" + screenshot.getName();

            try {
                LOG.info("create a screenshot");
                FileUtils.copyFile(screenshot, new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        };

        @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }



    @Override
    WebDriver getWebDriver() {
        return driver;
    }
}
