package Draw.Words;

import Draw.Word;
import Utils.Constants;

public class Level extends Word {

    public Level() {
        super(new short[]{21,27,93}, new short[]{207,210,235});
        this.setHasPadding(true);
        this.hide();
        this.setWordFromString("LEVEL", "center", "center");
    }
}
