# Via

To pass through a certain place during your commute, the user must add another stop to the journey by using the 'via'-textbox.
Here, the user may type in anything he or she likes. The app will then try to match the input to an existing stop or address.

## ChangeRouteTimeActivity

Basically the whole via-idea is handled in this class, ChangeRouteTimeActivity. 
```
public class ChangeRouteTimeActivity extends BaseActivity implements OnClickListener
```

In here, a Site is created, mViaPoint. This is the final Site that is used to change the journeyquery.
```    
private Site mViaPoint = new Site();
```

When the user starts typing we go into the method createAutoCompleteTextView, where a request to an API is sent, which matches the user input String. With the AutoCompleteTextView-solution we don't have to 'confirm' our search, the list of stops instead updates "on the fly" as we type.

This shows a drop down menu of available results. 

![alt text](./img/Sökning.PNG)

Read about it here: https://developer.android.com/reference/android/widget/AutoCompleteTextView.html

It is quite unclear how this goes from a selected Site in the dropdown menu to our Site object, mViaPoint.
However the Point does end up as a correct Site. 

Later on we call upon the function buildStop, which takes our site and an AutoCompleteTextView. From that we use .getText() and compare our Site with the site that we selected earlier. Naturally they should be the same, and we return an error if they are not.

```
 private Site buildStop(Site site, AutoCompleteTextView auTextView)
```

Finally mJourneyQuery.via is the last part that is changed, the actual query that is sent off to be processed.

```
mJourneyQuery.via = mViaPoint;
```
