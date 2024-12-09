package org.files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class check {
    public static void main(String[] args){

        String email = "sohail10@gmail.com";
        String password = "1234";

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@title='My Account' and @class='dropdown-toggle']")).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.MILLISECONDS);

        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit' and @class='btn btn-primary']")).click();
//        driver.findElement(By.xpath("//a[@class='dropdown-toggle' and text()='Laptops & Notebooks']")).click();
//        driver.findElement(By.xpath("//a[@class='see-all' and text()='Show AllLaptops & Notebooks']")).click();
        WebElement lapAndNote = driver.findElement(By.xpath("//a[@class='dropdown-toggle' and text()='Laptops & Notebooks']"));
        WebElement allLapAndNote = driver.findElement(By.xpath("//a[@class='see-all' and text()='Show AllLaptops & Notebooks']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(lapAndNote).click(allLapAndNote).build().perform();

        driver.findElement(By.xpath("(//button[@type='button'])[15]")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[19]")).click();
        driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();

        String item1 = driver.findElement(By.xpath("(//a[text()='MacBook Air'])[2]")).getText();
        String item2 = driver.findElement(By.xpath("(//a[text()='MacBook Pro'])[2]")).getText();
        if(item1.equals("MacBook Air") && item2.equals("MacBook Pro")){
            System.out.println("Product Names matched and verified");
        }else{
            System.out.println("Could not verify product names!");
        }

        String totalPrice = driver.findElement(By.xpath("(//table[@class='table table-bordered'])[3]//tr[4]//td[2]")).getText();
        if(totalPrice.equals("$3,202.00")) {
            System.out.println("Total price verified");
        }else{
            System.out.println("Total price not verified");
        }

        driver.quit();

    }
}
