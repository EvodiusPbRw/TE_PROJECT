import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Edit {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize();

        //Login ke orange
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));

        username.sendKeys("admin");
        password.sendKeys("admin123");

        WebElement submit = driver.findElement(By.id("btnLogin"));
        submit.click();

        WebElement pim_module = driver.findElement(By.id("menu_pim_viewPimModule"));
        pim_module.click();

        WebElement ascName = driver.findElement(By.partialLinkText("00022"));
        ascName.click();

        //Edit data employee
        driver.findElement(By.id("btnSave")).click();

        WebElement fullname = driver.findElement(By.id("personal_txtEmpFirstName"));
        fullname.clear();
        fullname.sendKeys("Odis");
        fullname = driver.findElement(By.id("personal_txtEmpMiddleName"));
        fullname.clear();
        fullname.sendKeys("");
        fullname = driver.findElement(By.id("personal_txtEmpLastName"));
        fullname.clear();
        fullname.sendKeys("Adalwin");

        WebElement idEmployee = driver.findElement(By.id("personal_txtEmployeeId"));
        idEmployee.clear();
        idEmployee.sendKeys("00022");
        idEmployee = driver.findElement(By.id("personal_txtOtherID"));
        idEmployee.sendKeys("0031");
        idEmployee.clear();
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
        nickname.sendKeys("Odis");

        WebElement checkbox = driver.findElement(By.id("personal_chkSmokeFlag"));
        checkbox.click();
        checkbox.click();

        WebElement service = driver.findElement(By.id("personal_txtMilitarySer"));
        service.clear();
        service.sendKeys("OK");

        driver.findElement(By.id("btnSave")).click();

        //Edit Golongan darah
        driver.findElement(By.id("btnEditCustom")).click();

        Select dropdown1 = new Select(driver.findElement(By.name("custom1")));
        dropdown1.selectByVisibleText("AB-");

        driver.findElement(By.id("btnEditCustom")).click();

        //Add Attachment
        driver.findElement(By.id("btnAddAttachment")).click();

        WebElement chooseFile = driver.findElement(By.id("ufile"));
        chooseFile.sendKeys("D:/Download From C/Picture/86330617_p0.jpg");

        WebElement textArea  = driver.findElement(By.id("txtAttDesc"));
        textArea.clear();
        textArea.sendKeys("Mantab");

        driver.findElement(By.id("btnSaveAttachment")).click();


        //Delete
        WebElement check = driver.findElement(By.id("attachmentsCheckAll"));
        check.click();

        driver.findElement(By.id("btnDeleteAttachment")).click();

        //Logout
        WebElement logout = driver.findElement(By.id("welcome"));
        logout.click();

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Logout"))).click();


    }
}
