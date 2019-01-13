package model.services;

public class PaypalTaxService implements OnlinePaymentService {

    private static final double TAX = 0.02;
    private static final double MONTHLY_INTEREST = 0.01;

    public double paymentTax(double amount) {
        return amount * this.TAX;
    }

    public double interest(double amount, int quotaNumber) {
        return amount * (this.MONTHLY_INTEREST * quotaNumber);
    }

}
