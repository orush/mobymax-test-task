package com.mobymax.automation.input.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum JobPosition {
    TEACHER_OR_TEACHER_ASSISTANT("Teacher or teacher assistant", JobType.US_SCHOOL);

    private final String value;
    private final JobType jobType;
}
