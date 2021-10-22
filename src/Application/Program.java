package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.TaxPayment;
import services.contractService;
import services.onlinePayment;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		TaxPayment tp = new onlinePayment();		
		
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Enter number of installments: ");
		int numberOfInstallment = sc.nextInt();
		
		contractService cs = new contractService(new onlinePayment());
		
		cs.processContract(contract, numberOfInstallment);
		
		System.out.println("Installments: ");
		for(Installment it : contract.getInstallments()) {
			System.out.println(it);
			
		}
		
		
		
	
		
		
		
		
		
		sc.close();

	}

}
