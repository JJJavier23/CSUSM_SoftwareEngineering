package edu.se370.team3;

import java.io.IOException;

import javax.swing.SwingUtilities;

public class CharacterBuilder {
    public Character character;
    private RaceFactory rFactory;
    private BackgroundFactory bFactory;
    private JobFactory jFactory;

    public CharacterBuilder(){
        this.character = new Character();
    }

    public void buildRace(String s){
        Race r = RaceFactory.createRace(s);
        this.character.setRace(r);
    }

    public void buildBackground(String s){
        Background b = BackgroundFactory.createBackground(s);
        this.character.setBackground(b);
    }

    public void buildJob(String s){
        Job j = JobFactory.createJob(s);
        this.character.setJob(j);
    }

    public Character getCharacter(){
        return this.character;
    }
}
