package com.revaso.revaso.repositories;

import com.revaso.revaso.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAuthorByUsernameIgnoreCase(String username);

    Author getProfileByEmail(String email);

    Author findAuthorByUsername(String username);
    List<Author> findAuthorByUsernameStartsWith(String username);

    List<Author> findAuthorByfNameStartsWith(String fName);

    List<Author> findAuthorByEmailStartsWith(String email);


}
