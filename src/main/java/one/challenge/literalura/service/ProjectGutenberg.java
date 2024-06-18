package one.challenge.literalura.service;

import one.challenge.literalura.model.ApiResponse;
import one.challenge.literalura.model.BookDetails;
import one.challenge.literalura.utilities.Utility;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ProjectGutenberg {
    public BookDetails query(String endpoint) {

        final String Base_URL = "https://gutendex.com/books/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Base_URL + endpoint))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            var conv = Utility.dataProcess(response.body(), ApiResponse.class);
            BookDetails book = conv.results().get(0);

            return book;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}