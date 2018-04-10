# Travel Mode

Router -> LegUtil.transportModesToTravelModes -> TravelMode.TravelMode -> TravelModeQuery


### TravelMode.java
Create a travelMode object tha corresponds to a string that describes the different travel modes. 

### TransportMode.java

### LegUtil.java
The functions transportModesToTravelModes and travelModesToTransportModes converts a list of transportMode objects to a list of travelMode objects and vice versa.  

### JourneyQuery.java
The function Uri toUri(boolean withTime) converts a list with transportModes objects to a list with travelMode objects through the transportModesToTravelModes function. A new travelModeQuery object is created based on the converted list of travelMode objects. 

The function then use the buildUpon() method (Constructs a new builder, copying the attributes from this Uri) and contructs at new builder upon the routesUri. then "travelMode='travelmodeValue'" is added to the uri.


In the Builder uriV2(Uri uri) function a TravelModeQuery object from the decode uri which contains the chosen travel mode. 


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



