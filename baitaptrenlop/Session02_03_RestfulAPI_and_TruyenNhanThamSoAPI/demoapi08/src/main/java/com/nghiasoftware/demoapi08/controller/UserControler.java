package com.nghiasoftware.demoapi08.controller;

import com.nghiasoftware.demoapi08.request.UpdateUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserControler {

    /**
     * @RequestParam: Quy định tham số client truyền lên cho toàn bộ phương thức
     *      - Chỉ với phương thức GET: cách test (sẽ điền tham số trên trình duyệt), sử dụng tab Params trong postman
     *      - Các phương thức còn lại: tham số truyền ngầm, sử dụng tab body trong postman
     *              + JSON: sử dụng tab raw trong postman
     *              + Không phải JSON sử dụng tab form-data hoặc x-www-form-urlencoded
     *
     * @RequestBody: Tham số truyền lên là dạng JSON
     *
     * @PathVariable: Tham số đóng vai trò như 1 đường dẫn, sử dụng được cho toàn bộ phương thức
     */

    @GetMapping
    public ResponseEntity<?> getUser(@RequestParam String username, @RequestParam String password) {
        return new ResponseEntity<>("Get user: " + username + " - " + password, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insertUser(@RequestParam String email, @RequestParam String phone, @RequestParam int age) {
        return new ResponseEntity<>("Insert user: " + email + " - " + phone + " - " + age, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getDetailUser(@PathVariable String userId) {
        return new ResponseEntity<>("Get detail user: " + userId, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest userRequest) {
        return new ResponseEntity<>("Update user: " + userRequest.getEmail(), HttpStatus.OK);
    }

}