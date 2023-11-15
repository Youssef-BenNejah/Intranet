package com.example.intranet.controllers.ManageController;

import com.example.intranet.Dto.PostDTO;
import com.example.intranet.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/File")
@PreAuthorize("hasAnyRole('ADMIN','EMPLOYE')")
public class PostContoller {
    @Autowired
    private PostService postService;

    @PostMapping("/uploadFile")
    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYE')")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file
            ) throws IOException {
        String uploadImage = postService.uploadPost(file);
        return ResponseEntity.ok(uploadImage);

    }
    @GetMapping("/getAllPost")
    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYE')")
    public ResponseEntity<List<PostDTO>> getAllPost() throws IOException {
        List<PostDTO> postDTOS = postService.getAllPost();
        return ResponseEntity.ok(postDTOS);

    }

    @GetMapping("/getPost/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public PostDTO getPost(@PathVariable long id) throws IOException {
        PostDTO postDTO = postService.getPostById(id);
        return postDTO;

    }
    @DeleteMapping("/deletePost/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deleteById(id);
        return ResponseEntity.ok("post deleted");
    }


}
