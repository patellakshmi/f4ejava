package pgoc.f4e.configs.helper;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pgoc.f4e.models.PotentialUser;
import pgoc.f4e.models.ProminentUser;
import pgoc.f4e.repositories.PotentialUserRepository;
import pgoc.f4e.repositories.ProminentUserRepository;

import java.util.Collections;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private PotentialUserRepository potentialUserRepository;
    private ProminentUserRepository prominentUserRepository;

    public UserDetailsServiceImpl(PotentialUserRepository potentialUserRepository, ProminentUserRepository prominentUserRepository) {
        this.potentialUserRepository = potentialUserRepository;
        this.prominentUserRepository = prominentUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        PotentialUser potentialUser = potentialUserRepository.findByAnyOfUniqueField(username);
        ProminentUser prominentUser = prominentUserRepository.findByAnyOfUniqueField(username);

        AuthUser authUser = AuthUser.getUser(username, potentialUser, prominentUser);

        if (authUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(authUser.getUsername(), authUser.getPassword(), Collections.emptyList());
    }
}