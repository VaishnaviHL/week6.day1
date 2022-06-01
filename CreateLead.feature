Feature: Leaftaps Create Lead functionality

@functional@smoke
Scenario Outline: Login with leaftaps credential
Given Open Chrome browser
And Load the application URL
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When Click on Login button
Then Homepage should be displayed
When Click on CRMSFA link
Then MyHomePage should be displayed
When Click on Leads
And Click on Create Lead link
When Enter the Company name as <companyname>
And Enter First name as <firstname>
And Enter Last name as <lastname>
When Click on Create Lead button
Then Get the title of the page

Examples:
|companyname|firstname|lastname|
|'EQ'|'Vaishnavi'|'J'|
|'HVL'|'Lakshanya'|'HV'|
