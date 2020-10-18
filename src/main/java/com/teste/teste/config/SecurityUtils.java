package com.teste.teste.config;

import com.teste.teste.domain.Token;
import com.teste.teste.domain.User;
import com.teste.teste.domain.dto.TokenDTO;
import com.teste.teste.domain.dto.ValidateTokenDTO;
import com.teste.teste.repository.TokenRepository;
import com.teste.teste.utils.Assert;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityUtils {

    @Autowired
    private TokenRepository tokenRepository;

    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 60 * 5;

    public String generateToken(User user) {
        Map<String, Object> data = new HashMap<>();
        data.put("login", user.getLogin());
        data.put("name", user.getName());
        data.put("administador", user.isAdmin());

        JwtBuilder jwtBuilder = Jwts.builder();

        Date expiration = new Date().from(Instant.now().plusSeconds(EXPIRATION_TIME));

        jwtBuilder.setExpiration(expiration);
        String token = jwtBuilder.setClaims(data)
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                .compact();

        tokenRepository.save(new Token(token, expiration, user.isAdmin()));

        return token;
    }


    public ValidateTokenDTO renovarToken(TokenDTO tokenDTO) {
        Token token = Assert.found(tokenRepository.findOneByToken(tokenDTO.getToken()), "Token not found");

        token.setExpiration(new Date().from(Instant.now().plusSeconds(EXPIRATION_TIME)));

        Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(tokenDTO.getToken())
                .getBody().setExpiration(new Date().from(Instant.now().plusSeconds(EXPIRATION_TIME)));


        tokenRepository.save(token);

        return new ValidateTokenDTO(true, "Token Renovado Com Sucesso");
    }

    public static String getUserName(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
