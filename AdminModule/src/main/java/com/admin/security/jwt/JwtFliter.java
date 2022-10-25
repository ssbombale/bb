package com.admin.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import com.admin.entity.AdminDetail;
import com.admin.service.UserImplementation;
import com.admin.service.UserService;
@CrossOrigin(origins = "*")
public class JwtFliter extends OncePerRequestFilter {
	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private UserImplementation useraccountService;


	@Override
	protected void doFilterInternal(HttpServletRequest  request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authorizationHeader = request.getHeader("Authorization");
		String token = null ;
		String userName = null;
		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer")) {
			token = authorizationHeader.substring(7);
			userName = jwtUtils.extractUsername(token);
		}
	
		if(userName!=null && SecurityContextHolder.getContext().getAuthentication() == null) {
		//if(userName!=null) {
			UserDetails user = useraccountService.loadUserByUsername(userName);
			if(jwtUtils.validateToken(token, user)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user,null);
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
				
			}
		}
		System.out.println("------>>>>>"+response.getStatus());
		filterChain.doFilter(request, response);
	}


	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");

		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}

		return null;
	}
}
