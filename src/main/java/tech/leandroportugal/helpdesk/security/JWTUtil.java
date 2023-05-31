package tech.leandroportugal.helpdesk.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tech.leandroportugal.helpdesk.domain.Person;
import tech.leandroportugal.helpdesk.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class JWTUtil {

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.secret}")
    private String secret;

	@Autowired
	private PersonRepository repository;

    
   

	public String  generateToken(String email) {

		Optional<Person> name = repository.findByEmail(email);

		return Jwts.builder()
				.setIssuer(name.get().getName())
				.setSubject(email)
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}

    public boolean tokenIsvalid(String token) {
        Claims claims = getClaims(token);
		if(claims != null){
			String username = claims.getSubject();
			Date  expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());

			if(username != null && expirationDate != null && now.before(expirationDate)){
				return true;
			}
		}
		return false;
		
    }

    private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			return null;
		}
	}

	public String getUsername(String token) {
		Claims claims = getClaims(token);
		if(claims != null){
			return claims.getSubject();
		}
		return null;
	}

	public String getName(String token) {
        Claims claims = getClaims(token);
        if (claims != null) {
            return claims.getIssuer();
        }
        return null;
    }
}
