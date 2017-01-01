package net.xeric.demos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by markshead on 12/31/16.
 */
public class AccountService {

    public List<Account> getAccounts() {
        List accounts = new ArrayList<Account>() {{
            add(new Account(100, "Checking", "Bob"));
            add(new Account(500, "Savings", "Greg"));
            add(new Account(100, "Savings", "Sue"));
            add(new Account(500, "Checking", "Grace"));
        }};
        return accounts;
    }
}
