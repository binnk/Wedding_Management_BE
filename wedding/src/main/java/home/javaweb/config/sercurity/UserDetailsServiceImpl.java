package home.javaweb.config.sercurity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import home.javaweb.repository.*;
import home.javaweb.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository UserRepository;

    public UserDetailsServiceImpl(home.javaweb.repository.UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User User = UserRepository.findByUsername(username);
        if (User == null) {
            throw new UsernameNotFoundException(username);
        }
        return User;
    }
}