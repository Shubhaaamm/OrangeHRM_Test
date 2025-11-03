package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utility;

public class LogoutPage {
    private WebDriver driver;

    // Locators
    private By profileMenu = By.xpath("//p[@class='oxd-userdropdown-name']");
    private By logoutButton = By.xpath("//a[text()='Logout']");

    // Constructor
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickProfileMenu() {
        WebElement menu = driver.findElement(profileMenu);
        menu.click();
        Utility.sleep(1);
    }

    public void clickLogout() {
        WebElement logout = driver.findElement(logoutButton);
        logout.click();
    }

    // Combined action
    public void logoutFromApp() {
        clickProfileMenu();
        clickLogout();
    }
}
