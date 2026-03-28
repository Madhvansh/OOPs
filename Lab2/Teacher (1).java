/**
 * This class manages an amusement park trip for a group of students.
 * It controls the ride simulation and keeps track of:
 * - students sent back to the bus
 * - students sent to first aid
 * - total money spent on rides
 *
 * Misbehaving students must be removed from the active student list
 * before the trip simulation begins.
 */
public class Teacher {

	/** Active list of students participating in the trip */
	private Student[] students;

	/** Number of currently active students */
	private int studentCount;

	/** All rides available in the amusement park */
	private Ride[] rides;

	/** Students who are sent back to the bus */
	private Student[] sendBackToBus;

	/** Students who are sent to first aid */
	private Student[] firstAid;

	/** Number of students sent back to the bus, zero initially */
	private int busCount;

	/** Number of students sent to first aid, zero initially */
	private int firstAidCount;

	/** Total money spent by all students on rides, zero initially */
	private int totalMoneySpent;

	/**
	 * Constructs a Teacher object with the given students and rides.
	 *
	 * @param students all students going on the trip
	 * @param rides all rides available in the park
	 */
	public Teacher(Student[] students, Ride[] rides) {
		this.students = students;
		this.studentCount = students.length;
		this.rides = rides;
		

	}

	/**
	 * Removes all students who are misbehaving and sends them to the bus.
	 *
	 * Misbehaving students are:
	 * <p> - added to sendBackToBus[]
	 * <p> - removed from the active students list
	 */
	private void removeMisbehavingStudents() {
		for (int i = 0; i < students.length; i++)
		{
			if (students[i].isMisbehaving() == true)
			{
				sendBackToBus[busCount++] = students[i];
				studentCount--;
			}
		}
		
	}
	
	/**
	 * Sends students to first aid if:
	 * nauseaLevel >= 45 OR
	 * fearLevel >= 45.
	 *
	 * 
	 */
	private void sendToFirstAid() {
		for (int i = 0; i < students.length; i++)
		{
			if (students[i].getNauseaLevel() >=45 || students[i].getFearLevel() >=45)
			{
				firstAid[firstAidCount++] = students[i];

			}
		}
	
			
		
		

	}

	/**
	 * Simulates the entire amusement park trip.
	 *
	 * <p>Rules to follow:
	 *
	 * <p>0. First, remove all misbehaving students and send them back to bus.
	 *
	 * <p>1. For each remaining student:
	 * <p>- If the student does not have a permission slip,
	 * <p>  send them back to bus immediately.
	 *
	 * <p>2. Otherwise, the student attempts rides in order:
	 * <p>- A student may take at most 3 successful rides.
	 * <p>- For each successful ride, the ride's ticket cost
	 *      must be added to totalMoneySpent.
	 *
	 * <p>3. If a student finishes all ride attempts without
	 *       successfully taking even one ride, send them back to bus.
	 *
	 * <p>4. After all students are processed, students with:
	 * <p> nauseaLevel >= 45 OR
	 * <p> fearLevel >= 45
	 * <p>must be sent to first aid.
	 */

	public void conductTrip() {
		this.removeMisbehavingStudents();
		for (int i = 0; i < students.length; i++)
		{
			int count = 0;
		
			if (students[i].hasPermissionSlip() == false) {
				sendBackToBus[busCount++] = students[i];
				
			}
			if(rides[i].isEligible(students[i]) && count < 3 )
			{
				rides[i].applyRideEffects(null);
				totalMoneySpent +=rides[i].getTicketCost();
			}
			if (rides[i].takeRide(students[i]) == false)
			{
				sendBackToBus[busCount++] = students[i];
			}
		
			
		}
		
				
		
		this.sendToFirstAid();


	}

	

	/**
	 * Returns the array of students sent back to the bus.
	 *
	 * @return array of students sent back to the bus
	 */
	public Student[] getSendBackToBus() {
		return this.sendBackToBus;

	}

	/**
	 * Returns the array of students sent to first aid.
	 *
	 * @return array of students sent to first aid
	 */
	public Student[] getFirstAid() {
		return this.firstAid;

	}

	/**
	 * Returns the total money spent on rides.
	 *
	 * @return total money spent
	 */
	public int getTotalMoneySpent() {
		return this.totalMoneySpent;

	}

	/**
	 * Returns the number of students sent back to the bus.
	 *
	 * @return number of students sent back
	 */
	public int getBusCount() {
		return this.busCount;

	}

	/**
	 * Returns the number of students sent to first aid.
	 *
	 * @return number of students sent to first aid
	 */
	public int getFirstAidCount() {
		return this.firstAidCount;

	}

	/**
	 * Returns the number of currently active students.
	 *
	 * @return number of active students
	 */
	public int getStudentCount() {
		return this.studentCount;

	}
}
