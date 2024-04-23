package co.com.pragma.model.tournament.config;

import lombok.Getter;

@Getter
public enum ErrorCode {
    B401000("B401-000", "Unauthorized", 401),
    B400001("B400-001", "No Category Found", 400),
    B400002("B400-002", "Bad Request-fields bad format", 400),
    B400003("b400-003", "No Game Type Found", 400),
    B400004("b400-004", "No Organizer Found", 400);


    private final String code;
    private final String log;
    private final int status;

    ErrorCode(String code, String log, int status) {
        this.code = code;
        this.log = log;
        this.status = status;
    }
}
