// package com.example.firstboot.controller;

// import java.util.Arrays;
// import java.util.List;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.firstboot.model.User;

// @RestController
// @RequestMapping("/user")
// public class UserController {

//     /*
//      * user/1
//      * user/list
//      * 
//      */
//     @GetMapping("/{id}") //-> @GetMapping("/user/{id}")
//     public String getUser(@PathVariable int id) {
//         return "Fetch id:" + id;
//     }

//     @PostMapping
//     public String createUser(@RequestParam String name) {
//         return "User Created" + name;
//     }

//     @PutMapping("/{id}")
//     public String updateUser(@PathVariable String id, @RequestParam(defaultValue = "Hello") String name) {
//         return "User Id: " + id + " name:" + name;
//     }

//     @DeleteMapping("/{id}")
//     public String deleteUser(@PathVariable int id) {
//         return "User Deleted: " + id;
//     }

//     @PostMapping("/create")
//     public String createUserObj(@RequestBody User user) {
//         return "Created User " + user.getId() + " " + user.getName();
//     }

//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         return user;
//     }

//     @GetMapping("/calculate/{num}")
//     public String calculate(@PathVariable int num, @RequestParam String op) {
//         if (op.equals("square")) {
//             return "Square: " + (num * num);
//         } else if (op.equals("cube")) {
//             return "Cube: " + (num * num * num);
//         } else {
//             return "Invalid";
//         }
//     }

//     @GetMapping("/greet")
//     public String greet(@RequestParam String name, @RequestParam(defaultValue = "en") String lang) {
//         switch (lang) {
//             case "en":
//                 return "Hello " + name;
//             case "te":
//                 return "Namaskaram " + name;
//             case "hi":
//                 return "Namste " + name;
//             default:
//                 return "Hello " + name;
//         }
//     }

//     @GetMapping("/test")
//     public User getUser() {
//         return new User(1, "Pavani");
//     }

//     @GetMapping("/all")
//     public List<User> getAllUser() {
//         return Arrays.asList(new User(1, "Pavani"), new User(2, "Yamini"));
//     }

//     @GetMapping("/welcome")
//     public ResponseEntity<String> welcome() {
//         return ResponseEntity.ok("Welcome");
//     }

//     @PostMapping("/createUser")
//     public ResponseEntity<String> createUser(@RequestBody User user) {
//         return new ResponseEntity<>("Created", HttpStatus.CREATED);
//     }

//     @GetMapping("/test/{id}")
//     public ResponseEntity<String> testNotFound(@PathVariable int id) {

//         if (id == 0) {
//             return new ResponseEntity<>("User Not found", HttpStatus.NOT_FOUND);
//         }
//         // return ResponseEntity.ok("User Found");
//         return new ResponseEntity<>("User found", HttpStatus.OK);
//     }

//     enum OperationStatus {
//         SUCCESS, FAILURE, INVALID_INPUT
//     }

//     //localhost:8080/user/status/enum?status=FAILURE 
//     @GetMapping("/status/enum")
//     public ResponseEntity<String> enumStatus(@RequestParam OperationStatus status) {
//         switch (status) {
//             case SUCCESS:
//                 return ResponseEntity.ok("Success");
//             case FAILURE:
//                 // 500 Internal Server Error
//                 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                         .body("Something went wrong");
//             case INVALID_INPUT:
//                 // 400 Bad Request
//                 return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                         .body("Invalid input provided");
//             default:
//                 return ResponseEntity.badRequest().build();
//         }

//     }

//     /*
//      * 200 - OK
//      * 201 - Created
//      * 400 - Bad Request
//      * 404 - Not Found
//      * 500 - Internal Server Error
//      */
//     //Jackson Java Object->JSON
//     /*
//     Assignment:
  
//    1. Map<Integer,Course> courses;
//    2. 404

//      */
// }
