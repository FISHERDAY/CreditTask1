package ua.training.controller;

import ua.training.model.*;
import ua.training.view.TextConstans;
import ua.training.view.View;

import java.util.Scanner;

public class Controller implements TextConstans {
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void processUser() {
        ConditionSaverAndLoader saverAndLoader = new ConditionSaverAndLoader();
        Account account = new Account();
        Loan loan = new Loan();
        Scanner sc = new Scanner(System.in);
        if (!saverAndLoader.loadCondition(account, loan)) {
            takeLoan(sc);
        } else operateWithLoan();

    }

    private void operateWithLoan() {

    }

    private void takeLoan(Scanner sc) {
        view.printMessage(TAKE_LOAN);
        for (Bank bank : Bank.values()) {
            view.printMessage(bank.toString());
        }
        int loanAmount = inputIntValue(INPUT_LOAN_AMOUNT, sc);
        int loanDuration = inputIntValue(INPUT_LOAN_DURATION, sc);
        double interestRate = inputDoubleValue(INPUT_LOAN_INTEREST_RATE, sc);



        view.printMessage(INPUT_LOAN_AMOUNT);
        while (!sc.hasNext()) {
            view.printMessage(WRONG_DATA_INT);
            sc.next();
        }


    }

    private int inputIntValue(String inputLoanDuration, Scanner sc) {
        view.printMessage(INPUT_LOAN_AMOUNT);
        String input = "";
        while (!sc.hasNext()) {
            view.printMessage(WRONG_DATA_INT);
            input = sc.next();
        }
        return Integer.parseInt(input);
    }

    private double inputDoubleValue(String inputLoanDuration, Scanner sc) {
        view.printMessage(INPUT_LOAN_AMOUNT);
        String input = "";
        while (!sc.hasNext()) {
            view.printMessage(WRONG_DATA_INT);
            input = sc.next();
        }
        return Double.parseDouble(input);
    }

}