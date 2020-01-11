package com.revaso.revaso.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * 
 * @author Sam, Lucnel, Niroj, Jimmy
 * 
 * Post class is the model class responsible for creating table named POST which contains five fields.Such as,
 * Post_ID, User_ID, Post_Title,Post_Body and Num_Likes.
 * Post_ID is the primary key in this table and it is generating automatically.
 * 
 * This class has ManyToOne relationship and The using  @JoinColumn, 
 * annotation helps us specify the column we'll use for joining an entity association or element collection.
 * 
 *Setters and Getters have been used for update and retrieve values .
 */

@Entity
@Table(name = "POST")
public class Post {

	@Id
	@Column(name = "POST_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(name = "USER_ID", nullable = false)
//	private int userId;
	
	@Column(name = "POST_TITLE", nullable = false)
	@NotBlank( message = "Post must have a title")
	private String postTitle;
	
	@Column(name = "POST_BODY", nullable = false)
	@NotBlank( message = "Post must have a body")
	private String postBody;
	
	@Column(name = "NUM_LIKES")
	private int numLikes;
	
	@Column(name = "POST_IMAGE")
	private String postImage;
	//private List<Ulike> whoseLiked;
	
	@ManyToOne(targetEntity= Author.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JsonIgnore
	private Author author;
//	private Long author_id;

	public Post() {
		
	}


	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostBody() {
		return postBody;
	}

	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}

	public int getNumLikes() {
		return numLikes;
	}

	public void setNumLikes(int numLikes) {
		this.numLikes = numLikes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostImage() {
		return postImage;
	}

	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

//	@Override
//	public String toString() {
//		return "Post{" +
//				"id=" + id +
//				", postTitle='" + postTitle + '\'' +
//				", postBody='" + postBody + '\'' +
//				", numLikes=" + numLikes +
//				", postImage='" + postImage + '\'' +
//				", author=" + author +
//				'}';
//	}


	/**
	 *  toString method to return the retrieved data.
	 */


	}

	/**
	 * Constructs and initializes a post.
	 * @param postId  Id of the post.
	 * @param userId  Id of the post creator.
	 * @param postTitle  Title of the post.
	 * @param postBody   Actual post written by user.
	 * @param numLikes   The number of likes received by other users.
	 * @param profiles   The other users profile who liked the post.
	 */

	/**
	 * Constructs and initializes a post.
	 * @param postId   Id of the post.
	 * @param userId   Id of the post creator.
	 * @param postTitle  Title of the post.
	 * @param postBody   Actual post written by user.
	 * @param numLikes   The number of likes received by other users.
	 */


	

