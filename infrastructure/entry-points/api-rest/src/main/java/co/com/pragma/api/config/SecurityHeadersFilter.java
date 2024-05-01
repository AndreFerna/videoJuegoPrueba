package co.com.pragma.api.config;

import co.com.pragma.model.tournament.config.ErrorCode;
import co.com.pragma.model.tournament.config.PragmaException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Slf4j
@Configuration
@WebFilter("/**")
public class SecurityHeadersFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authorization = httpRequest.getHeader("Authorization");
        log.info("---------------- Authorization -------" + authorization);
        String key = getKey(authorization);

        if(!key.equals("cfa90e11fa9f")){
            throw new PragmaException(ErrorCode.B401000);
        }

        HttpServletResponse header = (HttpServletResponse) response;
        header.setHeader("Content-Security-Policy", "default-src 'self'; frame-ancestors 'self'; form-action 'self'");
        header.setHeader("Strict-Transport-Security", "max-age=31536000;");
        header.setHeader("X-Content-Type-Options", "nosniff");
        header.setHeader("Server", "");
        header.setHeader("Cache-Control", "no-store");
        header.setHeader("Pragma", "no-cache");
        header.setHeader("Referrer-Policy", "strict-origin-when-cross-origin");
        chain.doFilter(request, response);
    }

    private String getKey(String strJwt) {
        try {
            if (strJwt == null || strJwt.isEmpty() || !strJwt.matches("[\\w-]*\\.[\\w-]*\\.[\\w-]*")) {
                throw new PragmaException(ErrorCode.B401000);
            }
            String strJwtWithoutSign = strJwt.substring(0, strJwt.lastIndexOf(".") + 1);

            Claims body = Jwts.parser().parseClaimsJwt(strJwtWithoutSign).getBody();
            String key = (String) body.get("key");
            if (key == null || key.isEmpty()) {
                throw new PragmaException(ErrorCode.B401000);
            }
            return key;
        } catch (Exception e) {
            log.info("JWT {} expired", e.getMessage());
            throw new PragmaException(ErrorCode.B401000);
        }
    }

}
