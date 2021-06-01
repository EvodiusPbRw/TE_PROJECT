import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Add {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize();

        WebElement user = driver.findElement(By.id("txtUsername"));
        user.sendKeys("Admin");
        WebElement pass = driver.findElement(By.id("txtPassword"));
        pass.sendKeys("admin123");

        driver.findElement(By.id("btnLogin")).submit();

        driver.findElement(By.id("menu_pim_viewPimModule")).click();

        driver.findElement(By.name("btnAdd")).click();

        driver.findElement(By.id("firstName")).sendKeys("Tester");
        driver.findElement(By.id("middleName")).sendKeys("");
        driver.findElement(By.id("lastName")).sendKeys("Test");

        driver.findElement(By.id("photofile")).sendKeys("D:/Images/Honkai/unknown2.png");
        driver.findElement(By.id("chkLogin")).click();

        driver.findElement(By.id("user_name")).sendKeys("Tester12345678");
        driver.findElement(By.id("user_password")).sendKeys("#Tester123");
        driver.findElement(By.id("re_password")).sendKeys("#Tester123");

        Select dropdown = new Select(driver.findElement(By.name("status")));
        dropdown.selectByVisibleText("Enabled");

        driver.findElement(By.id("btnSave")).click();

        Thread.sleep(5000);

        driver.findElement(By.id("welcome")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Logout"))).click();

    }
}
