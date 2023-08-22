package constant;

public interface Home {

    String FILTERS_DROPDOWN = "//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[2]/div[1]/span[1]/select[1]";

    String NAME_A_TO_Z = "//span[contains(text(),'Name (A to Z)')]";
    String NAME_Z_TO_A = "//option[contains(text(),'Name (Z to A)')]";

    String LOW_TO_HIGH = "//option[contains(text(),'Price (low to high)')]";
    String HIGH_TO_LOW = "//option[contains(text(),'Price (high to low)')]";


    String INVENTORY_ITEM_NAME = "div[class='inventory_item_name']";
    String INVENTORY_ITEM_PRICE = "//div[@class='inventory_item_price']";
}
