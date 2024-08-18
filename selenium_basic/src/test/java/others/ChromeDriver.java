package others;

public class ChromeDriver extends RemoteWebDriver {
	public ChromeDriver() {
		System.out.println("Chrome browser will be loaded");
	}

	public void get(String url) {
		System.out.println("get() method will trigger the current url " +url+ " in chrome");
	}

	public void quit() {
		System.out.println("quit() will close the current session that is all active windows in chrome");
	}
}
