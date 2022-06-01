Feature: Leaftaps Merge Lead functionality

Scenario: Login with leaftaps credential
Given Open Chrome browser
And Load the application URL
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When Click on Login button
Then Homepage should be displayed
When Click on CRMSFA link
And Click on Leads
And Click on Merge Leads link
And Click on From Lead lookup
And Enter the firstname in From Lead lookup as 'Vaishnavi'
And Click on Find Leads button
And Click on Lead ID link in From Lead lookup 
And Click on To Lead lookup
And Enter the firstname in To Lead lookup as 'Lakshanya'
And Click on Find Leads button
And Click on Lead ID link To Lead lookup
And Click on Merge button
