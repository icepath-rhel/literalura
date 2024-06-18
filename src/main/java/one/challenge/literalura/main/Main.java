
package one.challenge.literalura.main;

import java.util.List;
import java.util.stream.Collectors;

import one.challenge.literalura.model.Author;
import one.challenge.literalura.model.Book;
import one.challenge.literalura.model.BookDetails;
import one.challenge.literalura.repository.BooksRepository;
import one.challenge.literalura.service.ProjectGutenberg;
import one.challenge.literalura.utilities.Utility;

public class Main {
    private BooksRepository booksRepository;
    private ProjectGutenberg projectGutenberg;

    public Main(BooksRepository booksRepository, ProjectGutenberg projectGutenberg) {
        this.booksRepository = booksRepository;
        this.projectGutenberg = projectGutenberg;
    }

    public void execute() {
        System.out.print("Nombre del libro: ");
        var name = System.console().readLine();

        String encodeText = Utility.encodeText(name);
        BookDetails res = projectGutenberg.query("?search=" + encodeText);
        System.out.println("""

        ***** Libros Encontrado *****
        Book ID: %s
        Titulo: %s
        Autor%s: %s
        Downloads : %d
        *****************************

          """.formatted(res.bookId(), res.title(), res.authors().size() > 1 ? "es" : "", res.authors().get(0).name(),
                res.downloadCount()));

        Book book = new Book(res);
        List<Author> authors = res.authors().stream().map(Author::new).collect(Collectors.toList());

        book.setAuthors(authors);
        BooksRepository.save(book);
    }
}