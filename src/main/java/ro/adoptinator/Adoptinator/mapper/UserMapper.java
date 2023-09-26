package ro.adoptinator.Adoptinator.mapper;

import ro.adoptinator.Adoptinator.dto.UserRequestDTO;
import ro.adoptinator.Adoptinator.dto.UserResponseDTO;
import ro.adoptinator.Adoptinator.entity.UserEntity;

public class UserMapper {

    public static UserEntity toUser(UserRequestDTO dto){
        return UserEntity
                .builder()
                .username(dto.getUsername())
                .photoUrl(dto.getPhotoUrl())
                .email(dto.getEmail())
                .build();
    }

    public static UserResponseDTO toUserResponseDTO(UserEntity entity){
        return UserResponseDTO
                .builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .photoUrl(entity.getPhotoUrl())
                .build();

    }
}
