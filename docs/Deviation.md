![alt text](./DeviationDocumentation.png)

# Deviation

## TrafficStatusFragment

The page for deviations is created upon app launch, through this class

![alt text](./TrafficStatusFragment.PNG)

getTrafficStatus is a method in deviationStore which is called upon by the private class GetTrafficStatusTask. The method returns a type called 'TrafficStatus' which gives a "rating" for the current deviations affecting each way of transportation. It also provides the user with info about the devication cause. 

```
private class GetTrafficStatusTask
```
```
public TrafficStatus getTrafficStatus(final Context context) 
```

## DeviationStore
deviationStore communicates with SL's API to find deviations in the current traffic situation. It saves deviations as the type 'deviation' in an ArrayList through the method 'getDeviations'. This method then returns the list.

``` 
public ArrayList<Deviation> getDeviations(final Context context)
```


## DeviationsActivity
![alt text](./DeviationActivity.PNG)

  ### getDeviationTask
  Uses 'deviationStore', just like getTrafficStatus does, but the difference is that getTrafficStatus shows more detailed information about specific deviations under the tab 'show all'.
  
```
 private void fillData(ArrayList<Deviation> result) 
```
  This function transforms the deviation data and allows for it to be printed on the display.
