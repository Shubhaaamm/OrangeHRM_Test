package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage {
    WebDriver driver;

    By pimMenu = By.xpath("//span[text()='PIM']");
    By addEmployeeBtn = By.xpath("//a[text()='Add Employee']");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By saveBtn = By.xpath("//button[@type='submit']");

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addEmployee(String fName, String lName) {
        driver.findElement(pimMenu).click();
        driver.findElement(addEmployeeBtn).click();
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(saveBtn).click();
    }
}
