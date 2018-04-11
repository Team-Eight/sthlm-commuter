# Time

## Documentation on how to do Time-related things

## Date
Represented as number of milliseconds since the standard base time known as the Epoch (1970, 1 jan, 00:00:00 GMT)
Use DateTimeUtils class to work with it.

## DateTimeUtil

Useful functions
To create a Date object from a human-date and time:
```
    public static Date fromDateTime(final String dateString, final String timeString)
    
    //dataString format is "yyyy-MM-dd"
    //timeString format is "HH:mm"
```
## How to change departure/arrival time
Logic is inside the ChangeRouteTimeActivity.java class

The app uses dialog-windows which are activated by the date and time button to adjust the depart and arrival time.
After the date and time dialog windows close the information is sent to the listener and the time/date is changed accordingly using the following function. 
 
Row 315
To change the date modify year, monthOfYear and dayOfMonth variables
```   
 private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() 
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, monthOfYear);
    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
```   

Row 330
To change the time modify hourOfDay and minute variables
```   
 private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener()
            
    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
    calendar.set(Calendar.MINUTE, minute);
```

## Real-Time

data/models/RealTimeState.java <br/>
Endast en enum med olika states, används av GUI för att välja t.ex. rätt ikoner/stryka fel tid etc 
```
    BEHIND_SCHEDULE,
    AHEAD_OF_SCHEDULE,
    ON_TIME,
    NOT_SET,
```


<br/>

Plan.java: Vald resa from -> to
```

```
Route.java: Olika förslag på rutter med olika tider för att resa enligt planen,  Ex: buss 88 + buss 23 + tåg 4
```

```
Leg.java: Leg = delresa, Varje Route har flera Legs, t.ex. en tur med buss 88
```
Vars
boolean realtime        sätts av backend om realtimeinfo finns tillgängligt
<br />

Functs

<br/>

```
IntermediateStop.java: En hållplats på en Leg, t.ex. Grönlandsgången
```
Vars
start/end -time         tabelltiden
start/end -timeRt       Realtid (provided by backend)
<br/>


Functs
Set och gets för Realtid
Booleans för att kolla om det är delay på departure/arrival från hållplatsen
<br/>


## Real-Time GUI usages

Text color on departure times changes depending on realTimeState<br/>
ViewHelper.java row 303
```
    public static @ColorRes int getTextColorByRealtimeState(RealTimeState realTimeState)
```

