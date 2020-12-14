package Pages.Hotels;

import DriverWrapper.Web;
import Pages.BasePage;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {

    By lowToHighSortBtn = By.xpath("//a[contains(text(), 'Price (low to high)')]");
    By lowestPriceElm = By.xpath("//div[@class='price']//ins[1]");
    By cheapestHotel = By.xpath("(//li[@class='hotel'])[1]");
    By priceSortIcon = By.xpath("//a[@data-menu='sort-submenu-price']");

    public void sortPriceLowToHigh() {
        clickThis(priceSortIcon);
        clickThis(lowToHighSortBtn);
        sleepFor(2);
    }

    public void printLowestPriceAndHotelName() {
        System.out.println("Hotel name: " + Web.getDriver().findElement(cheapestHotel).getAttribute("data-title"));
        System.out.println("Price: " + Web.getDriver().findElement(lowestPriceElm).getText());
    }

    public boolean isLowestPriceLessThan(int price) {
        boolean result = false;
        String lowestPrice = Web.getDriver().findElement(lowestPriceElm).getText().substring(1);
        int lPriceInt = Integer.parseInt(lowestPrice);
        if (lPriceInt < price) {
            result = true;
        }
        return result;
    }
}
