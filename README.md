# IMDb Automated Testing Project

## Overview
This project showcases a robust implementation of automated testing for the IMDb website, adhering to best practices in software testing and design. Built with Java, Selenium WebDriver, and JUnit, the project effectively validates IMDb's core functionalities, UI elements, and performance metrics while ensuring code maintainability and reusability.

## Highlights of Implementation
- **Adoption of Design Patterns**: 
  - Utilized the **Page Object Model (POM)** to enhance test maintainability, readability, and reusability.
  - Separation of concerns by structuring page models and base classes for shared functionality.
- **Driver Management**: 
  - Implemented a dedicated `DriverManager` class to handle WebDriver setup and teardown efficiently.
- **Test Organization**: 
  - Designed a logical execution order for test cases, ensuring independent and repeatable tests.
  - Integrated cookie management to reduce repetitive sign-in steps and enhance test performance.
- **Configuration Management**: 
  - Centralized crucial constants like base URLs and credentials in a `Config` class for easy maintenance.

## Features
- **Comprehensive Automated Testing**:
  - User authentication (Sign In, Sign Up).
  - Navigation and search functionalities, including filters.
  - Watchlist management (add/remove titles, create custom lists).
  - Recently viewed list management.
  - Localization tests for multiple languages.
- **Performance and Security Testing**:
  - Response time evaluations.
  - HTTPS validation.
  - Cross-site scripting (XSS) and SQL injection vulnerability testing.
- **Test Suite Structure**:
  - Modular test case design for core IMDb functionalities.
  - Base classes for shared setup/teardown methods and utility functions.

## Tools and Environment
- **Tools and Frameworks**: Selenium WebDriver, JUnit, WebDriverManager.
- **Programming Language**: Java.
- **IDE**: IntelliJ IDEA.
- **Testing Platform**: IMDb website on Google Chrome (Windows 11).

## File Structure
- **Page Models**: Modular page classes encapsulating UI element locators and reusable methods.
- **Test Cases**: A wide range of tests validating IMDb's features, performance, and security.
- **Utilities**: Helper classes for WebDriver management, configurations, and test execution.

## How to Use
1. Clone the repository.
2. Configure `Config.java` with IMDb credentials.
3. Execute the `TestSuite` class to run all test cases in sequence.
