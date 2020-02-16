package com.revaso.revaso.controllers;

import com.revaso.revaso.models.LoginCredentials;
import com.revaso.revaso.models.Author;
import com.revaso.revaso.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Component
public class LoginController {

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping(value = "/login.do")
    public Author login(@RequestBody LoginCredentials creds) {
        if (creds == null) {
            return null;
        }
        Author found = returnLoggedInUser(creds.getUsername());
        if (creds.getPassword().equals(found.getUserPassword())) {
            return found;
        } else {
            return null;
        }
    }

    public Author returnLoggedInUser(String userName) {
        Author p = authorRepository.findAuthorByUsername(userName);
        System.out.println(p);
        return p;
    }
}
