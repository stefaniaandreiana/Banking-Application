package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/create")
    public BankAccount createAccount(@RequestBody BankAccount account) {
        return bankAccountService.createAccount(account.getAccountHolderName(), account.getBalance());
    }

    @GetMapping("/all")
    public List<BankAccount> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public BankAccount getAccount(@PathVariable int id) {
        return bankAccountService.getAccount(id);
    }

    @PostMapping("/transfer")
    public boolean transferMoney(@RequestParam int fromAccountId, @RequestParam int toAccountId, @RequestParam double amount) {
        return bankAccountService.transferMoney(fromAccountId, toAccountId, amount);
    }
}
