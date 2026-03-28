/**
 * Defines a specific campus event that impacts students.
 */

public class CampusEvent {
	
    /** Impact value on aura */
    private final int auraImpact;
    
    /** Impact value on rizz */
    private final int rizzImpact;
    
    /** Shift in the delusion index */
    private final int deluluShift;
    
    /** Gain in the confidence score */
    private final int confidenceGain;
    
    /** Tracked and updated globally across all events */
    public static int totalEventsProcessed = 0;

    /**
     * Constructs a new CampusEvent with the specified stat impacts.
     * @param auraImpact         	Impact value on aura
     * @param rizzImpact          	Impact value on rizz 
     * @param deluluShift        	Shift in the delusion index
     * @param confidenceGain    	Gain in the confidence score
     */
    public CampusEvent(int auraImpact, int rizzImpact, int deluluShift, int confidenceGain) {
    	this.auraImpact = auraImpact;
    	this.rizzImpact = rizzImpact;
    	this.deluluShift = deluluShift;
    	this.confidenceGain = confidenceGain;

    }

    /**
     * Calculates the specific impact on a student's Aura and Rizz based on their current status and updates their Aura and 
     * Vibes (includes rizz, deluluIndex and confidence).
     * <br/>
     * <b>Stat Modifiers:</b>
     * <ul>
     * <li> If vibe trend > 20, apply a <b>1.2x</b> multiplier to auraImpact and rizzImpact. </li>
     * <li> If vibe trend <= 20, apply a <b>0.8x</b> multiplier to auraImpact and rizzImpact. </li>
     * </ul>
     *<br/>
     *<pre>
     * <b>Note: </b>
     * The modified AuraImpact should be <b>added</b> to the current Aura of the student.
     * <br/>
     * </pre>
     * <b>Hint: </b>
     * <ul>
     * <li> Think of a method in VibeCheck to get the vibe trend.</li>
     * <li> Think of a method in VibeCheck to update the rizz, deluluIndex and confidence.</li>
     * </ul>
     * 
     * @param student    The student whose stats are being evaluated and updated.
     */
    public void updateStats(Student student) {
    	if(student.getVibes().getTrend() > 20)
    	{
    		int aura = (int)1.2* auraImpact;
    		int rizz = (int)1.2*rizzImpact;
    		student.getVibes().updateVibes(rizz, deluluShift, confidenceGain);
    		student.setAura(aura);
    		
    	}
    	
    	if(student.getVibes().getTrend() <= 20)
    	{
    		int aura = (int)0.8* auraImpact;
    		int rizz = (int)0.8*rizzImpact;
    		student.getVibes().updateVibes(rizz, deluluShift, confidenceGain);
    		student.setAura(aura);
    	}
    	
    	
    	
    	    
    }
}