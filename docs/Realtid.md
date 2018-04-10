# Realtid


## File Structure

* data/models/RealTimeState.java <br/>
Endast en enum med olika states, används av GUI för att välja t.ex. rätt ikoner/stryka fel tid etc 
```
    BEHIND_SCHEDULE,
    AHEAD_OF_SCHEDULE,
    ON_TIME,
    NOT_SET,
```


<br/>

* Plan:     Vald resa from -> to
```

```
* Route:    Olika förslag på rutter med olika tider för att resa enligt planen
```

```
* Leg:      Leg = delresa, Varje Route har flera Legs, t.ex. buss 844 -> buss 323
```

```
* IntermediateStop: En hållplats på en Leg, t.ex. Grönlandsgången
```

```
