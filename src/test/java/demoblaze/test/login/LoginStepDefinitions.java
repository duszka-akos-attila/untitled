package demoblaze.test.login;


import demoblaze.test.setup.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class LoginStepDefinitions extends Base {

    WebDriverWait wait = new WebDriverWait(driver,40);

    @Given("the Login page")
    public void navigateToLogin(){
        driver.findElement(By.cssSelector("#login2")).click();
    }

    @Given("user enters username {string}")
    public void giveUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginusername")));
        driver.findElement(By.cssSelector("#loginusername")).sendKeys(username);
    }

    @And("user enters password {string}")
    public void givePassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginpassword")));
        driver.findElement(By.cssSelector("#loginpassword")).sendKeys(password);
    }

    @When("clicks on Log in button")
    public void clickToLogin(){
        driver.findElement(By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-primary")).click();
    }

    @Then("user should see {string}")
    public void successfulLogin(String nameOfUser){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nameofuser")));
        String text = driver.findElement(By.cssSelector("#nameofuser")).getText();
        assertEquals(text, nameOfUser);
    }

    @Then("error message displayed")
    public void unsuccessfulLogin() throws InterruptedException {
        wait.until(ExpectedConditions.alertIsPresent());
        String alert = driver.switchTo().alert().getText();
        assertNotNull(alert);
        Thread.sleep(100);
    }
}
