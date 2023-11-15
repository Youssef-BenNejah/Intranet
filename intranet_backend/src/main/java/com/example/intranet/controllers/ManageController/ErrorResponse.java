package com.example.intranet.controllers.ManageController;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ErrorResponse {
    private  String messaage;
    private List<String> error;

    public ErrorResponse(String messaage, List<String> error) {
        this.messaage = messaage;
        this.error = error;
    }
}
