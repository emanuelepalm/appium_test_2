package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import appium.AppiumServer;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import static parameter.GlobalParameters.APK_PATH;

public class BaseClass {

        public static AppiumDriver<MobileElement> driver;
        public static AppiumServer server;

        @BeforeTest
        @Parameters({"udid", "platformVersion","url1","url2"})
        public void setup(String udid,String platformVersion,String url1, String url2) throws InterruptedException, MalformedURLException
        {
            server = new AppiumServer();
            Thread.sleep(5000);
            DesiredCapabilities cap=new DesiredCapabilities();
            cap.setCapability("deviceName", "emulator-4443");
            cap.setCapability("udid", udid);
            cap.setCapability("app", APK_PATH);
            cap.setCapability("platformName", "Android");
            cap.setCapability("platformVersion", platformVersion);
            driver=new AppiumDriver<MobileElement>(new URL(url1 + server.getPort() + url2), cap);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            Thread.sleep(5000);
        }
}

