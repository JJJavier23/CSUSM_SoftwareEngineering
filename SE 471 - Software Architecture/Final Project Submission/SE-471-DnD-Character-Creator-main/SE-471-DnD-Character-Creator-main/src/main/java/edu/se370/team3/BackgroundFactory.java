package edu.se370.team3;

public class BackgroundFactory {
    public static Background createBackground(String type) {
        type = type.toLowerCase();
        Background b = Background.BackgroundInstance();
        switch (type) {
          case "acolyte":
            b = new Acolyte();
          case "charlatan":
            b = new Charlatan();
          case "criminal":
            b = new Criminal();
          case "entertainer":
            b = new Entertainer();
          case "folkhero":
            b = new FolkHero();
          case "guildartisan":
            b = new GuildArtisan();
          case "hermit":
            b = new Hermit();
          case "noble":
            b = new Noble();
          case "outlander":
            b = new OutLander();
          case "sage":
            b = new Sage();
          case "sailor":
            b = new Sailor();
          case "urchin":
            b = new Urchin();
          default:
            b = new FolkHero();
        }
        return b;
      }
}
