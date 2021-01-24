package com.mobymax.automation.tests.web.providers;

import com.mobymax.automation.input.data.JobPosition;
import com.mobymax.automation.input.data.RegistrationType;
import com.mobymax.automation.input.data.School;
import com.mobymax.automation.input.data.UserProvider;
import org.testng.annotations.DataProvider;

public class RegisterUserProvider {

    @DataProvider(name = "registerNewUser")
    public static Object[][] registerNewUser() {
        return new Object[][]{
                {
                        UserProvider.getForRegistration()
                                .registrationType(RegistrationType.FOR_EDUCATORS)
                                .jobPosition(JobPosition.TEACHER_OR_TEACHER_ASSISTANT)
                                .school(School.NOLI_SCHOOL)
                                .build()
                },
        };
    }
}
