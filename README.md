# Al Riyadh Automation 
## Table of Content
-   [Introduction](#introduction)
-   [Prerequisites](#Prerequisites)
-   [Challanges and how to resolve them](#ChallangesAndHowToResolveThem)
-   [Used Features And Tools](#UsedFeaturesAndTools)
-   [Project Structure](#ProjectStructure)
-   [Running the Tests](#RunningTheTests)
  
## introduction
The project you're working on is a Java-based web automation testing suite for a user portal called "Maradim". It uses the TestNG testing framework and Maven for project management 

we have been used OOP paradigm to implement this framework, to make it flexible, maintainable, and editable, you can follow this project structure which provided to this Readmi file.

## Prerequisites
- Java: The project is written in Java, so you need to have a Java Development Kit (JDK) installed on your system. The version of the JDK required would depend on the version used in the project.  
- Maven: Maven is used for project management, including managing dependencies and building the project. You need to have Maven installed on your system.  
- TestNG: The project uses the TestNG testing framework. This would be included as a dependency in the project's pom.xml file, so Maven should handle installing it.  
- Selenium: The project appears to use Selenium for web automation testing. This would also be included as a dependency in the project's pom.xml file.  
- WebDriver: The project uses WebDriver to interact with web pages. You need to have the appropriate WebDriver installed for the browser you want to test on. The WebDriver needs to be compatible with the version of the browser installed on your system.  
- IDE: An Integrated Development Environment (IDE) that supports Java, such as IntelliJ IDEA, is needed to write and edit the code.  
- Git: Git is needed for version control and for contributing to the project, as described in the README.md file.  
- File System Access: The project appears to interact with the file system, for example to upload photos. You need to have the necessary permissions to read from and write to the relevant directories. 

## ChallangesAndHowToResolveThem
- There are more than one clickable control like(Button, Radio Button, Check Box, Link) and more than one editable controls like(Text Box, Text Area)
- There are more changable data
- There are more than workflow
- There are fixed pages with the same elements but the elements may be incremented or decremented depending on the implemented workflow
- There are fixed tests like(login and logout)
- We need to execute fully workflow path or only one branch once
- The elements take a while to be presented or displayed
- Need to print the test result in the report

We have resolved those above challanges through following the below techniques 
- For the first point we have used the OOP paradigm to resolve this challange so you can check the structure for more details
- For the second point we have read all workflow data through JSON file and every workflow has it is own JSON file
- For the third point we have created a package for every workflow Test cases and after that we have created a package for each workflow role that contains files which provided the the role's test cases
- For the fourth point we have created an effective way for locating elements by using XPATH
- For the fifth point we have created files for those fixed tests and call them when we need
- For the sixth point we have created a XML file contains all required tests for executing the needed workflow path
- For the seventh point we follow an effective way for locating elements => befor interacting with the element we user the explicity wait tell the element is presented then interacting with it
- For the Eighth point we use the allure reports to show us the test summary report after finishing the executon session

## UsedFeaturesAndTools
- Applying The OOP Paradigm
- Java: The project is written in Java, which is a popular object-oriented programming language.  
- Maven: Maven is used for project management, including managing dependencies and building the project.  
- TestNG: The project uses the TestNG testing framework for managing and running tests.  
- Selenium: Selenium is used for web automation testing. It allows the project to interact with web pages, mimicking user behavior.  
- WebDriver: WebDriver is a part of Selenium that allows the project to interact with web pages. It provides a way to locate and interact with web elements.  
- Page Object Model: The project uses the Page Object Model design pattern. This design pattern is used in test automation for enhancing test maintenance and reducing code duplication.  
- XPath and CSS Selectors: These are used to locate web elements on a page. They are a way to navigate through the HTML structure of a page.  
- JavascriptExecutor: This is used to execute JavaScript code directly in the browser through the WebDriver.  
- FileUtils: This is used to interact with the file system, for example to copy files.  
- TakesScreenshot: This is a WebDriver interface that is used to take screenshots.  
- XML: XML is used to define the test suite and tests in the ApprovalCycle.xml file.  
- Git: Git is used for version control, allowing for tracking changes, branching, and collaboration.  
- IntelliJ IDEA: This is the Integrated Development Environment (IDE) being used to write and edit the code.  
- GitHub: GitHub is used for hosting the project's repository, allowing for collaboration and version control.  
- JSON: JSON files are used to store test data in the TestData directory

## ProjectStructure
The project is structured as follows:

- `src/main/java/Pages`: This directory contains classes representing different pages in the user portal. Each page has its own class with methods to interact with the elements on the page.

- `src/main/java/UserPortalTests`: This directory contains test classes for different roles in the Maradim workflow. Each role has its own test class with methods to test the functionality of that role.

- `src/main/java/CoreElements`: This directory contains classes representing different types of web elements. These classes provide methods to interact with the web elements.

- `src/main/java/GlobalSetup`: This directory contains a class for global setup and teardown methods. These methods are run before and after each test, respectively.

The test data for the project is stored in JSON files in the TestData directory. These files contain data for different roles, pages, checklists, report statuses, assignees, actions, and action options. 
The project also includes a README.md file that provides an overview of the project, instructions for running the tests, and information about contributing to the project.  The code excerpts provided show that the project uses the Page Object Model design pattern,
where each page on the web application has a corresponding class in the test code. This class contains the locators for the web elements on the page and methods to interact with these elements.
The ReportDetailsPage and ReportDetailsElements classes are examples of this. The ClickableElements class in the CoreElements package provides methods for interacting with clickable elements on a page.
The ClickableElements class also includes a method uploadPhotoToAllElements which uploads a photo to all elements that match a specific locator.
This method uses the sendKeys method to upload the file, which is a common way to handle file uploads in Selenium.
The ReportDetailsPage class includes methods to interact with different elements on the page, such as clicking on the yes or no button, asserting the presence of a toast message, and uploading photos to all elements.
The ReportDetailsElements class represents the elements of a report details page. It includes locators for different elements on the page and methods to interact with these elements.
 For example, it includes a getSpecificAction method that returns a Label object representing a specific action on the report details page.

 
## RunningTheTests

To run the tests, you need to have Maven installed. You can run the tests using the following command:

```bash
mvn test

Or through the Created XML File which provide all valid transition test Cases such as (`TestRunner\ApprovalCycle.xml`)
