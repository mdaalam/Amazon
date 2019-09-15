import org.testng.annotations.Test;

public class AccountPage  extends SubBase{


    @Test
    public void testTWCSignIn() throws InterruptedException {
        //fsLogin();

        searchProduct();
        //Assert.assertEquals(driver.getTitle(), "Message Inbox | Secure Message Center");
    }


    @Test
    public void testTWCSignIn2() throws InterruptedException {
        //fsLogin();

        searchProduct2();



        //Assert.assertEquals(driver.getTitle(), "Message Inbox | Secure Message Center");
    }


}
