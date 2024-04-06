package com.yosra.user.user;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
    Flux<User> findAllByFirstnameIgnoreCase(String firstname);
}