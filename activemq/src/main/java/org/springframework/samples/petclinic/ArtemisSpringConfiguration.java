package org.springframework.samples.petclinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisConfigurationCustomizer;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArtemisSpringConfiguration {

    @Autowired
    private ArtemisProperties artemisProperties;

    @Bean
    public ArtemisConfigurationCustomizer customizer() {
        return configuration -> {
            try {
                configuration.addAcceptorConfiguration("netty", "tcp://localhost:" + artemisProperties.getPort());
            } catch (Exception e) {
                throw new RuntimeException("Failed to add netty transport acceptor to artemis instance", e);
            }
        };
    }

}