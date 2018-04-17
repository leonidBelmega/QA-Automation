package lesson07.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CustomExpectedConditions {
    public static ExpectedCondition<Boolean> listNthElementHasText(By locator, int NthElement, String text) {
        return driver -> {
            List<WebElement> list = driver.findElements(locator);
            return list.get(NthElement).getText().equals(text);
           };

    }

    public static ExpectedCondition<Boolean> pageIsLoaded(String title, String url) {
        return driver -> driver.getCurrentUrl().equals(url) && driver.getTitle().contains(title);
    }

    public static ExpectedCondition<Boolean> statelessOfElement(By locator) {
        return driver -> {
            List<WebElement> list = driver.findElements(locator);
            return list.isEmpty();
          };
    }
}




