
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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
        try {
            extentReports = new ExtentReports(USERDIR + File.separator + "report" + File.separator + "report.html", true);
            extentReports.loadConfig(new File(USERDIR + File.separator + "report_config.xml"));
            extentTest = extentReports.startTest("TEST AUTOMATION");

            Thread.sleep(5000);
            extentTest.log(LogStatus.PASS,"PASS",extentTest.addBase64ScreenShot(Screen.getBase64MobileScreenshot(driver)));
            System.out.println("SUCCESS!!!");

            extentReports.endTest(extentTest);
            extentReports.close();
        } catch (Exception e){
            System.out.println("FAILED: " + e.getMessage());
        }
    }
}