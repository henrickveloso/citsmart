package br.com.centralit.citcorpore.teste.TesteSelenium;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class MudaSLASelenium {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  LoginSelenium login;

  @Before
  public void setUp() throws Exception {
//    driver = new FirefoxDriver();
	DesiredCapabilities capability = DesiredCapabilities.firefox();
	driver = new RemoteWebDriver(new URL("http://10.2.1.3:4444/wd/hub"), capability);
    baseUrl = "http://localhost/citsmart";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    login = new LoginSelenium(driver, baseUrl, acceptNextAlert, verificationErrors);
  }

  @Test
  public void testUntitled() throws Exception {
	  	login.testUntitled();
	  	JavascriptExecutor js = (JavascriptExecutor) driver;
	    driver.findElement(By.cssSelector("a[id=itemMM52]")).click();
	   	driver.findElement(By.cssSelector("div[id=mmSUB53]")).click();
	   	js.executeScript("chamaItemMenu('/citsmart/pages/gerenciamentoServicos/gerenciamentoServicos.load')");
	   	Thread.sleep(2000L);
	   	js.executeScript("prepararMudancaSLA(58987,37553)");
	   	
	    WebElement ifr = driver.findElement(By.xpath("//iframe[@src='/citsmart/pages/mudarSLA/mudarSLA.load?idSolicitacaoServico=37553']"));
		driver.switchTo().frame(ifr);
	   	
	    new Select(driver.findElement(By.id("slaACombinar"))).selectByVisibleText("Definir o tempo");
	    driver.findElement(By.id("prazoHH")).clear();
	    driver.findElement(By.id("prazoHH")).sendKeys("4");
	    new Select(driver.findElement(By.id("idJustificativa"))).selectByVisibleText("Aguardando Resposta do Usu�rio");
	    js.executeScript("gravar();");
	    driver.switchTo().alert().getText().endsWith("Confirma a mudan�a de SLA");
	    Thread.sleep(2000L); 
	    driver.switchTo().alert().accept();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}