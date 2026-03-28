
/**
 * Represents a student enrolled in multiple courses.
 * Responsibilities include parsing student IDs and managing course enrollment.
 */
public class Student {
    
    /**
     * The unique campus ID for the student (e.g., "2022A7PS0694G").
     */
    private String studentId; 

    /**
     * An array storing the ExamCourse objects the student is registered for.
     */
    private ExamCourse[] courses;         

    /**
     * The current number of valid (non-null) courses in the array.
     */
    private int courseCount;

    /**
     * The maximum capacity of the courses array.
     */
    private int maxCourseCount;

    /**
     * Initializes a student with a pre-existing array of courses.
     * @param studentId The unique ID (e.g., "2022A7PS0694G")
     * @param courses The array of ExamCourse objects
     */
    public Student(String studentId, ExamCourse[] courses) {
    	
        this.studentId = studentId;
        this.courses = courses;
    }

    /**
     * Initializes a student with an empty course array of a fixed size.
     * @param studentId The unique ID
     * @param maxCourseCount The maximum capacity of the courses array
     */
    public Student(String studentId, int maxCourseCount) {
    	this.studentId = studentId;
    	this.courses = new ExamCourse[maxCourseCount];
        this.maxCourseCount = maxCourseCount;
    }

    /** @return The student's ID string */
    public String getStudentId() { 
        return studentId;
    }

    /** @return The array of courses the student is registered for */
    public ExamCourse[] getCourses() { 
        return courses;
    }

    /**
     * Dynamically calculates how many non-null course entries exist in the array.
     * @return count of courses
     */
    public int getCourseCount() {
        int count = 0;
    	for (int i =0; i < maxCourseCount; i++)
    	{
    		if(courses[i] != null)
    		{
    			count++;
    		}
    	}
    	return count;
    }

    /**
     * Extracts the first 4 characters of the studentId and converts them to an integer.
     * @return the 4-digit joining year
     */
    public int getJoiningYear() {
        String s = studentId.substring(0,4);
        int num = Integer.parseInt(s);
        return num;
    }

    /**
     * Extracts the unique numerical ID from index 8 to 11 of the studentId.
     * @return the 4-digit unique ID
     */
    public int getUniqueId() {
    	String s = studentId.substring(8,12);
        int num = Integer.parseInt(s);
        return num;
       
    }

    /**
     * Adds a course to the student's schedule if there is space.
     * @param course The ExamCourse to add
     * @return true if added successfully, false if array is full or course is null
     */
    public boolean addCourse(ExamCourse course) {
        if (course == null || courseCount >= maxCourseCount)return false;
        courses[courseCount] = course;
        return true;
    }

    /**
     * Delegates the check for exam schedule conflicts to the ExamCell class.
     * @return true if a clash is detected
     */
    public boolean checkClash() {
       if (ExamCell.checkExamClash(this) ==true) {return true;}
       else {return false;}
       
    }
}
