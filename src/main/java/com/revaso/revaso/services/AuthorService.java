package com.revaso.revaso.services;

import com.revaso.revaso.exceptions.UserExistsException;
import com.revaso.revaso.models.Author;
import com.revaso.revaso.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository profileRepository;
    @Autowired
    public AuthorService(AuthorRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Author addProfile(Author author) {

        try {
            return profileRepository.save(author);
        } catch (Exception e) {
            throw new UserExistsException("That username is already taken");
        }
    }

    public List<Author> findAllProfiles() {

        return profileRepository.findAll();
    }


    public Author findProfileById(Long id){
        return profileRepository.findById(id).get();
    }


    public Author findByUsername(String username) {
        return profileRepository.findAuthorByUsernameIgnoreCase(username);
    }


}
