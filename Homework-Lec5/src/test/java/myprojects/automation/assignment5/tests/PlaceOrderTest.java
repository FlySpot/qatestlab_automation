package myprojects.automation.assignment5.tests;

import myprojects.automation.assignment5.BaseTest;
import myprojects.automation.assignment5.utils.Properties;
import org.testng.annotations.Test;

public class PlaceOrderTest extends BaseTest {

    @Test
    public void checkSiteVersion() {
        // TODO open main page and validate website version
    }

    @Test
    public void createNewOrder() {
        // TODO implement order creation test
        driver.navigate().to(Properties.getBaseUrl());
        // open random product
        actions.openRandomProduct();

        // save product parameters
        actions.getOpenedProductInfo();
        // add product to Cart and validate product information in the Cart
        actions.getProductIntoCart();
        // proceed to order creation, fill required information
        actions.passToCart();
        actions.purchaseItemsinCart();
        // place new order and validate order summary
        // check updated In Stock value
    }

}
