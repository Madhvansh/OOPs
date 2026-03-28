/**
 *Manages the internal psychological metrics and history of a student.
 *<br/>
 * <pre>
 * - Tracks Rizz, Delulu, and Confidence.
 * - Maintains a <b>5-slot "circular"</b> buffer for trend analysis.
 * </pre>
 */
public class VibeCheck {
	
    /** Social influence power */
    private int rizz;
    
    /** Level of detachment from reality (state of delusion) */
    private int deluluIndex;
    
    /** Current self-belief (confidence) score */
    private int confidence;
    
    /** Circular buffer of size 5 for tracking confidence change */
    private final int[] confidenceHistory; 
    
    /** Pointer to the oldest confidence change in the circular buffer */
    private int historyIndex;

    /**
     * Constructs new VibeCheck with the given parameters.
     * 
     * @param rizz				Social influence power.
     * @param deluluIndex		Level of detachment from reality (state of delusion).
     * @param confidence		Current self-belief (confidence) score.		
     */
    public VibeCheck(int rizz, int deluluIndex, int confidence) {
    	this.rizz = rizz;
    	this.deluluIndex = deluluIndex;
    	this.confidence = confidence;
    	this.confidenceHistory = new int[5];
    	this.historyIndex = 0;
    	
    }

    /**
     * Constructs new VibeCheck object with the given vibeCheck's information.
     * <br/>
     * The new VibeCheck should not be a deep copy of the given object.
     * 
     * @param vibeCheck		The VibeCheck object whose information is used to create a new VibeCheck object.
     */
    public VibeCheck(VibeCheck vibeCheck) {
    	this.rizz = vibeCheck.rizz;
    	this.deluluIndex = vibeCheck.deluluIndex;
    	this.confidence = vibeCheck.confidence;
    	this.confidenceHistory = vibeCheck.confidenceHistory;
    	this.historyIndex = vibeCheck.historyIndex;
    	

    }

    /**
     * Calculates the average confidence score from the circular buffer.<br/>
     * 
     * @return Double value representing the social momentum.
     */
    public double getTrend() {
    	int sum = 0;
    	for(int i = 0; i < confidenceHistory.length; i++)
    	{
    		sum+=confidenceHistory[i];
    	}
    	double av = sum / confidenceHistory.length;
    	return av;

    }

    /**
     * Updates rizz, deluluIndex, confidence and replaces the oldest entry in the buffer with the given confidence change.<br/>
     * <pre>
     * <b>Note: </b>
     * The buffer is circular, so make sure to update the history index in a circular manner.
     * This ensures the buffer always stores the 5 most recent updates.
     * </pre>
     * 
     * @param rizzChange			The rizzChange to be added to current rizz.
     * @param deluluChange			The deluluChange to be added to current deluluIndex.
     * @param confidenceChange		The confidenceChange to be added to current confidence.
     */
    public void updateVibes(int rizzChange, int deluluChange, int confidenceChange) {
    	rizz+= rizzChange;
    	deluluIndex+= deluluChange;
    	confidence += confidenceChange;
    	
    	confidenceHistory[historyIndex] = confidence;
    	historyIndex++;
    	if (historyIndex == 4 )
    		{
    			historyIndex = 0;
    		}
    	}
    
    	
    	

    

    /**
     * Determines if the student is currently delusional or not.
     * 
     * @return <b>true</b> if deluluIndex exceeds confidence, <b>false</b> otherwise.
     */
    public boolean isDelusional() {
    	if (deluluIndex > confidence)return true;
    	else return false;

    }

    /**
     * Gets the Rizz.
     * 
     * @return The current rizz as an integer.
     */
    public int getRizz() { 
    	return this.rizz;
    	

    }
    
    /**
     * Gets the deluluIndex.
     * 
     * @return The current deluluIndex as an integer.
     */
    public int getDeluluIndex() { 

    	return this.deluluIndex;
    }
    
    /**
     * Gets the confidence.
     * 
     * @return The current confidence as an integer.
     */
    public int getConfidence() { 
    	return this.confidence;

    }
    
    /**
     * Gets the confidenceHistory array.
     * 
     * @return The current confidenceHistory array.
     */
    public int[] getConfidenceHistory() { 
    	return this.confidenceHistory;
 
    }
    
    /**
     * Gets the historyIndex.
     * 
     * @return The current historyIndex as an integer.
     */
    public int getHistoryIndex() { 
    	return this.historyIndex;

    }
}