package ua.training.controller;

import ua.training.model.*;
import ua.training.view.TextConstans;
import ua.training.view.View;

import java.io.IOException;
import java.util.Scanner;

public class Controller implements TextConstans {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        ConditionSaverAndLoader saverAndLoader = new ConditionSaverAndLoader();
        Account account = new Account();
        Loan loan = new Loan();
        Scanner sc = new Scanner(System.in);
        try {
            if (!saverAndLoader.loadCondition(account, loan)) {
                takeLoan();
            } else operateWithLoan();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void operateWithLoan() {

    }

    private void takeLoan() {
        view.printMessage(TAKE_LOAN);
        for (Bank bank : Bank.values()) {
            view.printMessage(bank.toString());
        }
    }
}
