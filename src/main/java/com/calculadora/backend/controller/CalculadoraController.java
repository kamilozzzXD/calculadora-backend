package com.calculadora.backend.controller;

import com.calculadora.backend.dto.OperacionRequest;
import com.calculadora.backend.service.CalculadoraService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @PostMapping
    public ResponseEntity<Double> calcular(@Valid @RequestBody OperacionRequest request) {

        double resultado = calculadoraService.calcular(
                request.getNumero1(),
                request.getNumero2(),
                request.getOperacion()
        );

        return ResponseEntity.ok(resultado);
    }
}
