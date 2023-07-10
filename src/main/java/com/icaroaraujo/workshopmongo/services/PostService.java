package com.icaroaraujo.workshopmongo.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icaroaraujo.workshopmongo.domain.Post;
import com.icaroaraujo.workshopmongo.repository.PostRepository;
import com.icaroaraujo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> optionalUser = repo.findById(id);
		try {
			Post post = optionalUser.get();
			return post;
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}

	}
	
	
}
