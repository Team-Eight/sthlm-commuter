=======
History
=======

The following sections have the basic functionality of the *history* activity described,
and some of the noteworthy classes & functions that are involved.

**The History function only saves the origin Site, making it available for searching departures from that location.**

PlannerFragment
---------------
function onCreate() # Activity entry point
-> getLoaderManager().initLoader(LOADER_JOURNEY_HISTORY, null, this);
- getLoaderManager() # Returns the LoaderManager for the selected Fragment.

function initViews()
- HistoryDbAdapter # Constructor that initiates connection to the local DB, to fetch data.


History Database
----------------
Handled via: *historyDbAdapter*

The database handles the persistent storing of history items, and saves the following keys:

+-----------+----------------+----------------------+
|    Key    |      Type      |          Note        |
+===========+================+======================+
|    id     |     INTEGER    |  Autoincremented ID  |
+-----------+----------------+----------------------+
|   type    |     INTEGER    |                      |
+-----------+----------------+----------------------+
|   name    |      TEXT      |    Station name      |
+-----------+----------------+----------------------+
|  created  |      date      |      Usage date      |
+-----------+----------------+----------------------+
|  latitute |     INTEGER    |      lat. coord.     |
+-----------+----------------+----------------------+
| longitude |     INTEGER    |      long. coord.    |
+-----------+----------------+----------------------+
| locality  |      TEXT      |     Municipality     |
+-----------+----------------+----------------------+
| place_id  |      TEXT      |                      |
+-----------+----------------+----------------------+
|  source   |     INTEGER    |                      |
+-----------+----------------+----------------------+
| category  |     INTEGER    |                      |
+-----------+----------------+----------------------+
