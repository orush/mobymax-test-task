package com.mobymax.automation.input.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum State {
    CALIFORNIA("California");

    private final String state;
}
