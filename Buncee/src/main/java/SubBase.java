import org.openqa.selenium.By;
import pageobject.AccountPage;

import java.io.IOException;

public class SubBase extends Base {

    public static String testDataFilePath = "/Users/u727759/Desktop/Amazon/Buncee/src/test/TestData/test_data.xlsx";

    // Test Data
    public String userName = readFromExcel(testDataFilePath, "Account", "B2");
    public String password = readFromExcel(testDataFilePath, "Account", "C2");

    public SubBase() throws IOException { }

    public void loginToAccount() throws InterruptedException{
        clickByXpath(AccountPage.loginLinkXPath);
        sendTestByXpath(AccountPage.userNameFieldXPath, userName);
        sendTestByXpath(AccountPage.passwordFieldXPath, password);
        clickByXpath(AccountPage.loginButtonXPath);
        clickByXpath(AccountPage.profileLogoXPath);
        clickByXpath(AccountPage.profileLogoXPath);
    }

    public void logoutFromAccount() throws InterruptedException {
        clickByXpath(AccountPage.profileLogoXPath);
        clickByXpath(AccountPage.logoutLinkXPath);
    }






}
