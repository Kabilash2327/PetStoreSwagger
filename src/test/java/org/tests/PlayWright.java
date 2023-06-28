package org.tests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlayWright {

	@Test
	public void InitalBrowserRun() {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page newPage = browser.newPage();

		newPage.navigate("https://www.amazon.in/");

		System.out.println("After the Home page loaded      -------" + newPage.title());

		Locator locator = newPage.locator("(//a[contains(text(),'Best')])[1]");
		locator.click();

		Locator locator2 = newPage.locator("//span[text()='Amazon Bestsellers']");

		String textContent = locator2.textContent();
		System.out.println("The captured text is -------" + textContent);

		browser.close();

		playwright.close();

	}

}
