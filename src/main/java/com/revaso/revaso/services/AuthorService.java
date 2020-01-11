package com.revaso.revaso.services;

import com.revaso.revaso.exceptions.UserExistsException;
import com.revaso.revaso.models.Author;
import com.revaso.revaso.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(Author author) {

        try {
            return authorRepository.save(author);
        } catch (Exception e) {
            throw new UserExistsException("That username is already taken");
//            e.printStackTrace();
        }
    }

    public List<Author> findAllAuthors() {

        return authorRepository.findAll();
    }


    public Author findAuthorById(Long id){
        return authorRepository.findById(id).get();
    }


    public Author findByUsername(String username) {
        return authorRepository.findAuthorByUsername(username);
    }


}
