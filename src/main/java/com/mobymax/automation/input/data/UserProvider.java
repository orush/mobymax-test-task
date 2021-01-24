package com.mobymax.automation.input.data;

import com.github.javafaker.Faker;
import com.mobymax.automation.models.UserModel;
import org.apache.commons.lang3.RandomStringUtils;

public class UserProvider {

    public static UserModel.UserModelBuilder getForRegistration() {
        return UserModel.builder()
                .firstName(UserFaker.getFirstName())
                .lastName(UserFaker.getLastName())
                .email(UserFaker.getEmail())
                .password(UserFaker.getPassword());
    }

    private static class UserFaker {
        private static final Faker FAKER = new Faker();

        private static String getFirstName() {
            return FAKER.name().firstName();
        }

        private static String getLastName() {
            return FAKER.name().lastName();
        }

        private static String getPassword() {
            return FAKER.internet().password();
        }

        private static String getEmail() {
            return RandomStringUtils.randomAlphanumeric(20) + "@wtfqa.us";
        }
    }
}
