package com.electron3d.controller;

import com.electron3d.domain.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskInfo {
    private String description;
    private Status status;
}
