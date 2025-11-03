package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;

    By profileMenu = By.xpath("//p[@class='oxd-userdropdown-name']");
    By logoutLink = By.xpath("//a[text()='Logout']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        driver.findElement(profileMenu).click();
        driver.findElement(logoutLink).click();
    }
}
