package corso.java.securitysample.services.dto;

import corso.java.securitysample.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class RegisterRequestDto {
	private String password;
	private String username;
	private Role role;
}
