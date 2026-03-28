/**
 * Represents a student with bitsID, aura, event count and vibes.
 */

public class Student {
	
    /** The student's ID*/
    private final String bitsID;
    
    /** Reference to the student's vibes */
    private final VibeCheck vibes;
    
    /**Current aura level of the student*/
    private int aura;
    
    /** Total number of events the student has participated in */
    private int eventCount;

    /**
     * Constructs a new Student with the given parameters.
     * @param id       The student's ID.
     * @param aura     The initial aura level of the student.
     * @param vibes    The VibeCheck object.
     */
    public Student(String id, int aura, VibeCheck vibes) {
    	this.bitsID = id;
    	this.aura = aura;
    	this.vibes = vibes;
    	this.eventCount = 0;

    }

    /**
     * Extracts the primary branch code from the student ID.
     * <br/>
     * <pre>
     * <b>Note: </b>
     * If the student is a dualite, return the Msc branch only. (e.g., if the ID is 2022B3A76767G, return "B3")
     * </pre> 
     * 
     * @return A 2-character string representing the branch (e.g., "A8").
     */
    public String getBranch() {
    	String a = bitsID.substring(4,6);
    	return a;

    }
    
    /**
     * Increments the student's event participation count by 1.
     */
    public void incrementEventCount() {
    	eventCount++;

    }
    
    /**
     * Gets the student's current Aura.
     * 
     * @return The current aura level as an integer.
     */
    public int getAura() { 
    	return this.aura;
 
    }
    
    /**
     * Sets the student's Aura to a specific value.
     * 
     * @param auraPoints    The new aura value to be set.
     */
    public void setAura(int auraPoints) { 
    	this.aura = auraPoints;

    }
    
    /**
     * Gets the student's vibes.
     * 
     * @return The VibeCheck object associated with the student.
     */
    public VibeCheck getVibes() { 
    	return this.vibes;

    }
    
    /**
     * Gets the total number of events the student has participated in.
     * 
     * @return The total event count as an integer.
     */
    public int getEventCount() {
    	return this.eventCount;

    }
    
    /**
     * Determines if the student is cooked or not.
     * 
     * @return <b>true</b> if the student's aura has dropped below 0, <b>false</b> otherwise.
     */
    public boolean isCooked() {
    	if (aura < 0)
    	{
    		return true;
    		
    	}
    	else
    	{return false;}
 
    }
}