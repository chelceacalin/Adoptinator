package ro.adoptinator.Adoptinator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.adoptinator.Adoptinator.entity.Post;

import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
}
