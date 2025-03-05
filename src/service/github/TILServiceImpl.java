package service.github;

import model.dto.Repo;
import model.dto.TIL;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class TILServiceImpl implements TILService {
    @Override
    public List<TIL> getTIL(Repo repo) {
        Logger logger = Logger.getLogger("service.github");
        HttpClient client = HttpClient.newHttpClient();
        try {
            switch (repo.repoType()) {
                case GITHUB:
                    String[] tokens = repo.link().split("/");
                    logger.info(Arrays.toString(tokens));
                    HttpResponse<String> response = client.send(HttpRequest.newBuilder()
                            .uri(URI.create("https://api.github.com/repos/%s/%s/issues".formatted(tokens[3], tokens[4])))
                            .header("Accept", "application/vnd.github+json")
                            .build(), HttpResponse.BodyHandlers.ofString());
                    logger.info("%d".formatted(response.statusCode()));
                    logger.info(response.body());
                    break;
                case VELOG:
                    break;
                case TISTORY:
                    break;
            }
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return List.of();
    }

}
