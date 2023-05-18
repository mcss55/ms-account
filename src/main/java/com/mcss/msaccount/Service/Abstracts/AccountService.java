package com.mcss.msaccount.Service.Abstracts;

import com.mcss.msaccount.DTO.AccountRequest;
import com.mcss.msaccount.DTO.AccountResponse;
import com.mcss.msaccount.DTO.AccountUpdate;

import java.util.List;

public interface AccountService {

    AccountResponse getAccountById(Long id);
    List<AccountResponse> getAllAccount();

    void deleteAccount(Long id);

    void updateAccount(AccountUpdate accountUpdate, Long id);

    void createAccount(AccountRequest accountRequest);


}
