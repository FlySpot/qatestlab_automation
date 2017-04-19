package myprojects.automation.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    //private By catalogueLink = By.cssSelector("#subtab-AdminCatalog");
    //private By categoriesLink = By.cssSelector("#subtab-AdminCategories");

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement loginInput = driver.findElement(By.cssSelector("#email"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#passwd"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login_form button[name='submitLogin']"));
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    /**
     * Adds new category in Admin Panel.
     * @param categoryName
     */
    public void createCategory(String categoryName) {
        String confirmationMessage = "×\nСоздано";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#subtab-AdminCatalog")));
        WebElement catalogLink = driver.findElement(By.cssSelector("#subtab-AdminCatalog"));
        WebElement categoriesLink = driver.findElement(By.cssSelector("#subtab-AdminCategories"));

        Actions actions = new Actions(driver);
        actions.moveToElement(catalogLink).moveToElement(categoriesLink).perform();
        categoriesLink.click();
        // searching 'Add Category button and click it
        WebElement catalogAdd = driver.findElement(By.cssSelector("#page-header-desc-category-new_category"));
        catalogAdd.click();
        // populate mandatory fields and create new category
        WebElement nameField = driver.findElement(By.cssSelector("#name_1"));
        nameField.sendKeys(categoryName);

        WebElement chpuField = driver.findElement(By.cssSelector("#link_rewrite_1"));
        chpuField.sendKeys(categoryName);

        WebElement submittBtn = driver.findElement(By.cssSelector("#category_form_submit_btn"));
        submittBtn.click();

        // Check confirmation message
//        String afterCreationMessage = driver.findElement(By.className("//*[@id=\"content\"]/div[3]/div/text()")).getText();
        String afterCreationMessage = driver.findElement(By.cssSelector("#content>div:nth-child(4)>div")).getText();
               if (afterCreationMessage.equals(confirmationMessage)) {
            System.out.println(afterCreationMessage); // выводим в консоль сообщение
        }
    }
/*
    public void createCategoryJS () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesLink));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement categoriesLink = driver.findElement(this.categoriesLink);
        executor.executeScript("arguments[0].click()",categoriesLink);
    }
*/
    /**
     * Sort By Name
     */
    public void sortByName() {
        WebElement sortButton = driver.findElement(By.cssSelector("#table-category > thead > tr:nth-child(1) > th:nth-child(3) > span > a:nth-child(1) > i"));
        sortButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tr_2_19_6\"]/td[3]")));
    }


    /**
     * Logout
     */
    public void logout() {
        WebElement logoutField = driver.findElement(By.cssSelector("#header_employee_box"));
        logoutField.click();
        WebElement logoutLink = driver.findElement(By.cssSelector("#header_logout"));
        logoutLink.click();
    }

}
