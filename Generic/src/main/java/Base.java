import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;

public class Base {
    public WebDriver driver = null;
    public Logger log = Logger.getLogger(Base.class.getName());

    @Parameters({"useSauceLab", "userName", "key", "appUrl", "os", "browserName", "browserVersion"})
    @BeforeMethod
    public void setUp(boolean useSauceLab, String userName, String key, String appUrl, String os, String browserName, String browserVersion) throws IOException {
        if (useSauceLab == true) {
            //getSauceLabDriver(userName, key, os, browserName, browserVersion);
        } else {
            getLocalDriver(os, browserName);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(appUrl);
        driver.manage().window().maximize();
        log.info("browser loaded with App");
    }

    @AfterMethod
    public void cleanUp() throws InterruptedException {
        log.info("driver is quiting");
        driver.quit();
        System.out.println();
    }

    //get local driver
    public WebDriver getLocalDriver(String os, String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {
            //driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "/Users/u727759/Desktop/Amazon/Generic/src/main/driver/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "/Users/u727759/Desktop/Amazon/Generic/src/main/driver/chromedriver"); }
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            //driver = new SafariDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "");
            //driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("htmlunit")) {
            //driver = new HtmlUnitDriver();
        }
        return driver;
    }

    public void clickByXpath(String xpath) throws InterruptedException{
        Thread.sleep(3000);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void sendTestByXpath(String xpath, String data) throws InterruptedException{
        Thread.sleep(3000);
        driver.findElement(By.xpath(xpath)).sendKeys(data);
    }

    public static String readFromExcel(String fileRef, String sheetRef, String cellRef) throws IOException {
        FileInputStream fis = new FileInputStream(fileRef);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetRef);
        DataFormatter formatter = new DataFormatter();
        CellReference cellReference = new CellReference(cellRef);
        Row row = sheet.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getCol());
        String value = "";
        if (cell != null) {
            value = formatter.formatCellValue(cell);//cell.getStringCellValue();
        }
        return value;
    }

    public String name = null;

    public void takeTheScreenshot(String testCaseName) throws Exception {
        System.out.println(name);

        System.out.println("------------------------------");
        Thread.sleep(3000);
        String screenShotLocation = "/Users/u727759/Desktop/Amazon/Buncee/src/test/TestResult/Screenshot/";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String currentTime = dateFormat.format(date); //2016/11/16 12:08:43
        System.out.println("---------------------"+currentTime);

        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(screenShotLocation + testCaseName + "_" +currentTime + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
    }



}