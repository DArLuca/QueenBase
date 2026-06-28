package darluca.QueenBase.domain.ports.out;

import darluca.QueenBase.domain.model.Game;

import java.util.Optional;

public interface GameRepository {
    
    Game save(Game game);
    
    Optional<Game> findById(Long id);
}