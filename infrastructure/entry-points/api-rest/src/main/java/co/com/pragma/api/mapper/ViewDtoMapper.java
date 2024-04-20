package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.ViewDto;
import co.com.pragma.model.tournament.View;

public class ViewDtoMapper {

    public static View viewDtoToView(ViewDto viewDto){
        return View.builder()
                .date(viewDto.getDate())
                .isFree(viewDto.isFree())
                .idTournament(viewDto.getIdTournament())
                .build();
    }

    public static ViewDto viewToViewDto(View view){
        return ViewDto.builder()
                .date(view.getDate())
                .isFree(view.isFree())
                .idTournament(view.getIdTournament())
                .build();
    }

}
