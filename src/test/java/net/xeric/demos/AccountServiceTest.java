package net.xeric.demos;

import org.junit.Test;
import org.mvel2.MVEL;

import javax.script.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by markshead on 12/31/16.
 */
public class AccountServiceTest {

    AccountService accountService = new AccountService();
    List<Account> accounts = accountService.getAccounts();
    @Test
    public void MVELTestFindCheckingAverage() throws Exception {
        Map vars = new HashMap();
        vars.put( "accounts", accounts );
        String code = "count = 0; "+
                      "sum = 0; "+
                      "foreach(account : accounts) { " +
                      "  if(account.type == 'Checking') { " +
                      "    count++;" +
                      "    sum += account.balance;"+
                      "  } " +
                      "} " +
                      "return sum/count;";

        Double output = (Double)MVEL.eval(code,vars) ;
        assertThat(output, is(300.0));
        System.out.println("MVEL - The average amount type checking accounts is: " + output);

    }

    @Test
    public void JavaScriptTestFindCheckingAverage() throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        Invocable invocable = (Invocable) engine;

        String statement = "function average(accounts) {" +
                           " var sum = 0;" +
                           " var count = 0;" +
                           " for each(account in accounts) { " +
                           "   if(account.getType() === 'Checking') { "+
                           "     sum += account.getBalance();" +
                           "     count++;" +
                           "    } " +
                           "  } " +
                           " return sum / count; " +
                           "} " ;
        CompiledScript cs = ((Compilable) engine).compile(statement);
        cs.eval();
        Double output = (Double) invocable.invokeFunction("average",accounts);
        assertThat(output, is(300.0));
        System.out.println("Javascript - The average amount type checking accounts is: " + output);
    }
}