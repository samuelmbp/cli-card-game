package org.samuelraducan.sanjida;

import org.samuelraducan.Game;

public class Snap extends Game {

    public Snap(String title, String rules) {
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
