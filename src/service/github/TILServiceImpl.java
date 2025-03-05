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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TILServiceImpl implements TILService {
    @Override
    public List<TIL> getTIL(Repo repo) throws Exception {
        Logger logger = Logger.getLogger("service.github");
        HttpClient client = HttpClient.newHttpClient();
        switch (repo.repoType()) {
            case GITHUB:
                String[] tokens = repo.link().split("/");
                logger.info(Arrays.toString(tokens));
                HttpResponse<String> response = client.send(HttpRequest.newBuilder()
                        .uri(URI.create("https://api.github.com/repos/%s/%s/issues".formatted(tokens[3], tokens[4])))
                        .header("Accept", "application/vnd.github+json")
                        .build(), HttpResponse.BodyHandlers.ofString());
                logger.info("%d".formatted(response.statusCode()));
                Pattern pattern = Pattern.compile("\"body\":\"(.*?)\",\""); // 수정된 정규 표현식 (최소 매칭)
                Matcher matcher = pattern.matcher(response.body());
                while (matcher.find()) {
                    logger.info(matcher.group(1));
                }

                break;
            case VELOG:
            case TISTORY:
                throw new Exception("지원하지 않는 종류");
        }
        return List.of();
    }
}
