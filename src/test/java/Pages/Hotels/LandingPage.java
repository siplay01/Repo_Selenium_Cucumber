package Pages.Hotels;

import DriverWrapper.Web;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage extends BasePage {

    By searchButton = By.xpath("//button[@type='submit']");
    By searchField = By.id("qf-0q-destination");
    By checkInCalendar = By.id("qf-0q-localised-check-in");
    By checkOutCalendar = By.id("qf-0q-localised-check-out");
    By allCalenderDates = By.xpath("//td[starts-with(@data-date,'2020-11')]");
    By briefcase = By.xpath("//span[@class='widget-query-num-nights']");
    By autoSuggestionsLocator = By.xpath("//div[@class='autosuggest-category-result']");
    By destinationPropertyLandmarkField = By.name("q-destination");
    By childrenDropdownElm = By.id("qf-0q-room-0-children");
    By childAgeFieldOne = By.id("qf-0q-room-0-child-0-age");
    By childAgeFieldTwo = By.id("qf-0q-room-0-child-1-age");

    public void clickSearch() {
        clickThis(searchButton);
    }

    public void searchFor(String searchData) {
        type(searchField, searchData);
        sleepFor(2);
    }

    public boolean isSearchButtonEnabled() {
        return Web.getDriver().findElement(searchButton).isEnabled();
    }

    public void selectCheckInDate(String checkInDate) {
        clickThis(checkInCalendar);
        List<WebElement> dates = Web.getDriver().findElements(allCalenderDates);
        for (WebElement date : dates) {
            if (date.getText().equalsIgnoreCase(checkInDate)) {
                date.click();
                break;
            }
        }
    }

    public void selectCheckOutDate(String checkOutDate) {
        clickThis(checkOutCalendar);
        List<WebElement> dates = Web.getDriver().findElements(allCalenderDates);
        for (WebElement date : dates) {
            if (date.getText().equalsIgnoreCase(checkOutDate)) {
                date.click();
                break;
            }
        }
    }

    public String getBriefcaseText() {
        return Web.getDriver().findElement(briefcase).getText();
    }

    public void selectAutoSuggestionsLocator(String toSelect) {
        List<WebElement> suggestions = Web.getDriver().findElements(autoSuggestionsLocator);
        for (WebElement suggestion : suggestions) {
            String suggestionText = suggestion.getText();
            if (toSelect.equalsIgnoreCase(suggestionText)) {
                suggestion.click();
                break;
            }
        }
    }

    public boolean isHeaderContainsText(String text) {
        return getWebpageTitle().contains(text);
    }

    public boolean isElementContainsText(String text) {
        String elmTxt = Web.getDriver().findElement(destinationPropertyLandmarkField).getAttribute("value");
        return elmTxt.contains(text);
    }

    public void selectChildren(String numOfChildren) {
        selectFromDropdownUsingVisibleText(childrenDropdownElm, numOfChildren);
    }

    public void selectChildrenAge(int childNum, String age) {
        switch (childNum) {
            case 1 -> selectFromDropdownUsingVisibleText(childAgeFieldOne, age);
            case 2 -> selectFromDropdownUsingVisibleText(childAgeFieldTwo, age);
        }
    }
}
