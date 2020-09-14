package com.twu.refactoring;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Direction {
    private final char direction;
    private static final List<Direction> directionList = Arrays.asList(new Direction('N'),
        new Direction('W'),
        new Direction('S'),
        new Direction('E'));

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction1 = (Direction) o;
        return direction == direction1.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
