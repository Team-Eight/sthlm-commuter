# Travel Mode

Router -> LegUtil.transportModesToTravelModes -> TravelMode.TravelMode -> TravelModeQuery

JourneyQueryParameter.java

* api/TravelModeQuery.java
  ** TravelModeQuery.fromStringList
  *** 
**  models/TravelMode.java

### TravelMode.java
Skapar ett travelmode-objekt som korresponderar till en sträng som är något av färdsätten

### TransportMode.java


### LegUtil.java
The functions transportModesToTravelModes and travelModesToTransportModes converts a list of transportMode objects to a list of travelMode objects and vice versa.  


### JourneyQuery.java
The function Uri toUri(boolean withTime) converts a list with transportModes objects to a list with travelMode objects through the transportModesToTravelModes function. A new travelModeQuery object is created based on the converted list of travelMode objects. 


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



