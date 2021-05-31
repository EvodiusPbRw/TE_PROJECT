import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Add {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");

        //Login ke orange
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));

        username.sendKeys("admin");
        password.sendKeys("admin123");

        WebElement submit = driver.findElement(By.id("btnLogin"));
        submit.click();

        //Pilih PIM
        WebElement pim_module = driver.findElement(By.id("menu_pim_viewPimModule"));
        pim_module.click();


        //Add
        driver.findElement(By.name("btnAdd")).click();

        driver.findElement(By.id("firstName")).sendKeys("Tester");
        driver.findElement(By.id("middleName")).sendKeys("");
        driver.findElement(By.id("lastName")).sendKeys("Test");

        driver.findElement(By.id("photofile")).sendKeys("C:/Users//EVODIUS/Pictures/1578953848_Luna.jpg");
        driver.findElement(By.id("chkLogin")).click();

        driver.findElement(By.id("user_name")).sendKeys("Tester");
        driver.findElement(By.id("user_password")).sendKeys("#Tester123");
        driver.findElement(By.id("re_password")).sendKeys("#Tester123");

        Select dropdown = new Select(driver.findElement(By.name("status")));
        dropdown.selectByVisibleText("Enabled");

        driver.findElement(By.id("btnSave")).click();


    }

}
