/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.controller;

import org.springframework.samples.petclinic.vets.Vet;
import org.springframework.samples.petclinic.vets.VetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class VetRestApi {

    private final VetRepository repository;

    public VetRestApi(VetRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/vets")
    public Collection<VetDto> vetList() {
        return this.repository.findAll()
            .stream()
            .map(this::createVetDto)
            .collect(Collectors.toList());
    }

    private VetDto createVetDto(Vet v) {
        return new VetDto(
            v.getFirstName(),
            v.getLastName(),
            v.getSpecialties().stream().map(s -> s.getName()).collect(Collectors.toList()
            ));
    }

}
