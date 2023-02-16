package org.zuno.Pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

    WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'My account')]")
    WebElement myAccount;

    @FindBy(xpath = "//div[@class='sc-b0501e6f-1 kFPFHq']")
    WebElement popUpDimension;

    @FindBy(xpath = "//div[@class='sc-b0501e6f-0 ewDiMe']")
    WebElement webPageDimension;


    public Home(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnAccount(){
        myAccount.click();
    }

    public Dimension getWebPageDimension(){
        Dimension dimension=webPageDimension.getSize();
        return dimension;
    }

    public Dimension getPopUpDimension(){
        Dimension dimension=popUpDimension.getSize();
        return dimension;
    }

    public Point getPopUpXYStartPoint(){
        Point point=popUpDimension.getLocation();
        return point;
    }





}
