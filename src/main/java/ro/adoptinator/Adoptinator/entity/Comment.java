package ro.adoptinator.Adoptinator.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "comment_entity")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "post_id",referencedColumnName = "id")
    private Post post;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(referencedColumnName = "id")
    private Comment parentComment;


    @OneToMany(mappedBy = "parentComment",cascade = CascadeType.ALL)
    private List<Comment> subComments=new ArrayList<>();

    @CreatedDate
    private LocalDate sendDate;
}
