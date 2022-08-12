package com.example.booklistapp.controller.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.booklistapp.dto.*;
import com.example.booklistapp.model.ReadingList;
import com.example.booklistapp.service.GenreService;
import com.example.booklistapp.service.UserService;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {
    @Autowired
    UserService userService;

        @PostMapping
        public UserDTO createUser(@RequestBody CreateUserDTO userDTO){
        return userService.createUser(userDTO);}

        @DeleteMapping("/{id}")
        public List<ReadingListDTO> deleteUser(@PathVariable Long id){
            return userService.deleteUser(id);
        }
        @PostMapping("/{id}/reading_lists")
        public List<BookListDTO> createReadingList(@PathVariable Long id, @RequestBody CreateReadingListDTO readingListDTO){
            return userService.createReadingList(id, readingListDTO);
        }
        @GetMapping("/{id}/reading_lists")
        public List<ReadingListDTO> getReadingList(@PathVariable Long id){
            return userService.getReadingLists(id);
        }

        @GetMapping("/{id}/reading_lists/{list_id}")
        public List<BookListDTO> getReadingListBooks(@PathVariable Long id, @PathVariable Long list_id){
            return userService.getReadingList(id,list_id);
        }








//    @GetMapping
//    public String getTest(){
//        return "users";


}