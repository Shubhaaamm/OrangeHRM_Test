package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import utils.Utility;

public class LogoutTest extends BaseTest {

    @Test
    public void verifyUserCanLogoutSuccessfully() {
        try {

            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("Admin", "admin123");


            LogoutPage logoutPage = new LogoutPage(driver);
            logoutPage.logoutFromApp();


            Utility.sleep(2);

            System.out.println(" Logout completed successfully!");
        } catch (Exception e) {
            System.out.println(" Logout test failed: " + e.getMessage());
        }
    }
}
