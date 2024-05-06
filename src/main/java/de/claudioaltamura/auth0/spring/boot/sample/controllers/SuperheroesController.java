package de.claudioaltamura.auth0.spring.boot.sample.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import de.claudioaltamura.auth0.spring.boot.sample.model.Superhero;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SuperheroesController {

    private final Random random = new Random();

    @GetMapping("/superheroes")
    public ResponseEntity<List<Superhero>> getAll() {
        final var list = Collections.singletonList(
                Superhero.builder().id(1L).name("Spider-Men").realName("Peter Parker").power(90.0d)
                        .build());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/superheroes")
    @PreAuthorize("hasAuthority('write:superheroes')")
    public ResponseEntity<Superhero> createSuperhero(@RequestBody @Valid final Superhero superhero) {
        final var id = random.longs(1, Long.MAX_VALUE).findFirst().getAsLong();
        superhero.setId(id);
        final var location =
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(id)
                        .toUri();

            return ResponseEntity.created(location).body(superhero);
    }
}
