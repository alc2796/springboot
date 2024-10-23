package com.alc.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alc.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.alc.rest.webservices.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController 
public class UserJpaResource {

	private UserRepository userRepository;
	private PostRepository postRepository;
	
	public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}
	
	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		
		if (user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
		}
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	public void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}
	
	@PostMapping(path = "/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder
							.fromCurrentRequest() //Nos proporciona el path de la request actual
							.path("/{id}") //anadimos al path /id
							.buildAndExpand(savedUser.getId()) //cogemos el ID del usuario creado
							.toUri(); //convertimos a URI
		return ResponseEntity.created(location).build();
	}
	
	/* Post */
	
	@GetMapping(path = "jpa/users/{id}/posts")
	public List<Post> retrivePostsForUser(@PathVariable int id){
		
		Optional<User> user = userRepository.findById(id);
		
		if (user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
		}
		
		return user.get().getPosts();

	}
	
	@GetMapping(path = "jpa/users/{user_id}/posts/{post_id}")
	public Post retrivePostForUser(@PathVariable int user_id, @PathVariable int post_id){
			
	    User user = userRepository.findById(user_id)
                .orElseThrow(() -> new UserNotFoundException("user_id:" + user_id));

		Post post = postRepository.findById(post_id)
		                   .orElseThrow(() -> new PostNotFoundException("post_id:" + post_id));
		
		if (!user.getPosts().stream().anyMatch(p -> p.getId() == post_id)) {
		throw new PostNotFoundForUserException("post_id: " + post_id + " not exist for user_id: " + user_id);
		}
		
		return post;

	}
	
	@PostMapping(path = "jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post){
		
		Optional<User> user = userRepository.findById(id);
		
		if (user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
		}
		
		post.setUser(user.get());
		Post savedPost = postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest() //Nos proporciona el path de la request actual
				.path("/{id}") //anadimos al path /id
				.buildAndExpand(savedPost.getId()) //cogemos el ID del usuario creado
				.toUri(); //convertimos a URI
		return ResponseEntity.created(location).build();

		

	}
	
}
