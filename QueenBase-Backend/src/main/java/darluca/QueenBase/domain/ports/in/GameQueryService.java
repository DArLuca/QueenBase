package darluca.QueenBase.domain.ports.in;

import darluca.QueenBase.domain.model.Game;

public interface GameQueryService {

    Game getGame(Long id);
}