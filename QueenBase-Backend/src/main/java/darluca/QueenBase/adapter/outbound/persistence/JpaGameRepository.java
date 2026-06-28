package darluca.QueenBase.adapter.outbound.persistence;

import darluca.QueenBase.adapter.outbound.persistence.mapper.GameEntityMapper;
import darluca.QueenBase.domain.model.Game;
import darluca.QueenBase.domain.ports.out.GameRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaGameRepository implements GameRepository {

    private final SpringDataGameRepository springDataRepository;
    private final GameEntityMapper mapper;

    public JpaGameRepository(SpringDataGameRepository springDataRepository, GameEntityMapper mapper) {
        this.springDataRepository = springDataRepository;
        this.mapper = mapper;
    }

    @Override
    public Game save(Game game) {
        GameEntity entity = mapper.toEntity(game);
        GameEntity savedEntity = springDataRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Game> findById(Long id) {
        return springDataRepository.findById(id).map(mapper::toDomain);
    }
}