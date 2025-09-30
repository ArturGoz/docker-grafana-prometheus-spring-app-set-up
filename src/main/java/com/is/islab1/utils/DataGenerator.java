package com.is.islab1.utils;

import com.is.islab1.model.User;
import com.is.islab1.model.UserData;

import java.util.List;
import java.util.Random;

public class DataGenerator {
    private static final List<String> USERNAMES = List.of(
            "artur", "olena", "ivan", "maria", "petro",
            "dmytro", "sofia", "oleh", "viktoria", "andrii"
    );

    private static final List<String> ADDRESSES = List.of(
            "Kyiv", "Lviv", "Odesa", "Kharkiv", "Dnipro",
            "Vinnytsia", "Poltava", "Chernihiv", "Uzhhorod", "Zhytomyr"
    );

    private static final List<String> PHONES = List.of(
            "123456789", "987654321", "555123456", "380991112233", "380671234567",
            "380931234567", "380661234567", "380501234567", "380971234567", "380631234567"
    );

    private static final Random random = new Random();

    public static User generateRandomUser() {
        User user = new User();
        user.setUsername(USERNAMES.get(random.nextInt(USERNAMES.size())));

        UserData userData = new UserData();
        userData.setAddress(ADDRESSES.get(random.nextInt(ADDRESSES.size())));
        userData.setPhone(PHONES.get(random.nextInt(PHONES.size())));

        user.setUserData(userData);
        userData.setUser(user);

        return user;
    }
}
