THE PURPOSE OF THIS SCRIPT IS TO SHOW GENERAL KNOWLEDGE OF SELENIUM

Script is made in Eclipse using Java.

My script consists of :

1. Page objects which are made generally of locators and all the necessary methods that are needed for the tests
(the different usage of locators is just to show that I know how to use different locators). 

2. Resource package which contains Base class (that has all the necessary methods for all the tests to run properly) 
and data properties file which holds important information for the base class such as which browser to be used and which web pages.

3. Log4j xml file (provides logs in logs folder) which Is used as an example in some of the tests.

4. Listener class which I use to make screenshot on every fail test and to send it in reports folder in the project.

5. Several different test classes just to show general knowledge that I know how to make test scenarios in every possible situation 
such as (Dropdowns, Buttons, Datepicker etc etc).

6. TestNg xml file which provides all the tests and makes them run in parallel.

7. POM xml file because the project is Maven Project and holds all the dependencies that are needed. 

8. For the test reports I use Jenkins and I check the results there.


Tests explanation:

1. Login test – Using data provider to test multiple username and passwords. (saucedemo.com)

2. ValidateTextInGoogle – Writing text in google search page, grabbing text that I got from the search result and setting it to a variable.  (Google.com)

3. WDUActionsTests – Dragging and dropping a box into specific spot, Double clicking an element, Hovering over element. (WebDriverUniversity.com)

4. WDUAutoCompleteTest – Giving some random key in the text input field,  selecting a text from the list of options and hitting the submit button.

5. WDUButtonsTest – Clicking the buttons on three different ways (Clicking the first button regularly, clicking the second button using javascript 
executor and clicking the third button using Action Move and click.

6. WDUContactUsTest  - Verifying that reset button works correctly, verifying that contact us section works properly with valid credentials and 
also with invalid credentials.

7. WDUDatePickerTest – Veryfing that date picker section works correctly with choosing only one date.
 
8. WDUDropdownsTest – Validating all the options in the page that works correctly (Dropdowns, Checkboxes, Radio buttons and Disabled button).

9. WDUFileUpload – Testing if I’m able to upload a file.

10. WDUIFrameTest – Switching Iframes .

11. WDUToDoList – Adding an item in the todolist, checking if the item is added correctly than deleting the same item and checking if the 
item deleted is correctly deleted.
