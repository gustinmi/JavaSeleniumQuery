# JavaSeleniumQuery
Write Java Selenium Tests in jQuery like syntax and access elements with selectors right out from browser's Developer tools.

## Explanation

Selenium is framework for automating web browser clicking (so to speak). Writing Selenium code in java gives you ability, to reuse the code you already have in application to be tested (Enums, utility classes, database access code). Also writing tests in object oriented language, gives you great flexibility and code reuse.

## Setup

For these example to run, you need Java 1.8, Maven and browsers with webdrivers. All webdrivers can be easily downloaded from internet. This project also includes the test website and embedded webserver, so that you can see everything in action. With Maven build tool, all librarires are downloaded automatically. You do not need any IDE or any special librarires.

## Some facts about webdriver

Accessing elements on webpage is a bit tricky. Usually webdriver gives access only to visible portion of webpage (viewport) and you have to scroll top or up via code. 

## Desig goals

Main goal was this: use javascript code in jQuery like syntax in java as well. So that the same code that works in webbrowser, works in Java too. Webdriver gives already a javascript like access to element's properties.

## Some examples 
<pre><code>

   // Select elements by various ways

   $("//*[@id=\"searchResults\"]/tbody/tr[1]").click(); // click first table row
   $("#radioButton").click();  // click radio
   $("#myInput").sendKeys("1"); // enter text 
   $("#additional").findElement(By.className("btnClose")).click();  
   WebElement flag = status.findElement(By.tagName("div"));
   List<WebElement> podmoduli = table.findElements(By.xpath("id('table2')/div/div/div"));
   String cssClass = $("#" + moduleName).getAttribute("class");
   
   // Execute custom javascript
   super.getJse().executeScript("$('.dtEnddate').blur()"); // execute jQuery code for some esoteric component
   jse.executeScript("scroll(250, 0)"); // scroll to the top of page
   jse().executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
   
   // Work with dropdows 
   WebElement cb = $(".cbOne");
   Select cbSelect = new Select(cb);
   cbSelect.selectByValue("4");
   
   // List all table rows
   WebElement table = $("#table1");
   List<WebElement> trRows = table.findElements(By.xpath("id('table1')/tbody/tr"));
    
   // Enter data in CKEditor
   
   String ckeName = cke.getAttribute("name");
   super.getJse().executeScript("CKEDITOR.instances['" + ckeName + "'].setData('" + ckeName + "')"); // izpolni CKE
   super.getJse().executeScript("CKEDITOR.instances['" + ckeName + "'].fire('blur')"); // trigger shrani
   
   // Wait for alert
   
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

   
</code></pre>

   
