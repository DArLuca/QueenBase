package darluca.QueenBase.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {


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

}
