package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import appium.AppiumServer;
import com.sun.org.apache.xpath.internal.operations.And;
import emu.AndroidEmu;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import static parameter.GlobalParameters.APK_PATH;

public class BaseClass {

        public static AppiumDriver<MobileElement> driver;
        public static AppiumServer server;
        public String emuName = "emulator-4443";

        @BeforeTest
        @Parameters({"udid", "platformVersion","url1","url2","appname"})
        public void setup(String udid,String platformVersion,String url1, String url2, String appName) throws InterruptedException, MalformedURLException
        {

            server = new AppiumServer();
            Thread.sleep(5000);

            DesiredCapabilities cap=new DesiredCapabilities();
            cap.setCapability("deviceName", emuName);
            cap.setCapability("udid", udid);
            cap.setCapability("app", APK_PATH + appName + ".apk");
            cap.setCapability("platformName", "Android");
            cap.setCapability("platformVersion", platformVersion);
            driver=new AppiumDriver<MobileElement>(new URL(url1 + server.getPort() + url2), cap);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            Thread.sleep(5000);
        }

        @AfterTest
        public void tearDown() throws InterruptedException {
            AndroidEmu.closeEmu();
            server.stop();
            Thread.sleep(5000);
            System.out.println("APPIUM STOPPING");
        }
}

