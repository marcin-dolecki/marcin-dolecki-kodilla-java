package com.kodilla.good.patterns.builder.checkers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CheckersTestSuite {
    @Test
    void testCheckersBuilder() {
        Checkers checkers = new Checkers.CheckersBuilder()
                .playerOne("John")
                .playerTwo("Theresa")
                .Figure(FigureFactory.PAWN, Figure.WHITE, 3, 0)
                .Figure(FigureFactory.PAWN, Figure.BLACK, 7, 9)
                .Figure(FigureFactory.QUEEN, Figure.WHITE, 2, 0)
                .build();
        System.out.println(checkers.getBoard());

        Figure figureOne = checkers.getBoard().getFigure(3, 0);
        Figure figureTwo = checkers.getBoard().getFigure(7, 9);
        Figure figureThree = checkers.getBoard().getFigure(2, 0);
        Figure figureFour = checkers.getBoard().getFigure(1, 1);

        assertEquals(Figure.WHITE, figureOne.getColor());
        assertEquals(Pawn.class, figureTwo.getClass());
        assertEquals(Queen.class, figureThree.getClass());
        assertNull(figureFour);
    }
}
