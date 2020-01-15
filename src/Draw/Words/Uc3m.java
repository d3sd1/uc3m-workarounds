package Draw.Words;

import Utils.Constants;
import Draw.Word;

public class Uc3m extends Word {

    public Uc3m() {
        super(new short[]{21, 27, 93},  new short[]{207, 210, 235});
        this.setHasPadding(true);
        this.setWordFromString("UC3M", "bottom", "center");
    }
}
