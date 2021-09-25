package pgoc.f4e.utility;

import org.apache.commons.lang3.StringUtils;
import pgoc.f4e.configs.helper.AuthUser;

public class SignupValidator {

    public static boolean isValidSignupDetail(AuthUser authUser){
        if(StringUtils.isBlank(authUser.getUsername()) || StringUtils.isBlank(authUser.getPassword()))  return  false;
        if( authUser.getUsername().length() < 5 || authUser.getPassword().length() < 5) return false;
        return true;
    }
}
