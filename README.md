# Web-Test-Automation
 Test Automation of Web Applications using Selenium, Junit

# Updates:
 - Old java files are moved to practice package.
 - It's mandatory to use **Page Object Pattern (POM)** in newely created tests.
 - Tests to be created are use-cases provided by Yousef.
 
# Initialize project:
 - ` git clone https://github.com/KareemAliRahman/Web-Test-Automation `
 - Create a maven project in eclipse in the same directory
 - Run as ` maven install ` /` mvn install `
 - `maven run tests` /` mvn test `
 
# General Guidelines:
 - New Test cases should be created in new Branch.
 - Group similar test cases in the same JUnit TestClass. Don't make a new TestClass for each testcase.
 - Created Branches are then merged locally with **`dev`**  branch.
 - Created Branches are then deleted after merging with dev is successful.
 - **Don't Commit on Master Branch.**
 
# Recommendations
 - Consider the possiblity of using TestNG instead of JUnit (better test grouping, parallel execution management)
 - Need to improve the quality of util code ande code used for test intialization
 - Consider using a better strategy for Tests run on Android emulation
 - FIREFOX causes problems (surprisingly)
 - Research how to choose number of concurrent tests to be run on a given machine.