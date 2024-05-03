package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.entities.TournamentSaleEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.mapper.TournamentSaleMapper;
import co.com.pragma.jpa.repository.JPATournamentSaleRepository;
import co.com.pragma.model.tournament.TournamentSale;
import co.com.pragma.model.tournament.gateways.TournamentSaleRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class JPARepositoryTournamentSaleAdapter extends AdapterOperations<TournamentSale, TournamentSaleEntity, Long, JPATournamentSaleRepository> implements TournamentSaleRepository {


    public JPARepositoryTournamentSaleAdapter(JPATournamentSaleRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, TournamentSale.class));
    }

    @Override
    public TournamentSale saveTournamentSale(TournamentSale tournamentSale) {
        TournamentSaleEntity tournamentSaleEntity = saveData(TournamentSaleMapper.toEntity(tournamentSale));
        return TournamentSaleMapper.toDomain(tournamentSaleEntity);
    }
}
