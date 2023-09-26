package ro.adoptinator.Adoptinator.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "friendship_entity")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FriendShip {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "user_1_id",referencedColumnName = "id")
    private UserEntity user1;

    @ManyToOne
    @JoinColumn(name = "user_2_id",referencedColumnName = "id")
    private UserEntity user2;

    @Enumerated(EnumType.STRING)
    private Status status;

    private enum Status {
        REQUEST_SENT,FRIENDS,REQUEST_CANCELLED
    }
}
