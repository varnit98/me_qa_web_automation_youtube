package demo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;

public class Whatsapp {

  public void main(String[] args) throws InterruptedException {
    System.out.println("Entering in WhatsApp Test");
  }

  public static void runWhatsAppTest() throws InterruptedException, MalformedURLException {
    //Starting Point of Execution
    System.out.println("Entering main()");

    // Code to Launch Chrome Browser on local setup
    WebDriverManager.chromedriver().timeout(30).setup();
    ChromeDriver driver = new ChromeDriver();

    // Maximize and Implicit Wait for things to initailize
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    // Launching the URL and maximize
    driver.get("https://web.whatsapp.com/");

    Thread.sleep(20000);

    // Searching for the Contact number of interest
    driver.findElementByXPath("//*[@id=\"side\"]/div[1]/div/label/div/div[2]").clear();
    driver.findElementByXPath("//*[@id=\"side\"]/div[1]/div/label/div/div[2]")
        .sendKeys("+919449084285");

    // Selecting the Contact person that comes up when the number is searched
    driver.findElementByXPath("//*[@id=\"pane-side\"]/div[1]/div/div/div[1]").click();

    //Typing in the Message and Sending
    driver.findElementByXPath(
        "//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[2]").clear();
    driver.findElementByXPath(
        "//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[2]")
        .sendKeys("Hi! This is an automated message. By Kiran Suresh." + Keys.ENTER);

    // Exiting Main()
    System.out.println("Exiting main()");

  }
}
