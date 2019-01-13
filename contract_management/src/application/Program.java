package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalTaxService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter contract data:");
        System.out.print("Number: ");
        int number = sc.nextInt();

        sc.nextLine();

        System.out.print("Date (dd/MM/yyyy): ");
        Date date = sdf.parse(sc.nextLine());

        System.out.print("Contract value: ");
        double value = sc.nextDouble();

        System.out.print("Enter number of installments: ");
        int numberOfInstallments = sc.nextInt();

        Contract contract = new Contract(number, date, value);

        ContractService contractService = new ContractService(new PaypalTaxService());
        contractService.processContract(contract, numberOfInstallments);

        for (Installment installment : contract.getInstallmentList()) {
            System.out.println(installment);
        }

        sc.close();

    }

}
