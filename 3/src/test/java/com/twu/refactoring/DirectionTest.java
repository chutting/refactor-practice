package com.twu.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DirectionTest {

    private Direction north;
    private Direction east;

    @BeforeEach
    public void setUp() throws Exception {
        north = Direction.NORTH;
        east = Direction.EAST;
    }

    @Test
    public void shouldTurnWestWhenTurnRightFromNorth() {
        Direction west = north.turnRight();
        assertThat(west, is(Direction.WEST));
    }

    @Test
    public void shouldTurnEastWhenTurnLeftFromNorth() {
        Direction east = north.turnLeft();
        assertThat(east, is(Direction.EAST));
    }

    @Test
    public void shouldTurnSouthWhenTurnLeftFromEast() {
        Direction south = east.turnLeft();
        assertThat(south, is(Direction.SOUTH));
    }
}
