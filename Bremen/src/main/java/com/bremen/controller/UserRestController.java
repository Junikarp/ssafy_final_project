package com.bremen.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bremen.model.dto.User;
import com.bremen.model.service.UserService;

import ch.qos.logback.core.net.SocketConnector.ExceptionHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api-user")
@Api(tags = "유저 컨트롤러")
@CrossOrigin("*")
public class UserRestController {

	@Autowired
	private UserService userService;

	// 예외 처리
	public ResponseEntity<?> exceptionHandler(Exception e) {
		String errMsg = "sorry : " + e.getMessage();
		return new ResponseEntity<String>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// 전체 유저
	@GetMapping("/user")
	@ApiOperation(value = "유저 조회 ")
	public List<User> userList(Model model) {
		return userService.selectAll();
	}

	// 회원가입
	@PostMapping("/user")
	@ApiOperation(value = "회원가입 ")
	public ResponseEntity<?> signUp(@RequestBody User user) {
		try {

			int result = userService.insertUser(user);
			if (result == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}

	// 로그인
	@PostMapping("/login")
	@ApiOperation(value = "로그인 ")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
		try {

			User loginUser = userService.selectOne(user.getUserId());
			if (loginUser != null && loginUser.getUserPassword().equals(user.getUserPassword())) {
				session.setAttribute("loginUser", loginUser.getUserName());
				System.out.println("로그인 성공 ");
				return new ResponseEntity<>(loginUser, HttpStatus.OK);
			} else {
				System.out.println("로그인 실패 ");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}

	@GetMapping("/logout")
	@ApiOperation(value = "로그아웃")
	public ResponseEntity<?> logout(HttpSession session) {
		try {

			session.invalidate();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandler(e);
		}
	}
}
