
/**
 * The administrative hub for exam management.
 * This class maintains static registries of all halls and courses,
 * and contains the logic for clash detection and seat allocation.
 */
public class ExamCell {
    
    /** * Static registry of available exam halls.
     * 
     */
	private static ExamHall[] examHalls = new ExamHall[10];
    
    /** * The number of halls currently registered.
     */
    private static int hallCount=0;
    
    /** * Static registry of all courses scheduled for examination.
     *
     */
    private static ExamCourse[] examCourses = new ExamCourse[10];

    
    /** * The number of courses currently registered.
     
     */
    private static int courseCount=0;

    /**
     * Registers a new exam hall in the global registry.
     * @param roomName The alphanumeric name of the hall (e.g., "A101")
     * @param capacity Total physical seats available
     * @return true if added successfully; false if name is null, capacity is non-positive, or registry is full
     */
    public static boolean addExamHall(String roomName, int capacity) {
    	if (roomName == null || capacity < 0 || hallCount >= 10 )return false;
    	ExamHall ehole = new ExamHall(roomName,capacity);
    	examHalls[hallCount++] = ehole;
    	return true;
    }

    /**
     * Adds an existing ExamCourse object to the global registry.
     * @param course The ExamCourse object to be added
     * @return true if added successfully; false if course is null or registry is full
     */
    public static boolean addExamCourse(ExamCourse course) {
    	if (course == null || courseCount >= 10 )return false;
    	examCourses[courseCount++] = course;
    	return true;
        
    }

    /**
     * Overloaded helper method to create and register a new ExamCourse.
     * @param courseCode The unique code (e.g., "CSF203")
     * @param examDay The scheduled day (e.g., "Monday")
     * @param examTime The scheduled session (FN/AN)
     * @return true if created and added successfully
     */
    public static boolean addExamCourse(String courseCode, String examDay, String examTime) {
    	ExamCourse ehole = new ExamCourse(courseCode,examDay,examTime);
    	examCourses[courseCount++] = ehole;
    	return true;
        
    }

    /**
     * Checks if a specific student has an exam scheduling conflict.
     * A clash occurs if the student is registered for two or more courses 
     * scheduled on the same day and at the same time session.
     * @param student The student object to evaluate
     * @return true if a clash is detected; false otherwise
     */
    public static boolean checkExamClash(Student student) {
    	int j = student.getCourseCount();
    	
    	
    	ExamCourse[] temp= student.getCourses();
    	for (int i = 0; i < student.getCourseCount(); i++)
    	{
    		if(temp[i].getCourseCode() == temp[i+1].getCourseCode())
    		{
    			return true;
    		}
    	}
    	return false;
    	
    	
    }

    /**
     * Allocates seats for a specific session of courses.
     * <p>
     * Seating Logic:
     * 1. Iterate through the provided courses one by one.
     * 2. For each course, find all registered students from the provided student list.
     * 3. Assign those students to halls starting from the current hall index.
     * 4. If a hall becomes full, move to the next available hall in the registry.
     * 5. Rule: Once a course's seating is finished, the next course must start 
     * in a brand new hall (no mixing different courses in the same hall).
     * </p>
     * @param courses The array of courses to be seated in this session
     * @param students The array of all potential students to be checked for registration
     */
    public static void allocateSeatsForCourses(ExamCourse[] courses, Student[] students) {
    	int c=0;
        for (int i = 0; i < courses.length; i++)
        	
        	
        {
        	for (int j = 0; j < students.length; j++)
        	{
        		students[j].getCourses();
        		for (int z = 0; z < students[j].getCourseCount(); z++)
        		if (courses[i].getCourseCode().equals(students[j].getCourses()[z].getCourseCode()))
        			
        		{
        			c++;
        		}
        	}
        }
    }
    
    /**
     * Retrieves the formatted exam schedule details for a specific student and course.
     * <p>
     * Logic Steps:
     * 1. Verify if the student is actually registered for the given course.
     * 2. Search through all registered halls to find where the student is seated.
     * 3. Account for the "One-Seat Gap" (indices 0, 2, 4...) when searching seated students.
     * 4. If found, return a string in the format: "CourseCode | Day | Time | RoomName"
     * </p>
     * @param student The student whose schedule is being requested
     * @param course The specific course to look up
     * @return A formatted schedule string, or null if the student is not registered or not seated
     */
    public static String getStudentExamSchedule(Student student, ExamCourse course) {
    	return null;
        
    }

       
}