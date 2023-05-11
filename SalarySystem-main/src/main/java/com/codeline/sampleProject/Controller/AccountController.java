package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("account/create")
    public void saveAccount () {
        createAccount();
    }

    private void createAccount() {
        Account acount = new Account();

        acount.setAccountHolderName("fahima");
        acount.setAccountType("muscat");
        acount.setBankBranch("muscat");
        acount.setBranchCode(11131);
        acount.setCreatedDate(new Date());
        acount.setSwiftCode("234");
        acount.setBankName("mithaq");
        acount.setAccountNumber("12345678912345");
        acount.setIsActive(true);
        accountService.saveAccount(acount);

    }


}
