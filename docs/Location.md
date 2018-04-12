# Location (GPS)
When using my location in the search function the app never initRoutes but instead waits for a location found callback from the LocationManager <br/><br/>
A LocationManager object is created in onCreate in RoutesActivity.java which listens to Location changes <br/>
LocationManager has an interface 
```
        void onMyLocationFound(Location location);
```
which is called when my location is found. <br/>

The logic for this function is found inside RoutesActivity.java:570
```
    @Override
    public void onMyLocationFound(Location location)
```
Here the routes are initatied etc and updated if location changes
