package com.revaso.revaso.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * This is the Profile model class creates Profile table. 
 * It has constructors, getters and setters to assign the values.
 * @author Sam, Lucnel, Niroj, Jimmy 
 * 
 * Profile table has fields which holds user's personal information including user name and password.
 * The user ID will be incremented automatically with the use of @GeneratedValue annotation.
 *
 */
@Entity
@Table(name = "AUTHOR")
public class Author {
	
	@Id // primary key
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement our id
	private Long id;
	
	@Column(name = "USERNAME", unique = true, nullable = false)
	private String username;
	
	@Column(name = "USERPASSWORD", nullable = false)
	private String userPassword;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String fName;
	
	@Column(name = "LAST_NAME", nullable = false)
	private String lName;
	
	@Column(name = "GENDER", nullable = false)
	private String gender;
	
	@Column(name="PROFILE_IMAGE")
	private String profileImage;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
	@JsonIgnore
	private List<Post> posts;

	public Author() {
		
	}

	/**
	 * Constructs and initializes the values for variables.
	 * @param userName      Passing User name value.
	 * @param userPassword  Passing the password value
	 * @param fName         Passing the first name of the user.
	 * @param lName			Passing the last name of the user.
	 * @param gender		Passing the gender of the user.
	 * @param email			Passing the email id of the user.
	 */
	public Author(String userName, String userPassword, String fName, String lName, String gender, String email) {
		super();
		this.username = username;
		this.userPassword = userPassword;
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

//	@Override
//	public String toString() {
//		return "Profile{" +
//				"Id=" + id +
//				", username='" + username + '\'' +
//				", userPassword='" + userPassword + '\'' +
//				", phoneNum=" + phoneNum +
//				", fName='" + fName + '\'' +
//				", lName='" + lName + '\'' +
//				", gender='" + gender + '\'' +
//				", profileImage='" + profileImage + '\'' +
//				", city='" + city + '\'' +
//				", email='" + email + '\'' +
//				", posts=" + posts +
//				'}';
//	}

}
