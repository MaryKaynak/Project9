package project9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class project9 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Parameters({"username", "password"})
    @BeforeClass
    public void setup(String username, String password) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hilal\\TechnoStudy\\Selenium\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://test-basqar.mersys.io/");

        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
    }


    @AfterClass
    public void quit() {
        driver.quit();

    }


        @Test
        public void group () {
            driver.findElement(By.cssSelector(".group-items > :nth-child(6)")).click();
            driver.findElement(By.cssSelector(".group-items > :nth-child(6) > .children > :nth-child(1)")).click();
            driver.findElement(By.cssSelector(".group-items > :nth-child(6) > .children > :nth-child(1) .children > :nth-child(1)")).click();
            driver.findElement(By.cssSelector("[data-icon='plus']")).click();

            driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]")).sendKeys("groupFourhilal");
            driver.findElement(By.cssSelector("#mat-select-2")).click();

            driver.findElement(By.xpath("//*[@id=\"mat-option-11\"]/span")).click();
            driver.findElement(By.xpath("//*[@id=\"mat-input-7\"]")).sendKeys("01/06/2020");

            driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")).sendKeys("03/015/2020");
            driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]")).sendKeys("Finish");

            driver.findElement(By.xpath("//*[@id=\"mat-tab-label-0-1\"]")).click();
            driver.findElement(By.xpath("//input[@class='mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-untouched ng-pristine ng-invalid']")).sendKeys("49");
            driver.findElement(By.xpath("//ms-decimal-field//input")).sendKeys("22112");
            driver.findElement(By.xpath("//*[@id=\"mat-tab-content-0-1\"]/div/budget-group-dialog-constant/div/div[1]/div/ms-button")).click();


            WebElement saveIcon = driver.findElement(By.cssSelector("mat-dialog-container [data-icon='save'] "));
            saveIcon.click();


            try {
                wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='Budget Group successfully created']" ) ) );

            } catch( Exception e) {
                Assert.fail( "Delete failure", e );
            }

        }
    }

