package com.egor.stuff_admin.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserContext {
    public static final String CORRELATION_ID = "correlation-id";

    private String correlationId = new String();
}
