package com.bookstore;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookstore.domain.Order;
import com.bookstore.domain.User;
import com.bookstore.repository.OrderRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.OrderService;
import com.bookstore.service.UserService;


@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderRepository orderRepository;
	
	
//	@Autowired 
//	ShoppingCartService shoppingCartService;
//	
//	@Autowired
//	ShoppingCartRepository shoppingCarRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	//spring security and database access

	@Override
	public void run(String... arg0) throws Exception {
		
		//add order to user table
//		User user = userService.findById(8L);
//		List<Order> listOfOrder = (List<Order>) orderRepository.findAll();
//		user.setOrderList(listOfOrder);
//		userRepository.save(user);
//		System.out.println("user set order success >>> ");
//		user.getOrderList().forEach(item -> System.out.println(item.getUser().getUsername()));
		
//		List<User> users = userRepository.findAll();
//		for(User one : users){
//			if(one.getUsername().equals("monica")) {
//				continue;
//			}
//			one.setOrderList(new ArrayList<Order>());
//			userRepository.save(one);
//		}
		
		
		
		//change user email
//		User jing = userService.findByUsername("fujing");
//		jing.setEmail("jingfu0815@gmail.com");
//		userRepository.save(jing);
//		User monica = userService.findByUsername("monica");
//		monica.setEmail("fu.jing1@husky.neu.edu");
//		userRepository.save(monica);
		
		//add shopping cart to user 
//		List<User> listOfUser = userRepository.findAll();
//		List<ShoppingCart>  listOfShoppingCart = shoppingCarRepository.findAll();
//		for (User user : listOfUser) {
//			System.out.println(user.getUsername());
//			user.setShoppingCart(new ShoppingCart());
//			userRepository.save(user);
//			}
//		for (ShoppingCart cart : listOfShoppingCart) {
//			if (cart.getId() == 3L) {
//				for (User user : listOfUser) {
//					if (user.getId() == 3L) cart.setUser(user);
//					System.out.println("set user success? "+cart.getUser().getUsername());
//					shoppingCarRepository.save(cart);
//					break;
//				}
//			break;
//			}
//		}
		
		
		//create user 
//		User user1 = new User();
//		user1.setFirstName("Jing");
//		user1.setLastName("Fu");
//		user1.setEmail("fujing0815@gmail.com");
//		user1.setUsername("fujing");
//		user1.setPassword(SecurityUtility.passwordEncoder().encode("123"));
//		
//		Role role1 = new Role();
//		role1.setName("user");
//		role1.setRoleId(1);
//		
//		Set<UserRole> userRoles = new HashSet<UserRole>();
//		userRoles.add( new UserRole(user1, role1) );
//		
//		userService.createUser(user1,userRoles);
//		userRoles.clear();
//		
//		//create user
//		User user2 = new User();
//		user2.setFirstName("Yuhao");
//		user2.setLastName("Yang");
//		user2.setUsername("yyh");
//		user2.setPassword(SecurityUtility.passwordEncoder().encode("123"));
//		user2.setEmail("yangyuhao@yahoo.com");
//		
//		Role role2 = new Role();
//		role2.setRoleId(2);
//		role2.setName("admin");
//		userRoles.add(new UserRole(user2,role2));
//		
//		userService.createUser(user2, userRoles);
		
	}
	
}
