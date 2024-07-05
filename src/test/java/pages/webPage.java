package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.Utility.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class webPage {

    String[] firstName = {"John","Jane","Albert","Michael","Doug","Jessie","Stan","Michele","Stacy","Lara"};
    String[] lastName = {"Smith","Dorsey","Kipling","Robertson","Derrick","Marlowe","Hamm","Norton","Shelby","Palmer"};
    String[] company = {"IT Solutions","MediCare","WaterFront","MediCare","Timepath Inc.","Apertue Inc.","Sugarwell","Apertue Inc.", "TechDev", "Timepath Inc."};
    String[] role = {"Analyst", "Medical Engineer","Accountant", "IT Specialist","Ananlyst","Scientist","Advisor","Scientist","HR Manager","Programmer"};
    String[] address = {"98 North Road", "11 Crown Street","22 Guild Street","17 Farburn Terrace","99 Shire Oak Road","27 Cheshire Street","10 Dam Road","13 White Rabbit Street","19 Pineapple Boulevard","87 Orange Street"};
    String[] email = {"jsmith@itsolutions.co.uk","jdorsey@mc.com","kipling@waterfront.com","mrobertson@mc.com","dderrick@timepath.co.uk","jmarlowe@aperture.us","shamm@sugarwell.org","mnorton@aperture.us","sshelby@techdev.com","lpalmer@timepath.co.uk"};
    String[] pNumber = {"40716543298","40791345621","40735416854","40733652145","40799885412","40733154268","40712462257","40731254562","40741785214","40731653845"};

    By btnStart = By.xpath("(//button[normalize-space()='Start'])[1]");
    By fName = By.cssSelector("[ng-reflect-name='labelFirstName']");
    By lName = By.cssSelector("[ng-reflect-name='labelLastName']");
    By cName = By.cssSelector("[ng-reflect-name='labelCompanyName']");
    By alamat = By.cssSelector("[ng-reflect-name='labelAddress']");
    By mail = By.cssSelector("[ng-reflect-name='labelEmail']");
    By roleC = By.cssSelector("[ng-reflect-name='labelRole']");
    By phone = By.cssSelector("[ng-reflect-name='labelPhone']");
    By btnSubmit = By.cssSelector("input[type='submit']");

    By congrat = By.xpath("(//div[@class='message1 teal-text text-darken-2'])[1]");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));



    public void tunggu(){
        try {
            Thread.sleep(5000); // Wait for 5 seconds (You can adjust this according to your video length)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickBtnStart() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnStart));
        driver.findElement(btnStart).click();
    }

    public void inputForm(int round) {
        tunggu();

        int antri = round-1;

        wait.until(ExpectedConditions.visibilityOfElementLocated(lName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alamat));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mail));
        wait.until(ExpectedConditions.visibilityOfElementLocated(roleC));
        wait.until(ExpectedConditions.visibilityOfElementLocated(phone));

        driver.findElement(fName).sendKeys(firstName[antri]);
        driver.findElement(lName).sendKeys(lastName[antri]);
        driver.findElement(cName).sendKeys(company[antri]);
        driver.findElement(alamat).sendKeys(address[antri]);
        driver.findElement(mail).sendKeys(email[antri]);
        driver.findElement(roleC).sendKeys(role[antri]);
        driver.findElement(phone).sendKeys(pNumber[antri]);
    }
    public void clickBtnSubmit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSubmit));

        driver.findElement(btnSubmit).click();
    }


    public void inputDone(String note) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(congrat));

        try {
            Thread.sleep(5000); // Wait for 20 seconds (You can adjust this according to your video length)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement msg = driver.findElement(congrat);
        String msgText = msg.getText();
        assertEquals(note, msgText);

    }

}
