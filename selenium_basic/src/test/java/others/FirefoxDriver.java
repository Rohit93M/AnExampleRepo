package others;

public class FirefoxDriver extends RemoteWebDriver {
	public FirefoxDriver() {
		System.out.println("Firefox browser will be loaded");
	}

	public void get(String url) {
		System.out.println("get() method will trigger the current url "+url+" in firefox");
	}

	public void quit() {
		System.out.println("quit() will close the current session that is all active windows in firefox");
	}
}
