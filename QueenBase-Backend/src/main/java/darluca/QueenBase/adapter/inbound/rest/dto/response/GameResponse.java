package darluca.QueenBase.adapter.inbound.rest.dto.response;

public record GameResponse(
    Long id,
    String whitePlayer,
    String blackPlayer,
    String result,
    String eventName,
    String site,
    String gameDate,
    String ecoCode,
    String pgn,
    String createdAt) {}
