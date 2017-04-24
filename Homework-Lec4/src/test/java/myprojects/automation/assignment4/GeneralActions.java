package myprojects.automation.assignment4;


import myprojects.automation.assignment4.model.ProductData;
import myprojects.automation.assignment4.utils.Properties;
import myprojects.automation.assignment4.utils.logging.CustomReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    public String productNameStr;
    public String productCountStr;
    public String productPriceStr;
    String [] arrFields;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        CustomReporter.log("Login as user - " + login);

        // TODO implement logging in to Admin Panel
        driver.navigate().to(Properties.getBaseAdminUrl());
        driver.findElement(By.cssSelector("#email")).sendKeys(login);
        WebElement passwordInput = driver.findElement(By.cssSelector("#passwd"));
        passwordInput.sendKeys(password);
        driver.findElement(By.cssSelector("#login_form button[name='submitLogin']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("main")));
    }

    public String[] createProduct(String newProduct) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#subtab-AdminCatalog")));
        WebElement catalogLink = driver.findElement(By.cssSelector("#subtab-AdminCatalog"));
        WebElement productLink = driver.findElement(By.cssSelector("#subtab-AdminProducts > a:nth-child(1)"));

        Actions actions = new Actions(driver);
        actions.moveToElement(catalogLink).moveToElement(productLink).perform();
        productLink.click();

        // searching 'Add product button and click it
        driver.findElement(By.cssSelector("#page-header-desc-configuration-add > i:nth-child(1)")).click();

        // populate mandatory fields and create new category
        // product Name
        WebElement productName = driver.findElement(By.cssSelector("#form_step1_name_1"));
        productNameStr = newProduct + String.valueOf((int)(Math.random() * 100));
        productName.sendKeys(productNameStr);

        // pass to Amount tab
        driver.findElement(By.cssSelector("#tab_step3 > a:nth-child(1)")).click();
        // populate amount
        WebElement productAmount = driver.findElement(By.cssSelector("#form_step3_qty_0"));
        productCountStr = String.valueOf((int)(Math.random() * 150));
        productAmount.sendKeys(Keys.BACK_SPACE);
        productAmount.sendKeys(productCountStr);

        // pass to Price tab
        driver.findElement(By.cssSelector("#tab_step2 > a:nth-child(1)")).click();
        // populate Price
        WebElement productPrice = driver.findElement(By.cssSelector("#form_step2_price_ttc"));
        productPriceStr = String.valueOf((int)(Math.random() * 1000));
        productPrice.sendKeys(Keys.BACK_SPACE);
        productPrice.sendKeys(productPriceStr);

        // click on 'On site' switch
        driver.findElement(By.cssSelector(".switch-input")).click();
        // Click on Save
        driver.findElement(By.cssSelector("button.js-btn-save")).click();
        CustomReporter.log("Created product - " + productNameStr);

        arrFields = new String[] {productNameStr, productCountStr, productCountStr};
        return arrFields;
    }

    public void checkProduct() {
        driver.navigate().to(Properties.getBaseUrl());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("s")));

        //search by product Name
        WebElement searchField = driver.findElement(By.name("s"));
        System.out.println("Arrived element - " + arrFields[0]);
        searchField.sendKeys(arrFields[0]);
        // click on it
        WebElement searchButton = driver.findElement(By.cssSelector("#search_widget > form:nth-child(1) > button:nth-child(4)"));
        searchButton.click();
        System.out.println("Found element - " + arrFields[0]);

        // inspect search result and click on one
        WebElement itemsList = driver.findElement(By.cssSelector(".product-description"));
        itemsList.click();
        System.out.println("Clicked by element - " + arrFields[0]);
        // inspect product details
        // Verify Name
        WebElement itemName = driver.findElement(By.cssSelector(".h1"));
        System.out.println("Found Name - " + itemName.getText());
        Assert.assertTrue(driver.findElement(By.cssSelector(".h1")).getText().contentEquals(arrFields[0]),"Product Name NOT Equal!");
        // Verify Count
        WebElement itemCount = driver.findElement(By.cssSelector(".product-quantities > span:nth-child(2)"));
        System.out.println("Found Count - " + itemCount.getText());
        Assert.assertTrue(driver.findElement(By.cssSelector(".product-quantities > span:nth-child(2)")).getText().contentEquals(arrFields[0] + "Товары"),"Product Count NOT Equal!");
        // Verify Price
        WebElement itemPrice = driver.findElement(By.cssSelector(".current-price > span:nth-child(1)"));
        System.out.println("Found Price - " + itemPrice.getText());
        Assert.assertTrue(driver.findElement(By.cssSelector(".current-price > span:nth-child(1)")).getText().contentEquals(arrFields[0] + ",00 ₴"),"Product Price NOT Equal!");
    }

}
