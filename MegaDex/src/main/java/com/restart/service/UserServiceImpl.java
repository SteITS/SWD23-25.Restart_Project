package com.restart.service;

import com.restart.dto.UserDto;
import com.restart.entity.Role;
import com.restart.entity.User;
import com.restart.repository.RoleRepository;
import com.restart.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //Metodo per salvare un nuovo utente
    @Override
    public void saveUser(UserDto userDto) {
        // Crea un nuovo oggetto User
        User user = new User();

        // Imposta nome completo concatenando nome e cognome dal DTO
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());

        // Imposta email
        user.setEmail(userDto.getEmail());

        // Codifica la password utilizzando Spring Security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        // Recupera il ruolo "ROLE_ADMIN" dal repository
        Role role = roleRepository.findByName("ROLE_ADMIN");

        // Se il ruolo non esiste, crealo e salvalo
        if (role == null) {
            role = checkRoleExist();
        }

        // Assegna il ruolo all'utente
        user.setRoles(Arrays.asList(role));

        // Salva l'utente nel database
        userRepository.save(user);
    }

    //Metodo per recuperare l'utente attualmente autenticato nella sessione
    @Override
    public User getAuthenticatedUser() {
        // Recupera l'autenticazione corrente dal SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Ottiene l'email dell'utente attualmente autenticato
        String currentUserEmail = authentication.getName();

        // Cerca l'utente con l'email recuperata
        return findUserByEmail(currentUserEmail);
    }

    //Metodo per cercare l'utente tramite email
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    // Recupera tutti gli utenti dal repository
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Cerca l'utente con l'ID specificato
    @Override
    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    // Recupera tutti gli utenti dal repository
    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();

        // Converte la lista di utenti in una lista di UserDto
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    //Metodo per ricercare il DTO di uno specifico utente
    private UserDto mapToUserDto(User user) {
        // Crea un nuovo oggetto UserDto
        UserDto userDto = new UserDto();

        // Separa nome e cognome dall'attributo "name" dell'utente
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);

        // Imposta l'email
        userDto.setEmail(user.getEmail());

        // Restituisce il DTO dell'utente
        return userDto;
    }

    //Metodo per verificare se un ruolo per gli utenti esiste già
    private Role checkRoleExist() {
        // Crea un nuovo oggetto Role con nome "ROLE_ADMIN"
        Role role = new Role();
        role.setName("ROLE_ADMIN");

        // Salva il ruolo nel database e restituiscilo
        return roleRepository.save(role);
    }
    
    //Metodo per eliminare un utente dal database
    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}