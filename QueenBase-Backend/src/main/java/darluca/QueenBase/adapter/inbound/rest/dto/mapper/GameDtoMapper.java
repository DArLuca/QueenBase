package darluca.QueenBase.adapter.inbound.rest.dto.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import darluca.QueenBase.adapter.inbound.rest.dto.request.CreateGameRequest;
import darluca.QueenBase.adapter.inbound.rest.dto.response.GameResponse;
import darluca.QueenBase.domain.model.Game;

@Component
public class GameDtoMapper {

    public Game toDomain(CreateGameRequest request) {
        if (request == null) {
            return null;
        }
        
        Game game = new Game();
        game.setWhitePlayer(request.whitePlayer());
        game.setBlackPlayer(request.blackPlayer());
        game.setResult(request.result());
        game.setEventName(request.eventName());
        game.setSite(request.site());
        game.setEcoCode(request.ecoCode());
        game.setPgn(request.pgn());
        
        if (request.gameDate() != null && !request.gameDate().isBlank()) {
            game.setGameDate(LocalDate.parse(request.gameDate()));
        }
        
        return game;
    }

    public GameResponse toResponse(Game game) {
        if (game == null) {
            return null;
        }
        
        return new GameResponse(
            game.getId(),
            game.getWhitePlayer(),
            game.getBlackPlayer(),
            game.getResult(),
            game.getEventName(),
            game.getSite(),
            game.getGameDate() != null ? game.getGameDate().toString() : null,
            game.getEcoCode(),
            game.getPgn(),
            game.getCreatedAt() != null ? game.getCreatedAt().toString() : null
        );
    }
}
