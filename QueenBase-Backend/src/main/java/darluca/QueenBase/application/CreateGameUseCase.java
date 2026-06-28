package darluca.QueenBase.application;

import darluca.QueenBase.domain.model.Game;
import darluca.QueenBase.domain.ports.in.GameCommandService;
import darluca.QueenBase.domain.ports.out.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateGameUseCase implements GameCommandService {

    private final GameRepository gameRepository;

    @Override
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }
}