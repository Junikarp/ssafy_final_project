package com.bremen.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bremen.model.dto.User;
import com.bremen.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/userapi")
@Api(tags = "유저 컨트롤러")
@CrossOrigin("*")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	
	// 전체 유저
	@GetMapping("/user")
	@ApiOperation(value = "유저 조회 ")
	public List<User> userList(Model model) {
		return userService.selectAll();
	}

	// 회원가입
	@PostMapping("/signup")
	@ApiOperation(value = "회원가입 ")
	public ResponseEntity<?> signUp(@RequestBody User user) {
		System.out.println(user.getUserId());
		int result = userService.insertUser(user);
		if (result == 0) {
			System.out.println("회원가입 실패 ");
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		System.out.println("회원가입 성공 ");
		return new ResponseEntity<Integer>(result, HttpStatus.OK);

	}

	// 로그인
	@PostMapping("/login")
	@ApiOperation(value = "로그인")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
		System.out.println(user.getUserId());
		User loginUser = userService.selectOne(user.getUserId());
		if (loginUser != null && loginUser.getUserPassword().equals(user.getUserPassword())) {
			session.setAttribute("loginUser", loginUser.getUserName());
			System.out.println("로그인성공");
			return new ResponseEntity<User>(loginUser, HttpStatus.OK);
		}	
		System.out.println("로그인실패");
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // 상태 -> 권한이 없다
	}

	@GetMapping("/logout")
	@ApiOperation(value = "로그아웃")
	public ResponseEntity<?> logout(HttpSession session) {

		session.invalidate();
		return new ResponseEntity<>(HttpStatus.OK);

	}

	// 친구추가
}
