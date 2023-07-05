package com.icaroaraujo.workshopmongo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icaroaraujo.workshopmongo.domain.User;
import com.icaroaraujo.workshopmongo.repository.UserRepository;
import com.icaroaraujo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> optionalUser = repo.findById(id);
		try {
			User user = optionalUser.get();
			return user;
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}

	}
}
