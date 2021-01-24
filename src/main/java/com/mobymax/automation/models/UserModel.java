package com.mobymax.automation.models;

import com.mobymax.automation.input.data.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode
@ToString(exclude = {"password"})
public class UserModel {
    String email;
    String password;
    String firstName;
    String lastName;
    School school;
    JobPosition jobPosition;
    RegistrationType registrationType;
    UserType type;
}
