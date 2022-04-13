package com.projeto.gestaoescolar.services;

import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {

    public static Object authenticated() {
        try {
            return (Object) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }

}
