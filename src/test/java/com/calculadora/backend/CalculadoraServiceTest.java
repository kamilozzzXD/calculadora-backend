package com.calculadora.backend;

import com.calculadora.backend.service.CalculadoraService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraServiceTest {

    private final CalculadoraService service = new CalculadoraService();

    @Test
    void suma_debe_funcionar() {
        double resultado = service.calcular(2, 3, "SUMA");
        assertEquals(5, resultado);
    }
}
