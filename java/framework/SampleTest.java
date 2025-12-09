package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class SampleTest {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Test
    public void testGoogle() {
        page.navigate("https://google.com");
        System.out.println("Title: " + page.title());
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
