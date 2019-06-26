package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {
    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public SparesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(".//*[text()='" + spareName + "']");
    }

    public void deleteSpareUntilPresent(String spareName) {
        boolean isElementDisplayed = isSpareInList(spareName);
        while (isElementDisplayed) {
            actionsWithOurElements.clickOnElement(".//*[text()='" + spareName + "']");
            EditSparePage editSparePage = new EditSparePage(webDriver);
            editSparePage.clickOnButtonDelete();

            isElementDisplayed = isSpareInList(spareName);
        }
    }
}
