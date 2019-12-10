package ua.training;

import ua.training.controller.Controller;
import ua.training.model.Account;
import ua.training.model.Loan;
import ua.training.view.View;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new View(), new Loan(), new Account());
        controller.processUser();
    }

}
