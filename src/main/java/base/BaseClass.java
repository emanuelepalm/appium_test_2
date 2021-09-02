package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import static parameter.GlobalParameters.APK_PATH;

public class BaseClass {

        public static AppiumDriver<MobileElement> driver;

        @BeforeTest
        @Parameters({"udid", "platformVersion","url"})
        public void setup(String udid,String platformVersion,String url) throws InterruptedException, MalformedURLException
        {
            DesiredCapabilities cap=new DesiredCapabilities();
            cap.setCapability("deviceName", "emulator-4443");
            cap.setCapability("udid", udid);
            cap.setCapability("app", APK_PATH);
            cap.setCapability("platformName", "Android");
            cap.setCapability("platformVersion", platformVersion);
            driver=new AppiumDriver<MobileElement>(new URL(url), cap);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            Thread.sleep(5000);
        }
}

