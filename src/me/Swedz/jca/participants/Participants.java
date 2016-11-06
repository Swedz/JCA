package me.Swedz.jca.participants;

import java.util.HashMap;

public class Participants implements iParticipants {
	public static HashMap<String, Integer> seeds = new HashMap<String, Integer>();
	public static HashMap<Integer, Integer> ids = new HashMap<Integer, Integer>();
	
	public int seed(String participant) throws Exception {
		return seeds.get(participant);
	}
	
	public int id(String participant) throws Exception {
		return ids.get(seed(participant));
	}
}
