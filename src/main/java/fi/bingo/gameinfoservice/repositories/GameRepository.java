package fi.bingo.gameinfoservice.repositories;

import org.springframework.stereotype.Repository;

import fi.bingo.gameinfoservice.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
    
}
