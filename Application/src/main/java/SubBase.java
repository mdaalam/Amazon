import org.openqa.selenium.By;

public class SubBase extends Base {

    // List of Web Elements
    public String searchField = "//*[@id=\"twotabsearchtextbox\"]";
    public String searchIcon = "//*[@id=\"nav-search\"]/form/div[2]/div/input";


    // Test Data
    public String product1 = "iPhone";
    public String product2 = "iPad";


    public void searchProduct() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(searchField)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(searchField)).sendKeys(product1);
        Thread.sleep(2000);
        driver.findElement(By.xpath(searchIcon)).click();
        Thread.sleep(2000);
    }


    public void searchProduct2() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(searchField)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(searchField)).sendKeys(product2);
        Thread.sleep(2000);
        driver.findElement(By.xpath(searchIcon)).click();
        Thread.sleep(2000);
    }






    public String signInLinkXpath = "//*[@id=\"app\"]/div/header/nav[1]/div/button";
    public String userNameFieldXPath = ".c-form-field.c-form-field--email>label>input";
    public String passwordFieldXpath = ".c-form-field.c-form-field--password>label>input";
    public String signInButtonXpath = ".c-btn.c-btn--primary";


    public String userName = "footlockertesting@gmail.com";
    public String password = "Test@1234";

    public void fsLogin() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.xpath(signInLinkXpath)).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector(userNameFieldXPath)).sendKeys(userName);
        Thread.sleep(4000);
        driver.findElement(By.cssSelector(passwordFieldXpath)).sendKeys(password);
        Thread.sleep(4000);
        driver.findElement(By.cssSelector(signInButtonXpath)).click();
        Thread.sleep(5000);
    }

}