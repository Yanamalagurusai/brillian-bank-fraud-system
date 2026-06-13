package com.brillian.dispute.dto;

import com.brillian.dispute.enums.DisputeStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDisputeStatusRequest {

    @NotNull(message = "status is required")
    private DisputeStatus status;
}
