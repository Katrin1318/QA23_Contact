package com.telran.contacts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    //static WebDriver driver;
    WebDriver driver;

    //@BeforeSuite
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //@AfterSuite(enabled = false)
    @AfterMethod (enabled = false)
    public void tearDown() {

        driver.quit();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public boolean isElementPresent2(By by) {
        try{
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException ex) {
            return false;

        }
    }

    public boolean isSignOutButtonPresent() {
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
        return false;
    }

    public void isRegistrationFormPresent() {
        Assert.assertTrue(isElementPresent2(By.cssSelector(".login_login__3EHKB")));
    }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void fillRegistrationLoginForm(String email, String password) {
        type(By.cssSelector("[placeholder='Email']"), email);
        type(By.cssSelector("[placeholder='Password']"), password);
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el:contacts) {
            if (el.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }

    public void jumpToFooter(By locator) {
        driver.findElement(locator).sendKeys(Keys.COMMAND, Keys.END);
    }

    public void clickWithActions(By save) {

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(save);

        actions.moveToElement(element).build().perform();
        element.click();
    }

    public int sizeOfContacts() {
        if (driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()>0) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }

    public void removeContact() {
        if(!isContactListEmpty()) {
            driver.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
            driver.findElement(By.xpath("//*[text()='Remove']")).click();
        }
    }

    public boolean isContactListEmpty() {
        return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    public boolean isSignOutBtnPresent() {
        return isElementPresent(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public void login() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        fillRegistrationLoginForm("korner_15@mail.com", "Sd3567890$");
        click(By.xpath("//button[contains(.,' Login')]"));
    }

    public void addContact() {
        int i = (int) ((System.currentTimeMillis()/ 1000) % 3600);

        click(By.cssSelector("a:nth-child(5)"));
        type(By.cssSelector("input:nth-child(1)"), "Korn");
        type(By.cssSelector("input:nth-child(2)"), "Eva");
        type(By.cssSelector("input:nth-child(3)"), "12345" + i);
        type(By.cssSelector("input:nth-child(4)"), "eva" + i + "@gmail.com");
        type(By.cssSelector("input:nth-child(5)"), "Kiev");
        type(By.cssSelector("input:nth-child(6)"), "butterfly");

        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void isHomeComponentPresent() {
        isElementPresent2(By.cssSelector("div:nth-child(2) > div > div"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean isLoginTabPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[contains(.,' Registration')]"));
    }

    public void clickOnLoginTab() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public boolean isRegistrationLoginFormPresent() {
        return isElementPresent(By.cssSelector(".login_login__3EHKB"));
    }

    public boolean isContactTabPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'CONTACTS')]"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[contains(.,' Login')]"));
    }
}
