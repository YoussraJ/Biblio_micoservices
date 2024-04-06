package com.yosra.Emprunt.emprunt;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

public interface EmpruntRepository extends ReactiveCrudRepository<Emprunt, Integer> {

}