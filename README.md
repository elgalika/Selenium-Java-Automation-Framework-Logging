# Selenium + Java Automation Framework

This repository contains a mini-project for the course "Application Testing Technology" at Polytechnic University of Tirana, focusing on building an automated testing framework using Selenium and Java. The project automates various test scenarios on the nopCommerce demo website.

## Project Overview

The goal of this project is to build an automation testing framework using **Selenium** with **Java** and **JUnit/TestNG**. The framework implements the **Page Object Model (POM)** design pattern to organize the code, uses assertions to validate test steps, and includes logging to track the execution flow and test outcomes.

### Main Features:
- **4 Automated Scenarios** covering registration, login, dashboard actions, and shopping cart functionality.
- **JUnit/TestNG** integration for managing and running tests.
- **Assertions** for verification at different steps.
- Use of **wait methods** to handle dynamic page content and avoid `Thread.sleep()`.
- **Logging** to track the execution of tests and capture errors or important events.
- Organized following the **Page Object Model (POM)** structure for reusability and maintainability.

### Technologies Used:
- **Java**
- **Selenium WebDriver**
- **JUnit/TestNG**
- **Logging** (Java `Logger` or Log4j, based on your implementation)
- **Page Object Model (POM)** design pattern
- **Maven** for dependency management

## Test Scenarios

### Test 1: Register Test
- Navigate to [nopCommerce demo site](https://demo.nopcommerce.com/).
- Click on the **Log In** menu, then click **Register**.
- Verify the title of the registration page.
- Fill the registration form and verify the success of the registration.

### Test 2: Login Test
- Navigate to [nopCommerce demo site](https://demo.nopcommerce.com/).
- Log in with credentials created in **Test 1**.
- Verify successful login (check for "Welcome to our store" message and Log out option).
- Log out.

### Test 3: Dashboard Test
- Log in to the nopCommerce application.
- Hover over the **Computers** menu and select **Notebooks**.
- Add items to wishlist and shopping cart.
- Verify that the wishlist and shopping cart update correctly with notifications.

### Test 4: Shopping Cart Test
- Hover over the **Shopping Cart** menu and navigate to the cart page.
- Verify that all items and prices are displayed correctly.
- Proceed through the checkout process, verifying that entered information is correct.
- Complete the order and verify the success message and order number.

## Logging

The framework includes logging to provide insights into the execution flow, test progress, and any errors encountered. Logs capture:

- Test start and end times.
- Steps being executed.
- Success or failure messages.
- Errors or exceptions for troubleshooting.

You can configure logging output (console, file, etc.) based on your preference using the logging configuration in your project (e.g., `Logger` or `Log4j`).

## Project Structure

The project is structured following the Page Object Model, separating test logic from the UI elements, improving readability and reusability.

```
├── src
│   ├── main
│   │   └── java
│   └── test
│       └── java
├── pom.xml
└── README.md
```

- **Page classes**: Define locators and methods for interacting with UI components.
- **Test classes**: Contain test scripts for the different scenarios.
- **Logging configuration**: Settings for capturing logs (log levels, output format).

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/elgalika/Selenium-Java-Automation-Framework-Logging
   cd Selenium-Java-Automation-Framework-Logging
   ```

2. Install dependencies using Maven:
   ```bash
   mvn clean install
   ```

3. Run the tests:
   ```bash
   mvn test
   ```

Logs will be saved to a file.

## Additional Features
- Use of `WebDriverWait` to handle dynamic content.
- Flexible test configuration for future scenarios.
