package com.example.demo.model.erros;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiErrors {
    private String code;
    private List<String> messages;
    private Integer errorCount;
    private Instant timeStamp;
}
