package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.Service.AccountService;
import com.codeline.sampleProject.Service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("account/create")
    public void saveAccount () {
        createAccount();
    }

    @RequestMapping("account/get")
    public List<Account> getAccount () {

        return accountService.getAccounts();

    }

    public void createAccount() {
        Account account = new Account();
        account.setBankName("Muscat");
        account.setAccountNumber("2224334655");
        account.setBankBranch("Gala");
        account.setSwiftCode("OM#99");
        account.setAccountHolderName("Ahmed Saif");
        account.setAccountType("Saving Account");
        account.setBranchCode(122);
        account.setCreatedDate(new Date());
        account.setIsActive(true);
        accountService.saveAccount(account);
    }
    @GetMapping("Employee/quer")
    @ResponseBody
    public String getaccountQueryString(@RequestParam String a, @RequestParam int b, @RequestParam String c, @RequestParam String d)
            throws JsonProcessingException {
        Employee emp = new Employee();
        emp.setName(a);
        emp.setSalary((double) b);
        emp.setGender(c);
        emp.setDepartment(d);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(emp.getGender());
        String s = mapper.writeValueAsString(EmployeeService.getempAsString(emp));
        System.out.print(s);
        return s;
    }
}