package org.springframework.samples.petclinic.vets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class VetsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VetsApplication.class, args);
    }

}
