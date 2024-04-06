package com.yosra.user.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
   // @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> save(
            @RequestBody User user
    ) {

        return service.save(user);
    }

    @GetMapping
   public Flux<User> findAll() {
        return  service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<User> findById(
            @PathVariable("id") int id
    ){
        return service.findById(id);
    }
}

