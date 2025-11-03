package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.EmployeePage;
import utils.Log;

public class AddEmployeeTest extends BaseTest {

    @Test(priority = 2)
    public void testAddEmployee() {
        Log.info("Starting Add Employee test");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        EmployeePage empPage = new EmployeePage(driver);
        empPage.addEmployee("John", "Doe");

        Log.info("Employee added successfully");
    }
}
