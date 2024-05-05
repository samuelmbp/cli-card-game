package org.samuelraducan.samuel;

import org.samuelraducan.Game;

public class WarCliGame extends Game {

    public WarCliGame(String title, String rules) {
        super(title, rules);
    }

    @Override
    public void play() {

    }

    @Override
    public boolean playAgain() {
        return false;
    }
}
