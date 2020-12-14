package stepDefenition.Hotels;

    import Pages.Hotels.LandingPage;
    import Pages.Hotels.SearchPage;
    import cucumber.api.java.en.Then;
    import cucumber.api.java.en.When;
    import org.testng.Assert;

public class searchSD {

    String tempDataHolder = "";

    LandingPage landingPage = new LandingPage();
    SearchPage searchPage = new SearchPage();

    @When("^I enter '(.+)' in search$")
    public void enterInSearch(String searchData) { landingPage.searchFor(searchData); }

    @When("^I select '(.+)' from autosuggestion$")
    public void selectFromAutosuggestion(String toSelect) {
        landingPage.selectAutoSuggestionsLocator(toSelect);
        tempDataHolder = toSelect;
    }

    @When("^I click Search button$")
    public void clickSearchBtn() { landingPage.clickSearch(); }

    @Then("^I verify search header contains text selected from auto suggestion$")
    public void assertContainsTxt() { Assert.assertTrue(landingPage.isHeaderContainsText(tempDataHolder)); }

    @Then("^I verify text under 'Destination, property, or landmark' is same as text selected from auto suggestion$")
    public void assertTrue() { Assert.assertTrue(landingPage.isElementContainsText(tempDataHolder)); }

    @When("^I select (.+) in children dropdown$")
    public void selectChildrenDropdown(String amountOfChildren) { landingPage.selectChildren(amountOfChildren); }

    @When("^I enter Child (.+) age as (.+)$")
    public void iEnterChildAgeAs(int childNum, String childAge) { landingPage.selectChildrenAge(childNum, childAge); }

    @When("^I sort the result by Price \\(low to high\\)$")
    public void sortResultBy() { searchPage.sortPriceLowToHigh(); }

    @Then("^I print the lowest price and hotel name in the console$")
    public void printLowestPriceAndHotelName() { searchPage.printLowestPriceAndHotelName(); }

    @Then("^I verify the lowest price is less than \\$(.+)$")
    public void isLowestPriceLessThan(int price) { Assert.assertTrue(searchPage.isLowestPriceLessThan(price)); }
}


