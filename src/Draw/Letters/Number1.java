package Draw.Letters;

import Draw.Letter;
import Draw.Point;
import Draw.Shape;

import java.util.ArrayList;
import java.util.Arrays;

public class Number1 extends Letter {

    public Number1() {
    }

    public Number1(short initX, short initY) {
        super(initX, initY, (short) 2, (short) 3);
        generateShape();
    }

    @Override
    public void generateShape() {
        this.shape = new Shape(
                new ArrayList<Point>(Arrays.asList(
                        new Point(this.initX, this.initY),
                        new Point(this.initX, this.initY + 1),
                        new Point(this.initX, this.initY + 2),
                        new Point(this.initX, this.initY + 3)
                ))
        );
    }
}