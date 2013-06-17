package simple.app.test;

import android.test.ActivityInstrumentationTestCase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidWebDriver;

import simple.app.SimpleAppActivity;

public class SimpleGoogleTest extends ActivityInstrumentationTestCase2<SimpleAppActivity> {
    private WebDriver driver;
    
    public SimpleGoogleTest() {
        super("simple.app", SimpleAppActivity.class);
    }
    
    @Override
    protected void setUp() throws Exception {
      driver = new AndroidWebDriver(getActivity());
    }
    
    protected void tearDown() {
    //   driver.quit();
    }
    
    public void testGoogleWorks() throws InterruptedException {
        driver.get("http://www.google.com");
       // driver.wait(4000);
        /*driver.findElement(By.xpath(".//*[@id='search-basic']")).clear();
        driver.findElement(By.xpath(".//*[@id='search-basic']")).sendKeys("photon");*/
      WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Android Rocks!");
        searchBox.submit();
        String title = driver.getTitle();
        assertTrue("Got title: " + title, title.contains("Google"));
        assertTrue(driver.findElements(By.partialLinkText("Android")).size() > 1);
    }
}
