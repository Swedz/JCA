[![JCA Banner](http://i.imgur.com/IuMFp5Z.png "Java Challonge API")](https://github.com/Swedz/JCA/)

***Note that this project has been cancelled and no further development on my end will be taking place. Feel free to take the code and update it elsewhere. Give credit if you're feeling nice ;)***

# JCA (Java Challonge API)
JCA strives to make [Challonge](https://challonge.com/) interactions through Java a lot easier, cleaner, and more efficient.

## Creating a Tournament
To initialize a tournament, you must run something of the sorts:
```java
Tournament tourn = new Tournament()
    .setAPIKey("api key goes here")
    .setName("Swedz's Tournament")
    .setType(Type.SINGLE)
    .setURL("single_elim")
    .setDesc("Some dank tournament stuffs")
    .withPlayers(new ArrayList<String>(Arrays.asList(
        "hey",
        "hi"
    )).build();
```
This will create a tournament at the link challonge.com/single_elim/ with the players Dank and Memes, description of "Some dank tournament stuffs", and with a display name of "Swedz's Tournament".

## Starting and Ending Tournaments
To start and/or end a tournament, simply use one of these functions:
```java
tourn.start();
...
tourn.end();
```
This will cause the tournament to begin or end on the webpage.

## Chosing Winners for Matches
Matches are a little trickier than the other things, so I have tried my hardest to make this as easy for you as possible. Simply, supply the tournament url (e.g: single_elim), match number that is currently running, and the player who won the match. Or, if it is a tie, supply both players.
```java
JCA.matches().winner(1, "Dank");
...
JCA.matches().tie(1, "Dank", "Memes");
```
Note, when supplying the match id, you want to specify the global match number. So, you would need to make an int variable (starting at 1) that will be added to every time a game ends. And that would be the match id you supply to the JCA#matches()#winner() or JCA#matches()#tie() methods.

## Known Problems
All projects have their little quirks and issues. And these are JCA's:

- Not Asynchronous
- Adding participants doesn't use [bulk_add](https://api.challonge.com/v1/documents/participants/bulk_add)
- Cannot do two Tournaments at the same time
  - When a new one is made, it overrides the old one.
