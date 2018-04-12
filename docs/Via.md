# Via

To pass through a certain place during your commute, the user must add another stop to the journey by using the 'via'-textbox.
Here, the user may type in anything he or she likes. The app will then try to match the input to an existing stop or address.

## ChangeRouteTimeActivity

This is done through the class ChangeRouteTimeActivity, where a Site, mViaPoint is created. This ends up as our 'via'-Site.

We create a type called DelayAutoCompleteTextView which executes a request to an API with the user input String, fetching SL-stops or addresses.
This shows a drop down menu of available results. Read about it here: https://developer.android.com/reference/android/widget/AutoCompleteTextView.html

The function createAutoCompleteTextView is then used to create the site where you want to go

mJourneyQuery.via is the last part that is changed, the actual query that is sent off to be processed.
