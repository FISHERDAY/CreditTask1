package ua.training.Tests;
import org.junit.Assert;
import org.junit.Test;
import ua.training.model.Account;

public class AccountTester {
    @Test
    public void TestWithdrawMonthlyPayment() {
        Account account = new Account();
        Assert.assertFalse(account.withdrawMonthlyPayment(5001));
        Assert.assertTrue(account.withdrawMonthlyPayment(1500));
        Assert.assertEquals(3500, account.getMoneyAmount());
    }


}
