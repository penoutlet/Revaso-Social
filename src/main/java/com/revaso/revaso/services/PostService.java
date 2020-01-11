package com.revaso.revaso.services;

import com.revaso.revaso.models.Author;
import com.revaso.revaso.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Author findByPostId(Long id) {
        return postRepository.getPostsByAuthor_Id(id);
    }
}
