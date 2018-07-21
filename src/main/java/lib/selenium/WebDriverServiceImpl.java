package lib.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import lib.listeners.WebDriverListener;

public class WebDriverServiceImpl extends WebDriverListener implements WebDriverService{

	public WebElement locateElement(String locator, String locValue) {

		switch (locator) {
		case "id": return driver.findElement(By.id(locValue));

		case "name": return driver.findElement(By.name(locValue));

		case "class": return driver.findElement(By.className(locValue));

		case "link" : return driver.findElement(By.linkText(locValue));

		case "xpath": return driver.findElement(By.xpath(locValue));

		default:
			break;
		}
		return null;
	}

	public void type(WebElement ele, String data) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.sendKeys(data);
			reportSteps("The Data "+data+" is Entered Successfully", "pass");
		} catch (Exception e) {
			reportSteps("The Data "+data+" is not Entered Successfully", "fail");
		}		
	}

	public void click(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.click();
			reportSteps("The button "+ele+" is clicked Successfully", "pass");
		} catch (NoSuchElementException | InvalidElementStateException e) {
			reportSteps("The button "+ele+" is not clicked Successfully", "fail");
//			System.err.println("Element "+ele+" is not found or not editable");
			throw new RuntimeException("NoSuchElementException");
		}				
	}

	public void clear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);
		reportSteps("The Data is cleared Successfully", "pass");
	}

	public String getText(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			String eleText = ele.getText();
			return eleText;
		} catch (NoSuchElementException | InvalidElementStateException e) {
			System.err.println("Element "+ele+" is not found or not editable");
			throw new RuntimeException("NoSuchElementException");
		}	
	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(ele));
			Select selectObject=new Select(ele);
			selectObject.selectByVisibleText(value);
			reportSteps("The dropdown value "+value+" from "+ele+" is selected Successfully", "pass");
		} catch (NoSuchElementException | InvalidElementStateException e) {
			reportSteps("The dropdown value "+value+" from "+ele+" is not selected Successfully", "fail");
//			System.err.println("Element "+ele+" is not found or not editable");
			throw new RuntimeException("NoSuchElementException");
		}			
	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			Select selectObject=new Select(ele);
			selectObject.selectByValue(value);
			reportSteps("The dropdown value "+value+" from "+ele+" is selected Successfully", "pass");
		} catch (NoSuchElementException | InvalidElementStateException e) {
			reportSteps("The dropdown value "+value+" from "+ele+" is not selected Successfully", "fail");
//			System.err.println("Element "+ele+" is not found or not editable");
			throw new RuntimeException("NoSuchElementException");
		}			
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			Select selectObject = new Select(ele);
			selectObject.selectByIndex(index);
			reportSteps("The dropdown value of index "+index+" from "+ele+" is selected Successfully", "pass");
		} catch (NoSuchElementException | InvalidElementStateException | IndexOutOfBoundsException e) {
			reportSteps("The dropdown value of index "+index+" from "+ele+" is not selected Successfully", "fail");
//			System.err.println("Element "+ele+" is not found or not editable or the specified index is invalid");
			throw new RuntimeException("NoSuchElementException");
		}			
	}

	public boolean verifyExactTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyPartialTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(ele));
		String outText = getText(ele);
		if(outText.equals(expectedText)) {
//			System.out.println("Verfied to be correct");
			reportSteps("The text "+expectedText+" from "+ele+" is verified Successfully", "pass");
		}
		else {
			reportSteps("The text "+expectedText+" from "+ele+" is not verified Successfully", "fail");
//			System.out.println("Verified to be incorrect");
		}
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(ele));
		String outText = getText(ele);
		if(outText.contains(expectedText)) {
			reportSteps("The text "+expectedText+" from "+ele+" is verified Successfully", "pass");
//			System.out.println("Verfied to be correct");
		}
		else {
			reportSteps("The text "+expectedText+" from "+ele+" is not verified Successfully", "fail");
//			System.out.println("Verified to be incorrect");
		}
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(ele));
		if(ele.getText().contains(value)) {
			System.out.println("Verfied to be correct");
		}
		else {
			System.out.println("Verified to be incorrect");
		}

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(ele));
		if(ele.getText().contains(value)) {
			System.out.println("Verfied to be correct");
		}
		else {
			System.out.println("Verified to be incorrect");
		}

	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void switchToWindow(int index) {
		try {
			Set<String> winHand = driver.getWindowHandles();
			List<String> hands=new ArrayList<String>();
			hands.addAll(winHand);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.numberOfWindowsToBe(index+1));
			driver.switchTo().window(hands.get(index));
		} catch (NoSuchWindowException e) {
			System.err.println("Requested Window is unavailable");
		}		
	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void acceptAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			System.err.println("No Alert present to accept");
			throw new RuntimeException("NoAlertPresentException");
		}
	}

	public void dismissAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			System.err.println("No Alert present to dismiss");
			throw new RuntimeException("NoAlertPresentException");
		}
	}

	public String getAlertText() {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	public void closeActiveBrowser() {
		try {
			driver.close();
		} catch (UnreachableBrowserException e) {
			System.err.println("Browser cannot be closed");
		}
	}
	public void closeAllBrowsers() {
		try {
			driver.quit();
		} catch (UnreachableBrowserException e) {
			System.err.println("Browsers cannot be closed");
		}
	}
}