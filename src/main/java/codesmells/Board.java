package codesmells;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tile> plays = new ArrayList<>();

    public Board() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                plays.add(new Tile(x,y,' '));
            }
        }
    }

    public Tile TileAt(int x, int y) {
        for (Tile t : plays) {
            if (t.X == x && t.Y == y){
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, int x, int y) {
        TileAt(x,y).Symbol = symbol;
    }
}
