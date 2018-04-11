# Travel Mode Function

Router -> LegUtil.transportModesToTravelModes -> TravelMode.TravelMode -> TravelModeQuery


### TravelMode.java
Create a travelMode object tha corresponds to a string that describes the different travel modes. 

### TransportMode.java

### LegUtil.java
The functions *transportModesToTravelModes* and *travelModesToTransportModes* converts a list of transportMode objects to a list of travelMode objects and vice versa.  

The *getTransportDrawable* function looks at the travelmode of the leg (led.getTravelMode) and supplies an icon accordingly. 

### JourneyQuery.java
The function Uri toUri(boolean withTime) converts a list with transportModes objects to a list with travelMode objects through the transportModesToTravelModes function. A new travelModeQuery object is created based on the converted list of travelMode objects. 

The function then use the buildUpon() method (Constructs a new builder, copying the attributes from this Uri) and contructs at new builder upon the routesUri. then "travelMode='travelmodeValue'" is added to the uri. The uri is passed to the PlannerFragment.java file.

In the *uriV2* function a TravelModeQuery object from the decode uri which contains the chosen travel mode.

### PlannerFragment.java
Function *onSearchRoutes* and *onCreateShortCut* calls the toUri function (One with time and the other without time). 

The function *nCreateShortCut* saves the URI in a variable called *routesUri*. A new *android.content.Intent* object is then created based upon *routesUri*. An *android.content.Intent* object is an abstract description of an operation to be performed. It can be used with startActivity to launch an Activity. In this specific case the activity is to view the information specified by the URI. 

The *onSearchRoutes* function creates a new *android.content.Intent* object called *routesIntent*. The activity is RoutesActivity.EXTRA_JOURNEY_QUERY and is based upon the URI. Then the function calls  the *startActivity* function in the Fragment.java file with the *routesIntent* variable as a parameter. 

### Leg.java
In the function *Leg* travel mode decided by the user is assigned to the variable *travelMode* 

 


## File Structure

* models/TravelMode.java
* api/TravelModeQuery.java
* planner/JourneyQuery.java
* api/ApiService.java
* models/Leg.java
* models/Route.java (?)
* routing/Router.java 
* site/PlacesProvider.java
* site/TransportMode.java
* service/DataMigrationService.java
* utils/LegUtil.java
* utils/ViewHelper.java
* utils/ChangeRouteTimeActivity.java
* utils/DeparturesAdepter.java
* utils/DeparturesActivity.java
* utils/FavoritesFragent.java
* utils/PlannerFragment.java
* utils/UriLauncherActivity.java


