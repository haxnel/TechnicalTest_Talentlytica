package com.Test_Technical.Web;

import com.Test_Technical.utilitas.Endpoint;
import com.Test_Technical.utilitas.Generate_Account;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Login_Test {

    By LogoWeb = By.cssSelector("body > div.wrap > div.header.header--sumpah-pemuda.clearfix > div.row.clearfix.header__wrap > div > div > div:nth-child(1) > div");
    By LoginIcon = By.cssSelector("body > div.wrap > div.header.header--sumpah-pemuda.clearfix > div.row.clearfix.header__wrap > div > div > div:nth-child(2) > div.sso__header.col-bs12-4");
    By Login = By.cssSelector("#txt_signin > span");
    By Email = By.cssSelector("#email");
    By Password = By.cssSelector("#password");
    By ButtonLogin = By.xpath("/html/body/div[2]/div[2]/div[1]/form/div[3]/input");

    WebDriver driver;

    public Login_Test (WebDriver driver){
        this.driver = driver;
    }

    public void driverHome (){
        FluentWait <WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofMinutes(1));
        driver.get(Endpoint.Host);
    }

    public void JudulWebsite(){
        FluentWait <WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofMinutes(1));
        driver.findElement(LogoWeb);
        Assertions.assertTrue(driver.findElement(LogoWeb).isDisplayed());;
    }

    public void ClickLogin(){
        FluentWait <WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofMinutes(1));
        Assertions.assertTrue(driver.findElement(LoginIcon).isDisplayed());
        driver.findElement(LoginIcon).click();
        driver.findElement(Login).click();
    }

    public void EmailAkun(String email){
        if (email.equals("Email Terdaftar")){
            FluentWait <WebDriver> wait = new FluentWait<>(driver);
            wait.withTimeout(Duration.ofMinutes(1));
            Assertions.assertTrue(driver.findElement(Email).isDisplayed());
            driver.findElement(Email).sendKeys("haxnel123@gmail.com");
        }
        else {
            FluentWait <WebDriver> wait = new FluentWait<>(driver);
            wait.withTimeout(Duration.ofMinutes(1));
            String buatEmail = Generate_Account.createEmail();
            Assertions.assertTrue(driver.findElement(Email).isDisplayed());
            driver.findElement(Email).sendKeys(buatEmail);
        }
    }

    public void PasswordAkun(String pass){
        if (pass.equals("Password Email Terdaftar")){
            FluentWait <WebDriver> wait = new FluentWait<>(driver);
            wait.withTimeout(Duration.ofMinutes(1));
            Assertions.assertTrue(driver.findElement(Password).isDisplayed());
            driver.findElement(Password).sendKeys("Megatron123");
        }
        else {
            FluentWait <WebDriver> wait = new FluentWait<>(driver);
            wait.withTimeout(Duration.ofMinutes(1));
            String buatPassword = Generate_Account.createPassword();
            Assertions.assertTrue(driver.findElement(Password).isDisplayed());
            driver.findElement(Password).sendKeys(buatPassword);
        }
    }

    public void clickButtonLogin (){
        FluentWait <WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofMinutes(1));
        driver.findElement(ButtonLogin).click();
    }

    public void LoginAkun(String word) {
        if (word.equals("Selamat Datang")){
            String sukses = driver.getTitle();
            Assertions.assertEquals("KG Media ID", sukses);
            System.out.println(sukses);
        }
        else {
            Assertions.assertEquals(word, driver.findElement(By.className("form-error")).getText());
            System.out.println(driver.findElement(By.className("form-error")).getText());
        }
    }
}
