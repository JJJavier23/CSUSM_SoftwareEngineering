package edu.se370.team3;

public class RaceFactory {
    public static Race createRace(String type) {
        Race r = Race.RaceInstance();
        switch (type) {
          case "hilldwarf":
            r = new HillDwarf();
          case "mountaindwarf":
            r = new MountainDwarf();
          case "highelf":
            r = new HighElf();
          case "woodelf":
            r = new WoodElf();
          case "darkelf":
            r = new DarkElf();
          case "lightfoot":
            r = new Lightfoot();
          case "stout":
            r = new Stout();
          case "human":
            r = new Human();
          case "dragonborn":
            r = new Dragonborn();
          case "forestgnome":
            r = new ForestGnome();
          case "rockgnome":
            r = new RockGnome();
          case "halfelf":
            r = new HalfElf();
          case "halforc":
            r = new HalfOrc();
          case "tiefling":
            r = new Tiefling();
          default:
            System.out.println("DEFAULT IN RACE");
            r = new Human();
        }
        return r;
      }
}
