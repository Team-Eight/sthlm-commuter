====
FAQ
====

Here you can find some information regarding different subjects that relate to the project.



**************
Android Basics
**************

Here's some basic information regarding the structure of an App, the different components that make up the app itself and what functionality they provide.

App components
--------------
Android apps consists of multiple components that
can be invoked individually, each components serves as an
entry point from which the system/user can enter the app.

There are four different types of components:
* Activities
* Services
* Broadcast receivers
* Content providers


Activities
----------
The activity component serve as an entry point for interacting
with the user. It serves one purpose, with a single screen and user interface.

For example, each screen in the STHLM Traveling app is categorized as separate
activites - One for searching and displaying search results, one for showing favourites
and so on. These activites together create a unified user experience, but they are
independent of each other - a different app can start any of the activites while another is running,
should the app allow it.

An activity provides the following key interactions between system and app:
* Keeping track of what the user has focus on (what's on screen) to ensure that
the system keeps the process that handles the acitivity alive.
* Keeping track of previously used processes (stopped activites), that the user may return to, and thus
prioritizes keeping those processes around.
* Helping the app handle termination of its processes, helping it restore the state so that
the user can return to activites.
* Provides a way for apps to enable user flows between each other, allowing the system to
coordinate these flows (for example sharing data).

Services
--------
A service is an user-interfaceless component that serves as a general-purpose entry point
for keeping the app running in the background. A service could be used to allow an apps
to fetch data over the network in the background without inhibiting user interaction with an activity.

There's two very distinct cases of a service, and how the system should manage it:

* Started services are kept alive by the system for as long as they need to complete their work. These services can be further divided into two types:

  #. A user can be directly aware of an service - the app tells the system by saying that it wants to run in the foreground with a notification to tell the user about it. The system then tries to keep the service's process alive. For example - music playback.
  #. A regular background service is not a service that the user is directly aware of, so the system has more freedom in managing it's process. The service may be killed (and restarted later) if system resources are required for something that is of more immediate concern to the user.

* Bounded services run because some other app (or the system) has notified that it wants to make use of it. Basically the service provides an API to another process. The system thus knows that there is a dependency between these processes - as long as process A runs, it need to keep process B alive. This alos means that prioriations are inherited by the 'child'-process.

Broadcast receivers
-------------------
The broadcast receiver component enables the system to deliver events to an app outside of the regular user flow,
allowing an app to respond/become aware of system-wide broadcast announcements.

The broadcast receivers are well-defined entry points into an app, thus the system can deliver
broadcasts to an app even though it's currently not running.

For example, an app can schedule an alarm to a Broadcast Receiver to display a notification to tell the user about something.
Thus by delivering that to a broadcast receiver there is no need for the app to keep running until the alarm goes off.

A broadcast receiver is commonly seen as just a gateway to other components and should do very little work.

Content providers
-----------------
The content managment activity manages a shared set of app data that can be stored in the file system,
a SQLite database or any other kind of persistent storage location that's available to the app.

Through the content provider, other apps can query or modify data if the content provider allows it.

To the system the content provider is an entry point into an app for publishing named data items, all identified by a URI scheme.
The app can then make decision on how it wants to map the data it contains to a URI namespace and then handing out those URIs to other
apps that in turn can use them to access the data. There are a few things this allows the system to do in the matter of managing an app:
* Assigning a URI doesn't require that the app remains running, URIs can persist after their owning app have exited. The system only needs
to make sure that the app is running when the data needs to be accessed.
* The URIs also provide a fine-grained security model. For example placing the URI for an image on the clipboard, but leaving the content provider
locked so that other apps cannot freely access it. The system can then grant temporary permission to the URI, should another app try to access it.


Activating components
---------------------

Different types of components are activated in different ways, activies, services and broadcast receivers are activated
by an asynchronous message called an *intent*. Intents bind individual components to each other at runtime.

An intent is created with a **Intent** object, that defines a message to activate a specific component (explicit intent) or a specific type of component (implicit intent).

For activities and services, an intent defines the action to perform, and may specify the URI of the data to act on, among other things that the component being started might need to now.
For example an Intent could be that an App issues a request for the user to pick a contact, which is then returned to you.

For broadcast receivers, the intent simply defines the announcement being broadcast. For example to indicate that the device battery is low.

Content providers are however not activated by intents, but instead activated when targeted by a request fro ma **ContentResolver**.


The manifest file
-----------------
The system becomes aware of the different components that exist in an app by reading it's *manifest file*, `AndroidManifest.xml`, in which
the app defines all of it's components.

The manifest also contains the following:

* Identifies any user permissions that the app requires.
* Declarus the minimum API level required, based on which APIs the app uses.
* Declares hardware/software features used or required by the app, such as camera, bluetooth etc.
* Declares API libraries that the app needs to be linked against, such as Google Maps library.


Credits
-------
Large amount of the information that's collected here is extracted and summarized from `Android Developers <https://developer.android.com/guide/components/fundamentals.html>`_.


************
Contributing
************

Here's some information regarding on how you can contribute to different aspects
of the project. Such as,

* The Documentation


Adding To The Wiki
------------------

The documentation is hosted and can be viewed here on ReadTheDocs,
while the source files are located on the `GitHub Repository <https://github.com/Team-Eight/sthlm-commuter/tree/gh-pages/docs/>`_.

| * Editing
|
|   To edit the current page, simply click the "Edit on GitHub" - found at the top of the page, or head over to the `GitHub Repository <https://github.com/Team-Eight/sthlm-commuter/tree/gh-pages/docs/>`_ to see all files.
|
| * Adding a new page
|
|  In order to add a new page you need to do three things,

  1. Decide whether you would like to use the **reStructuredText** or the **Markdown** syntax.

    - `reStructuredText <http://docutils.sourceforge.net/docs/user/rst/quickref.html>`_ has some more functionality but might be more complex.
    - `Markdown <https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet>`_ is easier and the same syntax as GitHub uses for it's '.md' - files.

  2. Create a file on GitHub

    - `GitHub Repository <https://github.com/Team-Eight/sthlm-commuter/tree/gh-pages/docs/>`_ with either the '.md' - for Markdown or '.rst' for reStructuredText.

  3. Add the name of the file to the index

    - Add the name of the file to the `Index-File <https://github.com/Team-Eight/sthlm-commuter/blob/gh-pages/docs/index.rst>`_ , without the filetype-extension, so that the compiler becomes aware of it. After each saved edit, a push will be sent and the documentation will be recompiled.
