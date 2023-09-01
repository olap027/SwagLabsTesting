package constant;

public interface Home {

    String ADD_TO_CART_ICON = "//div[@id='shopping_cart_container']";

    String FILTERS_DROPDOWN = "//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[2]/div[1]/span[1]/select[1]";

    String NAME_A_TO_Z = "//span[contains(text(),'Name (A to Z)')]";
    String NAME_Z_TO_A = "//option[contains(text(),'Name (Z to A)')]";

    String LOW_TO_HIGH = "//option[contains(text(),'Price (low to high)')]";
    String HIGH_TO_LOW = "//option[contains(text(),'Price (high to low)')]";

    String INVENTORY_ITEM_NAME = "div[class='inventory_item_name']";
    String INVENTORY_ITEM_PRICE = "//div[@class='inventory_item_price']";

    String ADD_TO_CART_BTN = ".btn_primary";
    String REMOVE_BTN = ".btn_secondary";
    String BUTTON = ".btn_inventory";

    String CART_ITEM = "//*[@id=\"item_0_title_link\"]";
    String CONTINUE_SHOPPING_BTN = "//button[@id='continue-shopping']";
    String CHECK_OUT_BTN = "//button[@id='checkout']";

    String FIRST_NAME_INPUT = "//input[@id='first-name']";
    String LAST_NAME_INPUT = "//input[@id='last-name']";
    String ZIP_CODE_INPUT = "//input[@id='postal-code']";

    String CONTINUE_BTN = "//input[@id='continue']";
    String CHECK_OUT_ERROR = "//div[@class='error-message-container error']";

    String TOTAL_PRICE = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]";
    String TAX = "//div[@class='summary_tax_label']";
    String ITEM_TOTAL = "//div[@class='summary_subtotal_label']";

    String FINISH_BTN = "//button[@id='finish']";
    String CANCEL_BTN = "//button[@id='cancel']";

    String BACK_TO_HOME = "//button[@id='back-to-products']";

    String COMPLETE_HEADER = "//span[contains(text(),'Checkout: Complete!')]";
}
