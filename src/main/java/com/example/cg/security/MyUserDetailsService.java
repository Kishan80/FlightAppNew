//package com.example.cg.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.cg.entity.UserLogin;
//import com.example.cg.repo.UserLoginRepository;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//	
//	@Autowired
//	private UserLoginRepository repo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		UserLogin user = repo.findByUsername(username);
//		if(user==null)
//			throw new UsernameNotFoundException("User 404");
//		
//		return new UserPrincipal(user);
//	}
//
//}
