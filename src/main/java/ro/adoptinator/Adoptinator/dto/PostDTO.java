package ro.adoptinator.Adoptinator.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import ro.adoptinator.Adoptinator.entity.UserEntity;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private UUID id;

    private UUID user_id;

    private String title;

    private String description;

    private String photoUrl;


    @CreatedDate
    private LocalDate created_date;
}
