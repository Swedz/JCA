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
        "Dank",
        "Memes"
    }).build();
```
This will create a tournament at the link challonge.com/single_elim/ with the players Dank and Memes, description of "Some dank tournament stuffs", and with a display name of "Swedz's Tournament".

## Starting and Ending Tournaments
To start and/or end a tournament, simply use one of these functions:
```java
se.start();
...
se.end();
```
This will cause the tournament to begin or end on the webpage.

## Chosing Winners for Matches
Matches are a little trickier than the other things, so I have tried my hardest to make this as easy for you as possible. Simply, supply the tournament url (e.g: single_elim), match number that is currently running, and the player who won the match. Or, if it is a tie, supply both players.
```java
JCA.matches().winner("single_elim", 1, "Dank");
...
JCA.matches().tie("single_elim", 1, "Dank", "Memes");
```
Note, when supplying the match id, you want to specify the global match number. So, you would need to make an int variable (starting at 1) that will be added to every time a game ends. And that would be the match id you supply to the JCA#matches()#winner() or JCA#matches()#tie() methods.

## Maven Setup
To use JCA in your Maven project, download the src for JCA, export it as a JAR File (named JCA.jar), put the jar in your /src/main/resources/ directory, and in your pom.xml, add this to your dependencies:
```xml
<dependency>
  <groupId>me.Swedz</groupId>
  <artifactId>jca</artifactId>
  <version>1.0</version>
  <scope>system</scope>
  <systemPath>${project.basedir}/src/main/resources/JCA.jar</systemPath>
</dependency>
```
Once you do this, you can use the API in your project as much as you want!

*Credit is appreciated :)*
