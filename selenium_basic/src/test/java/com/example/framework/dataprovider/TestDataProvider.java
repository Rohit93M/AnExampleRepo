package com.example.framework.dataprovider;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "fbLoginData01")
	public Object[][] getLoginData01() {
		return new Object[][] {
				{ "https://www.facebook.com/", "Facebook – log in or sign up", "7483215796", "Rohit93m" } };
	}

	@DataProvider(name = "fbLoginData02")
	public Object[][] getLoginData02() {
		return new Object[][] {
				{ "https://www.facebook.com/", "Facebook – log in or sign up", "rohit93m@gmail.com", "Rohit93m" } };
	}

	@DataProvider(name = "searchData")
	public Object[][] getSearchData() {
		return new Object[][] { { "https://www.google.co.in/", "Google", "Selenium" } };
	}
}
