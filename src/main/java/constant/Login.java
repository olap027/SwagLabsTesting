package constant;

public interface Login {

    String USERNAME_FIELD = "//input[@id='user-name']";
    String PASSWORD_FIELD = "//input[@id='password']";
    String LOGIN_BTN = "//input[@id='login-button']";

    String ERROR_MESSAGE = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]";

    String TABLE_CONTAINER = "//*[@id=\"inventory_container\"]";
}
