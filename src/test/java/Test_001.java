
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.Test;

import base.BaseClass;
import utils.Screen;

import java.io.File;

import static parameter.GlobalParameters.USERDIR;


public class Test_001 extends BaseClass {

    static private ExtentReports extentReports;
    static private ExtentTest extentTest;

    @Test
    public void setup() throws InterruptedException {
        extentReports = new ExtentReports(USERDIR + File.separator + "report.html", false);
        extentReports.loadConfig(new File(USERDIR + "report_config.xml"));
        extentTest = extentReports.startTest("TEST AUTOMATION");

        Thread.sleep(5000);
        extentTest.addBase64ScreenShot(Screen.getBase64MobileScreenshot(driver));
    }
}