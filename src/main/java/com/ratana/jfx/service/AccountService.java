package com.ratana.jfx.service;

import com.ratana.jfx.model.Account;

public interface AccountService {
    Account login(String username, String password);
}
