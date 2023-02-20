package com.cg.spring.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<User>();
	private static int countUser =0;
	
	static {
		users.add(new User(++countUser,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(++countUser,"suhail",LocalDate.now().minusYears(24)));
		users.add(new User(++countUser,"jadhav",LocalDate.now().minusYears(40)));
		users.add(new User(++countUser,"yogesh",LocalDate.now().minusYears(49)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
		
		Predicate<? super User> predicate = user ->user.getId()==(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
		
	}
	
	public User addUser(User user) {
		user.setId(++countUser);
		users.add(user);
		return user;
	}
	
	public void deleteUser(int id) {
		Predicate<? super User> predicate = user -> user.getId()== id;
		users.remove(predicate );
	}

}
