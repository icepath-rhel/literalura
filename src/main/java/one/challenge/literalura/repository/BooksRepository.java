package one.challenge.literalura.repository;

import one.challenge.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {
}
