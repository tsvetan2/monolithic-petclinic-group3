package org.springframework.samples.petclinic.service;

import java.util.Collection;

public interface VetGateway {
    Collection<VetDto> vetList();
}
