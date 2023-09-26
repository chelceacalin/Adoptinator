package ro.adoptinator.Adoptinator.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private UUID id;
    private String username;
    private String email;
    private String photoUrl;

}
