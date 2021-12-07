package com.joemerrill.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void areArrayElementsSameTest() {

        assertEquals(false, Utils.areArrayElementsSame(
                new String[] {"X","O","-"}
        ));

        assertEquals(false, Utils.areArrayElementsSame(
                new String[] {"O","O","X"}
        ));

        assertEquals(true, Utils.areArrayElementsSame(
                new String[] {"-","-","-"}
        ));

        assertEquals(true, Utils.areArrayElementsSame(
                new String[] {"X","X","X"}
        ));

        assertEquals(true, Utils.areArrayElementsSame(
                new String[] {"O","O","O"}
        ));
    }
}