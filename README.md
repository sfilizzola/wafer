# Wafer Challenge


Please send across an Android or iOS project (depending on your skills and desired job position) that:

1. Fetches json data through endpoint https://restcountries.eu/rest/v2/all
2. Display json data as listview with following elements parsed from json

a. “name”  ->  this is Country Name
b  “currencies” -> ”name" -> this is currency name, if more than 1 currency is present, first currency name is to be displayed
c. “languages” -> “name”  -> this is language name, if more than 1 language is present first language is to be used

3. On the displayed data, add a custom "Swipe to delete" with the following characteristics:
• Row background color -  white
• Swipe background color - purple
• Delete icon -  (if you cannot see it here - it should be attached -it is a bomb)



• It should have an anchor point for where the swipe just shows the delete icon.
• On a fast swipe past anchor point the row should delete.
• On a slow swipe past anchor point, swiped area should swipe back to anchor point showing the delete icon
• On a slow swipe till anchor point, the swipe should get cancelled.
• Clicking/Swiping any other row should cancel the current swipe.

4. NO external/3rd party libraries/dependencies are to be used.

Note for Android Developers:
• Use Java as development language.
• Should support API 19 to latest.
• Google's support libraries can be used.

Note for iOS Developers:
• Use Swift as development language.
• Should support OS 10.0 to latest.

Download Wafer Messenger to see how the swipe to delete is supposed to look like and behave. 

Good Luck!
