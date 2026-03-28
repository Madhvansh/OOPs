
/**
 * Represents a physical examination room.
 * This class handles the seating arrangement of students, 
 * ensuring specific rules like the "One-Seat Gap" are followed.
 */
public class ExamHall {
    
    /**
     * The alphanumeric name of the exam room (e.g., "A101").
     */
    private String roomName;

    /**
     * The total physical seating capacity of the hall.
     */
    private int capacity;

    /**
     * An array representing the seats in the hall and the students assigned to them.
     */
    private Student[] seatedStudents;

    /**
     * The number of students currently successfully seated in the hall.
     */
    private int seatCount;

    /**
     * Initializes a new Exam Hall with a specified name and capacity.
     * @param roomName The name of the hall (e.g., "A101")
     * @param capacity Total number of seats available
     */
    public ExamHall(String roomName, int capacity) {
        /* * Initialize seatedStudents array and set seatCount to zero.
         */
    	this.roomName = roomName;
    	this.capacity = capacity;
    	this.seatedStudents = new Student[capacity];
    	this.seatCount = 0;
    }

    /** @return The name of the hall */
    public String getRoomName() {
    	return roomName;
        
    }

    /** @return The total capacity of the hall */
    public int getCapacity() {
        return capacity;
    }

    /** @return The number of students currently seated */
    public int getSeatCount() {
        return seatCount;

    }

    /** @return The array containing seated students and empty seat gaps */
    public Student[] getSeatedStudents() {
        return seatedStudents;
    }

    /**
     * Attempts to seat a student in the hall using the "One-Seat Gap" rule.
     * Rule: Students must be seated at even indices (0, 2, 4...) to maintain gaps.
     * @param student The student to be seated
     * @return true if the student was successfully seated; false if student is null or hall is at capacity
     */
    public boolean addStudent(Student student) {
        if ( student == null || seatCount > capacity )return false;
        for (int i = 0; i < capacity; i+=2)
        {
        	seatedStudents[i] = student;
        }
        return true;
    }
}
