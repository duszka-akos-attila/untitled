package demoblaze.test.setup;


import org.openqa.selenium.WebDriver;

public class Base {

    protected WebDriver driver;

    public Base() {
        this.driver = Setup.driver;
    }
}