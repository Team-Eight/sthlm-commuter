=======
History
=======

The following sections have the basic functionality of the *history* activity described,
and some of the noteworthy classes & functions that are involved.

**The History function only saves the origin Site, making it available for searching departures from that location.**


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

Example entry in DB:

+----+------+------------+------------+----------+-----------+------------+----------+--------+----------+
| id | type |    name    |   created  | latitute | longitude |  locality  | place_id | source | category |
+====+======+============+============+==========+===========+============+==========+========+==========+
| 1  |   4  | Sollentuna | 11/04/2018 | 59428592 |  17948186 | Sollentuna |   9506   |    0   |     1    |
+----+------+------------+------------+----------+-----------+------------+----------+--------+----------+
| 2  |   4  |   Häggvik  | 11/04/2018 | 59444569 |  17933408 | Sollentuna |   9505   |    0   |     1    |
+----+------+------------+------------+----------+-----------+------------+----------+--------+----------+
