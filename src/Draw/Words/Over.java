package Draw.Words;

import Draw.Word;

public class Over extends Word {

    public Over() {
        super(new short[]{21,27,93}, new short[]{207,210,235});
        this.setHasPadding(true);
        this.setWordFromString("OVER", "bottom", "center");
        this.hide();
    }
}
