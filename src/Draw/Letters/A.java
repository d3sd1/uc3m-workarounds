package Draw.Letters;

import Draw.Letter;
import Draw.Point;
import Draw.Shape;

import java.util.ArrayList;
import java.util.Arrays;

public class A extends Letter {
    public A() {
    }

    public A(short initX, short initY) {
        super(initX, initY, (short) 3, (short) 3);
        generateShape();
    }

    @Override
    public void generateShape() {
        this.shape = new Shape(
                new ArrayList<Point>(Arrays.asList(
                        new Point(this.initX, this.initY),
                        new Point(this.initX, this.initY + 1),
                        new Point(this.initX, this.initY + 2),
                        new Point(this.initX, this.initY + 3),
                        new Point(this.initX + 1, this.initY),
                        new Point(this.initX + 1, this.initY + 2),
                        new Point(this.initX + 2, this.initY),
                        new Point(this.initX + 2, this.initY + 1),
                        new Point(this.initX + 2, this.initY + 2),
                        new Point(this.initX + 2, this.initY + 3)
                )));
    }
}