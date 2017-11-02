JavaSeleniumQuery
=================
Write Java Selenium Tests in jQuery like syntax and access elements with selectors generated right out from browser's Developer tools.
### Element selectors 
Java functions for selecting elements are dressed up to look like jQuery \$ function. You can select elements on your page in various ways. Following selectors are supported:

**ID selector**
```java
WebElement btn = $("#radioButton");
```
**Class selector**
```java
WebElement cbBox = $(".cbOne");
```
**XPATH selector**
```java
$(”//*[@id=\"resultView\"]/li/article/div/h2/a”); // all links in DIV
```
**Parent selectors**
```java
$("#additional").findElement(By.className("btnClose"));
WebElement flag = $("#additional").findElement(By.tagName("div"));
List submoduls = $("#additional").findElements(By.xpath("id('additional')/div/div/div"));
```
### Getting and setting values, triggering events
After element is selected, you manipulate it in various ways:

**Click the first table row**
```java
$("//*id/tbody/tr[1]").click();
```
**Check the radio or click button**
```java
$("#radioButton").click();
```
**Enter text in input or textarea**
```java
$("#myInput").sendKeys("some text data");
```
**Get the attribute value**
```java
String cssClass = $("#eltId").getAttribute("class");
```
**Select value on dropdown**
```java
WebElement cb = $(".cbOne");
Select cbSelect = new Select(cb);
cbSelect.selectByValue("4");
```
**Working with CKEditor**
Select the underlying input box
```java
String ckeName = cke.getAttribute("name");
```
Enter data
```java
super.getJse().executeScript("CKEDITOR.instances['" + ckeName + "'].setData('" + ckeName + "')");
```
Trigger save
```java
super.getJse().executeScript("CKEDITOR.instances['" + ckeName + "'].fire('blur')"); 
```
### Executing custom Javascript
When some special actions needs to be executed on browser, and this framework does not support it, you can execute arbitrary Javascript easily. For example:
**Trigger blur on some esoteric component**
```java
super.getJse().executeScript("$('.dtEnddate').blur()");
```
**Scroll to the top of window**
```java
jse.executeScript("scroll(250, 0)"); 
```
**Scroll to the bottom of page**
```java
jse().executeScript("window.scrollTo(0, document.body.scrollHeight)");
```
### Work with lists and tables
```java
WebElement table = $("#table1");
List trRows = table.findElements(By.xpath("id('table1')/tbody/tr"));
for (final WebElement row : trRows) {
    List<WebElement> btnCollection = row .findElements(By.className(".linkBtn"));
    // loop again ...
}
```
### Work with window alert’s
If clicking on some button will trigger window.alert, you can catch it and read the text from it.
```java
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
```
## Installation
This project requires Java 1.8 JDK. This requirement is due to Selenium version used. This project uses build tool Maven, solely to download dependencies. Apart from this, web drivers need to be downloaded for browsers you will use.

If you need help with Maven, please read my article : [Maven reference for Java Developers](https://docs.google.com/document/d/e/2PACX-1vRP75ce71OS-hVguQRNq6NliWQug-dW2mQ4oRoFVkZSOXbs9dM__-QT4_MwL5d6FimhU0svyUhYXVdj/pub)

If you need help with installing Java Development Kit on you machine, please read my article [Developing Java Webapps](https://docs.google.com/document/d/e/2PACX-1vQeT0f2T1fW0IB3Ue37dEImvnSHQ3C1Fhj36ye1hzhn6ZIC-7YKPAcQThdXAy78JJ55IN3pBSfZmAXp/pub)

You can test any web application, as long as you have access to it. Web application may require certificate or other form of authentication. This data must (can) be entered manually. Only data that can we filled via HTTP headers can be entered automatically.

## Background
Selenium is a framework for automating web browser clicking (so to speak). Writing Selenium code in java gives you ability, to reuse the code you already have in application to be tested (nums, utility classes, database access code). Also writing tests in object oriented language, gives you great flexibility and code reuse.
### Setup
For these example to run, you need Java 1.8, Maven and browsers with webdrivers. All webdrivers can be easily downloaded from internet. This project also includes the test website and embedded webserver, so that you can see everything in action. With Maven build tool, all librarires are downloaded automatically.
You do not need any IDE or any special librarires. Load wedrivers here :
-   [Selenium website with all drivers listed](http://www.seleniumhq.org/download/)
-   [Chrome webdriver](https://sites.google.com/a/chromium.org/chromedriver/downloads)
-   [Firefox webdriver](https://github.com/mozilla/geckodriver/releases)
-  [MS IE 11 webdriver](https://www.microsoft.com/en-us/download/details.aspx?id=44069)
After everything is prepared, simple execute
```java
mvn clean test
```
### Some facts about webdriver
Accessing elements on webpage is a bit tricky. Usually webdriver gives access only to visible portion of webpage (viewport) and you have to scroll top or up via code.
Another import thing: if HTML somehow changes, you need to load element (with selector) again. Webdriver caches the instance of the element, and if the element is selected, then removed, then added again, the old reference is useless, and you cannot execute any operations on it.
### Desig goals
Main goal was this: use javascript code in jQuery like syntax in java as well. So that the same code that works in webbrowser, works in Java too. Webdriver gives already a javascript like access to element's properties.
