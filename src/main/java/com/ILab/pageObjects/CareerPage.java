package com.ILab.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareerPage {

    WebDriver driver;

    public CareerPage (WebDriver rDriver){

        driver = rDriver;
        PageFactory.initElements(rDriver, this);

    }
    @FindBy(xpath = "/html/body/div[3]/div/div/div/article/div/div/div/div[3]/div[2]/div[2]/div/div")
    WebElement ZARbutton;

    @FindBy(xpath = "//*[@id=\"post-280245\"]/div/div/div/div[2]/div[2]/div/div/div/ul/li[1]/a")
    WebElement firstAvailableJob;

    @FindBy(id = "firstname-91269253-d0ea-4409-a821-873cda679554")
    WebElement nameField;

    @FindBy(id = "lastname-91269253-d0ea-4409-a821-873cda679554")
    WebElement surnameField;

    @FindBy(xpath = "//*[@id=\"hsForm_91269253-d0ea-4409-a821-873cda679554\"]/div[1]/div[2]/input")
    WebElement  submitButton;

    @FindBy(id = "email-91269253-d0ea-4409-a821-873cda679554")
    WebElement candidateEmail;

    @FindBy(id = "phone-91269253-d0ea-4409-a821-873cda679554")
    WebElement candidatePhone;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[2]/button[3]")
    WebElement acceptButton;

    @FindBy(xpath = "//*[@id=\"hsForm_91269253-d0ea-4409-a821-873cda679554\"]/fieldset[5]/div/ul/li/label")
    WebElement errorText;

    public boolean checkMessage(){

        if(errorText.isDisplayed()){
            System.out.println("############# Visible");
            return true;
        }else{
            return false;
        }
    }

    public void setEmail(String email)
    {candidateEmail.sendKeys(email);}

    public void setSurname(String surname){
        surnameField.click();
        surnameField.sendKeys(surname);
    }

    public void setPhoneNumber(String number){candidatePhone.sendKeys(number);}
    public void acceptBTN(){acceptButton.click();}

    public void submit(){
        submitButton.click();
    }

    public void setName(String name){
        nameField.click();
        nameField.sendKeys(name);}


    public void clickZARbutton(){
        ZARbutton.click();
    }

    public void clickFirstJobAvailable(){
        firstAvailableJob.click();
    }

}
