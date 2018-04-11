# Deviation 

![alt text](./DeviationDocumentation.png)

# Deviation

## trafficStatusFragment
![alt text](./TrafficStatusFragment.PNG)

The page for deviations is created upon app launch, through this class

getTrafficStatus is a method in trafficStatusFragment which communicates with deviationStore, where deviations are collected through SL's API. This info is general deviations, such as "Buses will replace trains from April to May on line 19"

```
private class GetTrafficStatusTask
public TrafficStatus getTrafficStatus(final Context context) 
```
## deviationStore
Kommunicerar med SLs API för störningar i trafiken för att organiserea och hämta störningar just nu. Sparar störningar som typen "deviation" i en ArrayList genom getDeviations, som sedan returnerar listan.

``` 
public ArrayList<Deviation> getDeviations(final Context context)
```


## fillData

## deviationActivity
![alt text](./DeviationActivity.PNG)
  ## getDeviationTask
  Använder sig av deviationstore, som getTrafficStatus, men skillnaden är att getDeviationTask visar mer noggrann info under "show all" in deviations.
  
