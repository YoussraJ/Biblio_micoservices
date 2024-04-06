package com.yosra.Emprunt.emprunt;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/emprunts")
@RequiredArgsConstructor
public class EmpruntController {
    private final EmpruntService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Emprunt> save(
            @RequestBody Emprunt emprunt
    ) {
        return service.save(emprunt);
    }

    @GetMapping
   public Flux<Emprunt> findAll() {
        return  service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Emprunt> findById(
            @PathVariable("id") int id
    ){
        return service.findById(id);
    }
}

