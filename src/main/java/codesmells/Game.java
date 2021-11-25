package codesmells;

public class Game {
    private char lastSymbol = ' ';
    private Board board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        if (isFirstMove()) {
            if (isNotTheTurnOf(symbol, 'O')) {
                throw new Exception("Invalid first player");
            }
        }
        else if (isNotTheTurnOf(symbol, lastSymbol)) {
            throw new Exception("Invalid next player");
        }
        else if (isAFilledTile(x, y)) {
            throw new Exception("Invalid position");
        }

        lastSymbol = symbol;
        board.AddTileAt(symbol, x, y);
    }

    private boolean isAFilledTile(int x, int y) {
        return board.TileAt(x, y).Symbol != ' ';
    }

    private boolean isNotTheTurnOf(char symbol, char o) {
        return symbol == o;
    }

    private boolean isFirstMove() {
        return lastSymbol == ' ';
    }

    public char Winner() {
        for (int row=0; row<3; row++) {
            if (isAWinningRow(row)) {
                    return board.TileAt(row, 0).Symbol;
            }
        }
        return ' ';
    }

    private boolean sameSymbol(int x_1, int y_1, int x_2, int y_2) {
        return board.TileAt(x_1, y_1).Symbol == board.TileAt(x_2, y_2).Symbol;
    }
    private boolean isAWinningRow(int row){
        if (filledRow(row)) {
            return (allThreeSymbolsMatching(row));
        }
        return false;
    }
    private boolean filledRow(int x){
        return isAFilledTile(x, 0) &&
                isAFilledTile(x, 1) &&
                isAFilledTile(x, 2);
    }
    private boolean allThreeSymbolsMatching(int x){
        return (sameSymbol(x,0,x,1) &&
                sameSymbol(x,1,x,2));
    }
}