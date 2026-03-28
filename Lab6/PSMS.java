public class PSMS {

	/**
	 * Stores all students in the system.
	 */
	private Student[] students;

	/**
	 * Stores all companies offering PS.
	 */
	private Company[] companies;

	/**
	 * Stores the current number of students.
	 */
	private int studentCount;

	/**
	 * Stores the current number of companies.
	 */
	private int companyCount;

	/**
	 * Maximum limit on number of students that can be stored.
	 */
	static final int MAX_STUDENTS = 200;

	/**
	 * Maximum limit on number of companies that can be stored.
	 */
	static final int MAX_COMPANIES = 50;

	/**
	 * Default company allotted during PS1 if a student is not allotted to any
	 * preferred company.
	 */
	Company defaultCompany;

	/**
	 * Nested class responsible for handling PS1 allocation.
	 */
	public PS1 ps1;

	/**
	 * Nested class responsible for handling PS2 allocation.
	 */
	public PS2 ps2;

	/**
	 * Constructs the PSMS system and initializes all components.
	 *
	 * Initializes {@link #students} and {@link #companies} arrays with maximum
	 * capacity defined by {@link #MAX_STUDENTS} and {@link #MAX_COMPANIES}.
	 *
	 * Sets {@link #studentCount} and {@link #companyCount} to {@code 0}.
	 *
	 * Creates instances of {@link PS1} and {@link PS2}.
	 *
	 * Initializes {@link #defaultCompany} with:
	 * <ul>
	 * <li>Name: Army Base Camp 505</li>
	 * <li>Cutoff: {@code null}</li>
	 * <li>SeatsPS1: "500"</li>
	 * <li>SeatsPS2: {@code null}</li>
	 * </ul>
	 */
	public PSMS() {
		this.students = new Student[MAX_STUDENTS];
		this.companies = new Company[MAX_COMPANIES];
		this.defaultCompany = new Company ("Army Base Camp 505", null, "500", null);
		this.ps1 = new PS1();
		this.ps2 = new PS2();
	
		studentCount = 0;
		companyCount = 0;
		
	}

	/** @return the students array */
	public Student[] getStudents() {
		return students;
	}

	/** @return the companies array */
	public Company[] getCompanies() {
		return companies;
	}

	/** @return the students count */
	public int getStudentCount() {
		return studentCount;
	}

	/** @return the companies count */
	public int getCompanyCount() {
		return companyCount;
	}

	/**
	 * Adds a {@link Student} to the system.
	 *
	 * @param s the student to be added
	 * @return {@code true} if the student is successfully added, {@code false}
	 *         otherwise
	 */
	public boolean addStudent(Student s) {
		if (s == null)
			return false;
		if (studentCount < MAX_STUDENTS) {
			students[studentCount++] = s;
			
			return true;
		}
		return false;
	}

	/**
	 * Adds a {@link Company} to the system.
	 *
	 * @param c the company to be added
	 * @return {@code true} if the company is successfully added, {@code false}
	 *         otherwise
	 */
	public boolean addCompany(Company c) {
		if (c == null)
			return false;
		if (companyCount < MAX_COMPANIES) {
			companies[companyCount++] = c;
			
			return true;
		}
		return false;
	}

	/**
	 * Sorts an array of Student objects in descending order of CGPA (you can use
	 * the Bubble Sort algorithm) Assume unique CGPAs
	 *
	 * @param students     the array of Student objects to be sorted
	 * @param studentCount the number of valid Student objects in the array
	 */
	public void sortStudentsByCGPA(Student[] students, int studentCount) {
		Student [] arr = new Student[studentCount];
		for(int i = 0; i < studentCount; i ++)
		{
			if (students[i].getCgpa() > students[i+1].getCgpa())
			{
				arr[i] = students[i];
			}
			else
			{
				arr[i] = students[i+1];
			}
		}
		students = arr;
	}

	public class PS1 {

		/**
		 * Simulates the PS1 allocation process.
		 *
		 * Sorts the students list in decreasing order of CGPAs. Traverses
		 * {@link PSMS#students} and processes each student:
		 * <ol>
		 * <li>Checks if the student is not null and is eligible for PS1</li>
		 * <li>If eligible, retrieves the priority order of the student</li>
		 * <li>Traverses the priority list in order</li>
		 * <li>For each company in the list, attempts to assign the company to the
		 * student</li>
		 * <li>If allocation is successful, stops further attempts for that student</li>
		 * <li>If no company is assigned, assigns {@link PSMS#defaultCompany}</li>
		 * </ol>
		 */
		void simulatePS1() {
			sortStudentsByCGPA(students, studentCount);
			for(int i = 0; i < studentCount; i++)
			{
				if (students[i] != null && students[i].eligibleForPS1())
				{
					int count = 0;
					Company[] priority_comp = new Company[companyCount];
					for(int j = 0; j < companyCount; j ++)
					{
					priority_comp = students[i].getPriorityOrder();

				}
				}
			}
		}
	}

	public class PS2 {

		/**
		 * Simulates the PS2 allocation process.
		 *
		 * Sorts the students list in decreasing order of CGPAs. Traverses
		 * {@link PSMS#students} and processes each student:
		 * <ol>
		 * <li>Checks if the student is not null and is eligible for PS2</li>
		 * <li>If eligible, retrieves the priority order of the student</li>
		 * <li>Traverses the priority list in order</li>
		 * <li>For each company in the list, attempts to assign the company to the
		 * student</li>
		 * <li>If allocation is successful, stops further attempts for that student</li>
		 * <li>If no company is assigned, assigns thesis</li>
		 * </ol>
		 */
		void simulatePS2() {
			sortStudentsByCGPA(students, studentCount);
			for(int i = 0; i < studentCount; i++)
			{
				if (students[i] != null && students[i].eligibleForPS2())
				{
					int count = 0;
					Company[] priority_comp = new Company[count];
					for(int j = 0; j < companyCount; j ++)
					{
					priority_comp = students[i].getPriorityOrder();
					
				}
				}
			}
		}
			
			// WRITE YOUR CODE HERE
		}
	

}