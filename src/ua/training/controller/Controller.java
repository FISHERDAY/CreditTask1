package ua.training.controller;

import ua.training.model.*;
import ua.training.view.TextConstans;
import ua.training.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller implements TextConstans {
    private View view;
    private Loan loan;
    private Account account;

    public Controller(View view, Loan loan, Account account) {
        this.view = view;
        this.loan = loan;
        this.account = account;
    }

    public void processUser() {
        ConditionSaverAndLoader saverAndLoader = new ConditionSaverAndLoader();
        Scanner sc = new Scanner(System.in);
        if (!saverAndLoader.loadCondition(account, loan)) {
            takeLoan(sc, loan);
        }

        chooseAction(sc);

        try {
            saverAndLoader.saveCondition(account, loan);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void chooseAction(Scanner sc) {
        view.printMessage(View.bundle.getString(CHOOSE_ACTION));
        view.printMessage(View.bundle.getString(PAY_MONTHLY));
        view.printMessage(View.bundle.getString(PAY_OFF_THE_LOAN));
        view.printMessage(View.bundle.getString(EXIT));

        String choosedAction = sc.next();
        while (!choosedAction.matches("[0-9]+") && Integer.parseInt(choosedAction) <= 4 && Integer.parseInt(choosedAction) > 0) {
            view.printMessage(View.bundle.getString(WRONG_DATA_INT));
            choosedAction = sc.next();
        }

        switch (Integer.parseInt(choosedAction)) {
            case (1):
                loan.payMonthly(account);
            case (2):
                loan.payOffTheLoan(account);
            case (3):
                exit();
            case (4):
                loan.increaseLoanAmount();
        }


    }

    private void exit() {
        View.bundle.getString(TextConstans.GOODBYE);
        System.exit(0);
    }

    private void takeLoan(Scanner sc, Loan loan) {
        view.printMessage(View.bundle.getString(TAKE_LOAN));
        for (Bank bank : Bank.values()) {
            view.printMessage(bank.toString());
        }
        int loanAmount = inputIntValue(View.bundle.getString(INPUT_LOAN_AMOUNT), sc);
        int loanDuration = inputIntValue(View.bundle.getString(INPUT_LOAN_DURATION), sc);
        double interestRate = inputDoubleValue(View.bundle.getString(INPUT_LOAN_INTEREST_RATE), sc);

        //HashMap<Integer, Bank> banks = new HashMap<>();
        ArrayList<Bank> banks = new ArrayList<>();

        int counter = 0;
        for (Bank bank : Bank.values()) {
            if (bank.loanAmount() >= loanAmount && bank.interestRate() <= interestRate && bank.maxDuration() <= loanDuration + 1 && bank.maxDuration() <= loanDuration - 1) {
                banks.add(bank);
                //counter++;
            }
        }

        view.printMessage(View.bundle.getString(BANKS_FOR_YOU));
        for (int i = 0; i < banks.size(); i++) {
            view.printMessage((i) + " " + banks.get(i));
        }


        view.printMessage(View.bundle.getString(CHOOSE_THE_BANK));
        String choosedBank = sc.next();
        while (!choosedBank.matches("[0-9]+") && Integer.parseInt(choosedBank) < 0 && Integer.parseInt(choosedBank) > banks.size()) {
            view.printMessage(View.bundle.getString(WRONG_DATA_INT));
            choosedBank = sc.next();
        }

        //banks.get(Integer.parseInt(choosedBank)).loanAmount();
        //System.out.println(yourBank.toString());
        loan.setLoanAmount(banks.get(Integer.parseInt(choosedBank)).loanAmount());
        loan.setInterestRate(banks.get(Integer.parseInt(choosedBank)).interestRate());
        loan.setLoanDuration(banks.get(Integer.parseInt(choosedBank)).maxDuration());
        loan.calculateMonthlyPayment();

        System.out.println("amount = " + loan.getLoanAmount() + " interest rate = " + loan.getInterestRate() + " duration = " + loan.getLoanDuration());
    }

    private int inputIntValue(String inputText, Scanner sc) {
        view.printMessage(inputText);
        String result = sc.next();
        while (!result.matches("[0-9]+")) {
            view.printMessage(View.bundle.getString(WRONG_DATA_INT));
            result = sc.next();
        }
        return Integer.parseInt(result);
    }

    private double inputDoubleValue(String inputText, Scanner sc) {
        view.printMessage(inputText);
        String result = sc.next();
        while (!result.matches("([0-9]+).?([0-9]+)?")) {
            view.printMessage(View.bundle.getString(WRONG_DATA_INT));
            result = sc.next();
        }
        return Double.parseDouble(result);
    }

}