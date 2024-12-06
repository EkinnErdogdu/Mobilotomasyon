package utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

    public class AppiumDriverManager {

        private AndroidDriver<MobileElement> driver;

        public AndroidDriver<MobileElement> getDriver() {
            return driver;
        }

        public void setDriver(AndroidDriver<MobileElement> driver) {
            this.driver = driver;
        }

        public void startAppiumServer() {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "Android Emulator");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appPackage", "com.akakce.android");
            caps.setCapability("appActivity", "com.akakce.android.activity.MainActivity");

            try {
                driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void stopAppiumServer() {
            if (driver != null) {
                driver.quit();
            }
        }
}

