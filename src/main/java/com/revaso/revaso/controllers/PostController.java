package com.revaso.revaso.controllers;

import com.revaso.revaso.models.Author;
import com.revaso.revaso.models.Post;
import com.revaso.revaso.repositories.PostRepository;
import com.revaso.revaso.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PostController is responsible for connection between front end and back end. 
 * 
 * @author Sam, Lucnel, Niroj, Jimmy
 * It is passing the request parameters to Dao Class methods and returning the data to front end.
 * @CrossOrigin is used to handle the request from different origins. 
 *
 */
@RestController
//@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {
	
	@Autowired
	private PostRepository postRepository;


	@Autowired
	private AuthorService authorService;
	
	/**
	 * Mapping with the retrieve all posts request method.
	 * @return
	 */
	@GetMapping("/allPosts.do")
	public ResponseEntity<?> list(){
		List<Post> posts = postRepository.findAll();
		return ResponseEntity.ok().body(posts);
	}
	
	/**
	 * Mapping with the post update request method
	 * @param post
	 * @return
	 */
	@PostMapping("/updatePosts.do")
	public ResponseEntity<String> update(Post post){
		
		return ResponseEntity.ok().body("Post updated: " + post.toString());
	}
	
	/**
	 * Mapping with the get all posts by post Id.
	 * @param id
	 * @return
	 */
	@GetMapping(value="/allPosts/{id}")
	public Post getPostById(@PathVariable("id") Long id) {
		return postRepository.getPostById(id);
	}
	
	/**
	 * Mapping with the get all posts by user ID
	 * @param userId
	 * @return
	 */
	@GetMapping(value="/postsByUser/{userId}")
	public List<Post> getPostsByUserId(@PathVariable("userId") Long userId){

		 Author a = authorService.findAuthorById(userId);
		return a.getPosts();
	}

	@PutMapping(value="/likePost/{id}")
	public Post likePost(@PathVariable Long id) {
		Post postToLike = postRepository.getPostById(id);
		postToLike.setNumLikes(postToLike.getNumLikes()+1);
		postRepository.save(postToLike);
		return postToLike;
	}
	@PostMapping(value="/addPost.do/{authorId}")
	public ResponseEntity<String> insert(@RequestBody Post post, @PathVariable Long authorId){
		System.out.println("Post added... " + post.toString());
		Author a = authorService.findAuthorById(authorId);
//		a.setPosts(a);
		post.setAuthor(a);
		postRepository.save(post);
		return ResponseEntity.ok().body("Post added: " + post.toString());
	}
	
	@PostMapping(value="/deletePost")
	public ResponseEntity<String> delete(Post post){
		return ResponseEntity.ok().body("Post deleted: " + post.toString());
	}
}
