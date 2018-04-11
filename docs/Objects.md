# Objects


## Plan
## Route
## Leg
## IntermediateStop
## TravelMode 
Consists of a string corresponding to a travel mode (ie. bus, train etc.)
## TravelModeQuery
Consists of a list with TravelMode objects
## JourneyQuery 
Consists of public Site origin;
    Site destination;
    Site via;
    Date time;
    boolean isTimeDeparture = true;
    boolean alternativeStops = false;
    List<String> transportModes = new ArrayList<>();
    String ident;
    boolean hasPromotions;
    nt promotionNetwork = -1; 
    String previousIdent;
    String previousDir;
