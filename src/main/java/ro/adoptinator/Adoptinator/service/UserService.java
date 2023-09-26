package ro.adoptinator.Adoptinator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.adoptinator.Adoptinator.dto.UserRequestDTO;
import ro.adoptinator.Adoptinator.dto.UserResponseDTO;
import ro.adoptinator.Adoptinator.entity.UserEntity;
import ro.adoptinator.Adoptinator.mapper.UserMapper;
import ro.adoptinator.Adoptinator.repository.UserRepository;

import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean checkAlreadyExists(String email) {

        Optional<UserEntity> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            throw new RuntimeException("User already exists");
        } else {
            return false;
        }
    }

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        if (nonNull(userRequestDTO) && nonNull(userRequestDTO.getEmail())) {
            if(!checkAlreadyExists(userRequestDTO.getEmail())){
                UserEntity newUser = UserMapper.toUser(userRequestDTO);
                userRepository.save(newUser);
                return UserMapper.toUserResponseDTO(newUser);
            }
        } else {
            throw new RuntimeException("Body is empty");
        }
        throw new RuntimeException("User cannot be null");
    }
}
