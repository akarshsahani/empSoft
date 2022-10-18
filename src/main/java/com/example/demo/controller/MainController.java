package com.example.demo.controller;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.config.SecurityConfiguration;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/login")
	public String login() {
		return"login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
	@GetMapping("/listuserdetails")
	//@PreAuthorize("hasRole('ADMIN')")
	public String listUserDetails(Model model) {
		User listUserDetails =  userRepository.findByUserEmail(userServiceImpl.email);
		System.out.println("user details are: " + listUserDetails);
		model.addAttribute("listUserDetails",listUserDetails);
		System.out.println("Model data is: " + model);
		
		System.out.println(listUserDetails.getRoles());
		System.out.println("user role: " + listUserDetails.getUserRole());
		List<Role> listRoles = userServiceImpl.listRoles();
	    System.out.println("list of reoles: " + listRoles);
	    
		return "userdetails";
	}
	
//	@GetMapping("/users")
//	public String listUsers(Model model) {
//	    List<User> listUsers = userServiceImpl.listAll();
//	    model.addAttribute("listUsers", listUsers);
//	     
//	    return "users";
//	}
	

	
	@GetMapping("/alluserdetails")
	@PreAuthorize("hasRole('ADMIN')")
	public String listUsers(Model model) {
	    List<User> listUsers = userServiceImpl.listAll();
	    for (Iterator iterator = listUsers.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
		   			
		}
	    System.out.println(listUsers);
	    model.addAttribute("listUsers", listUsers);
	     
	    return "allusers";
	}
	
	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable("id") Long id, Model model) {
	    User user = userServiceImpl.get(id);
	    List<Role> listRoles = userServiceImpl.listRoles();
	    System.out.println(listRoles);
	    model.addAttribute("user", user);
	    model.addAttribute("listRoles", listRoles);
	    return "edit";
	}
	
	@PostMapping("/users/save")
	public String saveUser(User user) {
		System.out.println("uder details to be saved: " + user);
		
		userRepository.save(user);
		
		if (userServiceImpl.email.equals(user.getUserEmail()))
			return "redirect:/alluserdetails";
		
		else
			return "redirect:/listuserdetails";
	}
	
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id, Model model) {
		Optional<User> user1 = userRepository.findById(id);
		System.out.println(user1);
		userRepository.deleteById(id);
		User user = userRepository.findByUserEmail(userServiceImpl.email);
		
		if(user != null) {
			return "redirect:/alluserdetails";
		}
		else
			return "redirect:/login";
	}
	
//	@PatchMapping("/users/edit/{id}")
//    public String updateUserPartially(
//    @PathVariable(value = "id") Long userId,
//     @RequestBody User userDetails)  {
//        User user = userRepository.findByUserId(userId);
//        System.out.println("user before edit: " + user);
//        if (userDetails.getUserEmail() !=null)
//        	user.setUserEmail(userDetails.getUserEmail());
//        if (userDetails.getUserGender() != null)
//        	user.setUserAge(userDetails.getUserAge());
//        if (userDetails.getUserFirstName() !=null)
//        	user.setUserFirstName(userDetails.getUserFirstName());
//        if (userDetails.getUserLastName() !=null)
//        	user.setUserLastName(userDetails.getUserLastName());
//        if (userDetails.getUserGender() !=null)
//        	user.setUserGender(userDetails.getUserGender());
//        if (userDetails.getUserPhoneNumber() != null)
//        	user.setUserPhoneNumber(userDetails.getUserPhoneNumber());
//        if (userDetails.getUserAddress() !=null)
//        	user.setUserAddress(userDetails.getUserAddress());
//        //user.setUpdatedAt(new Date());
//        System.out.println("user after edit: " + user);
//        final User updatedUser = userRepository.save(user);
//        return listUserDetails((Model)user);
//   }

}
