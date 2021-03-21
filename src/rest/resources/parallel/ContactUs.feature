Feature: Contact Us feature

Scenario Outline: Contact Us scenario with different set of data
Given user navigates to contact us page
When user fills the form from given sheet name "<SheetName>" and rownumber <RowNumber>
And user clicks on send button
Then it shows successful message "Your message has been successfully sent to our team."

Examples:
	|SheetName|RowNumber|
	|ContactUs|0		|
	|ContactUs|1		|