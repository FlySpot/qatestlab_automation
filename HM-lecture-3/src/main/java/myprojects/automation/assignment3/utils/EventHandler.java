package myprojects.automation.assignment3.utils;

/**
 * Created by FlySpot on 19.04.2017.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EventHandler implements WebDriverEventListener {

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {    }

    @Override
    public void afterNavigateBack(WebDriver driver) {    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {    }

    @Override
    public void afterNavigateForward(WebDriver driver) {    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
//        System.out.println("Element found"+ webElement.getTagName());
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Element found");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
 //       System.out.println("Should click");
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
//        System.out.println("Clicked successfull");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {  }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {    }

    @Override
    public void beforeScript(String script, WebDriver driver) {    }

    @Override
    public void afterScript(String script, WebDriver driver) {    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {    }
/*
    public static void logAction(String message) {
        Reporter.log(String.format("[%-12s] ACTION: %s", LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME), message));
        String.format("Change value of %s: %s\n", element.getTagName(), value);
    }
    */
}