package ro.adoptinator.Adoptinator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.adoptinator.Adoptinator.dto.PostDTO;
import ro.adoptinator.Adoptinator.entity.Post;
import ro.adoptinator.Adoptinator.entity.UserEntity;
import ro.adoptinator.Adoptinator.mapper.PostMapper;
import ro.adoptinator.Adoptinator.repository.PostRepository;
import ro.adoptinator.Adoptinator.repository.UserRepository;

import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostDTO addPost(PostDTO dto) {
        Optional<UserEntity> optionalUser = userRepository.findById(dto.getUser_id());
        if (optionalUser.isPresent()) {
            Post newPost = PostMapper.toPost(dto, optionalUser.get());
            postRepository.save(newPost);
            return PostMapper.toPostDTO(newPost);
        }
        else{
            throw new RuntimeException("User not found");
        }
    }
}
