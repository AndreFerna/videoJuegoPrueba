package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.ViewEntity;
import co.com.pragma.model.tournament.View;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ViewMapper {

    public static ViewEntity toEntity(View view){
        return ViewEntity.builder()
                .url(view.getUrl())
                .fecha(LocalDateTime.parse(view.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
                .id_torneo(view.getIdTournament())
                .gratuito(view.isFree())
                .build();
    }

    public static View toDomain(ViewEntity viewEntity){
        return View.builder()
                .url(viewEntity.getUrl())
                .date(viewEntity.getFecha().toString())
                .isFree(viewEntity.isGratuito())
                .idTournament(viewEntity.getId_torneo())
                .build();
    }
}