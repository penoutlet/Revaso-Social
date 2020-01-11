package com.revaso.revaso.repositories;

import com.revaso.revaso.models.Author;
import com.revaso.revaso.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Author getPostsByAuthor_Id(Long id);
    Post getPostById(Long id);

    List<Post> getPostsByAuthorOrderById(Long id);


}
