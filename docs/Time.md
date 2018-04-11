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

Real-time information is received from the backend automatically and is contained within the Leg class<br/>
The Leg class has a variety of functions to handle realtime
<br/>
Ex<br/>
start/end -time         tabelltiden<br/>
start/end -timeRt       Realtid <br/>
<br/>
<br/>
There is a thread running in the RoutesActivity.java:193 that checks if any of the legs of the routes in the plan need to be updated (with the shouldRefresh function in Plan) <br/>
If it turns out that any of the legs need to be updated the plan is adjusted to compensate for the real-time change

```
 //a thread is constantly running following function
    public boolean shouldRefresh(long timeMillis)
    
 //which returns true if realtime and then the thread calls 
    public void refreshTransit(final JourneyQuery journeyQuery, final Callback callback)
    
```


## Real-Time GUI usages

Text color on departure times changes depending on realTimeState<br/>
ViewHelper.java row 303
```
    public static @ColorRes int getTextColorByRealtimeState(RealTimeState realTimeState)
```

