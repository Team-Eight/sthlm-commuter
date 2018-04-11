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

## Real-Time

## How to change departure/arrival time

```
protected Dialog onCreateDialog(int id)
```
