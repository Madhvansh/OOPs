/**
 * 
 *
 * This class represents a ride in the amusement park.
 * It stores ride requirements and how the ride affects students.
 *
 * 
 */
public class Ride {

	/** Name of the ride */
	private String name;

	/** Minimum height required to take the ride */
	private int minHeightCm;

	/** Amount of energy a student loses after taking this ride */
	private int energyCost;

	/** Ticket cost of the ride */
	private int ticketCost;

	/** Nausea intensity of the ride */
	private int nauseaIntensity;

	/** Scariness of the ride */
	private int scareLevel;

	/**
	 * Constructor to initialise all ride fields.
	 *
	 * @param name ride name
	 * @param minHeightCm minimum height required
	 * @param energyCost energy cost of ride
	 * @param ticketCost ticket cost of ride
	 * @param nauseaIntensity nausea intensity of ride
	 * @param scareLevel scare level of ride
	 */
	public Ride(String name, int minHeightCm, int energyCost, int ticketCost,
			int nauseaIntensity, int scareLevel) { this.name = name; this.minHeightCm = minHeightCm; this.energyCost = energyCost; this.ticketCost = ticketCost;
			this.nauseaIntensity = nauseaIntensity; this.scareLevel = scareLevel;

	}

	/**
	 * Returns the ride name.
	 *
	 * @return ride name
	 */
	public String getName() {
		return this.name;

	}

	/**
	 * Returns the minimum height required.
	 *
	 * @return minimum height in cm
	 */
	public int getMinHeightCm() {
		return this.minHeightCm;

	}

	/**
	 * Returns the energy cost of the ride.
	 *
	 * @return energy cost
	 */
	public int getEnergyCost() {
		return this.energyCost;

	}

	/**
	 * Returns the ticket cost of the ride.
	 *
	 * @return ticket cost
	 */
	public int getTicketCost() {
		return this.ticketCost;

	}

	/**
	 * Returns the nausea intensity of the ride.
	 *
	 * @return nausea intensity
	 */
	public int getNauseaIntensity() {
		return this.nauseaIntensity;

	}

	/**
	 * Returns the scare level of the ride.
	 *
	 * @return scare level
	 */
	public int getScareLevel() {
		return this.scareLevel;

	}

	/**
	 * Calculates how much nausea the ride increases for the given student.
	 *
	 * <p> Nausea Calculation:
	 * <p> nauseaIncrease = nauseaIntensity × nauseaSensitivity × 1.5
	 *
	 * @param s the student
	 * @return nausea increase value
	 */
	public int calculateNauseaIncrease(Student s) {
		return (int)(s.getNauseaSensitivity()*getScareLevel()*1.5);

	}

	/**
	 * Calculates how much fear changes for the given student.
	 *
	 * <p>Fear Calculation:
	 * <p>fearIncrease = scareLevel × 1.5
	 * <p>fearDecrease = ridesTaken × bravery
	 * <p>fearChange = fearIncrease − fearDecrease
	 *
	 * @param s the student
	 * @return fear change (can be negative)
	 */
	public int calculateFearChange(Student s) {
		double fearIncrease = getScareLevel() * 1.5;
		double fearDecrease = s.getRidesTaken()*s.getBravery();
		return (int)(fearIncrease-fearDecrease);

	}

	/**
	 * Checks whether a student is eligible to take this ride.
	 *
	 * <p>A student is eligible only if:
	 * <p>1. The student meets the minimum height requirement.
	 * <p>2. The student has enough energy for the ride.
	 * <p>3. The student has enough pocket money to pay the ticket cost.
	 * <p>4. The student's current nauseaLevel + nausea increase from this ride is below 50.
	 * <p>5. The student's current fearLevel + fear change from this ride is below 50.
	 *
	 * @param s the student attempting the ride
	 * @return true if the student is eligible, false otherwise
	 */
	public boolean isEligible(Student s) {
		if (getMinHeightCm() >= s.getHeightCm() && (s.getEnergy() - getEnergyCost()) >= 0 && (s.getPocketMoney() - getTicketCost()) >= 0
				&& (s.getNauseaLevel() + calculateNauseaIncrease(s)) < 50 && (s.getFearLevel() + calculateFearChange(s)) < 50) {
			return true;
		}
		else
		{
			return false;
		}
			
		}

	/**
	 * Applies the ride effects on the student.
	 *
	 * <p>Remember, eligibility has already been checked above.
	 *
	 * <p>Updates performed:
	 * <p>- energy decreases by energyCost
	 * <p>- pocket money decreases by ticketCost
	 * <p>- nausea increases by nauseaIncrease
	 * <p>- fear changes by fearChange (fear clamps to 0 if negative)
	 * <p>- ridesTaken increments by 1
	 *
	 * @param s the student
	 */
	public void applyRideEffects(Student s) {
		s.updateEnergy(energyCost);
		s.updatePocketMoney(ticketCost);
		s.updateNausea(calculateNauseaIncrease(s));
		s.updateFear(calculateFearChange(s));
		s.incrementRidesTaken();

	}

	/**
	 * Attempts to let the student take this ride.
	 *
	 * If the student is eligible, apply ride effects and return true.
	 * Otherwise, no changes are made and return false.
	 *
	 * @param s the student attempting the ride
	 * @return true if the ride is successfully taken, false otherwise
	 */
	public boolean takeRide(Student s) {
		if(isEligible(s) == true) {
			applyRideEffects(s);
			return true;
		}
		else
		{
			return false;
		}

	}
}
