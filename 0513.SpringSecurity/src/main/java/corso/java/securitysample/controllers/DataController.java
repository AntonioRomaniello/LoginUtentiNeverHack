package corso.java.securitysample.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corso.java.securitysample.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class DataController {

    private final UserRepository userRepository; // Iniettare il repository degli utenti

    @GetMapping
    public ResponseEntity<List<String>> test() {
        // Recupera tutti gli utenti dal database e crea una lista di stringhe con username e ruolo
        List<String> usersWithRoles = userRepository.findAll().stream()
                .map(user -> String.format("Utente: %s, Ruolo: %s", user.getUsername(), user.getRole()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(usersWithRoles);
    }
}
