package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    ActionsWithOurElements actionsWithOurElements;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        /*
        инициалузирует елементы которые описаны в FindBy
         */
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }
}
