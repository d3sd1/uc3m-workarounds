package Draw.Words;

import Draw.Word;

public class Game extends Word {

    public Game() {
        super(new short[]{21,27,93}, new short[]{207,210,235});
        this.setHasPadding(true);
        this.setWordFromString("GAME", "center", "center");
        this.hide();
    }
}
