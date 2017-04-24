package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseTest;
import myprojects.automation.assignment4.GeneralActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateProductTest extends BaseTest {
    private static String productName = "Homework4-";
    @Test
    public void createNewProduct() {
        actions.login("webinar.test@gmail.com","Xcg7299bnSmMuRLp9ITw");
        Assert.assertTrue(driver.findElement(By.className("page-title")).getText().contains("Пульт"),"Wrong Title!");

        actions.createProduct(productName);

        actions.checkProduct();
    }

}
