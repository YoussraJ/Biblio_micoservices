package com.yosra.user.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public Mono<User> save(User user) {
        return repository.save(user);
    }

    public Flux<User> findAll() {
        return repository.findAll();
    }

    public Mono<User> findById(int id) {
        return repository.findById(id);
    }

    public Flux<User> findByFirstname(String firstname) {
        return repository.findAllByFirstnameIgnoreCase(firstname);
    }

    public void deleteById(int id) {
        repository.deleteById(id).subscribe();
    }
}
