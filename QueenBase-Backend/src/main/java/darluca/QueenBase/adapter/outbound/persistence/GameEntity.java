package darluca.QueenBase.adapter.outbound.persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "games")
@Getter
@Setter

public class GameEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;

  private String whitePlayer;
  private String blackPlayer;
  private String result;
  private String eventName;
  private String site;
  private LocalDate gameDate;
  private String ecoCode;
  private String pgn;
  private Long userId;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @PrePersist
  protected void onCreate() {
  createdAt = LocalDateTime.now();
  updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }

}
