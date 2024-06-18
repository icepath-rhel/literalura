
package one.challenge.literalura.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    Integer bookId;

    String title;
    Boolean copyright;
    Integer downloadCount;

    @ManyToOne(cascade = CascadeType.ALL)
    Author author;

    public Book(BookDetails bookDetails) {
        this.bookId = bookDetails.bookId();
        this.title = bookDetails.title();
        this.copyright = bookDetails.copyright();
        this.downloadCount = bookDetails.downloadCount();
    }

    public void setAuthors(List<Author> authors) {
        authors.forEach(a -> a.setBook(this));
        this.author = authors.get(0);
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCopyright() {
        return copyright;
    }

    public void setCopyright(Boolean copyright) {
        this.copyright = copyright;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }
}
