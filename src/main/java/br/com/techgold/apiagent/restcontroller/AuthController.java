package br.com.techgold.apiagent.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.techgold.apiagent.security.JWTService;
import br.com.techgold.apiagent.security.dto.AuthRequest;
import br.com.techgold.apiagent.security.dto.AuthResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Value("${sistech.security.agentkey}")
    private String AGENT_KEY;

    @Autowired private JWTService jwtService;

    @PostMapping("/token")
    public ResponseEntity<AuthResponse> gerarToken(@RequestBody AuthRequest request) {
        if (!AGENT_KEY.equals(request.getAgentKey())) {
            return ResponseEntity.status(401).build(); // Unauthorized
        }

        UserDetails userDetails = jwtService.loadUserByUsername("agent-system");

        String token = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
