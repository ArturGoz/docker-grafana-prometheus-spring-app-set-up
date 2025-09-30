package com.is.islab1.service;

import com.is.islab1.repository.UserRepository;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class UserMetricsScheduler {

    private final UserRepository userRepository;
    private final AtomicLong userCount = new AtomicLong(0);

    public UserMetricsScheduler(UserRepository userRepository, MeterRegistry meterRegistry) {
        this.userRepository = userRepository;

        Gauge.builder("users.count", userCount, AtomicLong::get)
                .description("Number of users in DB")
                .register(meterRegistry);
    }

    @Scheduled(fixedRate = 5000)
    public void updateUserCount() {
        long count = userRepository.count();
        userCount.set(count);
        log.info("Users count: {}", count);
    }
}
