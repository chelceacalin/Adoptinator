package ro.adoptinator.Adoptinator.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

@RequiredArgsConstructor
@Builder
public class UserRequestDTO {
    @NotBlank
    private String username;

    @Length(min = 4)
    private String password;
    private String photoUrl;
}
