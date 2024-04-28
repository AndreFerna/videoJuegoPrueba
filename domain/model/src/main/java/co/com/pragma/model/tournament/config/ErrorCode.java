package co.com.pragma.model.tournament.config;

import lombok.Getter;

@Getter
public enum ErrorCode {
    B401000("B401-000", "Unauthorized", 401),
    B400001("B400-001", "Bad Request-fields bad format", 400),
    B409000("B409-000", "No Organizer Found", 409),
    B409001("B409-001", "No Category Found", 409),
    B409002("B409-002", "No Game Type Found", 409),
    B409003("B409-003", "You have already created two free tournaments", 409),
    B409004("B409-004", "You have already created a free view.", 409);


    private final String code;
    private final String log;
    private final int status;

    ErrorCode(String code, String log, int status) {
        this.code = code;
        this.log = log;
        this.status = status;
    }
}
