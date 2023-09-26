package ro.adoptinator.Adoptinator.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @NotBlank
    private String username;

    private String email;

    private String photoUrl;
}
