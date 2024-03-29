package com.bremen.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bremen.model.dto.GroupUser;
import com.bremen.model.dto.User;
import com.bremen.model.service.UserService;
import com.bremen.model.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/userapi")
@Api(tags = "유저 컨트롤러")
@CrossOrigin("*")
public class UserRestController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

	// 전체 유저
	@GetMapping("/user")
	@ApiOperation(value = "유저 조회 ")
	public List<User> userList(Model model) {
		return userService.selectAll();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> userOne(@PathVariable String id) {
		User user = userService.selectOne(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
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
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		Map<String, Object> result = new HashMap<String, Object>();

		HttpStatus status = null;
		try {

			User loginUser = userService.selectOne(user.getUserId());
			if (loginUser != null && loginUser.getUserPassword().equals(user.getUserPassword())) {

				System.out.println(1);
				result.put("access-token", jwtUtil.createToken("id", user.getUserId()));
				result.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;

			} else {
				System.out.println(2);
				result.put("message", FAIL);
				status = HttpStatus.NO_CONTENT;
			}
		} catch (UnsupportedEncodingException e) {
			result.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String,Object>>(result, status);
	}

	@GetMapping("/logout")
	@ApiOperation(value = "로그아웃")
	public ResponseEntity<?> logout(HttpSession session) {

		session.invalidate();
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/groupuser/{groupId}")
	@ApiOperation(value = "유저 조회 ")
	public ResponseEntity<?> userList(@PathVariable int groupId) {
		List<User> list = userService.selectUsersByGroupId(groupId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping("/groupuser")
	public ResponseEntity<?> insertGroupUser(@RequestBody GroupUser groupUser) {
		System.out.println(groupUser.getGroupUserGroupId());
		System.out.println(groupUser.getGroupUserUserId());
		int result = userService.insertGroupUser(groupUser);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
