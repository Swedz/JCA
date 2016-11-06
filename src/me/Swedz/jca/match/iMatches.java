package me.Swedz.jca.match;

public interface iMatches {
	public String getAllMatches() throws Exception;
	public String getMatch(int matchID) throws Exception;
	public int getUniqueMatchID(int match) throws Exception;
	public void winner(int matchID, String winnerName) throws Exception;
	public void tie(int matchID, String player1, String player2) throws Exception;
}
