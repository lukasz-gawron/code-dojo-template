package ptv.dojo

import spock.lang.Specification

class GameTest extends Specification {
    def 'should have empty board at game start'() {
        when:
        def board = new Board()
        then:
        board.allCellsEmpty()
    }

    def 'should mark empty field with X'() {
        given:
        def board = new Board()
        when:
        board.mark(1, Mark.X)

        then:
        !board.allCellsEmpty()
    }

    def 'shouldn\'t mark field with X twice'() {
        given:
        def board = new Board()
        when:
        board.mark(1, Mark.X)
        and:
        board.mark(1, Mark.X)

        then:
        def ex = thrown(Exception)
    }

    def 'should fail in case cell index is higher than 9'() {
        given:
        def board = new Board()
        when:
        board.mark(10, Mark.X)

        then:
        def ex = thrown(Exception)
    }


    def 'should fail in case cell index is LOWER than 1'() {
        given:
        def board = new Board()
        when:
        board.mark(0, Mark.X)

        then:
        def ex = thrown(Exception)
    }


    def 'shouldnt fail in case cell index at max size'() {
        given:
        def board = new Board()
        when:
        board.mark(9, Mark.X)

        then:
        notThrown(RuntimeException)
    }

    def 'one player shoudn\'t mark twice'() {
        given:
        def board = new Board()
        when:
        board.mark(1, Mark.X)
        and:
        board.mark(2, Mark.X)

        then:
        def ex = thrown(RuntimeException)
    }

    def 'two players shoud mark take turns'() {
        given:
        def board = new Board()
        when:
        board.mark(1, Mark.X)
        board.mark(2, Mark.O)
        board.mark(3, Mark.X)

        then:
        def ex = notThrown(RuntimeException)
    }

    def 'should finish game when 3 the same marks in a column'() {
        given:
        def board = new Board()
        def game = new Game(board)
        when:
        board.mark(1, Mark.X)
        board.mark(2, Mark.O)
        board.mark(4, Mark.X)
        board.mark(5, Mark.O)
        board.mark(7, Mark.X)

        then:
        game.isEnded()
        game.whichPlayerWon() == Mark.X
    }

    def 'game is finished when all fields marked but draw'() {
        given:
        def board = new Board()
        def game = new Game(board)

        when:
        board.mark(2, Mark.O)
        board.mark(1, Mark.X)
        board.mark(4, Mark.O)
        board.mark(3, Mark.X)
        board.mark(6, Mark.O)
        board.mark(5, Mark.X)
        board.mark(7, Mark.O)
        board.mark(8, Mark.X)
        board.mark(9, Mark.O)

        then:
        game.isEnded()
        game.whichPlayerWon() == Mark.EMPTY
    }

    def 'game is not finished after first move'() {
        given:
        def board = new Board()
        def game = new Game(board)

        when:
        board.mark(1, Mark.X)

        then:
        !game.isEnded()
    }

}
