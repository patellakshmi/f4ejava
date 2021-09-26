package pgoc.f4e.controllers;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pgoc.f4e.configs.helper.AuthUser;
import pgoc.f4e.constants.APIConstant;
import pgoc.f4e.pojos.responses.GenericResponse;
import pgoc.f4e.service.SignupService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
public class SignupController {

    @Autowired
    SignupService signupService;

    @PostMapping(APIConstant.SIGNUP)
    public ResponseEntity<GenericResponse> signUp(@RequestBody AuthUser authUser, HttpServletRequest request, HttpServletResponse response) throws ServletException, JSONException, IOException {
        return signupService.signupPotentialUser(authUser, request, response);
    }




}
