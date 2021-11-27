import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {
    static WebDriver driver;

    @BeforeAll

    public static void setUp(){
        System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Olita\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterAll
    public static void tearUp(){
        driver.quit();
    }
    @Test
    public void sdaWebPageTesting (){

        driver.get("https://sdacademy.dev");
        System.out.println(driver.findElement(By.className("heading-1")).getText());

        Assertions.assertEquals("Dare to.\nMake a change.", driver.findElement(By.className("heading-1")).getText());



    }
    @Test
    public void sdaFromGoogleTest(){


        WebDriverWait wait = new WebDriverWait(driver , 10);

        driver.get("https://www.google.pl");
        driver.manage().window().maximize();
        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("software development academy");
        driver.findElement(By.name("btnK")).submit();
        driver.findElement(By.xpath("//*[@id=\"tads\"]/div[1]/div/div/div[1]/a")).click();
        System.out.println(driver.getTitle());
        Assertions.assertEquals("Wydarzenia - SDA Polska",driver.getTitle());

    }
    @Test
    public void wpLogin(){

        driver.get("https://profil.wp.pl/login/login.html");
        driver.findElement(By.id("login")).sendKeys("sdatesting");
        driver.findElement(By.id("password")).sendKeys("SDAtesting123!");
        driver.findElement(By.xpath("//*[@id=\"stgMain\"]/div/div/div[1]/form/button")).click();
        System.out.println(driver.getTitle());
        Assertions.assertEquals("WP Poczta", driver.getTitle());
    }
}
