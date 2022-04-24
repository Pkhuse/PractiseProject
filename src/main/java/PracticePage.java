import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;



public class PracticePage {

    public static void main(String[] args)
    {

        System.setProperty("webdriver.chrome.driver","C:\\New Practise\\Drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();



        //Open browser
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }





        WebDriverWait waiting= new WebDriverWait(driver, 20);
        WebElement myElement= driver.findElement(By.xpath("//input[@value='radio3']"));

        //click radio button three
        driver.findElement(By.xpath("//input[@value='radio3']")).click();

        //Validate radio button three is checked.

        boolean checked=driver.findElement(By.xpath("//input[@value='radio3']")).isSelected();

        System.out.println(checked);




        //Click radio button two
        driver.findElement(By.xpath("//input[@value='radio2']")).click();

        //Validate radio button two is checked.
        List<WebElement> radio=driver.findElements(By.xpath("//input[@name='radiobutton']"));
        for(int i=0;i<=radio.size();i++)
        {
            boolean check=driver.findElement(By.xpath("//input[@value='radio2']")).isSelected();
            if(check)
                System.out.println("Radio 2 is clicked");
            else
                System.out.println("Radio 2 is not clicked");

        }



        WebDriverWait x = new WebDriverWait(driver, 10);


        //Enter South Africa
        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("South");

        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ENTER);


        //Enter Republic Central

        WebDriverWait y = new WebDriverWait(driver, 1000);
        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Republic");

        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ENTER);






        //Click checkboxes
        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
        driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();

        //Validate checkboxes

        boolean checkbox1=driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected();
        System.out.println(checkbox1);
        boolean checkbox2=driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).isSelected();
        System.out.println(checkbox2);
        boolean checkbox3=driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).isSelected();
        System.out.println(checkbox3);



        //uncheck checkbox
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ignored){
        }
         driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();

        //Validate checkbox

        boolean bool2= driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).isSelected();
        boolean bool3= driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).isSelected();

           if(bool2)
               if(bool3)
               System.out.println("checkboxes are checked.");
            else
               System.out.println("checkboxes are not checked.");



        driver.manage().window().maximize();

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(200,500)");



        WebDriverWait wing= new WebDriverWait(driver, 1000);

        //click Hide button

        driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();

        //Validate button is hidden

         String results="";
        if(driver.findElement(By.xpath("//input[@id='displayed-text']")).isDisplayed()) {

             results = "Textbox is not hidden";

        } else
             results ="Textbox is hidden";
         System.out.println(results);



        WebDriverWait wa= new WebDriverWait(driver, 1000);
        //click Show button

        driver.findElement(By.xpath("//input[@id='show-textbox']")).click();

        //Validate button is displayed.
         String showResults="";
        if(driver.findElement(By.xpath("//input[@id='displayed-text']")).isDisplayed()) {

            showResults = "Textbox is displayed";

        } else
            showResults ="Textbox is not displayed";
        System.out.println(showResults);


        String innertext = driver.findElement(
                By.xpath("//td[contains(.,'46')]")).getText();
        System.out.println(innertext);


        String TotalAmount = driver.findElement(
                By.xpath("//div[@class='totalAmount'][contains(.,'Total Amount Collected: 296')]")).getText();
        System.out.println(TotalAmount);


        //By finding all the web elements using iframe tag
        //List<WebElement> iframeElements = driver.findElements(By.tagName("iframeResult"));
        JavascriptExecutor j=(JavascriptExecutor)driver;
        j.executeScript("window.scrollBy(300,500)");
        List<WebElement> iframeElements = driver.findElements(By.xpath("//ul[@class='clearfix'][contains(.,'contact@rahulshettyacademy.com')]"));
        System.out.println(" iframes  " + iframeElements);

        //Switch by frame name
       //driver.switchTo().frame("iframeResult");




       WebDriverWait w = new WebDriverWait(driver, 10);
       driver.close();



    }

}
