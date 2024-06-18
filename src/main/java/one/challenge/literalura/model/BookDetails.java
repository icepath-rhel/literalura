package one.challenge.literalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDetails(
        @JsonAlias("id") Integer bookId,
        String title,
        List<AuthorDetails> authors,
        Boolean copyright,
        @JsonAlias("download_count") Integer downloadCount) {
}