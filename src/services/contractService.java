package services;



import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class contractService {

		private TaxPayment taxpayment;
	
		
		
		public contractService(TaxPayment taxpayment) {
			this.taxpayment = taxpayment;
			
		}

		
		public void processContract( Contract contract, int months) {
			double basicQuota =contract.getTotalValue() / months;
			for(int i =1; i<=months; i++) {
				double uptadeQuota = basicQuota + taxpayment.interest(basicQuota, i);
				double finalQuota = uptadeQuota + taxpayment.paymenteFee(uptadeQuota);
				Date dueDate = addMonths(contract.getDate(), i);
				contract.getInstallments().add(new Installment(dueDate, finalQuota));
				
			}
				
		}

	
		private Date addMonths(Date date, int N) {
			Calendar calendar= Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MONTH, N);
			return calendar.getTime();
		}
		
		
}
