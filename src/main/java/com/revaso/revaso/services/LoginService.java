package com.revaso.revaso.services;

import com.revaso.revaso.exceptions.UserDoesNotExistException;
import com.revaso.revaso.models.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


//    public ResponseEntity<Author> returnLoggedInUser(String userName) {
//        ResponseEntity<Author> authorResponseEntity =new ResponseEntity<Author>(new Author(), HttpStatus.BAD_REQUEST);
//        try {
//            Author p = profileRepository.findAuthorByUsername(userName);
//            return authorResponseEntity = new ResponseEntity<Author>(p, HttpStatus.ACCEPTED);
//        } catch (Exception e) {
//            throw new UserDoesNotExistException("No such user found");
//        }
////        return new ResponseEntity<Author>(new Author(), HttpStatus.BAD_REQUEST);
//    }
}
