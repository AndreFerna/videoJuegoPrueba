package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.ViewRequestDto;
import co.com.pragma.api.dto.ViewResponseDto;
import co.com.pragma.model.tournament.View;

public class ViewDtoMapper {

    public static View viewDtoToView(ViewRequestDto viewResponseDto){
        return View.builder()
                .date(viewResponseDto.getDate())
                .isFree(viewResponseDto.getFree())
                .idTournament(viewResponseDto.getIdTournament())
                .entrancePrice(viewResponseDto.getEntrancePrice())
                .build();
    }

    public static ViewResponseDto viewToViewDto(View view){
        return ViewResponseDto.builder()
                .url(view.getUrl())
                .date(view.getDate())
                .free(view.isFree())
                .idTournament(view.getIdTournament())
                .aforo(view.getAforo())
                .uniqueCode(view.getUniqueCode())
                .entrancePrice(view.getEntrancePrice())
                .build();
    }

}
