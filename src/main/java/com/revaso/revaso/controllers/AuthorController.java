package com.revaso.revaso.controllers;

import com.revaso.revaso.models.Author;
import com.revaso.revaso.services.MapValidationErrorService;
import com.revaso.revaso.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * ProfileController is responsible for connection between front end and back end. 
 *
 * @author IBM
 * It is passing the request parameters to Dao Class methods and returning the data to front end.
 * @CrossOrigin is used to handle the request from different origins. 
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthorController {

	private MapValidationErrorService mapValidationErrorService;
	private AuthorService authorService;

	public AuthorController(MapValidationErrorService mapValidationErrorService, AuthorService authorService) {
		this.mapValidationErrorService = mapValidationErrorService;
		this.authorService = authorService;
	}
	
	/**
	 * Mapping with getting all profiles method.
	 * @return  Return a list of profiles.
	 */

	@GetMapping("/getAllProfiles.do")
	public ResponseEntity<List<Author>> list(){
		List<Author>Plist = authorService.findAllAuthors();
		return ResponseEntity.ok().body(Plist);
	}
	



	//insert a profile
	@CrossOrigin("http://localhost:4200")
	@PostMapping(value="/addProfile.do")
	public ResponseEntity<?> insert(@RequestBody @Valid Author author, BindingResult result){


		ResponseEntity<?> errors = mapValidationErrorService.MapValidationService(result);
		if (errors.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
			return errors;
		}

		authorService.addAuthor(author);
		return new ResponseEntity<Author>(author, HttpStatus.CREATED);
	}
	 
	/**
	 * Mapping with select by user Id method.
	 * @param id    Passing user Id as a parameter.
	 * @return      Return the specific user profile.
	 */
	//select profile by ID
	@GetMapping("/selectProfileByID/{id}.do")
	public ResponseEntity<Author> selectById(@PathVariable("id") Long id){

		Author author = authorService.findAuthorById(id);
		return ResponseEntity.ok().body(author);
	}
	
	@PutMapping("/updateProfile/{id}")
	public Author updateAndReturn(@PathVariable int id, @RequestBody Author author) {
		System.out.println("Updating profile: " + author.toString());
		Author newProfile = authorService.addAuthor(author);
		System.out.println("New profile in controller: " + newProfile.toString());
		return newProfile;
//		return ResponseEntity.ok().body("Profile updated: " + newProfile.toString());
	}
	
//	@PutMapping("/resetPassword/{username}")
//	public HttpStatus resetPassword(@PathVariable String username, @RequestBody Profile profile) {
//
//		Profile foundProfile = proDao.selectByUserName(username); // find profile of the user
//		String tempPass = SendEmail.sendMail(foundProfile.getEmail());
//		if(foundProfile.getUserPassword().equals("false")) {
//			System.out.println("SMTP failed. Resetting password to 'false' for user: " + foundProfile.getUserName());
//			return HttpStatus.NOT_IMPLEMENTED;
//		}
////		String tempPass = "false";
//		foundProfile.setUserPassword(tempPass);
//		proDao.update(foundProfile.getUserId(), foundProfile); //update the atabase
//		System.out.println("Password reset and sent to: " + foundProfile.getEmail());
//		return HttpStatus.OK;  //send a message to front end
//
//	}

}




