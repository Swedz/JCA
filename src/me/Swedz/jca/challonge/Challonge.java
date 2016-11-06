package me.Swedz.jca.challonge;

import me.Swedz.jca.JCA;
import me.Swedz.jca.web.Web;

public class Challonge implements iChallonge {
	/*
	 * Returns a JSON of the participants in the specified tournament
	 * as a String (soon to be JSONObject)
	 */
	public String getParticipants() throws Exception {
		return Web.get("https://api.challonge.com/v1/tournaments/" + JCA.tournament + "/participants.json", 30*1000, false);
	}

	/*
	 * Returns a JSON of the matches in the specified tournament as a
	 * String (soon to be JSONObject)
	 */
	public String getMatches() throws Exception {
		return Web.get("https://api.challonge.com/v1/tournaments/" + JCA.tournament + "/matches.json", 30*1000, false);
	}
	
	/*
	 * Starts the specified tournament
	 * NOTICE: You must start the tournament before you can 
	 */
	public void start() throws Exception {
		Web.post("https://api.challonge.com/v1/tournaments/" + JCA.tournament + "/start.json", "{}", 30*1000);
	}
}
