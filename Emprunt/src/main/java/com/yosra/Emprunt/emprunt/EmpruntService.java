package com.yosra.Emprunt.emprunt;

import com.yosra.Emprunt.producer_consumer.VerifyUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmpruntService {
    private final EmpruntRepository repository;
    private final VerifyUser vu;
    public Mono<Emprunt> save(Emprunt emprunt) {
        // Verify the user before saving the Emprunt
        return vu.verifyUser(String.valueOf(emprunt.getId_user()))
                .flatMap(result -> {
                    if ("verified".equalsIgnoreCase(result)) {
                        // User is verified, proceed with saving the Emprunt
                        log.info("User {} verified. Saving Emprunt.", emprunt.getId_user());
                        return repository.save(emprunt);
                    } else {
                        // User is not verified, return an error
                        log.warn("User {} not verified. Emprunt not saved.", emprunt.getId_user());
                        return Mono.error(new RuntimeException("User verification failed"));
                    }
                });
    }

    public Flux<Emprunt> findAll() {
        return repository.findAll();
    }

    public Mono<Emprunt> findById(int id) {
        return repository.findById(id);
    }

    /*public Flux<Emprunt> findById_user(Long id_user) {
        return repository.findAllByIdUserIgnoreCase(id_user);
    }*/

    public void deleteById(int id) {
        repository.deleteById(id).subscribe();
    }
}
