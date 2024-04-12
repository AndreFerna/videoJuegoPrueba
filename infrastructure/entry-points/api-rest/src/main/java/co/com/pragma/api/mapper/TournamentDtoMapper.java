package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.TournamentDto;
import co.com.pragma.model.tournament.Tournament;

public class TournamentDtoMapper {

    public static Tournament tournamentDtoToTournament(TournamentDto tournamentDto){
        return Tournament.builder()
                .name(tournamentDto.getName())
                .description(tournamentDto.getDescription())
                .startDate(tournamentDto.getStartDate())
                .endDate(tournamentDto.getEndDate())
                .entrancePrice(tournamentDto.getEntrancePrice())
                .capacity(tournamentDto.getCapacity())
                .organizer(tournamentDto.getOrganizer())
                .gameType(tournamentDto.getGameType())
                .category(tournamentDto.getCategory())
                .build();
    }

}
