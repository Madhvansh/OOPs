public class Company {

	/**
	 * Stores the name of the company.
	 */
	private String name;

	/**
	 * Stores the CGPA cutoff for PS2 selection.
	 */
	private Double cutoffCGPA;

	/**
	 * Stores the students selected by the company for PS1.
	 */
	private Student[] selectedStudentsPS1;

	/**
	 * Stores the students selected by the company for PS2.
	 */
	private Student[] selectedStudentsPS2;

	/**
	 * Stores the number of students currently selected for PS1.
	 */
	Integer studentCountPS1;

	/**
	 * Stores the total number of seats offered by the company for PS1.
	 */
	Integer SeatsPS1;

	/**
	 * Stores the number of students currently selected for PS2.
	 */
	Integer studentCountPS2;

	/**
	 * Stores the total number of seats offered by the company for PS2.
	 */
	Integer SeatsPS2;

	/**
	 * Constructs a Company object with the given details. Initializes all fields
	 * and allocates arrays for student selections.
	 *
	 * If {@code cutoffCGPA} is null, it is initialized to {@code 0}. If
	 * {@code SeatsPS1} or {@code SeatsPS2} is null, they are initialized to
	 * {@code 0}. This may occur if the company participates only in PS1 or PS2.
	 *
	 * Initializes the selected student counts to {@code 0}. Initializes both
	 * student arrays with appropriate sizes.
	 *
	 * @param name       the name of the company
	 * @param cutoffCGPA the CGPA cutoff (as String, converted to Double)
	 * @param SeatsPS1   number of seats for PS1 (as String, converted to Integer)
	 * @param SeatsPS2   number of seats for PS2 (as String, converted to Integer)
	 */
	public Company(String name, String cutoffCGPA, String SeatsPS1, String SeatsPS2) {
		this.name = name;

		if (cutoffCGPA == null) {
			this.cutoffCGPA = 0.0;
		}
		if (SeatsPS1 == null) {
			this.SeatsPS1 = 0;
		}
		if (SeatsPS2 == null) {
			this.SeatsPS2 = 0;
		}
		this.studentCountPS1 = 0;
		this.studentCountPS2 = 0;

		this.cutoffCGPA = Double.valueOf(cutoffCGPA);
		this.SeatsPS1 = Integer.valueOf(SeatsPS1);
		this.SeatsPS2 = Integer.valueOf(SeatsPS2);
		this.selectedStudentsPS1 = new Student[this.SeatsPS1];
		this.selectedStudentsPS2 = new Student[this.SeatsPS2];

	}

	/** @return the company name */
	public String getName() {
		return name;
	}

	/** @return the CGPA cutoff for the company */
	public Double getCutoffCGPA() {
		return cutoffCGPA;
	}

	/** @return the students selected for PS1 */
	public Student[] getPS1Students() {
		return selectedStudentsPS1;
	}

	/** @return the students selected for PS2 */
	public Student[] getPS2Students() {
		return selectedStudentsPS2;
	}

	/**
	 * Adds the specified student to the PS1 selected students list.
	 *
	 * There is no CGPA criterion for PS1. Eligibility criterion is NOT checked in
	 * this method. Simply add the student to the array. Hint: Do not forget to
	 * update the student's status.
	 *
	 * @param s the student to be added
	 * @return {@code true} if the student is successfully added, {@code false}
	 *         otherwise
	 */
	public boolean addStudentPS1(Student s) {
		if (s == null)
			return false;
		if (studentCountPS1 < SeatsPS1) {
			selectedStudentsPS1[studentCountPS1++] = s;
			s.gotPS = true;
			return true;
		}
		return false;

	}

	/**
	 * Adds the specified student to the PS2 selected students list.
	 *
	 * Checks whether the student's CGPA meets the {@link #cutoffCGPA}. No other
	 * eligibility criteria are considered. Simply add the student to the array.
	 * Hint: Do not forget to update the student's status.
	 *
	 * @param s the student to be added
	 * @return {@code true} if the student is successfully added, {@code false}
	 *         otherwise
	 */
	public boolean addStudentPS2(Student s) {
		if (s == null)
			return false;
		if (s.getCgpa() >= cutoffCGPA && (studentCountPS2 < SeatsPS2)) {

			selectedStudentsPS2[studentCountPS2++] = s;
			s.gotPS = true;
			return true;
		}
		return false;
	}
	
@Override
public String toString() {
	return "Name: " + "\"" + name + "\"" + 
			"Cutoff: " + cutoffCGPA +
			"SeatsPS1: " + "\"" + SeatsPS1 + "\"" + 
			"SeatsPS2: " + "\"" + SeatsPS2 + "\"" ; 
}

}