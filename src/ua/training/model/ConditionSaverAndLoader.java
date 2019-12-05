package ua.training.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConditionSaverAndLoader {

    public void saveCondition(Account account, Loan loan) throws IOException {
        FileWriter fileWriter = new FileWriter("Condition.txt");
        fileWriter.write(account.getMoneyAmount() + "," + loan.getLoanAmount() + "," + loan.getInterestRate() + "," + loan.getLoanDuration());
        fileWriter.close();
    }

    public boolean loadCondition(Account account, Loan loan) throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("Condition.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        Scanner scanner = new Scanner("Condition.txt");
        String params[] = scanner.nextLine().split(",");
        account.setMoneyAmount(Integer.parseInt(params[0]));
        loan.setLoanAmount(Integer.parseInt(params[1]));
        loan.setInterestRate(Double.parseDouble(params[2]));
        loan.setLoanDuration(Integer.parseInt(params[3]));
        return true;
    }

}
