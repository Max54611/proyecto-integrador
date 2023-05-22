package com.a.ventafrutos.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String correo;
    private String contra;
}
