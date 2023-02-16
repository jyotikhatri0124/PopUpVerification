package org.zuno;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.zuno.Pages.Home;


//using start point of pop up in X and Y direction we can check if pop up is in center or not.

//formula--> ((width of web window-width of pop up))/2--> so if start point of pop up is equal to this value it will be in center for
//calculating height of pop up.
// ((height of web window-height of pop up)/2)
public class PopUpAssignment {

    WebDriver driver;
    Home home;

    @BeforeSuite
    public void initDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        driver=new ChromeDriver();
    }

    @Test
    public void verifyPopUpAlignment(){
        driver.get("https://www.hizuno.com/");
        driver.manage().window().maximize();

        home=new Home(driver);

        //clicking on my account page
        home.clickOnAccount();

        //fetching web page dimension-->width and height both
        Dimension webPageDimension=home.getWebPageDimension();

        //fetching pop up dimension-->width and height both
        Dimension popUpDimension=home.getPopUpDimension();

        //fetching start point of pop up from X and Y direction
        Point popUpXYPoint = home.getPopUpXYStartPoint();

        //calling method to verify if pop up is in center or not
        boolean result=verifyLocationOfPopUp(webPageDimension,popUpDimension,popUpXYPoint);
        Assert.assertTrue(result,"Pop up is not in center");
    }


    //common method for identifying if pop up is in center or not
    public static boolean verifyLocationOfPopUp(Dimension windowDimension, Dimension popUpDimension, Point popUpXYPoint){

        int widthPaddingValue =  Math.round((windowDimension.getWidth()-popUpDimension.width)/2);
        int heightPaddingValue =  Math.round((windowDimension.getHeight()-popUpDimension.height)/2);
        if(widthPaddingValue==popUpXYPoint.getX() && heightPaddingValue==popUpXYPoint.getY()){
            System.out.println("Pop up is in center ");
            System.out.println(widthPaddingValue+" " +popUpXYPoint.getX());
            System.out.println(heightPaddingValue+" " +popUpXYPoint.getY());
            return true;
        }else{
            return false;
        }


    }
}

