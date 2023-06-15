package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class FindTopThree {

  public void main(String[] args) throws InterruptedException {
    System.out.println("Entering in FindTopThree");
  }

  public static void runYoutubeTest() throws InterruptedException, MalformedURLException {
	  
	  
	  
    //Starting Point of Execution
    System.out.println("Entering main()");

    
    //Set item name here
    String searchWord = "movies";
    
    //Launch Chrome Browser
    final DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setBrowserName(BrowserType.CHROME);
    RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
    

    //Maximize and Implicit Wait for things to initialize
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    //Launch the URL and maximize
    driver.get("https://www.youtube.com");

    // Wait 4 seconds for site to get loaded
    Thread.sleep(4000);

    // Find the element where Search Word is to be entered, 
    // populate the search bar
    driver.findElement(By.xpath("//input[@name='search_query']")).clear();
    driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys(searchWord);
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//button[@aria-label='Search'])[1]")).click();

    // Wait 2 seconds
    Thread.sleep(2000);
    
    //Print the first element card (title, price, latest delivery time, etc)
    String videoOne = driver.findElement(By.xpath("(//a[@id='video-title'])[1]")).getText();
    String videoTwo = driver.findElement(By.xpath("(//a[@id='video-title'])[2]")).getText();
    String videoThree = driver.findElement(By.xpath("(//a[@id='video-title'])[3]")).getText();
    
    System.out.println("-------------------------------------------------\n\n");
    System.out.println("The first 3 "+searchWord+" videos available are: \n 1. "+videoOne+"\n 2. "+videoTwo+"\n 3. "+videoThree);
    System.out.println("-------------------------------------------------\n\n");

    //Close and quit the driver
    driver.close();
    driver.quit();
  }
  
}