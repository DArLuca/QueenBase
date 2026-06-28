package darluca.QueenBase.adapter.outbound.persistence.mapper;

import darluca.QueenBase.adapter.outbound.persistence.GameEntity;
import darluca.QueenBase.domain.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameEntityMapper {

    public Game toDomain(GameEntity entity) {
        if (entity == null) {
            return null;
        }
        
        Game game = new Game();
        game.setId(entity.getId());
        game.setWhitePlayer(entity.getWhitePlayer());
        game.setBlackPlayer(entity.getBlackPlayer());
        game.setResult(entity.getResult());
        game.setEventName(entity.getEventName());
        game.setSite(entity.getSite());
        game.setGameDate(entity.getGameDate());
        game.setEcoCode(entity.getEcoCode());
        game.setPgn(entity.getPgn());
        game.setUserId(entity.getUserId());
        game.setCreatedAt(entity.getCreatedAt());
        game.setUpdatedAt(entity.getUpdatedAt());
        
        return game;
    }

    public GameEntity toEntity(Game game) {
        if (game == null) {
            return null;
        }
        
        GameEntity entity = new GameEntity();
        entity.setId(game.getId());
        entity.setWhitePlayer(game.getWhitePlayer());
        entity.setBlackPlayer(game.getBlackPlayer());
        entity.setResult(game.getResult());
        entity.setEventName(game.getEventName());
        entity.setSite(game.getSite());
        entity.setGameDate(game.getGameDate());
        entity.setEcoCode(game.getEcoCode());
        entity.setPgn(game.getPgn());
        entity.setUserId(game.getUserId());
        entity.setCreatedAt(game.getCreatedAt());
        entity.setUpdatedAt(game.getUpdatedAt());
        
        return entity;
    }
}