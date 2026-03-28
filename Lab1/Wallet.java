/**
 * Represents a student's digital wallet containing their transaction history.
 */
public class Wallet {
    private String ownerName;
    private String bitsID;
    private Transaction[] history;
    private int count;

    /**
     * Constructor initializing the wallet and history array.
     */
    public Wallet(String ownerName, String bitsID, int capacity) {
        this.ownerName = ownerName;
        this.bitsID = bitsID;
        this.history = new Transaction[capacity];
        this.count = 0; 
    }

    /**
     * Adds a transaction to the history if space is available.
     */
    public boolean addTransaction(Transaction t) {
    	
    	if (count < history.length ) {
    		count ++;
    		return true;
    			
    	}
    	return false;

    	
    }

    public Transaction[] getHistory() {
    	return history;
    	
    }

    public int getCount() {
        return count;
    } 
    
    public char getCampus() {
    	return bitsID.charAt(bitsID.length()-1);
    	
    }

    public String getOwnerName() {
        return ownerName;
    }
    
    /**
     * Extracts the last four numeric digits of the bitsID (the 4 digits after the PS and before the campus character)
     */
    public short getShortCode() {
    	String number = bitsID.substring(8,12);
    	int id = Integer.parseInt(number);
    	return (short)id;
    	
    }
      
    // Returns the sum of the ACSII values of the campus character and the shortCode 
    public int calculateCreditScore() {
    	return getCampus() + getShortCode();
    	
    }
      
}