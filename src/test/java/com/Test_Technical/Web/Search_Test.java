package com.Test_Technical.Web;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.Keys;
import java.time.Duration;


public class Search_Test {
    WebDriver driver;

    By search = By.cssSelector("#search");
    By clickSearch = By.cssSelector("body > div.wrap > div.header.header--sumpah-pemuda.clearfix > div.row.clearfix.header__wrap > div > div > div:nth-child(2) > form > button");

    public Search_Test (WebDriver driver){
        this.driver = driver;
    }
    public void searchBerita(String berita, String searching){

        if (searching.equals("Enter")){
            driver.findElement(search).sendKeys(berita);
            driver.findElement(search).sendKeys(Keys.RETURN);
            FluentWait<WebDriver> wait = new FluentWait<>(driver);
            wait.withTimeout(Duration.ofMinutes(1));
        }
        else {
            driver.findElement(search).sendKeys(berita);
            driver.findElement(clickSearch).click();
            FluentWait<WebDriver> wait = new FluentWait<>(driver);
            wait.withTimeout(Duration.ofMinutes(1));
        }
    }

    public void tulisanTampil(String tulisTampil){
        String adaTulisan = driver.findElement(By.className("title__content")).getText();
        Assertions.assertEquals(tulisTampil, adaTulisan);
        System.out.println(adaTulisan);
    }

    public void TulisanTerhapus(){
        Assertions.assertEquals("", driver.findElement(By.className("form__input")).getText());
        System.out.println(driver.findElement(By.className("form__input")).getText());
        System.out.println("Tidak terdapat tulisan");
    }
}
