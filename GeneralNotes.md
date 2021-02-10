# GENERAL NOTES FROM OSCAR VALERIO MONTES

REQUIRED
1. Remove the driver executable files from the repo, and configure them in the execution environment.
2. Cross-Browsing: Change the code to be able to run tests using Chrome and Firefox, and also to run the tests headless.
3. Create several TestNG xml files to avoid commenting and uncommenting portions of code.
4. Use groups in all test cases to mark them as regression, smoke, etc 
5. Create a readme file to generate some documention about your project, for example to document how to run different suites based on the different testng xml files


OPTIONAL
1. I would say that you can move the "pages" package to the "test/java" folder to have all related to automation in one place, it can be easier to access page objects if they are close to the tests package. It can more beneficial when a project is bigger and you have a lots of test cases, lots of pages, etc.
