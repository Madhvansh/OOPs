/**
 * Provides utility methods for processing wallet data and currency.
 */
public class Processor {
	
	
	// For reference on how to extract transactions array from a wallet object
	public Transaction[] getTransactions(Wallet w) {
		Transaction[] txns = w.getHistory();
		return txns;
	}

    /**
     * Calculates the net balance by iterating through history.
     * 'C' adds amount; 'D' subtracts amount and processing fee.
     * If balance turns out to be negative, return -1.
     */
    public double calculateBalance(Wallet w) {
    	int total = 0; 

    		
    	
    	
    	return -1;
    }

    /**
     * Multiplies the given amount with 1.5 and then returns the product as an int
     */
    public int convertToTokens(double amount) {
    	double mul = amount * 1.5;
    	return (int)mul;
    	
    }
    
    /**
     * Determines eligibility for upgrade based on creditScore + Balance
     */
    public boolean isEligibleForUpgrade(Wallet w) {
    	double sum = calculateBalance(w) + w.calculateCreditScore();
    	if((int)sum >= 100) {
    		return true;
    	}
    	return false;
    	
    }

}