package darluca.QueenBase.adapter.outbound.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataGameRepository extends JpaRepository<GameEntity, Long> {
    // Spring Data JPA provides findById, save, etc. automatically
}