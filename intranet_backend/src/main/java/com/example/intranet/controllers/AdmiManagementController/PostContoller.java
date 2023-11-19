package com.example.intranet.controllers.AdmiManagementController;

import com.example.intranet.Dto.PostDTO;
import com.example.intranet.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/File")

public class PostContoller {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file
            ,PostDTO postDTO) throws IOException {
        String uploadImage = postService.uploadPost(file,postDTO);
        return ResponseEntity.ok(uploadImage);

    }
    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPost() throws IOException {
        List<PostDTO> postDTOS = postService.getAllPost();
        return ResponseEntity.ok(postDTOS);

    }

    @GetMapping("/downloadPost/{id}")
    public ResponseEntity<?> downloadPost(@PathVariable long id) throws IOException {
        PostDTO postDTO = postService.getPostById(id);
        byte[] data=postDTO.getFileData();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM).body(data);

    }
    @GetMapping("{id}")
    ResponseEntity<PostDTO> getPost(@PathVariable long id) throws IOException {
        PostDTO postDTO =postService.getPostById(id);
        return ResponseEntity.ok(postDTO);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deleteById(id);
        return ResponseEntity.ok("post deleted");
    }
    @PutMapping("{id}")
    public ResponseEntity<Void> updatePost(@PathVariable long id,PostDTO postDTO
    ,@RequestParam("file")MultipartFile file){
        postService.updatePost(postDTO,id,file);
        return ResponseEntity.ok().build();
    }


}
