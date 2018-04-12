# Location (GPS)
When using my location in the search function the app never initRoutes but instead waits for a location found callback from the LocationManager.<br/><br/>

The app doesn't store any location data inside the Site (orgin or destination) if My Location has been selected but instead this is handled using the LocationManager in real-time.<br/><br/>

A LocationManager object is created in onCreate in RoutesActivity.java which listens to Location changes. <br/>
LocationManager has an interface...
```
    void onMyLocationFound(Location location);
```
..which is called when my location is found. <br/>

But the logic for this function is found inside RoutesActivity.java:570
```
    @Override
    public void onMyLocationFound(Location location)
    {
        	//Logic
            //the location variable contains My Location in coordinates
    }
```
Here the routes are initatied when location found and updated if my location changes
