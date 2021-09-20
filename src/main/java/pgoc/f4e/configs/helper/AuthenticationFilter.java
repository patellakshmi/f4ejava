package pgoc.f4e.configs.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pgoc.f4e.constants.APIConstant;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl(APIConstant.LOGIN);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            AuthUser authUser = new ObjectMapper().readValue(request.getInputStream(), AuthUser.class);
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authUser.getUsername(), authUser.getPassword(), new ArrayList<>()));
            return authentication;
        } catch (IOException e) {
            throw new RuntimeException("Could not read request" + e);
        }
    }

    @SneakyThrows
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authentication) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(((User) authentication.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 864_000_000))
                .signWith(SignatureAlgorithm.HS512, SecurityConfigConst.SECRETE_KEY.getBytes())
                .compact();
        response.addHeader(SecurityConfigConst.F4E_AUTH, "" + token);
        JSONObject json = new JSONObject();
        json.put(SecurityConfigConst.F4E_AUTH, token);
        response.getOutputStream().write(json.toString().getBytes( StandardCharsets.UTF_8 ) );
    }

}