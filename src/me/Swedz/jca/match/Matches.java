package me.Swedz.jca.match;

import java.util.HashMap;

import me.Swedz.jca.JCA;
import me.Swedz.jca.web.Web;

/*
 * Everything in this class requires the tournament to be active
 */
public class Matches implements iMatches {
	/*
	 * Get all matches from the tournament in JSON as a String
	 * (Soon to be JSONObject)
	 */
	public String getAllMatches() throws Exception {
		return Web.get("https://api.challonge.com/v1/tournaments/" + JCA.tournament + "/matches.json", 30*1000, false);
	}
	
	/*
	 * Get data of match from id specified in JSON as a String
	 * (Soon to be JSONObject)
	 */
	public String getMatch(int matchID) throws Exception {
		return Web.get("https://api.challonge.com/v1/tournaments/" + JCA.tournament + "/matches/" + matchID + ".json", 30*1000, false);
	}
	
	/*
	 * Gets unique id for match id
	 */
	public static HashMap<Integer, Integer> matchIDs = new HashMap<Integer, Integer>();
	public int getUniqueMatchID(int match) throws Exception {
		return matchIDs.get(match);
	}
	
	/*
	 * Sets winner in match specified
	 */
	public void winner(int matchID, String winnerName) throws Exception {
		System.out.println("match: " + getUniqueMatchID(matchID));
		System.out.println("id: " + JCA.participants().id(winnerName));
		Web.put("https://api.challonge.com/v1/tournaments/" + JCA.tournament + "/matches/" + getUniqueMatchID(matchID) + ".json",
			"{\"match\": {\"scores_csv\": \"1-0\", \"winner_id\": " + JCA.participants().id(winnerName) + "}}", 30*1000);
	}
	
	/*
	 * Sets the match to be tied (sets player with higher seed to win)
	 */
	public void tie(int matchID, String player1, String player2) throws Exception {
		int seed1 = JCA.participants().seed(player1);
		int seed2 = JCA.participants().seed(player2);
		String winner = null;
		if(seed1 > seed2) {
			winner = player1;
		} else {
			winner = player2;
		} int id = JCA.participants().id(winner);
		
		Web.post("https://api.challonge.com/v1/tournaments/" + JCA.tournament + "/matches/" + getUniqueMatchID(matchID) + ".json",
				"{\"match\": {\"scores_csv\": \"0-0\", \"winner_id\": " + id + "}}", 30*1000);
	}
}
