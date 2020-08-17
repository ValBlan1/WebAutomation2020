package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Optional;
import org.testng.annotations.*;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CommonAPI {

    public String browserStackUserName="vallerieblankins1";
    public String browserStackAccessKey="xzhKARjpajaPxdEDjM4y";
    public String sauceLabsUserName="vallerie115";
    public String sauceLabsAccessKey="200c1781-e03d-437d-a9df-baf961f496d9";
    public static ExtentReports extent;
    private static Set<String> windows = null;

    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutpuDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }

    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
        driver.quit();
    }

    @AfterSuite
    public void generateReport() {
        driver.quit();
    }
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    public static WebDriver driver = null;
    @Parameters({"useCloudEnv","cloudEnvName","url","os","os_version","browserName","browserVersion"})
    @BeforeMethod
    public void setUp(@Optional("false")String useCloudEnv, @Optional("browserstack")String cloudEnvName,@Optional String url,
                      @Optional("OS x")String OS, @Optional("10") String os_version, @Optional("Chrome")String browserName,
                      @Optional("84") String browserVersion)throws IOException {
        if (useCloudEnv.equalsIgnoreCase("true")) {
            getCloudDriver(cloudEnvName,browserStackUserName,browserStackAccessKey,OS,os_version,browserName,browserVersion);
        } else if (useCloudEnv.equalsIgnoreCase("false")){
            getLocalDriver(OS,browserName);
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40 , TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public WebDriver getLocalDriver(String OS, String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.chrome.driver", "..\\Generic\\driver\\chromedriver");
                driver = new ChromeDriver();
            }else if(OS.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.chrome.driver", "..\\Generic\\driver\\chromedriver.exe");
                driver = new ChromeDriver();
            }
        }else if (browserName.equalsIgnoreCase("firefox")) {
            if(OS.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.gecko.driver", "..\\Generic\\driver\\geckodriver");
                driver = new FirefoxDriver();
            } else if (OS.equalsIgnoreCase("Windows")) {
                System.setProperty("webdriver.gecko.driver", "..\\Generic\\driver\\geckodriver.exe");
                driver = new FirefoxDriver();

            }
        }

        return driver;
    }
    public WebDriver getCloudDriver(String envName, String envUserName, String envAccessKey, String OS,
                                    String os_version, String browserName, String browserVersion)throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser", browserName);
        cap.setCapability("browserVersion", browserVersion);
        cap.setCapability("os", OS);
        cap.setCapability("os_version", os_version);
        if(envName.equalsIgnoreCase("Saucelabs")){
            driver = new RemoteWebDriver(new URL("http://"+envUserName+":"+envAccessKey+
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
        }else if(envName.equalsIgnoreCase("Browserstack")) {
            driver = new RemoteWebDriver(new URL("http://" + envUserName + ":" + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), cap);
        }

        return driver;
    }
    @AfterMethod
    public void cleanUp(){
        driver.close();
    }

    public void clickOnElement(String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }
    public void typeOnElement(String locator, String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }
    public List<WebElement> getListOfWebElements(String locator){
        List<WebElement> elementList = driver.findElements(By.cssSelector(locator));

        return elementList;
    }
    public List<String> getListOfString(List<WebElement> elementList){
        List<String> listOfString = new ArrayList<String>();
        for(WebElement element:elementList){
            listOfString.add(element.getText());
        }
        return listOfString;
    }

    public void clearInputField(String locator){
        driver.findElement(By.cssSelector(locator)).clear();
    }
    public static void navigateBack(){
        driver.navigate().back();
    }
    //Synchronization
    public static void waitUntilClickAble(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitUntilSelectable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    public static void waitUntilClickAble(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitUntilVisible(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public static void waitUntilSelectable(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    public void sendKeysByChar(String keys, WebElement element){
        Arrays.asList(keys.toCharArray()).forEach((s) -> {
            element.sendKeys(String.valueOf(s));
        });
    }

    public void typeOnElementNEnter(String locator, String value){
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        }catch(Exception ex1) {
            try{
                System.out.println("First Attempt was not successful");
                driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
            }catch(Exception ex2) {
                try {
                    System.out.println("Second Attempt was not successful");
                    driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
                } catch (Exception ex3) {
                    System.out.println("Third Attempt was not successful");
                    driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
                }
            }
        }
    }
    // get links
    public void getLinks(String locator) {
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }

    public void clearField(String locator){
        driver.findElement(By.id(locator)).clear();
    }



    public static String convertToString(String st){
        String splitString ;
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }

    public void signInUserName(String locator, String value){
        //sign in user
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void signInPassWord(String locator, String value){
        //sign in password
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    List<String> items = new ArrayList<>();

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName + " " + df.format(date) + ".png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }
        public String getWindow(){
            List<String> newWindow = driver.getWindowHandles()
                    .stream()
                    .filter(n -> windows.contains(n) == false)
                    .collect(Collectors.toList()
                    );
            return newWindow.get(0);
        }
    public String getTextByCss(String locator) {
        String st = driver.findElement(By.cssSelector(locator)).getText();
        return st;
    }

    }


