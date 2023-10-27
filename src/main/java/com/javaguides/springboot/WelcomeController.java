package com.javaguides.springboot;

import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.UnivariateIntegrator;

@RestController
public class WelcomeController {
    @GetMapping ("/welcome")
    public String welcome(){
        return "Welcome to Team Code Masters!!!";
    }

    @GetMapping ("/common")
    public String testingCommon(){
        UnivariateFunction function = v -> v;
        UnivariateIntegrator integrator = new SimpsonIntegrator(1.0e-12, 1.0e-8, 1, 32);
        double i = integrator.integrate(100, function, 0, 10);
        return "Calculates integral of identity function.";
    }
}
