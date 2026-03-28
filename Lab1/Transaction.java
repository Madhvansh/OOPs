/**
 * Represents a single financial transaction in the BITS-Pay system.
 */
public class Transaction {
    private String transactionID;
    private double amount;
    private char type; // 'C' for Credit, 'D' for Debit
    private boolean isInternational;

    /**
     * Constructor to initialize all transaction fields.
     */
    public Transaction(String transactionID, double amount, char type, boolean isInternational) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.type = type;
        this.isInternational = isInternational;
    }

    public double getAmount() {
        return amount;
    }

    public char getType() {
        return type;
    	
    }

    public boolean isInternational() {
    	return isInternational;
    	
    }

    /**
     * Returns 5 if the transaction is international, 0 otherwise.
     */
    public int getProcessingFee() {
    	if(isInternational()== true)
    	{
    		return 5;
    	}
    	else
    	{
    		return 0;
    	}
    	
    }

    /**
     * Extracts the category (first 3 characters) from the transactionID and return them.
     */
    public String getCategory() {
    	return transactionID.substring(0,3);
    	
    }
      
}