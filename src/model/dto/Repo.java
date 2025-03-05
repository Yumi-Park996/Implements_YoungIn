package model.dto;

public record Repo(
   String name,
   String link,
   String category
) {
   Repo(String name, String link) {
        this(name, link, "");
    }
}
