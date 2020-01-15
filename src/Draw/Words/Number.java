package Draw.Words;

import Draw.Word;

public class Number extends Word {

    public Number(String number) {
        super(new short[]{21,27,93}, new short[]{207,210,235});
        this.setHasPadding(true);
        this.hide();
        this.setWordFromString(number, "bottom", "center");
    }
}
