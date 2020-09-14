package com.twu.refactoring;

import java.util.Arrays;
import java.util.List;

enum Direction {
    NORTH('N'), SOUTH('S'), WEST('W'), EAST('E');
    private final char direction;
    private static final List<Direction> directionList = Arrays.asList(NORTH, WEST, SOUTH, EAST);

    Direction(char direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        int index = directionList.indexOf(this);
        if (index == -1) {
            throw new IllegalArgumentException();
        }

        if(index == directionList.size() - 1){
            return directionList.get(0);
        }
        return directionList.get(index + 1);
    }

    public Direction turnLeft() {
        int index = directionList.indexOf(this);
        if (index == -1) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            return directionList.get(directionList.size() - 1);
        }
        return directionList.get(index - 1);
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
