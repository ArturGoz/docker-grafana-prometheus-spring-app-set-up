package com.is.islab1.service;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class AuthService {
    private boolean authorized = false;

    public void authorize() {
        authorized = true;
    }
}
