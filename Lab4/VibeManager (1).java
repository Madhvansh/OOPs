/**
 * The core controller that manages student registrations and event simulation.
 */

public class VibeManager {
	
    /** Maximum number of students */
    private static final int CAPACITY = 50;
    
    /** Student array for registered student objects */
    private final Student[] students;
    
    /** The current count of students actively in the students array */
    private int studentCount;
    
    /** The minimum possible value for an integer */
    public static final int minimumIntegerValue = Integer.MIN_VALUE;

    /**
     * Constructs a new VibeManager, initializing the student array up to maximum capacity.
     */
    public VibeManager() {
    	this.students = new Student[CAPACITY];
    	studentCount = students.length;

    }

    /**
     * Processes a streak of events for a student.
     * Updates the global static variable tracking event counts for CampusEvent.
     * <br/>
     * <pre>
     * - If the student is "cooked" before an event's impact is applied, they skip the event's 
     * normal impact and instead gain a flat <b>+10 Aura</b> boost to stand a chance to 
     * participate in next event. <br/>
     * - Else the student's event participation increases by 1 and update stats for the 
     * student for that particular event (Hint: Think of a method in CampusEvent class).
     * </pre>
     * 
     * @param student	A student willing to participate in the events.
     * @param events    An array (varargs) of CampusEvents to occur.
     */
    public void simulateEvents(Student student, CampusEvent... events) {
    	
    	

    }
    
    /**
     * Evaluates all registered students to determine who the "Main Character" is.
     * <br/>
     * <pre>
     * <b>Scoring Formula:</b>
     * Score = (40% of Aura) + (40% of Rizz) + (20% of number of Events the student has participated in)
     * </pre>
     * <b>Note: </b> Assume only 1 student has the highest score.
     * 
     * @return The Student object with the highest calculated score, or <b>null</b> if no students exist.
     */
    public Student getMainCharacter() {
        Student mainCharacter = null;					// The mainCharacter student to return
        double topScore = minimumIntegerValue; 			//Variable to track the highest score
        
    	
        
        return mainCharacter;
    }

    /**
     * Adds a student to the students array.
     * Registration only succeeds if the current count is below the maximum capacity.
     * 
     * @param s    The Student object to register.
     * 
     * @return <b>true</b> if a student is successfully registered, <b>false</b> otherwise.
     */
    public boolean registerStudent(Student s) {
    	if(studentCount >=CAPACITY)return false;
    	students[studentCount++] = s;
    	return true;

    }
    
    /**
     * Retrieves the total number of campus events processed globally.
     * 
     * @return The global event count as tracked by the CampusEvent static variable.
     */
    public static int getTotalEventsProcessed() { 
    	return CampusEvent.totalEventsProcessed;
    }
}