package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    private static final Logger logger = LogManager.getLogger(Utility.class);

    // 📸 Take a screenshot and save it under /screenshots with timestamp
    public static void takeScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            logger.error("Driver is null, cannot capture screenshot for: " + testName);
            return;
        }

        // Create timestamp for unique file names
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String destDir = System.getProperty("user.dir") + "/screenshots/";
        String destPath = destDir + testName + "_" + timestamp + ".png";

        try {
            // Create folder if not exists
            File directory = new File(destDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Capture and save file
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(destPath));

            logger.info(" Screenshot captured: " + destPath);
        } catch (IOException e) {
            logger.error(" Failed to capture screenshot for test: " + testName, e);
        }
    }

    // 🕒 Optional: wait helper for demo/testing
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            logger.error("Sleep interrupted", e);
            Thread.currentThread().interrupt();
        }
    }
}
