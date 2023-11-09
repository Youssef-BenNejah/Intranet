package com.example.intranet.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor

public enum Role {
    EMPLOYE(Collections.emptySet()),
    MANAGER(
            Set.of(
                    Permession.MANAGER_CREATE,
                    Permession.MANAGER_PUT,
                    Permession.MANAGER_DELETE,
                    Permession.MANAGER_READ
            )
    ),
    ADMIN(
            Set.of(
                    Permession.ADMIN_CREATE,
                    Permession.ADMIN_READ,
                    Permession.ADMIN_PUT,
                    Permession.ADMIN_DELETE,
                    Permession.MANAGER_CREATE,
                    Permession.MANAGER_PUT,
                    Permession.MANAGER_DELETE,
                    Permession.MANAGER_READ
            )
            );
    @Getter
    private final Set<Permession> permessions;
    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities =  getPermessions()
                .stream()
                .map(permession -> new SimpleGrantedAuthority(permession.getPermession()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities;


    }


}
