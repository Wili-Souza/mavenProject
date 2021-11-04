package br.upe.mavenBasico;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DriverTest extends TestCase {
    /**  Teste para resultado da MegaSena */
    @Test
    public void testResultadoMegaSena() {
        // Criando driver
        WebDriver driver = new Driver("95").getDriver();

        // Se foi criado (não nulo)
        assertNotNull(driver);

        // testando driver
        driver.get("https://www.google.com");
        assertNotNull(driver.findElement(By.tagName("html")));
    }
}