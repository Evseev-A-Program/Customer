//package com.example.customer.security.token;
//
//import com.example.customer.models.Token;
//import com.example.customer.repository.TokenDao;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.Date;
//import java.util.Optional;
//
///**
// * 25.04.2018
// * TokenAuthenticationProvider
// *
// * @author Sidikov Marsel (First Software Engineering Platform)
// * @version v1.0
// */
//@Component
//public class TokenAuthenticationProvider implements AuthenticationProvider{
//
//    @Autowired
//    private TokenDao tokenDao;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;
//
//        Optional<Token> tokenCandidate = tokenDao.findOneByValue(tokenAuthentication.getName());
//
//        if (tokenCandidate.isPresent()) {
//            UserDetails userDetails = userDetailsService.loadUserByUsername(tokenCandidate.get().getCustomer().getEmail());
//            tokenAuthentication.setUserDetails(userDetails);
//            tokenAuthentication.setAuthenticated(true);
//            return tokenAuthentication;
//        } else throw new IllegalArgumentException("Bad token");
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return TokenAuthentication.class.equals(authentication);
//    }
//
//    @Value("$(jwt.secret)")
//    private String jwtSecret;
//
//    public String generateToken(String login) {
//        Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
//        return Jwts.builder()
//                .setSubject(login)
//                .setExpiration(date)
//                .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
//    }
//
//}