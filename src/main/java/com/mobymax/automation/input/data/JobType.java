package com.mobymax.automation.input.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum JobType {
    US_SCHOOL("I work at a U.S. school as a");

    private final String value;
}
