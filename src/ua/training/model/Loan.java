package ua.training.model;

import ua.training.view.TextConstans;
import ua.training.view.View;

public class Loan {
    private int loanDuration;
    private int loanAmount;
    private double interestRate;
    private double monthlyPayment;


    public void payMonthly(Account account) {
        account.withdrawMonthlyPayment((int) monthlyPayment);
        loanAmount -= monthlyPayment;
        loanDuration--;
    }



    public int getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = (int) (loanAmount + loanAmount * interestRate / 100);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void calculateMonthlyPayment() {
        this.monthlyPayment = loanAmount / loanDuration;
    }

    public void payOffTheLoan(Account account) {
        if (account.getMoneyAmount() > loanAmount) {
            account.setMoneyAmount(account.getMoneyAmount() - loanAmount);
            loanAmount = 0;
        } else {
            View.bundle.getString(TextConstans.ERROR_NO_MONEY);

        }
    }

    public void increaseLoanAmount() {
        //in developing
    }
}
