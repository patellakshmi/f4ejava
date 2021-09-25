package pgoc.f4e.service;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pgoc.f4e.configs.helper.AuthUser;
import pgoc.f4e.models.PotentialUser;
import pgoc.f4e.pojos.responses.GenericResponse;
import pgoc.f4e.repositories.PotentialUserRepo;
import pgoc.f4e.utility.AuthUtility;
import pgoc.f4e.utility.IdGenerator;
import pgoc.f4e.utility.SignupValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class SignupServiceImpl implements SignupService{

    @Autowired
    private PotentialUserRepo potentialUserRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<GenericResponse> signupPotentialUser(AuthUser authUser, HttpServletRequest request, HttpServletResponse response) throws ServletException, JSONException, IOException {

        if(!SignupValidator.isValidSignupDetail(authUser)){
            return new ResponseEntity<GenericResponse>(new GenericResponse("SUCCESS", "User & Pass must contains more than 4 chars"), HttpStatus.FOUND);
        }

        authUser.setPassword(this.passwordEncoder.encode(authUser.getPassword()));
        String uniqueId = null;
        PotentialUser existingUser = null;
        do{
            uniqueId = IdGenerator.getUniqueId();
            existingUser = potentialUserRepo.findByAnyOfUniqueField(uniqueId);
        }while (existingUser != null);

        PotentialUser existingUser1 = potentialUserRepo.findByAnyOfUniqueField(authUser.getUsername());
        if( existingUser1 != null){
            return new ResponseEntity<GenericResponse>(new GenericResponse("SUCCESS", "Please use different user-name"), HttpStatus.FOUND);
        }
        PotentialUser potentialUser = new PotentialUser( uniqueId,  authUser.getUsername(), authUser.getPassword());
        potentialUserRepo.save(potentialUser);
        AuthUtility.aadAuthHeader(request, response, authUser);
        return new ResponseEntity<GenericResponse>(new GenericResponse("SUCCESS", "Thanks for signup!"), HttpStatus.OK);

    }

}
