package ro.adoptinator.Adoptinator.mapper;

import ro.adoptinator.Adoptinator.dto.PostDTO;
import ro.adoptinator.Adoptinator.entity.Post;
import ro.adoptinator.Adoptinator.entity.UserEntity;

import java.time.LocalDate;

public class PostMapper {


    public static Post toPost(PostDTO dto, UserEntity user) {
        return Post
                .builder()
                .title(dto.getTitle())
                .user(user)
                .description(dto.getDescription())
                .photoUrl(dto.getPhotoUrl())
                .created_date(LocalDate.now())
                .build();
    }

    public static PostDTO toPostDTO(Post post) {
        return PostDTO
                .builder()
                .title(post.getTitle())
                .user_id(post.getUser().getId())
                .description(post.getDescription())
                .photoUrl(post.getPhotoUrl())
                .created_date(post.getCreated_date())
                .build();
    }
}
