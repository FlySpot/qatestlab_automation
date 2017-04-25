package myprojects.automation.assignment5;


import myprojects.automation.assignment5.model.ProductData;
import myprojects.automation.assignment5.utils.logging.CustomReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void openRandomProduct() {
        // TODO implement logic to open random product before purchase
        List<WebElement> elements = driver.findElements(By.className("thumbnail-container"));
        WebElement webElement = elements.get(new Random().nextInt(elements.size()));
        webElement.click();
        //throw new UnsupportedOperationException();
    }

    /**
     * Extracts product information from opened product details page.
     *
     * @return
     */
    public ProductData getOpenedProductInfo() {
        CustomReporter.logAction("Get information about currently opened product");
        // TODO extract data from opened page
         throw new UnsupportedOperationException();
    }

    public ProductData getProductIntoCart() {
        CustomReporter.logAction("Get a product into Cart");
        WebElement productaddToCartButton = driver.findElement(By.cssSelector("button.btn-primary"));
        productaddToCartButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#myModalLabel")));
        driver.findElement(By.cssSelector(".close")).click();
        throw new UnsupportedOperationException();
    }

    public ProductData passToCart() {
        CustomReporter.logAction("Pass to Cart");
        driver.findElement(By.cssSelector(".header > a:nth-child(1) > span:nth-child(2)")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.btn")));
        driver.findElement(By.cssSelector("a.btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout-personal-information-step > h1:nth-child(1)")));
        throw new UnsupportedOperationException();
    }

    public ProductData purchaseItemsinCart() {
        CustomReporter.logAction("Fill mandatory user data");
        WebElement nameField = driver.findElement(By.cssSelector("#customer-form > section:nth-child(1) > div:nth-child(3) > div:nth-child(2) > input:nth-child(1)"));
        nameField.sendKeys("Ivan");
        WebElement sernameField = driver.findElement(By.cssSelector("div.form-group:nth-child(4) > div:nth-child(2) > input:nth-child(1)"));
        sernameField.sendKeys("Ivanov");
        WebElement emailField = driver.findElement(By.cssSelector("#customer-form > section:nth-child(1) > div:nth-child(3) > div:nth-child(2) > input:nth-child(1)"));
        emailField.sendKeys("none@i.ua");

        driver.findElement(By.cssSelector("#customer-form > footer:nth-child(2) > button:nth-child(2)")).click();
        //step2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout-addresses-step > h1:nth-child(1)")));
        CustomReporter.logAction("Fill address data");
        WebElement addressField = driver.findElement(By.cssSelector(".form-fields > div:nth-child(9) > div:nth-child(2)"));
        addressField.sendKeys("address");
        WebElement postIndexField = driver.findElement(By.cssSelector("div.form-group:nth-child(11) > div:nth-child(2)"));
        postIndexField.sendKeys("65000");
        WebElement cityField = driver.findElement(By.cssSelector("div.form-group:nth-child(12) > div:nth-child(2)"));
        cityField.sendKeys("City");
        driver.findElement(By.cssSelector("#delivery-address > div:nth-child(1) > footer:nth-child(2) > button:nth-child(2)")).click();
        //step 3
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout-delivery-step > h1:nth-child(1)")));
        CustomReporter.logAction("Pass delivery step");
        driver.findElement(By.cssSelector("#js-delivery > button:nth-child(2)")).click();
        //step4
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout-payment-step > h1:nth-child(1)")));
        CustomReporter.logAction("Check payment options");
        driver.findElement(By.cssSelector("#payment-option-1")).click();
        driver.findElement(By.cssSelector("#conditions_to_approve\\[terms-and-conditions\\]")).click();
        driver.findElement(By.cssSelector("div.ps-shown-by-js > button:nth-child(1)")).click();
        //confirmation
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.h1")));

        throw new UnsupportedOperationException();
    }
}
