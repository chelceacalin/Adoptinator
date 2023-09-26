package ro.adoptinator.Adoptinator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "message_entity")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "whoSentIt",referencedColumnName = "id")
    private UserEntity whoSentIt;

    @ManyToOne
    @JoinColumn(name = "toWhom",referencedColumnName = "id")
    private UserEntity toWhom;
}
