# Automation Testing for Sign-Up Flow

## Objective
The objective of this project is to automate the sign-up flow of the website [Magento Software Testing Board](https://magento.softwaretestingboard.com/) and test the sign-in functionality with the newly created account.

## Test Cases Excel file
Attached the test cases file in the project directory with name testCases.xls

## Task
- Automate the creation of an account on the website.
- Sign in using the newly created account and validate the login functionality.

## Deliverables

### 1. **Test Cases**
Test cases will be documented in an Excel file. Each test case will include:
- Test case ID
- Description of the test case
- Expected results
- Actual results (for manual testing)
- Status (Pass/Fail)

### 2. **Automation Code**
The automation code will be committed to the GitHub repository. The automation will use the following tools and frameworks:
- **BDD** (Behavior-Driven Development) for structuring test cases.
- **POM** (Page Object Model) for structuring the test scripts.

The code will be implemented using **Selenium** or **Cypress** based on the framework chosen.

### 3. **Repository**
The automation code can be accessed via the following GitHub repository:  
[GitHub Repository](https://github.com/DeeksVault/IncubyteAutomationAssignment)

### 4. **Test Framework**
- **Selenium**: For automating the web interactions.
- **Cucumber**: To implement BDD (Behavior-Driven Development) for writing test cases.
- **Page Object Model (POM)**: For maintaining a clean and reusable code structure.
  
### 5. **Test Steps**
- Navigate to the Magento website.
- Automate the process of filling in the sign-up form with valid details (first name, last name, email, password, etc.).
- After successful account creation, sign in with the same credentials.
- Validate the sign-in process and check for successful login.

### 6. **Test Execution**
To run the automation tests, follow the below steps:

#### Prerequisites:
- Ensure **Java** and **Maven** are installed.
- Clone this repository to your local machine.

#### Steps to Execute:
1. Open your terminal or command prompt.
2. Navigate to the project folder where the code is saved.
3. Run the following Maven command to execute the test cases:
   ```bash
   mvn test
4. If the above method does not work, run the TestRunner.java manually
