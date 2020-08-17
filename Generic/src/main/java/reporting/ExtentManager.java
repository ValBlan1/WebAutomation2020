package reporting;

import org.testng.ITestContext;
import org.testng.Reporter;
import com.relevantcodes.extentreports.ExtentReports;


import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    private static ITestContext context;

    public synchronized static ExtentReports getInstance() {
        if (extent == null) {
            File outputDirectory = new File(context.getOutputDirectory());
            File resultDirectory = new File(outputDirectory.getParentFile(), "html");
            extent = new ExtentReports(System.getProperty("user.dir") + "\\Extent-Report\\ExtentReport.html");
            Reporter.log("Extent Report Directory" + resultDirectory, true);
            extent.addSystemInfo("HostName", "Local Instance")
                    .addSystemInfo("Environment", "Ebay")
                    .addSystemInfo("User Name", "Vallerie Blankinship");
            extent.loadConfig(new File(System.getProperty("user.dir") + "\\report-config.xml"));
        }
        return extent;
    }

    public static void setOutpuDirectory(ITestContext context) {
        ExtentManager.context = context;
    }
}
