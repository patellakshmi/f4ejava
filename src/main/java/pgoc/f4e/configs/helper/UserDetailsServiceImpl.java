package pgoc.f4e.configs.helper;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pgoc.f4e.models.PotentialUser;
import pgoc.f4e.models.ProminentUser;
import pgoc.f4e.pojos.common.User;
import pgoc.f4e.repositories.PotentialUserRepo;
import pgoc.f4e.repositories.ProminentUserRepo;

import java.util.Collections;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private PotentialUserRepo potentialUserRepo;
    private ProminentUserRepo prominentUserRepo;

    public UserDetailsServiceImpl(PotentialUserRepo potentialUserRepo, ProminentUserRepo prominentUserRepo) {
        this.potentialUserRepo = potentialUserRepo;
        this.prominentUserRepo = prominentUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        PotentialUser potentialUser = potentialUserRepo.findByAnyOfUniqueField(username);
        ProminentUser prominentUser = prominentUserRepo.findByAnyOfUniqueField(username);

        User user = User.getUser(username, potentialUser, prominentUser);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}