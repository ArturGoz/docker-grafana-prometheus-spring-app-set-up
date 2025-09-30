package com.is.islab1.service;

import com.is.islab1.model.User;
import com.is.islab1.repository.UserRepository;
import com.is.islab1.utils.DataGenerator;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final MeterRegistry meterRegistry;

    public List<User> generateAndSaveUsers(int n) {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            User user = DataGenerator.generateRandomUser();
            users.add(userRepository.save(user));
        }

        log.info("Generated {} users", users.size());
        updateUserCountMetric();

        return users;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    private void updateUserCountMetric() {
        long count = userRepository.count();
        meterRegistry.gauge("users.count", count);
    }
}
