package pgoc.f4e.configs.helper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pgoc.f4e.models.PotentialUser;
import pgoc.f4e.models.ProminentUser;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthUser {

    private String username;
    private String password;

    public static AuthUser getUser(String username, PotentialUser potentialUser, ProminentUser prominentUser){
        if(potentialUser != null)
            return AuthUser.builder().username(username).password(potentialUser.getPassword()).build();
        if(prominentUser != null)
            return AuthUser.builder().username(username).password(prominentUser.getPassword()).build();
        return null;
    }

    public static AuthUser getUser(String username, PotentialUser potentialUser){
        if(potentialUser != null)
            return AuthUser.builder().username(username).password(potentialUser.getPassword()).build();
        return null;
    }

    public static AuthUser getUser(String username, ProminentUser prominentUser){
        if(prominentUser != null)
            return AuthUser.builder().username(username).password(prominentUser.getPassword()).build();
        return null;
    }

}
