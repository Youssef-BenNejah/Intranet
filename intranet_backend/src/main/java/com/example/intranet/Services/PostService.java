package com.example.intranet.Services;

import com.example.intranet.Dto.PostDTO;
import com.example.intranet.entities.Post;
import com.example.intranet.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    private final String FOLDER ="D:\\intranet_files\\";

    public String uploadPost(MultipartFile file ) throws IOException {
        String path = FOLDER+file.getOriginalFilename();
        var post = Post.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .path(path)
                .build();
        postRepository.save(post);
        file.transferTo(new File(path));

        if (post != null){
            return "file uploded successfully"+path;

        }return "failed to upload file";
    }

    private byte[] loadImageData(String filePath) throws IOException {
        return Files.readAllBytes(Paths.get(filePath));
    }


    public PostDTO getPostById(long id) throws IOException {
        Post post = postRepository.getById(id);
        byte[] fileData =loadImageData(post.getPath());
        var post1 = PostDTO.builder()
                .name(post.getName())
                .type(post.getType())
                .path(post.getPath())
                .fileData(fileData)
                .build();
        return post1;
    }


    public List<PostDTO> getAllPost() throws IOException {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> postDTOS =new ArrayList<>();
        for (Post post : posts){
            PostDTO postDTO = new PostDTO();
            byte[] fileData =loadImageData(post.getPath());
            postDTO.setName(post.getName());
            postDTO.setType(post.getType());
            postDTO.setPath(post.getPath());
            postDTO.setFileData(fileData);
            postDTOS.add(postDTO);
        }
        return postDTOS;
    }


    public void deleteById(long id) {
        postRepository.deleteById(id);
    }

}
