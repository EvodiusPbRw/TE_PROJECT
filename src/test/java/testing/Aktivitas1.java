package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.SortedMap;
import java.util.concurrent.TimeUnit;

public class Aktivitas1 {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://google.com");

//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("profile.default_content_setting_values.notifications",2);
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs",map);
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.get("https://www.facebook.com");
//        WebElement element = driver.findElement(By.xpath("//*[@id = 'email']"));
//        element.sendKeys("email");
//        WebElement element2 = driver.findElement(By.xpath("//*[@id = 'pass']"));
//        element2.sendKeys("password");
//
//        element2.submit();

        //Hard Assertion
        /*System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.facebook.com");
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Facebook - Masuk atau Daftar";
        Assert.assertEquals(ExpectedTitle,ActualTitle);
        Assert.assertNotEquals(ExpectedTitle,ActualTitle);
        Assert.assertNull(ExpectedTitle);
        Assert.assertNotNull(ExpectedTitle);
        Assert.assertTrue("Facebook".equals("Facebook"),"First soft assert failed");
        Assert.assertFalse("Facebook".equals("Facebook"),"Second soft assert failed");
        driver.quit();*/

        //Soft Assertion
        //System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        driver.navigate().to("https://www.facebook.com/");
        String getActualTitle = driver.getTitle();
        Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Facebook - Masuk atau Daftar");
        softAssert.assertEquals(getActualTitle,"Facebook - Masuk atau Daftar");
        softAssert.assertNotEquals(getActualTitle,"Facebook - Masuk atau Daftar");
        softAssert.assertNull(verifyTitle);
        softAssert.assertNotNull(verifyTitle);
        softAssert.assertTrue("Facebook".equals("Facebook"),"First soft assert failed");
        softAssert.assertFalse("Facebook".equals("Facebook"),"First soft assert failed");
        softAssert.assertAll();
        driver.quit();

    }


}
