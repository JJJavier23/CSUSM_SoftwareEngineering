package edu.se370.team3;

public class JobFactory {
    public static Job createJob(String input) {
        Job j = Job.JobInstance();
        switch (input) {
          case "Barbarian":
            j.Barbarian();
            break;
          case "Bard":
            j.Bard();
            break;
          case "Cleric":
            j.Cleric();
            break;
          case "Druid":
           j.Druid();
            break;
          case "Fighter":
            j.Fighter();
            break;
          case "Monk":
            j.Monk();
            break;
          case "Paladin":
            j.Paladin();
            break;
          case "Ranger":
            j.Ranger();
            break;
          case "Rogue":
            j.Rogue();
            break;
          case "Sorcerer":
            j.Sorcerer();
            break;
          case "Warlock":
            j.Warlock();
            break;
          case "Wizard":
            j.Wizard();
            break;
          default:
            j.Bard();
            break;
        }
        return j;
      }
}
