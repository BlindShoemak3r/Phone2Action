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

