package ro.adoptinator.Adoptinator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.adoptinator.Adoptinator.dto.PostDTO;
import ro.adoptinator.Adoptinator.service.PostService;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/add")
    public ResponseEntity<PostDTO> addPost(PostDTO dto){
        return new ResponseEntity<>(postService.addPost(dto), HttpStatus.CREATED);
    }
}
