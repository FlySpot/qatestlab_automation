package myprojects.automation.assignment2.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * Created by FlySpot on 29.03.2017.
 */
public class MainTest extends BaseScript{
    private static String BASE_URL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";

    public static  void main(String[] args) {
        String logintext = "webinar.test@gmail.com";
        String passwdtext = "Xcg7299bnSmMuRLp9ITw";

        WebDriver driver = getDriver();

        driver.manage().window().maximize();
        driver.get(BASE_URL);  // проходим по url
        sleep(500); // ждем

        // находим логин, пароль поля и кнопку войти
        WebElement loginField = driver.findElement(By.cssSelector("#email"));
        WebElement passwordField = driver.findElement(By.cssSelector("#passwd"));
        WebElement buttonEnter = driver.findElement(By.cssSelector("[name='submitLogin']"));
        loginField.sendKeys(logintext);  // прописываем логин
        passwordField.sendKeys(passwdtext);  // прописываем пароль
        buttonEnter.click(); // жмем enter по кнопке
        sleep(3000);

        List<WebElement> menuitems = driver.findElements(By.xpath("//nav[@id='nav-sidebar']//li[contains(@class,'maintab')]/a"));
        for(WebElement element : menuitems){
            element.click();
            String pageTitleBeforeRefresh = driver.findElement(By.className("page-title")).getText();
           driver.navigate().refresh();

            WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("page-title")));

            String pageTitleAfterRefresh = driver.findElement(By.className("page-title")).getText();
//            System.out.println(pageTitleAfterRefresh);
            if (pageTitleBeforeRefresh == pageTitleAfterRefresh) {
            System.out.println(pageTitleAfterRefresh); // выводим в консоль заголовок страницы
            }

        }


        sleep(1000);
        WebElement logoutField = driver.findElement(By.cssSelector("#header_employee_box"));
        logoutField.click();
        WebElement logoutLink = driver.findElement(By.cssSelector("#header_logout"));
        logoutLink.click();

    }

    public static void  sleep(long ms) {
        try {
            Thread.sleep(3000);
        }   catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
