package app.dev.labs.appdev_labs510.security;

import app.dev.labs.appdev_labs510.daos.UserRepository;
import app.dev.labs.appdev_labs510.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return new User(user.getEmail(), user.getPassword(), user.isEnabled(),
                user.isAccountNonExpired(),user.isCredentialsNonExpired(), user.isAccountNonLocked(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
    }
}
