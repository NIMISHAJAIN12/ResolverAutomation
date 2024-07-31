package StepDefinitions;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class test1{
	WebDriver driver;
	WebDriverWait wait;
	

@Given("navigate to Home Page")
public void navigate_to_home_page() throws InterruptedException {
    System.setProperty("webDriver.chrome.driver","C:\\\\Users\\\\jainn\\\\OneDrive\\\\Documents\\\\chromeDriver\\\\chromedriver-win64\\\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.get("file:///C:/Users/jainn/AppData/Local/Temp/b61ae3ea-73b0-43a7-81b7-861cff84330b_AutomationChallenge_2022.zip.30b/QE-index.html#");
    Thread.sleep(5000);
    
}

@When("checking fields")
public void checking_fields() {
    WebElement a=driver.findElement(By.id("inputEmail"));
    WebElement b=driver.findElement(By.id("inputPassword"));
    assert a.isDisplayed():"Email input is not displayed";
    assert b.isDisplayed():"Password field is not displayed";
}

@Then("enter details")
public void enter_details() {
	driver.findElement(By.id("inputEmail")).sendKeys("jain.nimisha0012@gmail.com");
	driver.findElement(By.id("inputPassword")).sendKeys("resolver");
	driver.quit();
}

@When("check there are three values")
public void check_there_are_three_values() throws InterruptedException {
   
	WebElement element = driver.findElement(By.id("test-2-div"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView(true);", element);
	 Thread.sleep(3000);
 WebElement d=driver.findElement(By.className("list-group"));
List<WebElement> items = d.findElements(By.cssSelector("li[class='list-group-item justify-content-between']"));
  for (WebElement item : items) {
      System.out.println("Item text: " + item.getText());
     }
  System.out.println("Number of list group items found: " + items.size());
 assertEquals(3,items.size(), "The list group does not contain exactly three items");
 System.out.println("wohooo");
  WebElement item_second = items.get(1); 
  String item_second_text = item_second.getText();
  Assert.assertTrue(item_second_text.contains("List Item 2"), "The second list item's value is not 'List Item 2'");
  System.out.println("wohooo2");
  WebElement item_second_Badge = item_second.findElement(By.cssSelector("span[class='badge badge-pill badge-primary']"));
  int badgeValue = Integer.parseInt(item_second_Badge.getText());
  Assert.assertEquals(badgeValue, 6, "The second list item's badge value is not 6");
  System.out.println("wohooo3");
  driver.quit();
}
@Then("check the dropdown")
public void check_the_dropdown() throws InterruptedException {
	WebElement element = driver.findElement(By.id("test-3-div"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView(true);", element);
	 Thread.sleep(3000);
	 WebElement e = driver.findElement(By.id("dropdownMenuButton"));
	 Assert.assertEquals(e.getText(),"Option 1","something is wrong" );
    System.out.println("wohooo");
    e.click();
    driver.findElement(By.xpath("//a[text()='Option 3']")).click();
    System.out.println("wohooo2");
    driver.quit();
    }
@Then("find enable and disable")
public void find_enable_and_disable() {
	WebElement element = driver.findElement(By.id("test-4-div"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView(true);", element);
    WebElement button1=driver.findElement(By.xpath("(//button[@class='btn btn-lg btn-primary'])[1]"));
    WebElement button2=driver.findElement(By.xpath("//button[@class='btn btn-lg btn-secondary']"));
    Assert.assertTrue(button1.isEnabled(), "The first button is not enabled");
    System.out.println("wohooo");
    Assert.assertFalse(button2.isEnabled(), "The second button is not disabled");
    System.out.println("wohooo2");
    driver.quit();
}
@Then("run the tasks")
public void run_the_tasks() {
	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement element = driver.findElement(By.id("test-5-div"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView(true);", element);
	WebElement button3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-lg btn-primary'])[2]")));
	button3.click();
	WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'You clicked a button!')]")));
	Assert.assertTrue(message.isDisplayed(), "Success message should be displayed");
	System.out.println("wohooo");
	Assert.assertFalse(button3.isEnabled(), "The second button is not disabled");
    System.out.println("wohooo2");
    driver.quit();
}
public String getCellValue(int row, int col) {
	WebElement table = driver.findElement(By.tagName("tbody"));
	 List<WebElement> rows = table.findElements(By.tagName("tr"));
	 WebElement specificRow = rows.get(row);
	 List<WebElement> cells = specificRow.findElements(By.tagName("td"));
	 return cells.get(col).getText();
	 
}

@Then("find the method")
public void find_the_method() {
	WebElement element = driver.findElement(By.id("test-6-div"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView(true);", element);
	 String cellValue = getCellValue(2, 2);
	 System.out.println(cellValue);
	Assert.assertEquals(cellValue, "Ventosanzap", "The cell value should be 'Ventosanzap'");
	System.out.println("wohooo");
	driver.quit();
}
//1 extra piece of code because I am confused about the cell and its values 
//according to the guide 
public String getCellValueaccordingtoguide(int row, int col) {
	WebElement table = driver.findElement(By.tagName("table"));
	 List<WebElement> rows = table.findElements(By.tagName("tr"));
	 WebElement specificRow = rows.get(row);
	 List<WebElement> cells = specificRow.findElements(By.tagName("td"));
	 return cells.get(col).getText();
	 
}
@Then("second method")
public void second_method() {
	WebElement element = driver.findElement(By.id("test-6-div"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView(true);", element);
	 String cellValue = getCellValueaccordingtoguide(2, 2);
	 System.out.println(cellValue);
	Assert.assertEquals(cellValue, "Ventosanzap", "The cell value should be 'Ventosanzap'");
	System.out.println("wohooo");
	driver.quit();
}


}



    

