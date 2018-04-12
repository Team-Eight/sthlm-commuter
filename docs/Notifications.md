# Notifications
* Documentation about how Notifications work
* There is an "Experimental" notifcation system concerning deviations already implemented in the application

## AndroidManifest
First you need a Service (a thingy that runs in the background on the phone) that must be included in the AndroidManifest.xml <br/>
And a file: DeviationService.java which implements some service interface (current one that is used is deprectated :( (still works doe))
```
  <service
      android:name=".service.DeviationService"
      android:enabled="true"
      android:exported="false"
      />
```

## StartActivity.java
In the entry point of the app we start the service in StartActivity.onCreate(..) 
```
  // Start background service.
  DeviationService.startAsRepeating(getApplicationContext());
```

## DeviationService.java
Service Setup, for example how often the notification checks should update (every 60min currently)
```
    public static void startAsRepeating(Context context)

```
So at every 60 min following function is called:
```
    protected void doWakefulWork(Intent intent)
```
Which first takes out all the user-chosen Interesting Leg deviations from DeviationStore.java (Which retrieves ALL deviations from backend):
```
 ArrayList<Integer> triggerFor = DeviationStore.extractLineNumbers(filterString, null);
```
Then it Checks all these deviations with the DeviationNotificationDbAdapter.java which maintains a database on the phone of all deviations and adds new deviations or updates already existing 
```
  //check if reference is same and version is same
  if (!mDb.containsReference(deviation.getReference(), deviation.getMessageVersion())) 
      mDb.create(deviation.getReference(), deviation.getMessageVersion());
```
If any Interesting deviations were new or updated it will send a notification to the phone
```
  showNotification(deviation);       
  ...
  Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.stat_notify_error)
                .setWhen(System.currentTimeMillis())
                .setContentTitle(getText(R.string.deviations_label))
                .setContentText(getText(R.string.new_deviations))
      ...
```
