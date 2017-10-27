JavaSeleniumQuery
=================

Write Java Selenium Tests in jQuery like syntax and access elements with
selectors generated right out from browser's Developer tools.

### Element selectors 

Java functions for selecting elements are dressed up to look like jQuery \$
function. You can select elements on your page in various ways. Following
selectors are supported:

**ID selector**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
$("#radioButton")
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

**Class selector**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
WebElement cb = $(".cbOne")
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

**XPATH selector**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
$(”//*[@id=\"resultView\"]/li/article/div/h2/a”)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

**Parent selectors**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
$("#additional").findElement(By.className("btnClose"));
WebElement flag = status.findElement(By.tagName("div"));
List submoduls = table.findElements(By.xpath("id('table2')/div/div/div"));
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 

### Getting and setting values, triggering events

After element is selected, you manipulate it in various ways:

**Click first table row **

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
$("//*id/tbody/tr[1]").click();
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

**Check the radio or click button**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
$("#radioButton").click();
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

**Enter text in input or textarea**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
$("#myInput").sendKeys("some text data");
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

**Get the attribute value**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
String cssClass = $("#" + moduleName).getAttribute("class");
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

**Select value on dropdown**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
WebElement cb = $(".cbOne");
Select cbSelect = new Select(cb);
cbSelect.selectByValue("4");
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

**Working with CKEditor**

Select the underlying input box

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
String ckeName = cke.getAttribute("name");
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Enter data

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
super.getJse().executeScript("CKEDITOR.instances['" + ckeName + "'].setData('" + ckeName + "')");
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Trigger save

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
super.getJse().executeScript("CKEDITOR.instances['" + ckeName + "'].fire('blur')"); 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 

### Executing custom Javascript

When some special actions needs to be executed on browser, and this framework
does not support it, you can execute arbitrary Javascript easily. For example:

**Trigger blur on some esoteric component**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
super.getJse().executeScript("$('.dtEnddate').blur()");
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

**Scroll to the top of window**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
jse.executeScript("scroll(250, 0)"); 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

**Scroll to the bottom of page**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
jse().executeScript("window.scrollTo(0, document.body.scrollHeight)");
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 

### Work with lists and tables

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
WebElement table = $("#table1");
List trRows = table.findElements(By.xpath("id('table1')/tbody/tr"));
for (final WebElement row : trRows) {
    List<WebElement> btnCollection = row .findElements(By.className(".linkBtn"));
    // loop again ...
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 

### Work with window alert’s

If clicking on some button will trigger window.alert, you can catch it and read
the text from it.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
try {
    Alert alert = super.getDriver().switchTo().alert();
    if (alert != null) {
        String alertText = alert.getText();
        log.info("Alert data: " + alertText);
        alert.accept();
    }
} catch (NoAlertPresentException e) {
    log.log(Level.SEVERE, e.getMessage(), e);
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 

Background
----------

Selenium is framework for automating web browser clicking (so to speak). Writing
Selenium code in java gives you ability, to reuse the code you already have in
application to be tested (Enums, utility classes, database access code). Also
writing tests in object oriented language, gives you great flexibility and code
reuse.

 

Setup
-----

For these example to run, you need Java 1.8, Maven and browsers with webdrivers.
All webdrivers can be easily downloaded from internet. This project also
includes the test website and embedded webserver, so that you can see everything
in action. With Maven build tool, all librarires are downloaded automatically.
You do not need any IDE or any special librarires. Load wedrivers here :

-   [Selenium website with all drivers
    listed](http://www.seleniumhq.org/download/)

-   [Chrome
    webdriver](https://sites.google.com/a/chromium.org/chromedriver/downloads)

-   [Firefox webdriver](https://github.com/mozilla/geckodriver/releases)

-   [MS IE 11
    webdriver](https://www.microsoft.com/en-us/download/details.aspx?id=44069)

 

Some facts about webdriver
--------------------------

Accessing elements on webpage is a bit tricky. Usually webdriver gives access
only to visible portion of webpage (viewport) and you have to scroll top or up
via code.

 

Another import thing: if HTML somehow changes, you need to load element (with
selector) again. Webdriver caches the instance of the element, and if the
element is selected, then removed, then added again, the old reference is
useless, and you cannot execute any operations on it.

 

Desig goals
-----------

Main goal was this: use javascript code in jQuery like syntax in java as well.
So that the same code that works in webbrowser, works in Java too. Webdriver
gives already a javascript like access to element's properties.
