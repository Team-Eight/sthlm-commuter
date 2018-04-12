
# Search Function

- Documentation on the general functionality of searching for transportation routes and how the result is displayed to the user.
## Entrypoint

```
PlannerFragment

private void handleSearchAction() {
```
## handleSearchAction
The handleSearchAction function inside of the PlannerFragment class checks if the user has entered information into startpoint textbox if that is not the case, the app will suggest autocomplete options for that textbox. The application then goes on to perform the same check on the endpoint textbox. When the users has entered information into both textboxes the program creates two sites out of the startpoint and endpoint by calling buildStop.

## buildStop
```
private Site buildStop(Site site, TextView textView)
```


The buildStop function then checks to see what type of information the user has entered into the textbox it then converts that information into a useable site object and returns it.

## onSearchRoutes
```
private void onSearchRoutes(Site startPoint, Site endPoint) 
```

The onSearchRoutes function is then called with the startpoint site and endpoint site as parameters and this function then builds a journeyQuery based on the information provided and describes an intent to be used with the JourneyQuery in order to start the RouteActivity. 

## routesActivity

```
public class RoutesActivity extends BaseListActivity implements
protected void onCreate(Bundle savedInstanceState)
```

The program then enters the RoutesActivity and the onCreate method is called, this method then builds the GUI. Also starts a thread (Monitor object) which runs in the background that updates the routes if new info available.  Afterwards the onResume method is called. OnResume then calls the initRoutes method. 

onResume() will always be called when the activity goes into foreground, but it will never be executed before onCreate() 

## initRoutes

```
private void initRoutes(JourneyQuery journeyQuery)
```

InitRoutes first calls fetchTransitRoute and afterwards fetchAlternativeRoutes.

## FetchTransitRoutes
```
void fetchTransitRoute(JourneyQuery journeyQuery)
```

fetchTransitRoute fetches routes available from public transport by calling planTransit using the mRouter object.

## PlanTransit
```
public void planTransit(final JourneyQuery journeyQuery, final Callback callback)
```

planTransit contacts the sthlm-traveler backend using a journeyQuery to get the available public transport routes.

## updateTransitRoutes

```
public void updateTransitRoutes(Plan plan)
-> public void onSearchRoutesResult(Plan plan)
public void refill(List<Route> trips) 
```

Called with callback when data received from backend: displays the routes using the RoutesAdapter internal class. GUI-stuff



## Alternativeroutes (foot, bike, car)
```
void fetchRouteAlternatives(JourneyQuery journeyQuery)
```

fetchRouteAlternatives fetches routes available by foot/bike/car by calling plan in Router.java.

## Plan
```
public void plan(final JourneyQuery journeyQuery, final Callback callback)
```

plan contacts the sthlm-traveler backend using the journeyQuery which produces the routes.

## updateRouteAlternatives
```
public void updateRouteAlternatives(Plan plan)
```

updateRouteAlternatives displays the plan retrieved from backend. GUI-stuff
The program then callsback to refresh the routes on the GUI using the showroutes() method.


## Callback
Class A calls Class B to get some work done in a Thread. If the Thread finished the work, it will inform Class A over the callback and provide the results. So there is no need for polling or something. You will get the results as soon as they are available.
In Android Callbacks are used f.e. between Activities and Fragments. Because Fragments should be modular you can define a callback in the Fragment to call methods in the Activity.

## Reverse
While at the Search page there are two different reverses, one which only changes the position of the search Strings, and one which reverses the given query and presents the reversed route. The second reverse is the more complex of the two, yet still very simple. When the button with given ID is pressed it updates the JourneyQuery / transit via the function shown below.
```
public class RoutesActivity
protected void reverseJourneyQuery()
```

## HowTo- Manual Search

Inside PlannerFragment.java 
 -> Inside function:  handleSearchAction()
 <br/>
 Change the following code to search from hardcoded coordinates
 <br/>
Row 581
```
            //new code
            //mStartPoint = buildStop(mStartPoint, mStartPointAutoComplete);
           // mEndPoint = buildStop(mEndPoint, mEndPointAutoComplete);
            mStartPoint = new Site();
            mStartPoint.setLocation(59.43, 17.95);
            mStartPoint.setName("Katt");

            mEndPoint = new Site();
            mEndPoint.setLocation(59.35, 17.95);
            mEndPoint.setName("Moo");
            //new code
```
