package com.calculadora.backend.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public double calcular(double numero1, double numero2, String operacion) {

        return switch (operacion.toUpperCase()) {
            case "SUMA" -> numero1 + numero2;
            default -> throw new IllegalArgumentException("Operación no soportada");
        };
    }
}
