package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.TournamentDto;
import co.com.pragma.model.tournament.Tournament;

import java.util.UUID;

public class TournamentDtoMapper {
    public static Tournament tournamentDtoToTournament(TournamentDto tournamentDto){
        return Tournament.builder()
                .name(tournamentDto.getName())
                .description(tournamentDto.getDescription())
                .startDate(tournamentDto.getStartDate())
                .endDate(tournamentDto.getEndDate())
                .entrancePrice(tournamentDto.getEntrancePrice())
                .organizer(tournamentDto.getOrganizer())
                .category(tournamentDto.getCategory())
                .gameType(tournamentDto.getGameType())
                .uniqueCode(UUID.randomUUID().toString())
                .isFree(tournamentDto.isFree())
                .build();
    }

    public static TournamentDto tournamentToTounamentDto(Tournament tournament){
        return TournamentDto.builder()
                .name(tournament.getName())
                .description(tournament.getDescription())
                .startDate(tournament.getStartDate())
                .endDate(tournament.getEndDate())
                .entrancePrice(tournament.getEntrancePrice())
                .capacity(tournament.getCapacity())
                .organizer(tournament.getOrganizer())
                .category(tournament.getCategory())
                .gameType(tournament.getGameType())
                .uniqueCode(tournament.getUniqueCode())
                .isFree(tournament.isFree())
                .build();
    }

}
