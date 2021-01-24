package com.mobymax.automation.input.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum RegistrationType {
    FOR_EDUCATORS("For Educators");

    private final String value;
}
