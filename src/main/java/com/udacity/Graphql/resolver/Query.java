package com.udacity.Graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.Graphql.entity.Dog;
import com.udacity.Graphql.exception.DogNotFoundException;
import com.udacity.Graphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private DogRepository dogRepository;
    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return (Iterable<Dog>) dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }

}
