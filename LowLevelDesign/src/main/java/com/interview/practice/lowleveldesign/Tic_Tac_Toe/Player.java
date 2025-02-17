package com.interview.practice.lowleveldesign.Tic_Tac_Toe;

public class Player {

    private String name;
    private MarkEnumType mark;

    public Player(String name, MarkEnumType mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public MarkEnumType getMark() {
        return mark;
    }
}
