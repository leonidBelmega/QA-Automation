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
            System.out.println(list.get(NthElement).getText());

            if (list.get(NthElement).getText().equals(text))
                return true;
            else return false;
        };

    }

    public static ExpectedCondition<Boolean> pageIsLoaded(String title, String url) {
        return driver -> {
            if (driver.getCurrentUrl().equals(url) && driver.getTitle().equals(title))
                return true;
            return null;
        };
    }

    public static ExpectedCondition<Boolean> statelessOfElement(By locator) {
        return driver -> {
            List<WebElement> list = driver.findElements(locator);
            if (list.isEmpty())
                return true;
            else return false;
        };

    }

}




