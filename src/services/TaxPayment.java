package services;

public interface TaxPayment {
	
		double paymenteFee(double amount);
		
		double interest(double amount, int months);
		

}
