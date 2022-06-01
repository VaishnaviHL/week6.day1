Feature: Leaftaps Delete Lead functionality

Scenario: Login with leaftaps credential
Given Open Chrome browser
And Load the application URL
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When Click on Login button
Then Homepage should be displayed
When Click on CRMSFA link
And Click on Leads
And Click on Find Lead link
And Click on Phone
And Enter the Phone number as 99
And Click on Find Leads button
And Click on Lead ID link
And Click on Delete button