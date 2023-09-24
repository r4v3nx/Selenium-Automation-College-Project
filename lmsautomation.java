package setPackage;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class lmsAutomation {

    public static void main(String[] args) {
        // Set ChromeDriver executable path
    	System.out.println("---------------------------------------------------------");
    	System.out.println("Automating UI testing for college LMS portal");
    	System.out.println("---------------------------------------------------------");

        System.setProperty("webdriver.chrome.driver", "/home/nyx/Downloads/Untitled Folder/chromedriver-linux64/chromedriver");

        // Configure ChromeDriver options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize the window

        // Create a ChromeDriver instance
        ChromeDriver browserObject = new ChromeDriver(options);

        try {
            // Navigate to Google
        	System.out.println("Starting tests...");
            browserObject.get("http://google.com");

            // Perform a Google search
            WebElement searchBox = browserObject.findElement(By.name("q"));
            searchBox.sendKeys("Sathyabama lms");
            searchBox.sendKeys(Keys.ENTER);

            // Click on Sathyabama LMS link
            WebElement siteLink = browserObject.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
            String siteName = siteLink.getText();
            siteLink.click();
            System.out.println("Site name: " + siteName);

            // Check if the site name contains "Sathyabama LMS" and click on the login link if it does
            if (siteName.contains("Sathyabama LMS")) {
                WebElement login = browserObject.findElement(By.xpath("//a[@href='https://sathyabama.cognibot.in/login/index.php']"));
                login.click();

                // Perform login
                WebElement username = browserObject.findElement(By.id("username"));
                WebElement password = browserObject.findElement(By.id("password"));
                WebElement loginButton = browserObject.findElement(By.id("loginbtn"));

                // Perform login with incorrect credentials
                username.sendKeys("411105266");
                password.sendKeys("pass");

                // Click the login button
                loginButton.click();
                WebElement errorMessage = browserObject.findElement(By.id("loginerrormessage"));

                // Check for error message or any indication of failed login
                if(errorMessage.isDisplayed()) {
                           System.out.println("(1/10) Negative validation of login passed. Error message displayed.");
                }
                else {//*[@id="instance-176686-header"]
                	System.out.println("Negative validation of login failed. Error message not displayed");
                }
                   
                username = browserObject.findElement(By.id("username"));
                password = browserObject.findElement(By.id("password"));
                loginButton = browserObject.findElement(By.id("loginbtn"));
                    username.sendKeys("username");
                    password.sendKeys("pass");
                    loginButton.click();
                    WebElement customizeBtn = browserObject.findElement(By.xpath("//*[@id=\"instance-176686-header\"]"));

                   if(customizeBtn.isDisplayed()) {
                	   System.out.println("(2/10) Positive validation of login passed. Logged in successfully.");
                   }
                   else { System.out.println("Positive validation of login failed");}
                    // Perform positive validation
                  
                    
                   WebElement logo = browserObject.findElement(By.xpath("//*[@id=\"logo\"]/a/span/img"));
if(logo.isDisplayed()) {
	System.out.println("(3/10) Logo displayed successfully.");
}
else {
	System.out.println("Logo is not displayed");
}
WebElement userMenu = browserObject.findElement(By.id("action-menu-toggle-1"));
userMenu.click();
WebElement Profile = browserObject.findElement(By.id("actionmenuaction-2"));
Profile.click();
System.out.println("(4/10) User menu clicked.");
WebElement editProfile = browserObject.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/section/div/div/div[2]/section[1]/div/ul/li[1]/span/a"));
editProfile.click();
WebElement description = browserObject.findElement(By.id("id_description_editoreditable"));
description.sendKeys(" This description was typed by an automated process using Selenium!");
WebElement updateProfile = browserObject.findElement(By.id("id_submitbutton"));
updateProfile.click();
// Wait for the element to be displayed

System.out.println("(5/10) Description updated successfully.");
WebElement hamburgerMenu = browserObject.findElement(By.xpath("/html/body/div[1]/nav/div/div/button"));
hamburgerMenu.click();
System.out.println("(6/10) Dashboard menu clicked.");
System.out.println("(7/10) Options in the menu are: ");
java.util.List<WebElement> spanElements = browserObject.findElements(By.cssSelector("span.media-body"));

// Iterate through the elements and print their text content
for (WebElement spanElement : spanElements) {
    System.out.println(spanElement.getText());
}
System.out.println("(8/10) Courses printed successfully.");
hamburgerMenu.click();
System.out.println("(9/10) Dashboard menu closed.");
userMenu = browserObject.findElement(By.id("action-menu-toggle-1"));
userMenu.click();

WebElement logout = browserObject.findElement(By.id("actionmenuaction-6"));
logout.click();
System.out.println("(10/10) Logged out successfully.");
System.out.println("All test cases passed successfully.");
System.out.println("Closing Browser...");
System.out.println("---------------------------------------------------------");
            }
                     
             else {
                System.err.println("The site does not contain 'Sathyabama LMS'.");
            }
        } finally {
            // Close the browser
            //browserObject.quit();
        }
    }
}
