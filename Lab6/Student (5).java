public class Student {

	/**
	 * Stores the name of the student.
	 */
	private String name;

	/**
	 * Stores the ID of the student in BITS format (e.g., 2024AAPS0001G). Assume
	 * only single degree IDs.
	 */
	private String id;

	/**
	 * Stores the CGPA of the student.
	 */
	private Double cgpa;

	/**
	 * Stores the priority order of companies given by the student.
	 */
	private Company[] priorityOrder;

	/**
	 * Indicates if the student has been allotted a PS station.
	 */
	Boolean gotPS;

	/**
	 * Indicates if the student has been placed.
	 */
	Boolean placed;

	/**
	 * Constructor to initialize the student. Initializes all fields with given
	 * arguments. Sets {@link #gotPS} and {@link #placed} to false. If
	 * {@link #priorityOrder} is null, initializes it as an empty array of type
	 * {@link Company}.
	 *
	 * @param name          the name of the student
	 * @param id            the ID of the student in BITS format
	 * @param cgpa          the CGPA of the student (as String, converted to Double)
	 * @param priorityOrder the priority order of companies
	 */
	public Student(String name, String id, String cgpa, Company[] priorityOrder) {
		this.name = name;
		this.id = id;
		this.cgpa = Double.valueOf(cgpa);
		this.priorityOrder = priorityOrder;
		
		  if (priorityOrder == null)  
			  {this.priorityOrder = new Company[0];
			  }
		gotPS = false;
		placed = false;
	}

	/** @return the name of the student */
	public String getName() {
		return name;
	}

	/** @return the ID of the student */
	public String getID() {
		return id;
	}

	/** @return the CGPA of the student */
	public Double getCgpa() {
		return cgpa;
	}

	/** @return the Priority Order of the student */
	public Company[] getPriorityOrder() {
		return priorityOrder;
	}

	/**
	 * Extracts and returns the branch code from the student ID.
	 *
	 * The branch code is the two-letter code present in the ID. For example,
	 * "2024AAPS0001G" returns "AA".
	 *
	 * @return the branch code of the student
	 */
	public String getBranch() {
		return id.substring(4, 6);
	}

	/**
	 * Checks whether the student is eligible for PS1.
	 *
	 * Eligibility criterion: Student must belong to the 2024 batch.
	 *
	 * @return true if eligible, false otherwise
	 */
	public boolean eligibleForPS1() {
		if (id.substring(0, 4).equals("2024"))
			return true;
		return false;

		// WRITE YOUR CODE HERE
	}

	/**
	 * Checks whether the student is eligible for PS2.
	 *
	 * Eligibility criteria: 1. Student must belong to the 2022 batch 2. Student
	 * must not be placed (PS Lock) 3. Student must not be registered for thesis
	 *
	 * @return true if eligible, false otherwise
	 */
	public boolean eligibleForPS2() {
		if (id.substring(0, 4).equals("2022") && placed == false && !id.substring(6, 8).equals("TS")) {
			return true;
		}
		return false;
		// WRITE YOUR CODE HERE
	}

	/**
	 * Registers the student for Thesis by modifying the ID.
	 *
	 * Replaces the "PS" part of the ID with "TS". For example, "2024AAPS0001G"
	 * becomes "2024AATS0001G".
	 */
	public void changeIDToThesis() {
		id.replace("PS","TS");
		
		// WRITE YOUR CODE HERE
	}

}