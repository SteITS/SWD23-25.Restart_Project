package com.restart.security;

import com.restart.entity.Role;
import com.restart.entity.User;
import com.restart.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    // Costruttore che inizializza il repository degli utenti
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Metodo per caricare un utente in base all'email
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Ricerca dell'utente nel repository per email
        User user = userRepository.findByEmail(email);

        // Se l'utente esiste, restituisce i dettagli dell'utente con le relative autorità
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
        } else {
            // Se l'utente non esiste, lancia un'eccezione
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    // Metodo per mappare i ruoli dell'utente nelle autorità di sicurezza
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        // Mappatura dei ruoli a oggetti GrantedAuthority
        Collection<? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}
