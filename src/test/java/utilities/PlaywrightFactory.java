package utilities;

import java.util.Arrays;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

	    private static Playwright playwright;
	    private static Browser browser;
	    private static BrowserContext browserContext;

	    public static void init() {
	        if (playwright != null) return;  // already initialized

	        playwright = Playwright.create();
	        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        		.setSlowMo(1000).setHeadless(false).setArgs(Arrays.asList("--start-maximized")));
	        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
	     
	    }

	    public static Page getPage() {
	        if (browserContext == null) throw new RuntimeException("BrowserContext not initialized!");
	        return browserContext.newPage(); // always a new tab
	    }

	    public static void tearDown() {
	        if (browserContext != null) browserContext.close();
	        if (browser != null) browser.close();
	        if (playwright != null) playwright.close();
	    }

		

		
   
}
