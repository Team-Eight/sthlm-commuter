
# Search Function


## Hmm

* data/models/RealTimeState.java <br/>

Search function Documentation

Documenation of the general functionality of how the program searches for transportation routes and displays them to the user aswell as the general description of 


```
PlannerFragment

private void handleSearchAction() {
```

The handleSearchAction function inside of the PlannerFragment class checks if the user has entered information into startpoint textbox if that is not the case, the app will suggest autocomplete options for that textbox. The application then goes on to perform the same check on the endpoint textbox. When the users has entered information into both textboxes the program creates two sites out of the startpoint and endpoint by calling buildStop.

```
private Site buildStop(Site site, TextView textView)
```


The buildStop function then checks to see what type of information the user has entered into the textbox it then converts that information into a useable site object and returns it.

```
private void onSearchRoutes(Site startPoint, Site endPoint) 
```

The onSearchRoutes function is then called with the startpoint site and endpoint site as parameters and this function then builds a journeyQuery based on the information provided and describes an intent to be used with the JourneyQuery in order to start the RouteActivity. 

```
public class RoutesActivity extends BaseListActivity implements
protected void onCreate(Bundle savedInstanceState)
```

The program then enters the RoutesActivity and the onCreate method is called, this method then builds the GUI. Also starts a thread (Monitor object) which runs in the background that updates the routes if new info available.  Afterwards the onResume method is called. OnResume then calls the initRoutes method. 

onResume() will always be called when the activity goes into foreground, but it will never be executed before onCreate() 


```
private void initRoutes(JourneyQuery journeyQuery)
```

InitRoutes first calls fetchTransitRoute and afterwards fetchAlternativeRoutes.

##Fetch transit routes
```
void fetchTransitRoute(JourneyQuery journeyQuery)
```

fetchTransitRoute fetches routes available from public transport by calling planTransit using the mRouter object.

```
public void planTransit(final JourneyQuery journeyQuery, final Callback callback)
```

planTransit contacts the sthlm-traveler backend using a journeyQuery to get the available public transport routes.


```
public void updateTransitRoutes(Plan plan)
-> public void onSearchRoutesResult(Plan plan)
public void refill(List<Route> trips) 
```

Called with callback when data received from backend: displays the routes using the RoutesAdapter internal class. GUI-stuff


#Alternative routes (foot, bike, car)
```
void fetchRouteAlternatives(JourneyQuery journeyQuery)
```

fetchRouteAlternatives fetches routes available by foot/bike/car by calling plan in Router.java.

```
public void plan(final JourneyQuery journeyQuery, final Callback callback)
```

plan contacts the sthlm-traveler backend using the journeyQuery which produces the routes.

```
public void updateRouteAlternatives(Plan plan)
```

updateRouteAlternatives displays the plan retrieved from backend. GUI-stuff
The program then callsback to refresh the routes on the GUI using the showroutes() method.



##Callback
Class A calls Class B to get some work done in a Thread. If the Thread finished the work, it will inform Class A over the callback and provide the results. So there is no need for polling or something. You will get the results as soon as they are available.
In Android Callbacks are used f.e. between Activities and Fragments. Because Fragments should be modular you can define a callback in the Fragment to call methods in the Activity.









##JourneyQuery

public class JourneyQuery implements Parcelable {
   public Site origin;
   public Site destination;
   public Site via;
   public Date time;
   public boolean isTimeDeparture = true;
   public boolean alternativeStops = false;
   public List<String> transportModes = new ArrayList<>();
   public String ident;
   public boolean hasPromotions;
   public int promotionNetwork = -1;
   // Storing the state of the current ident and scroll dir toallow refresh of paginated
   // results

JourneyQuery is the part of the program that takes in a parcel object and converts it into 




When 

dest.writeLong(startTime != null ? startTime.getTime() : -1);
dest.writeLong(endTime != null ? endTime.getTime() : -1);
dest.writeLong(startTimeRt != null ? startTimeRt.getTime() : -1);
dest.writeLong(endTimeRt != null ? endTimeRt.getTime() : -1);












