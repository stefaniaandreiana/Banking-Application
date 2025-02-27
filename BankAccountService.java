package project;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

    private List<BankAccount> accounts = new ArrayList<>();
    private int accountIdCounter = 1;

    public BankAccount createAccount(String accountHolderName, double initialBalance) {
        BankAccount account = new BankAccount(accountIdCounter++, accountHolderName, initialBalance);
        accounts.add(account);
        return account;
    }

    public BankAccount getAccount(int accountId) {
        return accounts.stream().filter(a -> a.getAccountId() == accountId).findFirst().orElse(null);
    }

    public boolean transferMoney(int fromAccountId, int toAccountId, double amount) {
        BankAccount fromAccount = getAccount(fromAccountId);
        BankAccount toAccount = getAccount(toAccountId);

        if (fromAccount != null && toAccount != null && fromAccount.getBalance() >= amount) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    // Obținerea tuturor conturilor
    public List<BankAccount> getAllAccounts() {
        return accounts;
    }
}
