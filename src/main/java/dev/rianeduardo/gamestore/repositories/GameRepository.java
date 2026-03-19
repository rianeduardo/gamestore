package dev.rianeduardo.gamestore.repositories;

import org.springframework.data.repository.CrudRepository;

import dev.rianeduardo.gamestore.models.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {

}
