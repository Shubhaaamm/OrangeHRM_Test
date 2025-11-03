package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import utils.Log;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testLoginLogout() {
        Log.info("Starting Login and Logout test");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        Log.info("Logged in successfully");
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.logout();

        Log.info("Logged out successfully");
    }
}
