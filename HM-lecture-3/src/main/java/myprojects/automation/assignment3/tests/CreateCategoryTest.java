package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateCategoryTest extends BaseScript {

    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";
    private static String categoryName = "Homework2";


    public static void main(String[] args) throws InterruptedException {
        // TODO prepare driver object
        WebDriver driver = getConfiguredDriver();

        // login
        GeneralActions action = new GeneralActions(driver);
        action.login(login, password);

        // create category
        action.createCategory(categoryName);
        //action.createCategoryJS();
        // check that new category appears in Categories table
        //sort by Name
        action.sortByName();
        //logout
        action.logout();
        // finish script
    }
}
