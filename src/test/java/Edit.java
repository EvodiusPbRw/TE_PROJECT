import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.asserts.SoftAssert;

public class Edit {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        SoftAssert sa = new SoftAssert();
        driver.manage().window().maximize();

        //Login ke orange
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        username.sendKeys("admin");
        password.sendKeys("admin123");
        WebElement submit = driver.findElement(By.id("btnLogin"));
        submit.click();
        String ActualURL = driver.getCurrentUrl();
        sa.assertTrue("https://opensource-demo.orangehrmlive.com/index.php/dashboard".equals(ActualURL),"Login Success");
	sa.assertFalse("https://opensource-demo.orangehrmlive.com/index.php/dashboard".equals(ActualURL),"Login Failed");

        //Load Employee List
        WebElement pim_module = driver.findElement(By.id("menu_pim_viewPimModule"));
        pim_module.click();
        ActualURL = driver.getCurrentUrl();
        sa.assertTrue("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList".equals(ActualURL),"Employee List Success");
	sa.assertFalse("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList".equals(ActualURL),"Employee List Failed");
        
        //Load to edit Employee
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("0002"))).click();
//        driver.findElement(By.partialLinkText("0002")).click();
        ActualURL = driver.getCurrentUrl();
        sa.assertTrue("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployee/empNumber/2".equals(ActualURL),"Employee List Success");
	sa.assertFalse("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployee/empNumber/2".equals(ActualURL),"Employee List Failed");
        
        //Edit data employee
        driver.findElement(By.id("btnSave")).click();
        WebElement fullname = driver.findElement(By.id("personal_txtEmpFirstName"));
        fullname.clear();
        fullname.sendKeys("Tester");
        
        fullname = driver.findElement(By.id("personal_txtEmpMiddleName"));
        fullname.clear();
        fullname.sendKeys("");
        
        fullname = driver.findElement(By.id("personal_txtEmpLastName"));
        fullname.clear();
        fullname.sendKeys("Test");
        
        WebElement idEmployee = driver.findElement(By.id("personal_txtEmployeeId"));
        idEmployee.clear();
        idEmployee.sendKeys("0002");
        
        idEmployee = driver.findElement(By.id("personal_txtOtherID"));
        idEmployee.clear();
        idEmployee.sendKeys("0031");
        
        idEmployee = driver.findElement(By.id("personal_txtLicenNo"));
        idEmployee.clear();
        idEmployee.sendKeys("QZ45232222");
        
        WebElement license = driver.findElement(By.id("personal_txtLicExpDate"));
        license.clear();
        license.sendKeys("2016-02-01");
        
        license = driver.findElement(By.id("personal_txtNICNo"));
        license.clear();
        license.sendKeys("42");
        
        license = driver.findElement(By.id("personal_txtSINNo"));
        license.clear();
        license.sendKeys("42");
        
        WebElement gender = driver.findElement(By.id("personal_optGender_1"));
        gender.click();
               
        Select dropdown = new Select(driver.findElement(By.id("personal_cmbMarital")));
        dropdown.selectByVisibleText("Married");
        
        dropdown = new Select(driver.findElement(By.id("personal_cmbNation")));
        dropdown.selectByVisibleText("American");
        
        WebElement nickname = driver.findElement(By.id("personal_txtEmpNickName"));
        nickname.clear();
        nickname.sendKeys("Tester");
  
        WebElement checkbox = driver.findElement(By.id("personal_chkSmokeFlag"));
        checkbox.click();
       
        WebElement service = driver.findElement(By.id("personal_txtMilitarySer"));
        service.clear();
        service.sendKeys("OK");
        
        driver.findElement(By.id("btnSave")).click();
        
        //Assert Edit Personal Detail
        sa.assertTrue("OK".equals(driver.findElement(By.id("personal_txtMilitarySer")).getAttribute("value")),"Edit Millitary Service Status Success");
	sa.assertFalse("OK".equals(driver.findElement(By.id("personal_txtMilitarySer")).getAttribute("value")),"Edit Millitary Service Status Failed");
        sa.assertTrue("true".equals(driver.findElement(By.id("personal_chkSmokeFlag")).getAttribute("checked")),"Edit Smoker Status Success");
	sa.assertFalse("true".equals(driver.findElement(By.id("personal_chkSmokeFlag")).getAttribute("checked")),"Edit Smoker Status Failed");
        sa.assertTrue("Tester".equals(driver.findElement(By.id("personal_txtEmpNickName")).getAttribute("value")),"Edit Nickname Success");
	sa.assertFalse("Tester".equals(driver.findElement(By.id("personal_txtEmpNickName")).getAttribute("value")),"Edit Nickname Failed");
        sa.assertTrue("American".equals(new Select(driver.findElement(By.id("personal_cmbNation"))).getFirstSelectedOption().getText()),"Edit Nationality Success");
	sa.assertFalse("American".equals(new Select(driver.findElement(By.id("personal_cmbNation"))).getFirstSelectedOption().getText()),"Edit Nationality Failed");
        sa.assertTrue("Married".equals(new Select(driver.findElement(By.id("personal_cmbMarital"))).getFirstSelectedOption().getAttribute("value")),"Edit Marital Status Success");
	sa.assertFalse("Married".equals(new Select(driver.findElement(By.id("personal_cmbMarital"))).getFirstSelectedOption().getAttribute("value")),"Edit Marital Status Failed");
        sa.assertTrue("true".equals(driver.findElement(By.id("personal_optGender_1")).getAttribute("checked")),"Edit Gender Success");
	sa.assertFalse("true".equals(driver.findElement(By.id("personal_optGender_1")).getAttribute("checked")),"Edit Gender Failed");
        sa.assertTrue("42".equals(driver.findElement(By.id("personal_txtSINNo")).getAttribute("value")),"Edit SIN Number Success");
	sa.assertFalse("42".equals(driver.findElement(By.id("personal_txtSINNo")).getAttribute("value")),"Edit SIN Number Failed");
        sa.assertTrue("42".equals(driver.findElement(By.id("personal_txtNICNo")).getAttribute("value")),"Edit SSN Number Success");
	sa.assertFalse("42".equals(driver.findElement(By.id("personal_txtNICNo")).getAttribute("value")),"Edit SSN Number Failed");
        sa.assertTrue("2016-02-01".equals(driver.findElement(By.id("personal_txtLicExpDate")).getAttribute("value")),"Edit Licence Exp Date Success");
	sa.assertFalse("2016-02-01".equals(driver.findElement(By.id("personal_txtLicExpDate")).getAttribute("value")),"Edit Licence Exp Date Failed");
        sa.assertTrue("QZ45232222".equals(driver.findElement(By.id("personal_txtLicenNo")).getAttribute("value")),"Edit Licence No Success");
	sa.assertFalse("QZ45232222".equals(driver.findElement(By.id("personal_txtLicenNo")).getAttribute("value")),"Edit Licence No Failed");
        sa.assertTrue("0031".equals(driver.findElement(By.id("personal_txtOtherID")).getAttribute("value")),"Edit Other ID Success");
	sa.assertFalse("0031".equals(driver.findElement(By.id("personal_txtOtherID")).getAttribute("value")),"Edit Other ID Failed");
        sa.assertTrue("0002".equals(driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value")),"Edit ID Success");
	sa.assertFalse("0002".equals(driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value")),"Edit ID Failed");
        sa.assertTrue("Test".equals(driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value")),"Edit Last Name Success");
	sa.assertFalse("Test".equals(driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value")),"Edit Last Name Failed");
        sa.assertTrue("".equals(driver.findElement(By.id("personal_txtEmpMiddleName")).getAttribute("value")),"Edit Middle Name Success");
	sa.assertFalse("".equals(driver.findElement(By.id("personal_txtEmpMiddleName")).getAttribute("value")),"Edit Middle Name Failed");
        sa.assertTrue("Tester".equals(driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value")),"Edit First Name Success");
	sa.assertFalse("Tester".equals(driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value")),"Edit First Name Failed");

        //Edit Golongan darah
        driver.findElement(By.id("btnEditCustom")).click();
        Select dropdown1 = new Select(driver.findElement(By.name("custom1")));
        dropdown1.selectByVisibleText("AB-");
        driver.findElement(By.id("btnEditCustom")).click();
        
        //Asert Edit Blood Type
        sa.assertTrue("AB-".equals(new Select(driver.findElement(By.name("custom1"))).getFirstSelectedOption().getAttribute("value")),"Edit Blood Type Success");
	sa.assertFalse("AB-".equals(new Select(driver.findElement(By.name("custom1"))).getFirstSelectedOption().getAttribute("value")),"Edit Blood Type Failed");

        //Add Attachment
        driver.findElement(By.id("btnAddAttachment")).click();
        WebElement chooseFile = driver.findElement(By.id("ufile"));
        chooseFile.sendKeys("C:\\Users\\Joevi\\OneDrive\\Gambar\\image.jpg");
        
        WebElement textArea  = driver.findElement(By.id("txtAttDesc"));
        textArea.clear();
        textArea.sendKeys("Mantab");
        driver.findElement(By.id("btnSaveAttachment")).click();
        
        //Assert Edit Attachment
        sa.assertTrue("https://opensource-demo.orangehrmlive.com/index.php/pim/viewAttachment/empNumber/2/attachId/1".equals(driver.findElement(By.partialLinkText("image.jpg")).getAttribute("href")),"Edit Attachment Success");
	sa.assertFalse("https://opensource-demo.orangehrmlive.com/index.php/pim/viewAttachment/empNumber/2/attachId/1".equals(driver.findElement(By.partialLinkText("image.jpg")).getAttribute("href")),"Edit Attachment Failed");

        //Delete
//        WebElement check = driver.findElement(By.id("attachmentsCheckAll"));
//        check.click();
//
//        driver.findElement(By.id("btnDeleteAttachment")).click();

        //Logout
        WebElement logout = driver.findElement(By.id("welcome"));
        logout.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Logout"))).click();
        
        sa.assertAll();
    }
}
