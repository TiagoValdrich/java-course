package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.util.Calendar;

public class ContractService {

    private OnlinePaymentService taxService;

    public ContractService(OnlinePaymentService taxService) {
        this.taxService = taxService;
    }

    public void processContract(Contract contract, int months) {
        double valuePerQuota = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(contract.getDate());
            calendar.add(Calendar.MONTH, i);

            double valueWithInterest = valuePerQuota + this.taxService.interest(valuePerQuota, i);
            double valueWithPaymentTax = valueWithInterest + this.taxService.paymentTax(valueWithInterest);

            contract.addInstallment(new Installment(calendar.getTime(), valueWithPaymentTax));
        }
    }

}
