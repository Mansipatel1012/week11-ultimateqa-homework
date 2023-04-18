package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on the ‘Sign In’ link
        WebElement signinLinkElement = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        signinLinkElement.click();
        //Verify the text ‘Welcome Back!’
        String expectedMessage = "Welcome Back!";
        WebElement actualMessageElement = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

           }

    @Test
    public void verifyTheErrorMessage() {
        //click on the ‘Sign In’ link
        WebElement signinLinkElement = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        signinLinkElement.click();
        WebElement emailFieldelement = driver.findElement(By.id("user[email]"));
        emailFieldelement.sendKeys("Rosie_mosie@gmail.com");
        //find password Field Element
        WebElement passwordFieldElement = driver.findElement(By.id("user[password]"));
        //send key to password field
        passwordFieldElement.sendKeys("RM123");
        // find sign in field element
        WebElement signinFieldElement = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        signinFieldElement.click();
        // Requirement is Invalid email or password
        String exceptedMessage = "Invalid email or password.";
        WebElement actualMessageElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals(exceptedMessage, actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}