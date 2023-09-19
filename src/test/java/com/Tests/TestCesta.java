package com.Tests;

import com.Pages.RegisterPage;
import org.junit.jupiter.api.Test;
import com.Pages.AddPage;
import com.Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCesta {

	public WebDriver driver;
	public WebDriverWait wait;
	static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES_ADD.HTML");
	static ExtentReports extent;

	@BeforeEach
	public void setUp() throws InterruptedException {
		this.extent = ExtentFactory.getInstance();
		this.extent.attachReporter(new ExtentObserver[]{this.info});
		this.driver = new ChromeDriver();
		this.wait = new WebDriverWait(this.driver, Duration.ofMillis(2000L));
		AddPage addPage = new AddPage(this.driver, this.wait);
		addPage.setup();
		addPage.url("https://opencart.abstracta.us/index.php?route=common/home");
	}

	@Test
	@Tag("CESTA")
	public void Cesta() throws InterruptedException {
		ExtentTest test = this.extent.createTest("Cesta");
		test.log(Status.INFO, "Comienza el Test");
		AddPage addPage = new AddPage(this.driver, this.wait);
		addPage.clickProduct();
		addPage.clickAdd();
	}

	@Test
	@Tag("REGISTRO")
	public void RegistroExitoso() throws InterruptedException {
		ExtentTest test = this.extent.createTest("Add to cart Exitoso");
		test.log(Status.INFO, "Comienza el Test");
		AddPage addPage = new AddPage(this.driver, this.wait);
		addPage.clickProduct();
		addPage.clickAdd();

		String AddThis = addPage.getAddThis();
		assertTrue(AddThis.equals(" Success: You have added iPhone to your shopping cart!"));
	}

	@AfterEach
	public void cerrar() {
		AddPage addPage = new AddPage(this.driver, this.wait);
		addPage.close();
		this.extent.flush();
	}
}

