package com.revaso.revaso.controllers;

import com.revaso.revaso.models.Author;
import com.revaso.revaso.services.AuthorSearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class SearchAuthorController {

    private AuthorSearchService authorSearchService;

    public SearchAuthorController(AuthorSearchService authorSearchService) {
        this.authorSearchService = authorSearchService;
    }

    /**
     * Mapping with the select by first name method.
     * @param firstName   Passing first name as a parameter.
     * @return    Return a list of profiles.
     */
	@GetMapping("/selectProfileByFirstName/{firstName}.do")
	public ResponseEntity<List<Author>> selectProfileByFirstName(@PathVariable("firstName") String firstName){
		List<Author> authors = authorSearchService.findByFirstNameLike(firstName);
		return ResponseEntity.ok().body(authors);
	}

    /**
     *
     * Mapping with select by email method.
     * @param email    Passing email id as a parameter.
     * @return     Returning profile of the specific user.
     */

    	@GetMapping("/selectProfileByEmail/{email}.do")
	public ResponseEntity<List<Author>> selectProfileByEmail(@PathVariable("email") String email){
		List<Author> authors = authorSearchService.findByEmailStartsWith(email);
		return ResponseEntity.ok().body(authors);
	}


    /**
     * Mapping with select by user name method.
     * @param userName    Passing user name as a parameter.
     * @return     Returning profile of the specific user.
     */
	@GetMapping("/selectProfileByUsername/{username}.do")
	public ResponseEntity<List<Author>> selectProfileByUsernameStartsWith(@PathVariable("username") String username){
		List<Author> authors = (List<Author>) authorSearchService.findByUsernameStartsWith(username);
		return new ResponseEntity<>(authors, HttpStatus.ACCEPTED);
	}


}
