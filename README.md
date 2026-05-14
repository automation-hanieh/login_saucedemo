# SauceDemo Login & Checkout Automation

Automated end-to-end tests for [saucedemo.com](https://www.saucedemo.com) using Java, Selenium WebDriver, and TestNG.

## Tech Stack

| Tool | Version |
|---|---|
| Java | 23 |
| Selenium WebDriver | 4.18.1 |
| TestNG | 7.9.0 |
| Maven | Latest |
| IDE | IntelliJ IDEA |

## Project Structure

src/test/java/
├── pages/
│   ├── LoginPage.java
│   ├── InventoryPage.java
│   ├── CartPage.java
│   └── CheckoutPage.java
└── LoginTest.java

## Test Cases

| Test | Description |
|---|---|
| `testSuccessfulLogin` | Login with valid credentials |
| `testFailedLogin` | Login with invalid credentials |
| `testAddToCart` | Add item to cart and verify count |
| `testCheckoutFlow` | Complete end-to-end checkout |

## Design Pattern

This project uses **Page Object Model (POM)** — each page has its own class containing elements and actions, keeping tests clean and maintainable.

## How to Run

1. Clone the repo:
```bash
git clone https://github.com/MousavianHanieh/login_saucedemo.git
```

2. Open in IntelliJ IDEA

3. Run `LoginTest.java` with TestNG

## Author

**Hanieh Mousavian** — QA Engineer  
[LinkedIn](https://www.linkedin.com/in/hanieh-rabani) | [GitHub](https://github.com/MousavianHanieh)
