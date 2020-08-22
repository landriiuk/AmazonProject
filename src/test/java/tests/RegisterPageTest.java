package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RegisterPageTest extends BaseTest {
    public static final String URL_REGISTER = "https://www.amazon.com/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3F_encoding%3DUTF8%26ref_%3Dnav_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";

    @Test
    public void checkCreateNewAccountWithoutData() {
        getDriver().get(URL_REGISTER);
        getRegisterPage().clickButtonCreateNewAccount();
        assertTrue(getRegisterPage().isAlertNameDisplayed());
        assertTrue(getRegisterPage().isAlertEmailDisplayed());
        assertTrue(getRegisterPage().isAlertPasswordDisplayed());
    }
}
