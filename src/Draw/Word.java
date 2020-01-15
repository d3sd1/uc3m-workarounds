package Draw;

import Draw.Letters.*;
import Utils.Constants;
import Utils.Sleep;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Word implements Runnable {

    private boolean hasPadding = false;
    private ArrayList<Letter> word;
    protected short[] primaryColor;
    protected short[] secondaryColor;
    private boolean hide;
    Thread t;

    public Word(short[] primaryColor, short[] secondaryColor) {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        t = new Thread(this, "blink-effect-" + this.toString());
        t.start();
    }

    public void show() {
        for(Letter letter : word) {
            letter.draw();
        }
        this.hide = false;
    }
    public void hide() {
        this.hide = true;
        if(null != this.word) {
            for(Letter letter : word) {
                letter.hide();
            }
        }
    }

    private void animator() {
        Sleep sleeper = new Sleep();
        while (true) {
            if(this.hide) {
                sleeper.sleepThread(this.t, 2000);
            }
            else if(null != this.getWord()) {
                blinkAnim: for (Letter letter : this.getWord()) {
                    ArrayList<Point> points = letter.getShape().getPoints();
                    for (int i = 0; i < points.size(); i++) {

                        Point actualPoint = points.get(i);
                        if (this.isPrimaryColor(actualPoint.getColor())) {
                            actualPoint.setColor(this.getSecondaryColor());
                        } else {
                            actualPoint.setColor(this.getPrimaryColor());
                        }

                        if (this.hide) {
                            this.hide();
                            break blinkAnim;
                        }
                        sleeper.sleepThread(this.t, 50);
                    }
                }
            }
        }
    }



    public void run() {
        this.animator();
    }

    private boolean isPrimaryColor(short[] compareColors) {
        return Arrays.equals(compareColors, this.getPrimaryColor());
    }

    protected void setWordFromString (String wordStr, String verticalAlign, String horizontalAlign) {

        boolean setPointPrimaryColor = true;
        ArrayList<Letter> letters = new ArrayList<>();
        short initX = 0, initY = 0, xPadding = 0, yPadding = 0;

        // Just to secure it
        wordStr = wordStr.toUpperCase();

        // Set position
        switch(verticalAlign.toUpperCase()) {
            case "CENTER":
                initY = 7;
                break;
            case "BOTTOM":
                initY = 14;
                break;
            case "TOP":
                initY = 0;
                break;
            default:
                System.out.println("No position found for vertical align.");
        }
        switch(horizontalAlign.toUpperCase()) {
            case "LEFT":
                initX = 0;
                break;
            case "CENTER":
                initX = 1;
                break;
            default:
                System.out.println("No position found for horizontal align.");
        }

        for(int pos = 0; pos < wordStr.length(); pos++) {
            short auxX = (short)(initX + xPadding), auxY = (short)(initY + yPadding); //yPadding just for vertical texts. Not used.
            Letter letter = null;
            System.out.println("Draw letter: " + wordStr.charAt(pos));
            switch(wordStr.charAt(pos)) {
                case 'G':
                    letter = new G(auxX, auxY);
                    break;
                case 'A':
                    letter = new A(auxX, auxY);
                    break;
                case 'L':
                    letter = new L(auxX, auxY);
                    break;
                case 'U':
                    letter = new U(auxX, auxY);
                    break;
                case 'C':
                    letter = new C(auxX, auxY);
                    break;
                case '3':
                    letter = new Number3(auxX, auxY);
                    break;
                case 'M':
                    letter = new M(auxX, auxY);
                    break;
                case 'E':
                    letter = new E(auxX, auxY);
                    break;
                case 'V':
                    letter = new V(auxX, auxY);
                    break;
                case 'O':
                    letter = new O(auxX, auxY);
                    break;
                case 'R':
                    letter = new R(auxX, auxY);
                    break;
                case '1':
                    letter = new Number1(auxX, auxY);
                    break;
                default:
                    System.out.println("No letter " + wordStr.charAt(pos) + " found for (" + wordStr + ")");
            }
            if(letter != null) {
                xPadding += letter.getLengthX();
                if(this.hasPadding) {
                    xPadding += 1;
                }

                /* Add letter points color */
                for(Point point : letter.getShape().getPoints()) {
                    if(setPointPrimaryColor) {
                        point.setColor(this.primaryColor);
                    }
                    else {
                        point.setColor(this.secondaryColor);
                    }
                }
                setPointPrimaryColor = !setPointPrimaryColor;

                /* Add letter */
                letters.add(letter);
            }
        }

        this.word = letters;
    }

    public boolean isHasPadding() {
        return hasPadding;
    }

    public void setHasPadding(boolean hasPadding) {
        this.hasPadding = hasPadding;
    }

    public ArrayList<Letter> getWord() {
        return word;
    }

    public void setWord(ArrayList<Letter> word) {
        this.word = word;
    }

    public short[] getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(short[] primaryColor) {
        this.primaryColor = primaryColor;
    }

    public short[] getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(short[] secondaryColor) {
        this.secondaryColor = secondaryColor;
    }
}
