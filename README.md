# P2A QA Engineer Technical Assessment

This is my submission for the Phone2Action technical assessment. I am interested in any feedback you may have.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for testing and assessing purposes.

### Prerequisites

What things you need in order to execute these tests

* An IDE (I used Eclipse)
* Google Chrome (preferably v84)
  * The chromedriver included with my project is only good for Chrome v84. If your version of Chrome is different, you can get additional chromedivers from the links provided below. Simply download the new driver (without renaming it) and replace the one included with my project.
  * Other chromedriver versions can be found [here](https://chromedriver.chromium.org/downloads)
  * [Chrome v83 driver](https://chromedriver.storage.googleapis.com/index.html?path=83.0.4103.39/)
  * [Chrome v85 driver](https://chromedriver.storage.googleapis.com/index.html?path=85.0.4183.38/)

### Installation

Simply clone this repository and import it into your IDE of choice. Navigate to this location to find the test classes:

* Phone2Action\src\test\java\BenJerry.Phone2Action

## Running the tests

[Video demo of the tests can be found here](https://drive.google.com/file/d/1kLLF9uvMtG0FR7uMyv7Cphg2Wqzhgw_Q/view?usp=sharing)

I suggest running the tests in one at time as I encountered some issues running them in parallel. The tests can be run in any order, but I suggest starting with Form Field Validate. 

To run the tests, right click within the text editor window -> Run As -> TestNG Test

### Brief explanation of tests

#### Form Field Validate

The purpose of these test cases are to verify that all of the expected input fields are present.

#### Email Form

The purpose of these test cases are to go through the email form, with negative scenarios first, concluded with a positive test to successfully submit the form.

#### Phone Form

The purpose of these test cases are to go through the phone call form, with negative scenarios first, concluded with a positive test to successfully submit the form.

#### Facebook

The purpose of these test cases are to test the Facebook text link, as well as the Facebook buttons after both types of forms have been submitted.

#### Twitter

The purpose of these test cases are to test the Twitter text link, as well as the Twitter buttons after both types of forms have been submitted.

## Built With

* Selenium with Java
* Maven Dependency Management
* TestNG Testing Framework

## Additional Test Scenarios

Since we were only given a limited amount of time to complete this assignment, I wanted to focus my time on writing test cases on what I thought were the most crucial areas. Here is a list a few more things and additional test scenarios I would cover if given more time:

* Reorient my project structure to follow more of a Page Object model with helper classes. That way I could define any of the needed objects in the main folder, and save the test folder only for tests. This would clean up my test cases in that I would not need to declare the same objects/web elements repeatedly, only reference them from other class files.

* If I did the math correctly, there's over 700 combinations of inputs to submit the email form. I wouldn't attempt to test for that many, but I would touch on a few more negative scenarios based on leaving some fields with data and others blank.

* Edge scenarios by testing the input fields with numbers, letters, and foreign language  symbols in unexpected places. Ex: numbers in the name field, letters in the phone number field, wingdings in the the address field.

* Formats of the phone numbers, i.e. XXX-XXX-XXXX, XXX.XXX.XXXX, (XXX) XXX-XXXX.

* Validity of information provided - using a phone number with 555 area code, changing the zip of the suggested address.

* Testing what happens if I submit the same person's information twice.

* Further testing of the input fields to determine what makes a submission unique. Is it just based on email addresses? What happens if I submit the same person twice, but use different email addresses?

* I would take some additional time to learn more about JMeter to design & implement a load testing plan for the test page to monitor how it behaves under a high load balance.

* I assume this is out of our purview for testing, but if it is not, I would test the links in the header and footer of the webpage to verify that those hyperlinks still work and go to their intended locations.

* Lastly, a ticket that I may write is that I noticed sometimes it would take two clicks of the submit button to successfully submit the form. Further investigation is needed.