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

* Plan.java: Vald resa from -> to
```

```
* Route.java: Olika förslag på rutter med olika tider för att resa enligt planen,  Ex: buss 88 + buss 23 + tåg 4
```

```
* Leg.java: Leg = delresa, Varje Route har flera Legs, t.ex. en tur med buss 88
```
Vars
boolean realtime        sätts av backend om realtimeinfo finns tillgängligt
<br />

Functs

<br/>

```
* IntermediateStop.java: En hållplats på en Leg, t.ex. Grönlandsgången
```
Vars
start/end -time         tabelltiden
start/end -timeRt       Realtid (provided by backend)
<br/>

Functs
Set och gets för Realtid
Booleans för att kolla om det är delay på departure/arrival från hållplatsen
<br/>



```
