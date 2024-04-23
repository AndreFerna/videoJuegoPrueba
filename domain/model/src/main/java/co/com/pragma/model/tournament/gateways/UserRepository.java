package co.com.pragma.model.tournament.gateways;

import co.com.pragma.model.tournament.User;

public interface UserRepository {

    User findByIdOrganizer(String id);
}
