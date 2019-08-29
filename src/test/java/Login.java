import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Ferramentas\\chromedriver.exe");
        return new ChromeDriver();
    }

    public WebDriver driver = getDriver();
    public WebDriverWait wait = new WebDriverWait(driver, 10);

    @Before
    public void before() {
        driver.manage().window().maximize();
        driver.get("https://www.madeiramadeira.com.br/cadastro");

    }

    @After
    public void after(){
        driver.quit();
    }

    @Test
    public void cadastrar() {
        int numeroRandomico = 1 + (int) (Math.random() * 10000);
        driver.findElement(By.id("txtEmail")).sendKeys("prova" + numeroRandomico + "@yaman.com.br");
        driver.findElement(By.id("txtCPF")).sendKeys("84618491086");
        driver.findElement(By.id("txtName")).sendKeys("Wprova Yaman");
        driver.findElement(By.id("txtTel1")).sendKeys("11998899645");
        driver.findElement(By.id("txtPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtCEP")).sendKeys("06454000");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtAddNum")));
        // driver.findElement(By.id("txtAddress")).sendKeys("Alameda Rio Negro");
        driver.findElement(By.id("txtAddNum")).sendKeys("500");
        // driver.findElement(By.id("txtAddBairro")).sendKeys("Alphaville");
        // driver.findElement(By.id("txtAddState")).sendKeys("São Paulo");
        // driver.findElement(By.id("txtAddCity")).sendKeys("Barueri");
        driver.findElement(By.id("txtAddRef")).sendKeys("Yaman");
        driver.findElement(By.id("btnFullSignin")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='area-vip-welcome-message']")));
        String validar = driver.findElement(By.xpath("//span[@class='area-vip-welcome-message']")).getText();
        Assert.assertTrue(validar.contains("Bem vindo!"));

    }


}
