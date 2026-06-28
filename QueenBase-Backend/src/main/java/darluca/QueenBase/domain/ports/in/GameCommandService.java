package darluca.QueenBase.domain.ports.in;

import darluca.QueenBase.domain.model.Game;

public interface GameCommandService {

    Game createGame(Game game);
}