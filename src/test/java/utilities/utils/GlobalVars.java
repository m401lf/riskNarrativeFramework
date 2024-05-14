package utilities.utils;

public class GlobalVars {

    /**
     * Config Properties file
     **/

    // Download Application PDF location
    public static String APPLICATIONS_DOWNLOAD_FILEPATH = System.getProperty("user.dir") + "/File_downloads";
    public static String REPORTING_DOWNLOAD_FILEPATH = System.getProperty("user.dir") + "/File_downloads/";
    public static String APPLICATIONS_DOWNLOAD_FILENAME = "-Application forms.pdf";
    public final static String CONFIG_PROPERTIES_DIRECTORY = "properties\\config.properties";
    public final static String DATAPROVIDER_JSONPATH = System.getProperty("user.dir") + "//src//test//java//testData//data//Register.json";

    public final static String URL_HOMEPAGE = "https://automationteststore.com/";
    public final static String GOOGLE_HOMEPAGE_URL = "https://www.google.co.uk/";
    public final static String ACCOUNTCREATEPAGE_URL = "https://automationteststore.com/index.php?rt=account/create";

    public final static String LOGINPAGE_URL = "https://automationteststore.com/index.php?rt=account/login";

    public final static String ACCOUNTCREATEPAGE_TITLE = "Register Account";
    public final static String ACCOUNT_LOGIN_TXT = "ACCOUNT LOGIN";
    public final static String MYACCOUNT = "My Account";
    public final static String LOGIN = "Login";

    public final static String Browser = "Chrome";
    public final static String RETURNING_CUSTOMER = "Returning Customer";
    public final static String NEW_CUSTOMER = "New Customer";

    public final static String myAccountInformation = "My Account Information";
    public final static String REGISTER_JSON_PATH = "//src//test//java//opencart//testData.data//createAnAccount.json";

    public final static String recoveryPassword_Username = "benazeta70";
    public final static String username = "webdriverio2";
    public final static String password = "webdriverio2";
    public final static String myAccount = "My Account";
    public final static String accountSuccessfullyUpdated = "Success: Your account has been Success: Your account has been successfully updated..";

    public final static String wrong_password = "Password_Wrong";
    public final static String pass_word = "Password";

    public final static String CONTINUE_BTN_TEXT = "Continue";

    public final static String HOMEPAGE_TITLE = "Your Store";
    public final static String ACCOUNT_LOGOUT_HEADER = "Account Logout";
    public final static String WELCOME_MESSAGE_TXT = "Welcome back";
    public final static String ACCOUNT_EDIT_URL_PATH = "account/edit";
    public final static String PRODUCTNAME_1 = "Skinsheen Bronzer Stick";
    public final static String Benefit_Bella_Bamba = "Benefit Bella Bamba";
    public final static String PRODUCTNAME_3 = "Absolue Eye Precious Cells";


    //=================================================================//
    public final static String LASTNAME = "John";
    public final static String FIRSTNAME = "Doe";
    public final static String TELEPHONE = "0740500000000";
    public final static String FAX = "0740500000001";
    public final static String loginname_password = "benazeta70";
    public final static String email_password = "benazeta70@gmail.com";
    public final static String lastname = "Zeta";
    public final static String emailAddress = "email001@email.com";
    public final static String wrongPassword = "WrongPassword00";

    public final static String INCORRECT_LOGIN_PASSWORD_PROVIDED = "Warning: No match for E-Mail Address and/or Password.";
    public final static String RECOVERY_PASSWORD_SUCCESS_MSG = "Success: Password reset link has been sent to your e-mail address";
    public final static String RECOVERY_LOGINNAME_SUCCESS_MSG = "Success: Your login name reminder has been sent to your e-mail address.";

    public final static String FORGET_YOUR_PASSWORD_LINK_TXT = "Forgot your password?";
    public final static String FORGET_YOUR_LOGINNAME_LINK_TXT = "Forgot your login?";
    public final static int explicitWait = 15;

    public final static int expWait = 5;
    public final static int explicit_Wait = 2;
    public final static int IMPLICIT_WAIT = 2;
    public final static int DEFAULT_EXPLICIT_TIMEOUT = 15;

    public final static int EXPLICIT_TIMEOUT = 30;
    public final static int POLLING_TIMEOUT = 250;
    public final static int PAGELOAD_TIMEOUT = 120;

    public final static int DEFAULT_IMPLICIT_TIMEOUT = 7;

    public static final int IMPLICIT_WAIT_TIME = 10;
    public static final int PAGE_LOAD_TIME = 15;
    public static final int EXPLICIT_WAIT_BASIC_TIME = 30;
    public final static int implicitWait = 10;
    static String UPDATED_SUCCESSFULLY = "Success: Your account has been successfully updated";
    static String THANKS_FOR_SHOPPING_WITH_US = "Thank you for shopping with us!";

    public static String getRecoveryLoginnameLastName() {
        return lastname;
    }

    public static String getLoginnamePassword() {
        return loginname_password;
    }

    //=================================================================//

    public static String getEmailPassword() {
        return email_password;
    }

    public static String getMyAccount() {
        return MYACCOUNT;
    }

    public static String getLogin() {
        return LOGIN;
    }


    public static String getRecoveryPasswordAlertSuccessMsg() {
        return RECOVERY_PASSWORD_SUCCESS_MSG;
    }

    public static String getRecoveryLoginnameAlertSuccessMsg() {
        return RECOVERY_LOGINNAME_SUCCESS_MSG;
    }

    public static String getWarningIncorrectLoginPasswordMsg() {
        return INCORRECT_LOGIN_PASSWORD_PROVIDED;
    }

    public static String getForgotYourPasswordTxt() {
        return FORGET_YOUR_PASSWORD_LINK_TXT;
    }

    public static String getForgotYourLoginnameTxt() {
        return FORGET_YOUR_LOGINNAME_LINK_TXT;
    }

    public static String getSkinBronzerStick() {
        return PRODUCTNAME_1;
    }

    public static String getBenefitBellaBamba() {
        return Benefit_Bella_Bamba;
    }

    public static String getAbsolueEyePreciousCells() {
        return PRODUCTNAME_3;
    }

    public static String getConfigPropertiesDirectory() {
        return CONFIG_PROPERTIES_DIRECTORY;
    }

    public static String getDataProviderJsonPath() {
        return DATAPROVIDER_JSONPATH;
    }

    public static String getHomePageTitle() {
        return HOMEPAGE_TITLE;
    }

    public static String getRegisterJsonPath() {
        return REGISTER_JSON_PATH;
    }


    public static String getHomePageUrl() {
        return URL_HOMEPAGE;
    }

    public static String getAccountCreatePageUrl() {
        return ACCOUNTCREATEPAGE_URL;
    }

    public static String getLoginPageUrl() {
        return LOGINPAGE_URL;
    }

    public static String getAccountCreatePageTitle() {
        return ACCOUNTCREATEPAGE_TITLE;
    }

    public static String getGoogleHomepageUrl() {
        return GOOGLE_HOMEPAGE_URL;
    }


    public static String getUserName() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getRecoveryPassword_Username() {
        return recoveryPassword_Username;
    }


    public static String getWrongPassword() {
        return wrong_password;
    }

    public static String getContinueBtnText() {
        return CONTINUE_BTN_TEXT;
    }


    public static String getReturningCustomer() {
        return RETURNING_CUSTOMER;
    }

    public static String getAccountLogin() {
        return ACCOUNT_LOGIN_TXT;
    }

    public static String getNewCustomer() {
        return NEW_CUSTOMER;
    }

    public static String getThanksForShoppingWithUs() {
        return THANKS_FOR_SHOPPING_WITH_US;
    }

    public static int getExplicitWait() {
        return explicitWait;
    }

    public static int explicitWait() {
        return expWait;
    }


    public static int getExplicit_Wait() {
        return explicit_Wait;
    }

    public static String getEmailAddress() {
        return emailAddress;
    }

    public static String getPass() {
        return pass_word;
    }

    public static String getWrongPass() {
        return wrong_password;
    }


    public static int getImplicitWait() {
        return implicitWait;
    }

    public static int getPollinTimeout() {
        return POLLING_TIMEOUT;
    }

    public static int getDefaultExplicitTimeout() {
        return DEFAULT_EXPLICIT_TIMEOUT;
    }

    public static int getMaxExplicitTimeout() {
        return EXPLICIT_TIMEOUT;
    }

    public static int getPageLoadTimeout() {
        return PAGELOAD_TIMEOUT;
    }

    public static int getDefaultImplicitTimeout() {
        return DEFAULT_IMPLICIT_TIMEOUT;
    }

    public static String getUpdatedSuccessfully() {
        return UPDATED_SUCCESSFULLY;
    }

    public static String getAccountLogoutHeaderTxt() {
        return ACCOUNT_LOGOUT_HEADER;
    }

    public static CharSequence getWelcomeMessageTxt() {
        return WELCOME_MESSAGE_TXT;
    }
}

