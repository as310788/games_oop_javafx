package ru.job4j.chess;

import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import org.junit.Test;

public class LogicTest {

    @Test(expected = OccupiedCellException.class)
    public void testMove() throws OccupiedCellException, FigureNotFoundException {
        Figure figure1 = new BishopBlack(Cell.A1);
        Figure figure2 = new BishopBlack(Cell.D4);
        Logic logic = new Logic();
        logic.add(figure1);
        logic.add(figure2);
        logic.move(figure1.position(), Cell.H8);
    }

    @Test(expected = FigureNotFoundException.class)
    public void testNotFoundFigure() throws OccupiedCellException, FigureNotFoundException {
        Figure figure1 = new BishopBlack(Cell.A1);
        Logic logic = new Logic();
        logic.add(figure1);
        logic.move(Cell.A2, Cell.G5);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testImpossibleMoveExp() throws OccupiedCellException, FigureNotFoundException,
            ImpossibleMoveException {
        Figure figure1 = new BishopBlack(Cell.A1);
        Logic logic = new Logic();
        logic.add(figure1);
        logic.move(figure1.position(), Cell.G1);
    }
}