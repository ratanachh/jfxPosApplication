package com.ratana.jfx.service.Impl;

import com.ratana.jfx.exception.ServiceException;
import com.ratana.jfx.model.Account;
import com.ratana.jfx.repository.AccountRepository;
import com.ratana.jfx.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account login(String username, String password)  {

        if (!StringUtils.hasLength(username.trim())) {
            throw new ServiceException("Please enter username.");
        }

        if (!StringUtils.hasLength(password.trim())) {
            throw new ServiceException("Please enter password.");
        }
        Account account = accountRepository.findById(username)
                .orElseThrow(() -> new ServiceException("Username and password is incorrect!"));

        if (account.getPassword().equals(password)) {
            return account;
        }
        throw new ServiceException("Username and password is incorrect!");
    }
}
