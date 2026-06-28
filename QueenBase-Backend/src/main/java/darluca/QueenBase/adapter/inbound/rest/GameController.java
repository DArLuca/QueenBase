package darluca.QueenBase.adapter.inbound.rest;

import darluca.QueenBase.adapter.inbound.rest.dto.mapper.GameDtoMapper;
import darluca.QueenBase.adapter.inbound.rest.dto.request.CreateGameRequest;
import darluca.QueenBase.adapter.inbound.rest.dto.response.GameResponse;
import darluca.QueenBase.domain.model.Game;
import darluca.QueenBase.domain.ports.in.GameCommandService;
import darluca.QueenBase.domain.ports.in.GameQueryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {

    private final GameCommandService gameCommandService;
    private final GameQueryService gameQueryService;
    private final GameDtoMapper mapper;

    @PostMapping
    public ResponseEntity<GameResponse> createGame(@Valid @RequestBody CreateGameRequest request) {
        Game game = mapper.toDomain(request);
        Game savedGame = gameCommandService.createGame(game);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(savedGame));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponse> getGame(@PathVariable Long id) {
        Game game = gameQueryService.getGame(id);
        return ResponseEntity.ok(mapper.toResponse(game));
    }
}