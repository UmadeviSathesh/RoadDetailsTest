Feature: Road Details
Scenario: Road ID is valid
Given a valid a2 is specified
When the client is run appId as 4a75af26 appKey as 9be8231002849a9ba64ed977d67d1469
Then the road A2,Closure,Closure  should be displayed

Scenario: Road ID is invalid
Given a invalid a223 is specified
When the application client is run appId as 4a75af26 appKey as 9be8231002849a9ba64ed977d67d1469
Then the road  a223 should be displayed as invalid
