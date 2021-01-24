package com.mobymax.automation.input.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum School {
    NOLI_SCHOOL("Noli School", State.CALIFORNIA);

    private final String schoolName;
    private final State state;
}
