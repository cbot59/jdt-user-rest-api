package dev.rivaldi.userrestapi;

public class RandomAnimeQuoteResponse {
    private String anime;
    private String character;
    private String quote;

    public RandomAnimeQuoteResponse() {
    }

    public RandomAnimeQuoteResponse(String anime, String character, String quote) {
        this.anime = anime;
        this.character = character;
        this.quote = quote;
    }

    public String getAnime() {
        return anime;
    }

    public String getCharacter() {
        return character;
    }

    public String getQuote() {
        return quote;
    }
}
