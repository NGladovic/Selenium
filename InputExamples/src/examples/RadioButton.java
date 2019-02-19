
package examples;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButton {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        driver.manage().window().maximize();
        driver.get("https://www.nngroup.com/articles/checkboxes-vs-radio-buttons/");
        ((JavascriptExecutor) driver).executeScript("scroll(0,1400);");

        System.out.println("Page title: " + driver.getTitle());
        

        // Find radio items by using relative xPath
        //List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        List<WebElement> radioButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type='radio']")));

        System.out.println("Number of radio buttons found: " + radioButtons.size());
        
        // Click on item based on his position inside list
        radioButtons.get(4).click();

        // Click on every item
        for (WebElement radioButton : radioButtons) {
            Thread.sleep(1500);
            radioButton.click();
        }
        
        // Click on every item 2
        for (int i = 0; i < radioButtons.size(); i++) {
            Thread.sleep(1500);
            radioButtons.get(i).click();
        }
        
        
        Thread.sleep(5000);
        driver.quit();

    }
}
