package edu.se370.team3;

import java.util.ArrayList;

public class Character {
  private String characterName;
  private int health;
  private int ac;
  private int[] hitDie;
  private ArrayList<Item> backpack;
  private ArrayList<String> chosenSkills;
  private Job job;
  private Race race;
  private Background background;
  private Stats stats;
  private Skills skills;
  private Spellbook spellbook;

  public Character() {
    this.characterName = "";
    this.health = 0;
    this.ac = 10;
    this.hitDie = new int[] { 1, this.health }; // 0: # of dice, 1: # of sides (0d1)
    this.backpack = new ArrayList<Item>();
    this.chosenSkills = new ArrayList<String>();
    this.race = race.RaceInstance();
    this.job = job.JobInstance();
    this.background = background.BackgroundInstance();
    this.stats = stats.StatsInstance();
    this.skills = skills.SkillsInstance();
    this.spellbook = new Spellbook();
  }

  public void setName(String name) {
    this.characterName = name;
  }

  public String getName() {
    return this.characterName;
  }

  public void addHealth(int hp) {
    this.health += hp;
  }

  public int getHealth() {
    return this.health;
  }

  public String getHitDie() {
    return this.hitDie[0] + "d" + this.hitDie[1];
  }

  public void addAC(int armor) {
    this.ac += armor;
  }

  public int getAC() {
    return this.ac;
  }

  public void addItem(Item item) {
    this.backpack.add(item);
  }

  // This takes skills from Background and Race and adds it to Skills as well
  // as returns the list of the skills

  public ArrayList<String> getGivenSkills() {
    ArrayList<String> givenSkills = new ArrayList<String>();
    givenSkills.addAll(this.race.getSkills());

    for (String skill : this.background.getSkills()) {
      if (!givenSkills.contains(skill))
        givenSkills.add(skill);
    }
    this.skills.addProficiency(givenSkills);

    return givenSkills;
  }

  public ArrayList<String> getItemList() {
    ArrayList<String> itemNames = new ArrayList<String>();
    for (Item item : this.backpack) {
      itemNames.add(item.getName());
    }
    return itemNames;
  }

  public Job getJob() {
    return this.job;
  }

  public void setJob(Job j) {
    this.job = j;
  }

  public Background getBackground() {
    return this.background;
  }

  public void setBackground(Background b) {
    this.background = b;
  }

  public Race getRace() {
    return this.race;
  }

  public void setRace(Race r) {
    this.race = r;
  }

  public Stats getStats() {
    return this.stats;
  }

  public Skills getSkills() {
    return this.skills;
  }

  public Spellbook getSpellbook() {
    return this.spellbook;
  }

}
