/**
 * Represents a specific course and its scheduled exam details.
 * This class tracks when and where a course's exam will take place.
 */
public class ExamCourse {

    /**
     * The unique alphanumeric code for the course (e.g., "CSF203").
     */
    private String courseCode;

    /**
     * The full title of the course.
     */
    private String courseName;

    /**
     * The day of the week the exam is scheduled (e.g., "Monday", "Tuesday").
     */
    private String examDay;

    /**
     * The session of the exam, typically "FN" (Forenoon) or "AN" (Afternoon).
     */
    private String examTime;

    /**
     * Constructor used when only the course code and exam slot are known.
     * @param courseCode The code of the course
     * @param examDay The day of the exam
     * @param examTime The session (FN/AN)
     */
    public ExamCourse(String courseCode, String examDay, String examTime) {
    	this.courseCode = courseCode;
    	this.examDay = examDay;
    	this.examTime = examTime;

    }

    /**
     * Constructor used when all course details, including the name, are available.
     * @param courseCode The code of the course
     * @param courseName The full name of the course
     * @param examDay The day of the exam
     * @param examTime The session (FN/AN)
     */
    public ExamCourse(String courseCode, String courseName, String examDay, String examTime) {
    	this.courseCode = courseCode;
    	this.examDay = examDay;
    	this.courseName = courseName;
    	this.examTime = examTime;
    }

    /** @return The unique course code */
    public String getCourseCode() {
    	return courseCode;
        
    }

    /** @return The full name of the course */
    public String getCourseName() {
    	return courseName;
        
    }

    /** @return The scheduled day of the exam */
    public String getExamDay() {
    	return examDay;
        
    }

    /** @return The scheduled time slot (FN/AN) */
    public String getExamTime() {
    	return examTime;
        
    }

    /**
     * Updates the scheduled day for the exam.
     * @param examDay The new day to be set
     */
    public void setExamDay(String examDay) {
    	this.examDay = examDay;
    }

    /**
     * Updates the scheduled time slot for the exam.
     * @param examTime The new session (FN or AN) to be set
     */
    public void setExamTime(String examTime) {
    	this.examTime = examTime;
    }
}