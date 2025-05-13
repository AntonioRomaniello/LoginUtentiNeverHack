package corso.java.securitysample.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corso.java.securitysample.entities.UsersRepository;


@RestController
@RequestMapping("/api/test")
public class DataController {

	@GetMapping
	public ResponseEntity<List<String>> test() {
		
		UsersRepository usersRepository;
		List<String> roles = usersRepository
				.findAll().stream()
				.map(r -> String.format("Utente: %s, Ruolo %s",r.getUsername(),r.getRole())
						.collect(Collectors.toList()));
		return ResponseEntity.ok( //
				IntStream.range(0, 100) //
						.mapToObj(n -> String.format("Stringa %s", n)) //
						.toList());
	}
}
