=======
History
=======
The following sections have the basic functionality of the *history* activity described,
and some of the noteworthy classes & functions that are involved.

**There are several places within the app that relate to history. The following sections just describe the general functionality and notes some activities that invoke activites related to history.**

### The General Scenario
If you've made a search, both the starting location and the destination are saved into the history view,
enabling you to use either of them as a **departure** location in a new search.

History is also utilized when you're making a new search, and your recent locations are listed.

setupHistoryViews
-----------------
This function is triggered when you click either the departure/destination location field in order to search for a location and populates a list with some of your recently used/searched locations. 

HistoryAdapter
--------------
This class handles populating the *history view* with recent departure sites i.e the departure location in a recent search.


History Database
----------------
Handled via: *historyDbAdapter*

The above mentioned functions, and any related functions to loading history utilizes this class.
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

Example entry in DB:

+----+------+------------+------------+----------+-----------+------------+----------+--------+----------+
| id | type |    name    |   created  | latitute | longitude |  locality  | place_id | source | category |
+====+======+============+============+==========+===========+============+==========+========+==========+
| 1  |   4  | Sollentuna | 11/04/2018 | 59428592 |  17948186 | Sollentuna |   9506   |    0   |     1    |
+----+------+------------+------------+----------+-----------+------------+----------+--------+----------+
| 2  |   4  |   Häggvik  | 11/04/2018 | 59444569 |  17933408 | Sollentuna |   9505   |    0   |     1    |
+----+------+------------+------------+----------+-----------+------------+----------+--------+----------+
