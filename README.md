# 📱 Web Automation Framework (Java + Selenium + TestNG)

This is a modular and extensible test automation framework for Web applications using **TestNG**, and **Page Object Model (POM)** design. It includes support for **Extent Reports**, **screenshot capture**, **retry logic**, and more.

---

## 🚀 Features

- ✅ Cross-browser support (chrome & firefox)
- 🧱 Page Object Model using `PageFactory`
- 📸 Screenshot capture on failure
- 📊 Extent HTML Reports with platform metadata
- 🔁 Retry mechanism for flaky tests
- 🧪 TestNG integration with parallel execution support
- 🧩 Clean code structure with `BrowserActions` helper class

---

## 🧾 Project Structure

- **src/main/java**
  - com.web.framework.actions &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# actions which needs to be performed on the elements
  - com.web.framework.drivermanager &nbsp;&nbsp;# driver initialization and capabilities set
  - com.web.framework.pages &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Page object class
  - com.web.framework.utils &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Utility class like Screenshot, Extentmanager, Jsonutils

- **src/main/resources** &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# can be used store config, can provide platform from here as well

- **src/test/java**
  - com.web.framework.listeners &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# TestNG Listeners (Extent, Retry, Skip, etc.)
  - com.web.framework.test &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# test case

- **src/test/resources**
  - testdata &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# can keep data required for testing (excel, json)

- **test-output** &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Extent report and screenshots
- **pom.xml** &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Maven dependencies
- **testng.xml**
- **README.md**


---

## 🔧 Setup Instructions

### Prerequisites

- Java 17 or later
- Maven 3.x
- Selenium
- Webdrivermanager
- Testng

### Install Dependencies

```bash
mvn clean install
```

### Note
- A few test cases are intentionally designed to fail in order to demonstrate failure logging, screenshot capture on failure, and the retry mechanism
- Parallel execution has been setup using testng.xml
