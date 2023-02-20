package com.cg.spring.controller;

import java.net.URI;
import java.util.List;

 import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cg.spring.exception.UserNotFoundException;
import com.cg.spring.user.User;
import com.cg.spring.user.UserDaoService;

import jakarta.validation.Valid;

@RestController
public class UserController {

  private UserDaoService service;
  
/**
 * @param service
 */
public UserController(UserDaoService service) {
	this.service = service;
}


@GetMapping("/user")
public List<User> getAllUser(){
	
	return service.findAll();
	  
  }

@GetMapping("/users/{id}")
public EntityModel<User> fibdById(@PathVariable int id){
	
	 User user = service.findOne(id);
	 if(user == null)
		 throw new UserNotFoundException("id:"+id);
	 EntityModel<User> entityUser = EntityModel.of(user);
	 
	 WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUser());
	 entityUser.add(link.withRel("All-User"));
	 return entityUser;
	
}
//response entity is use to get the exact response from http like status code 
@PostMapping("/users")
public ResponseEntity<User> CreateUser(@Valid @RequestBody User user) {
	
	User savedUser =service.addUser(user);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser .getId()).toUri();
	return ResponseEntity.created(uri).build();
	
}

@DeleteMapping("/delete/{id}")
public void deleteUser(@PathVariable int id){
	service.deleteUser(id);
	
}
}
