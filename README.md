# JCA (Java Challonge API)
JCA strives to make Challonge interactions though Java a lot easier, cleaner, and more efficient.

## Creating a Tournament
To initialize a tournament, you must run something of the sorts:
```java
SingleElim se = new SingleElim()
    .setAPIKey("api key goes here")
    .setName("Swedz's Tournament")
    .setURL("single_elim")
    .setDesc("Some dank tournament stuffs")
    .withPlayers(new String[] {
        "Swedz",
        "Memes"
    }).build();
```
This will create a tournament at the link challonge.com/single_elim/ with the players Swedz and Memes, description of "Some dank tournament stuffs", and with a display name of "Swedz's Tournament".
