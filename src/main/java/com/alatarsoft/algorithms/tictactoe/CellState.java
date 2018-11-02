package com.alatarsoft.algorithms.tictactoe;

public enum  CellState {

    COMPUTER("X"), USER("Y"), EMPTY("-");

    private CellState(String text) {
        this.text = text;
    }

    private final String text;

    @Override
    public String toString() {
        return this.text;
    }

}
