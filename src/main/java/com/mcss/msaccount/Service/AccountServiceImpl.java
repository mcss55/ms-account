package com.mcss.msaccount.Service;

import com.mcss.msaccount.DTO.AccountRequest;
import com.mcss.msaccount.DTO.AccountResponse;
import com.mcss.msaccount.DTO.AccountUpdate;
import com.mcss.msaccount.Model.Account;
import com.mcss.msaccount.Repository.AccountRepository;
import com.mcss.msaccount.Service.Abstracts.AccountService;
import com.mcss.msaccount.Util.Exceptions.AccountNotFound;
import com.mcss.msaccount.Util.Mapper.Abstracts.MapperService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;
    MapperService mapperService;

    @Override
    public AccountResponse getAccountById(Long id) {
        return mapperService.forResponse().map(accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFound("Account not found with id: " + id)),
                AccountResponse.class);

    }

    @Override
    public List<AccountResponse> getAllAccount() {

        return accountRepository.findAll().stream()
                .map(account -> mapperService.forResponse().map(account,AccountResponse.class))
                .toList();

    }

    @Override
    public void deleteAccount(Long id) {

        Account foundAcc = accountRepository.findById(id).orElseThrow(() -> new AccountNotFound("Account not found with id: " + id));

        accountRepository.delete(foundAcc);

    }

    @Override
    public void updateAccount(AccountUpdate accountUpdate, Long id) {

        accountRepository.findById(id).orElseThrow(() -> new AccountNotFound("Account not found with id: " + id));

        Account mappedAcc = mapperService.forResponse().map(accountUpdate, Account.class);
        mappedAcc.setId(id);

        accountRepository.save(mappedAcc);

    }

    @Override
    public void createAccount(AccountRequest accountRequest) {

        Account newAccount = mapperService.forResponse().map(accountRequest, Account.class);

        accountRepository.save(newAccount);

    }



}
