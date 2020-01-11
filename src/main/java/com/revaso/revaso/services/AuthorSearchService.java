package com.revaso.revaso.services;

import com.revaso.revaso.models.Author;
import com.revaso.revaso.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorSearchService {

    private AuthorRepository authorRepository;
    public AuthorSearchService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findByUsernameStartsWith(String username) {
        System.out.println("Username ignore case");
        return authorRepository.findAuthorByUsernameStartsWith(username);
    }

    public List<Author> findByFirstNameLike(String fName) {
        return authorRepository.findAuthorByfNameStartsWith(fName);
    }

    public List<Author> findByEmailStartsWith(String fName) {
        return authorRepository.findAuthorByEmailStartsWith(fName);
    }

    public List<Author> findByUsernameIgnoreCase(String username) {

        return authorRepository.findAuthorByUsernameIgnoreCase(username);
    }
}
