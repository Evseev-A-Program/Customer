package com.example.customer.security.details;

import com.example.customer.models.Customer;
import com.example.customer.models.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UserDetailsImpl implements UserDetails {

    private final Customer customer;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String userRole = customer.getRole().name();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userRole);
        return Collections.singleton(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return customer.getHashPassword();
    }

    @Override
    public String getUsername() {
        return customer.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !customer.getState().equals(State.BANNED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return customer.getState().equals(State.ACTIVE);
    }
}
