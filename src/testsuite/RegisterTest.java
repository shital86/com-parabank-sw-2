package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //click on the ‘Register’ link
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
       // Verify the text ‘Signing up is easy!
        String expectedresult = "Signing up is easy!";
        WebElement actualresult = driver.findElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        String actualResult = actualresult.getText();
        System.out.println(actualResult);
        Assert.assertEquals("Verifying the results", expectedresult, actualResult);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        //click on the ‘Register’ link
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        //Enter First name
        driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Paul");
        //Enter Last name
        driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Marsh");
        //Enter Address
        driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("10th Avenue");
        //Enter City
        driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Bombay");
       //Enter State
        driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Maharashtra");
       //Enter Zip Code
        driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys("1234");
       //Enter Phone
        driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("98234567898");
       //Enter SSN
        driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("101");
       //Enter Username
        driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys("Paula");
       //Enter Password
        driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("Welcome11");
       //Enter Confirm
        driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("Welcome11");
      //Click on REGISTER button
        driver.findElement(By.xpath("//tbody/tr[13]/td[2]/input[1]")).click();
      //Verify the text 'Your account was created successfully. You are now logged in.’
        String expectedresult = "Your account was created successfully. You are now logged in.";
        WebElement actualresult = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        String actualResult = actualresult.getText();
        System.out.println(actualResult);
        Assert.assertEquals("Verifying the results:", expectedresult, actualResult);
    }
}
