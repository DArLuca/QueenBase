package darluca.QueenBase.adapter.inbound.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateGameRequest(

    @NotBlank(message = "whitePlayer is required")
    String whitePlayer,

    @NotBlank(message = "blackPlayer is required")
    String blackPlayer,

    @NotBlank(message = "result is required")
    @Pattern(regexp = "1-0|0-1|1/2-1/2|\\*", message = "result must be one of: 1-0, 0-1, 1/2-1/2, *")
    String result,

    String eventName,

    String site,

    String gameDate,

    String ecoCode,

    @NotBlank(message = "pgn is required")
    String pgn) {}