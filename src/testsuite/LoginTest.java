package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {

        openBrowser(baseUrl);//Launching Url
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter valid username
        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]")).sendKeys("nora");
        //Enter valid password
        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]")).sendKeys("Dolly1234");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]")).click();
        //Verify the ‘Accounts Overview’ text is display
        String expected = "Accounts Overview";
        WebElement actual = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        String actualResult = actual.getText();
        Assert.assertEquals("Verifying the Results", expected, actualResult);
    }

    @Test
    public void verifyTheErrorMessage() {
        //Enter invalid username
        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]")).sendKeys("kim");
        //Enter invalid password
        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]")).sendKeys("Welcome23");
        //Click on login button
        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]")).click();
        //Verify the error message ‘The username and password could not be verified.’
        String expected = "The username and password could not be verified.";
        WebElement actual = driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
        String actualResult = actual.getText();
        Assert.assertEquals("Verifying the Results", expected, actualResult);

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //Enter valid username
        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]")).sendKeys("nora");
        //Enter valid password
        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]")).sendKeys("Dolly1234");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]")).click();
        //Click on ‘Log Out’ link
        driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
        //Verify the text ‘Customer Login’
        String expected = "Customer Login";
        WebElement actual = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        String actualResult = actual.getText();
        System.out.println(actualResult);
        Assert.assertEquals("verifying the results:", expected, actualResult);
    }

    @After
    public void tearDown() {

        closeBrowser();
    }

}
