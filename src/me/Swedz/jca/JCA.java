package me.Swedz.jca;

import me.Swedz.jca.challonge.Challonge;
import me.Swedz.jca.match.Matches;
import me.Swedz.jca.participants.Participants;

/*
 * Started on 11/5/16
 * at 11:34 PM
 * 
 * Developed by Swedz
 */
public class JCA {
	public static String api_key = null;
	public static int timeout = 30*1000;
	public static String tournament = null;

	public static Challonge challonge = null;
	public static Challonge challonge() { return challonge; }
	
	public static Matches matches = null;
	public static Matches matches() { return matches; }
	
	public static Participants participants = null;
	public static Participants participants() { return participants; }
}
