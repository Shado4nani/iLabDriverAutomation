package com.ILab.testCases;

import com.ILab.utilities.ReadConfigFile;
//import com.aventstack.extentreports.reporter.FileUtil;
import com.beust.jcommander.Parameter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class BaseClass {

    ReadConfigFile readconfig = new ReadConfigFile();
    public String baseURL=readconfig.readProperty("baseURL");
    public String candidateEmail = "automationAssessment@iLABQuality.com";
    public String errorMessage = "Please complete this required field.";

    public static WebDriver driver;

    public static ExtentReports report;
    public static ExtentTest test;


    @Parameters("browser")
    @BeforeClass
    public void setup(String browser){

        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//src//main//resources//Drivers//chromedriver");
            driver=new ChromeDriver();
        } else if (browser.equals("firefox")) {

            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//src//main//resources//Drivers//geckodriver");
            driver=new ChromeDriver();

        }

        report = new ExtentReports(System.getProperty("user.dir")+"/iLabDriverAutomation/iLabReport.html");
        test = report.startTest("iLabReportTest");
    }

    @AfterClass
    public  void tearDown(){

        report.endTest(test);
        report.flush();
        //driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source,target);
        System.out.println("Screen taken");
    }
}
