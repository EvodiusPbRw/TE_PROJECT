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
        SoftAssert sa = new SoftAssert();
        driver.manage().window().maximize();

        WebElement user = driver.findElement(By.id("txtUsername"));
        user.sendKeys("Admin");
        WebElement pass = driver.findElement(By.id("txtPassword"));
        pass.sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).submit();
        String ActualURL = driver.getCurrentUrl();
        sa.assertTrue("https://opensource-demo.orangehrmlive.com/index.php/dashboard".equals(ActualURL),"Login Success");
	sa.assertFalse("https://opensource-demo.orangehrmlive.com/index.php/dashboard".equals(ActualURL),"Login Failed");

        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        ActualURL = driver.getCurrentUrl();
        sa.assertTrue("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList".equals(ActualURL),"Employee List Success");
	sa.assertFalse("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList".equals(ActualURL),"Employee List Failed");
        
        Thread.sleep(2000);
        driver.findElement(By.name("btnAdd")).click();
        ActualURL = driver.getCurrentUrl();
        sa.assertTrue("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee".equals(ActualURL),"Load Add Employee Success");
	sa.assertFalse("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee".equals(ActualURL),"Load Add Employee Failed");

        driver.findElement(By.id("firstName")).sendKeys("Tester");
        driver.findElement(By.id("middleName")).sendKeys("");
        driver.findElement(By.id("lastName")).sendKeys("Test");

        driver.findElement(By.id("photofile")).sendKeys("D:/Images/Honkai/unknown2.png");
//        driver.findElement(By.id("photofile")).sendKeys("C:\\Users\\Joevi\\OneDrive\\Gambar\\image.jpg");
        driver.findElement(By.id("chkLogin")).click();

        driver.findElement(By.id("user_name")).sendKeys("Tester1234");
        driver.findElement(By.id("user_password")).sendKeys("#Tester123");
        driver.findElement(By.id("re_password")).sendKeys("#Tester123");

        Select dropdown = new Select(driver.findElement(By.name("status")));
        dropdown.selectByVisibleText("Enabled");

        driver.findElement(By.id("btnSave")).click();
        
        Thread.sleep(5000);
        ActualURL = driver.getCurrentUrl();
        sa.assertTrue("https://opensource-demo.orangehrmlive.com/index.php/pim/viewPersonalDetails/empNumber/".equals(ActualURL.substring(0, 86)),"Add Employee Success");
	sa.assertFalse("https://opensource-demo.orangehrmlive.com/index.php/pim/viewPersonalDetails/empNumber/".equals(ActualURL.substring(0, 86)),"Add Employee Failed");
        sa.assertTrue("Tester".equals(driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value")),"Adding First Name Success");
	sa.assertFalse("Tester".equals(driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value")),"Adding First Name Failed");
        sa.assertTrue("".equals(driver.findElement(By.id("personal_txtEmpMiddleName")).getAttribute("value")),"Adding Middle Name Success");
	sa.assertFalse("".equals(driver.findElement(By.id("personal_txtEmpMiddleName")).getAttribute("value")),"Adding Middle Name Failed");
        sa.assertTrue("Test".equals(driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value")),"Adding Last Name Success");
	sa.assertFalse("Test".equals(driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value")),"Adding Last Name Failed");
        
        driver.findElement(By.id("welcome")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Logout"))).click();
        
        sa.assertAll();
    }
}
