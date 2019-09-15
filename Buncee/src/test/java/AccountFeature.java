import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class AccountFeature extends SubBase {

    public AccountFeature() throws IOException { }

    @Test
    public void login() throws InterruptedException {

        loginToAccount();

    }

    @Test
    public void logout() throws Exception {
        loginToAccount();
        logoutFromAccount();
        takeTheScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
    }



    @Test
    public void addAddress() throws InterruptedException {

        // new test case




    }



//
//    @Test
//    public void changeName() throws InterruptedException {
//
//
//    }






}
