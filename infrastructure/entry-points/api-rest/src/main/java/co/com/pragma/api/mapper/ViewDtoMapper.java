package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.ViewDto;
import co.com.pragma.model.tournament.View;

public class ViewDtoMapper {

    public static View viewDtoToView(ViewDto viewDto){
        return View.builder()
                .date(viewDto.getDate())
                .isFree(viewDto.isFree())
                .idTournament(viewDto.getIdTournament())
                .entrancePrice(viewDto.getEntrancePrice())
                .build();
    }

    public static ViewDto viewToViewDto(View view){
        return ViewDto.builder()
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
