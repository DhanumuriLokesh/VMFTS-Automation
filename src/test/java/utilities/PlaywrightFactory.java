package utilities;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext browserContext;
    private static Page page;
    private static boolean initialized = false;

    // Initialize Playwright only once
    public static void init() {
        if (initialized) {
            System.out.println("Playwright already initialized");
            return;
        }

        try {
            System.setProperty("PLAYWRIGHT_BROWSERS_PATH", 
                System.getProperty("user.home") + "/AppData/Local/ms-playwright");

            // Create Playwright instance
            playwright = Playwright.create();
            System.out.println("Playwright created");

            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                    .setSlowMo(500)
                    .setHeadless(false);
            System.out.println("Launch options created");

            // Launch Chromium browser
            browser = playwright.chromium().launch(options);
            System.out.println("Browser created");

            // Create a new browser context
            browserContext = browser.newContext();
            System.out.println("Browser context created");

           
            initialized = true;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize Playwright", e);
        }
    }

    // Return the page object
    public static Page getPage() {
        if (page == null) {
            throw new IllegalStateException("Playwright page not initialized. Call init() first.");
        }
        // Create a new page
        page = browserContext.newPage();
        System.out.println("Page created");

        return page;
    }
    
    
    // Tear down Playwright safely
    public static void tearDown() {
        try {
            if (page != null) page.close();
            if (browserContext != null) browserContext.close();
            if (browser != null) browser.close();
            if (playwright != null) playwright.close();
            System.out.println("Playwright tear down completed");
        } catch (Exception e) {
            System.err.println("Error while tearing down Playwright: " + e.getMessage());
        } finally {
            page = null;
            browserContext = null;
            browser = null;
            playwright = null;
            initialized = false;
        }
    }
}
