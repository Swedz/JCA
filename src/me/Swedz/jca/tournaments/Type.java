package me.Swedz.jca.tournaments;

public enum Type {
	SINGLE("single elimination"),
	DOUBLE("double elimination"),
	;
	
	private final Object[] values;
	Type(Object... vals) { values = vals; }
    public String getName() { return (String) values[0]; }
}
