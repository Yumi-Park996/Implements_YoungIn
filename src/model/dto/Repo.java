package model.dto;

public record Repo(
   String name,
   String link,
   String category
) {
   public Repo(String name, String link) {
        this(name, link, "");
    }
}
