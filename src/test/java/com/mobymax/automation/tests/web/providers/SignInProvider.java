package com.mobymax.automation.tests.web.providers;

import com.mobymax.automation.input.data.*;
import org.testng.annotations.DataProvider;

public class SignInProvider {

    @DataProvider(name = "signIn")
    public static Object[][] signIn() {
        return new Object[][]{
                {
                        UserProvider.getForRegistration()
                                .registrationType(RegistrationType.FOR_EDUCATORS)
                                .jobPosition(JobPosition.TEACHER_OR_TEACHER_ASSISTANT)
                                .school(School.NOLI_SCHOOL)
                                .type(UserType.TEACHER)
                                .build()
                },
        };
    }
}
