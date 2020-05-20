Feature: Login into Application 

Scenario: Positive test validating login 
Given Initialize the browser with chrome
And Navigate to "QAClickAcademy" Site 
And Click on Login link in home page to land on sign in Page 
When User enters "test99@gmaul.com" and "123456" and logs in 
Then Verify that user is successfully logged in 

