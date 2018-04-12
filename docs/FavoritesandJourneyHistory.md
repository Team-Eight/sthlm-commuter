# Favorites and Journey history
All favorites (starred journeys) begin as journey entries in the journeys table in journeys.db. This database file is primarily handled by JourneysProvider.  
Journeys are starred or unstarred by toggling the star icons in the PlannerFragment view or the RoutesActivity view.
All starred journeys are loaded and displayed in the FavoritesFragment view.  
The class FavoritesDbAdapter and corresponding database favorite.db seem to only exist for backwards compatibility and are not used.
![alt text](./Journeys.png)
\

The journey_data column contains JSON data about the journey. Example:  
`{"transportModes":["MET","BUS","WAX","TRN","TRM"],"alternativeStops":false,"origin":{"id":"1094","name":"Körsbärsvägen","latitude":59348411,"longitude":18064758,"source":0,"locality":"Stockholm"},"destination":{"id":"9204","name":"Tekniska högskolan","latitude":59345543,"longitude":18071707,"source":0,"locality":"Stockholm"}}`

## PlannerFragment
![alt text](./plannerfragment.png)
\
  
The five latest journeys are displayed here, in order of most recently modified. Non-starred journeys outside of the 5 most recent are deleted, but even starred journeys are not preferentially displayed here.  

Code relating to the toggling of favourites is found inflateView, around line 730.


## RoutesActivity
![alt text](./routesactivity.png)
\
The currently viewed  journey can be starred here. 

## FavoritesFragment
![alt text](./favoritesfragment.png)
\
All starred journeys in the database are fetched and listed here.\
Pressing and holding, then selecting Delete, deletes an entry as follows:
```java
getActivity().getContentResolver().delete(ContentUris.withAppendedId(Journeys.CONTENT_URI, menuInfo.id),null, null);
```
