package ua.training.model;

public class Account {
    private int accountNumber;
    private int moneyAmount = 5000;


    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public boolean withdrawMonthlyPayment(int monthlyPayment) {
        if ((moneyAmount - monthlyPayment) < 0) {
            return false;
        } else {
            setMoneyAmount(moneyAmount - monthlyPayment);
        }
        return true;
    }

}
