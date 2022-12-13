package com.ILab.testCases;

import com.ILab.pageObjects.CareerPage;
import com.ILab.utilities.XLUtils;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_JobsZA_001 extends BaseClass {

    @Test(dataProvider = "iLabTest")
    public void detailsTest(String name, String surname) throws Exception{

        CareerPage cPage = new CareerPage(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get(baseURL);

        test.log(LogStatus.PASS, "Launch page");

        if(driver.getTitle().equals("South Africa - iLab2")){

            Assert.assertTrue(true);
        }else{

            captureScreen(driver,"detailsTest");
            Assert.fail();
        }

        driver.manage().window().maximize();
        js.executeScript("window.scrollBy(0,800)");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        cPage.clickZARbutton();
        test.log(LogStatus.PASS, "Clicked on ZAR Button");

        js.executeScript("window.scrollBy(0,500)");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        cPage.clickFirstJobAvailable();
        test.log(LogStatus.PASS, "First JOB available");

        js.executeScript("window.scrollBy(0,1300)");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        cPage.acceptBTN();

        //Filling th form
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.switchTo().frame("hs-form-iframe-0");
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        cPage.setName(name);
        test.log(LogStatus.PASS, "Entered candidate name");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        cPage.setSurname(surname);
        test.log(LogStatus.PASS, "Entered candidate surname");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        cPage.setEmail(candidateEmail);
        test.log(LogStatus.PASS, "Entered email");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        cPage.setPhoneNumber(candidatePhoneNumber);
        test.log(LogStatus.PASS, "Entered phone number");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        cPage.submit();
        test.log(LogStatus.PASS, "Clicked on submit");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        cPage.checkMessage();

    }

    @DataProvider(name="iLabTest")
    public String [][] getData() throws IOException {

        String path=(System.getProperty("user.dir") + "/src/main/java/com/ILab/testData/iLabTestData.xlsx");

        int rownum= XLUtils.getRowCount(path,"Sheet1");
        int colcount= XLUtils.getCellCount(path, "Sheet1", 1);

        String candidateData[][]=new String[rownum][colcount];

        for(int i=1;i<=rownum;i++){
            for(int j=0;j<colcount;j++){
                candidateData[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
                System.out.println(candidateData);
            }
        }

       return candidateData;
    }

}
