package one.challenge.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorDetails(
        @JsonAlias("birth_year") String birthYear,
        @JsonAlias("death_year") String deathYear,
        @JsonAlias("name") String name) {
}