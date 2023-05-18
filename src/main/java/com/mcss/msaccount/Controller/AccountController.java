package com.mcss.msaccount.Controller;

import com.mcss.msaccount.DTO.AccountRequest;
import com.mcss.msaccount.DTO.AccountResponse;
import com.mcss.msaccount.DTO.AccountUpdate;
import com.mcss.msaccount.Service.Abstracts.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountController {

    AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountResponse>> getAllAccount(){
        return ResponseEntity.ok(accountService.getAllAccount());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccountById(@PathVariable Long id){
        AccountResponse accountById = accountService.getAccountById(id);
        return new ResponseEntity<>(accountById, HttpStatus.OK);
    }

    @PostMapping
    public void addAccount(AccountRequest accountRequest){
        accountService.createAccount(accountRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
    }

    @PutMapping("/{id}")
    public void updateAccount(AccountUpdate accountUpdate,@PathVariable Long id){
        accountService.updateAccount(accountUpdate,id);
    }


}


