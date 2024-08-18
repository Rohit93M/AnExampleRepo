package com.example.framework.google;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.framework.dataprovider.TestDataProvider;
import com.example.genericutility.BaseClass;
import com.example.genericutility.ListenersImplementation;
import com.example.pomrepo.GooglePage;

@Listeners(ListenersImplementation.class)
public class GooglePageTest extends BaseClass {

	@Test(dataProvider = "searchData", dataProviderClass = TestDataProvider.class)
	public void fetchTheTextOfSearchResults(String url, String title, String text) throws IOException {

		driver.get(url);

		webdriverUtils.waitForATitle(driver, title);
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, title);

		GooglePage googlePage = new GooglePage(driver);

		googlePage.search(text);
		googlePage.clickBtn();

		webdriverUtils.waitForTitleContains(driver, "Google Search");
		actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.contains("Google Search"), "Page title is incorrect");
	}
}
