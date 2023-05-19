package fi.bingo.gameinfoservice.repositories;

import fi.bingo.gameinfoservice.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long>{
    
}
