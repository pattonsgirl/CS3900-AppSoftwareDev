package com.wsu.workorderproservice.model.constants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum WorkOrderStatus {
    CP("Completed"),
    CX("Cancelled"),
    UN("Unscheduled"),
    SH("Scheduled"),
    OH("On Hold");

    private final String status;
}
