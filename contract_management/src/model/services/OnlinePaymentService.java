package model.services;

public interface OnlinePaymentService {

    public double paymentTax(double amount);

    public double interest(double amount, int quotaNumber);

}
