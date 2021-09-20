package pgoc.f4e.utility;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.codehaus.jettison.json.JSONException;
import pgoc.f4e.configs.helper.SecurityConfigConst;
import pgoc.f4e.pojos.common.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AuthUtility {

    public static void aadAuthHeader(HttpServletRequest request, HttpServletResponse response, User user) throws IOException, ServletException, JSONException {
        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 864_000_000))
                .signWith(SignatureAlgorithm.HS512, SecurityConfigConst.SECRETE_KEY.getBytes())
                .compact();
        response.addHeader(SecurityConfigConst.F4E_AUTH, "" + token);
    }
}
