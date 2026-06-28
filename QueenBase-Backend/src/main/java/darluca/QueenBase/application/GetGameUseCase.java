package darluca.QueenBase.application;

import darluca.QueenBase.domain.exception.GameNotFoundException;
import darluca.QueenBase.domain.model.Game;
import darluca.QueenBase.domain.ports.in.GameQueryService;
import darluca.QueenBase.domain.ports.out.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetGameUseCase implements GameQueryService {

    private final GameRepository gameRepository;

    @Override
    public Game getGame(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
    }
}