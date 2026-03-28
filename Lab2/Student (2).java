/**
 *
 * This class represents a student going on the amusement park trip.
 * It stores personal attributes and tracks how rides affect the student.
 *
 */
public class Student {

	/** Student's name */
	private String name;

	/** Whether the student has a signed permission slip */
	private boolean permissionSlip;

	/** Whether the student is misbehaving */
	private boolean isMisbehaving;

	/** Student's height in centimeters */
	private int heightCm;

	/** Student's current energy level */
	private int energy;

	/** Student's current nausea level */
	private int nauseaLevel;

	/** Student's nausea sensitivity */
	private int nauseaSensitivity;

	/** Student's current fear level */
	private int fearLevel;

	/** Student's bravery */
	private int bravery;

	/** Student's pocket money */
	private int pocketMoney;

	/** Number of rides taken by the student, initialized to zero */
	private int ridesTaken;

	/**
	 * Constructor to initialise all student fields.
	 *
	 * @param name student's name
	 * @param permissionSlip whether the permission slip is signed
	 * @param isMisbehaving whether the student is misbehaving
	 * @param heightCm student's height in centimeters
	 * @param energy starting energy level
	 * @param nauseaLevel starting nausea level
	 * @param nauseaSensitivity student's nausea sensitivity
	 * @param fearLevel starting fear level
	 * @param bravery student's bravery
	 * @param pocketMoney student's starting pocket money
	 */
	public Student(String name, boolean permissionSlip, boolean isMisbehaving,
			int heightCm, int energy, int nauseaLevel, int nauseaSensitivity,
			int fearLevel, int bravery, int pocketMoney) {
		this.name = name;
		this.permissionSlip = permissionSlip;
		this.isMisbehaving = isMisbehaving;
		this.heightCm = heightCm;
		this.energy = energy;
		this.nauseaLevel = nauseaLevel;
		this.nauseaSensitivity = nauseaSensitivity;
		this.fearLevel = fearLevel;
		this.bravery = bravery;
		this.pocketMoney = pocketMoney;

	}

	/**
	 * Returns the student's name.
	 *
	 * @return student name
	 */
	public String getName() {
		return this.name;

	}

	/**
	 * Returns whether the student has a signed permission slip.
	 *
	 * @return true if permission slip is signed, false otherwise
	 */
	public boolean hasPermissionSlip() {
		return this.permissionSlip;

	}

	/**
	 * Returns whether the student is misbehaving.
	 *
	 * @return true if student is misbehaving, false otherwise
	 */
	public boolean isMisbehaving() {
		return this.isMisbehaving;
		

	}

	/**
	 * Returns the student's height in centimeters.
	 *
	 * @return height in cm
	 */
	public int getHeightCm() {
		return this.heightCm;

	}

	/**
	 * Returns the student's current energy level.
	 *
	 * @return energy level
	 */
	public int getEnergy() {
		return this.energy;

	}

	/**
	 * Returns the student's current nausea level.
	 *
	 * @return nausea level
	 */
	public int getNauseaLevel() {
		return this.nauseaLevel;

	}

	/**
	 * Returns the student's nausea sensitivity.
	 *
	 * @return nausea sensitivity
	 */
	public int getNauseaSensitivity() {
		return this.nauseaSensitivity;

	}

	/**
	 * Returns the student's current fear level.
	 *
	 * @return fear level
	 */
	public int getFearLevel() {
		return this.fearLevel;

	}

	/**
	 * Returns the student's bravery value.
	 *
	 * @return bravery
	 */
	public int getBravery() {
		return this.bravery;

	}

	/**
	 * Returns the student's pocket money.
	 *
	 * @return pocket money
	 */
	public int getPocketMoney() {
		return this.pocketMoney;

	}

	/**
	 * Returns how many rides the student has taken so far.
	 *
	 * @return rides taken
	 */
	public int getRidesTaken() {
		return this.ridesTaken;

	}

	/**
	 * Updates the student's energy by the given amount.
	 *
	 * @param amount amount to add (negative amount decreases energy)
	 */
	public void updateEnergy(int amount) {
		this.energy+=amount;


	}

	/**
	 * Updates the student's nausea level by the given amount.
	 *
	 * @param amount amount to add
	 */
	public void updateNausea(int amount) {
		this.nauseaLevel+=amount;

	}

	/**
	 * Updates the student's fear level by the given amount.
	 *
	 * Fear is not allowed to go below 0.
	 * If fear becomes negative, it is clamped back to 0.
	 * note - if amount is negative, fear decreases
	 *
	 * @param amount amount to add 
	 */
	public void updateFear(int amount) {
		this.fearLevel+=amount;
		if (fearLevel < 0) {fearLevel = 0;}

	}

	/**
	 * Updates the student's pocket money by the given amount.
	 * note - if amount is negative, pocket money decreases
	 *
	 * @param amount amount to add
	 */
	public void updatePocketMoney(int amount) {
		this.pocketMoney+=amount;
		

	}

	/**
	 * Increments the student's ride count by 1.
	 */
	public void incrementRidesTaken() {
		this.ridesTaken++;

	}
}
