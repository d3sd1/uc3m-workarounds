package Galaga.Items.Interface;

import Utils.Directions;
import Utils.Random;

public class Path {

    final int[] MortalDescender = {
            Directions.DIR_NW,
            Directions.DIR_NW
    };
    final int[] Test = {
            Directions.DIR_NW,
            Directions.DIR_NW,
            Directions.DIR_NW,
            Directions.DIR_NW,
            Directions.DIR_NW,
            Directions.DIR_NW,
            Directions.DIR_NW,
            Directions.DIR_NW
    };
    final int[] ZigZag =  {
            /* ZIGZAG */
            Directions.DIR_NW,
            Directions.DIR_NNW,
            Directions.DIR_NNW,
            Directions.DIR_NNW,
            Directions.DIR_ENE,
            Directions.DIR_ENE,
            Directions.DIR_ENE,
            Directions.DIR_NW,
            Directions.DIR_NW,
            Directions.DIR_NW,
            Directions.DIR_NNW,
            Directions.DIR_NNW,
            Directions.DIR_NNW,
            Directions.DIR_ENE,
            Directions.DIR_ENE,
            Directions.DIR_ENE,
            Directions.DIR_NW,
            Directions.DIR_NW,
            Directions.DIR_NW,
            Directions.DIR_NNW,
            Directions.DIR_NNW,
            Directions.DIR_NNW,
            Directions.DIR_ENE,
            Directions.DIR_ENE,
            Directions.DIR_ENE
    };

    public int[][] getPaths() {
        return new int[][]{
                this.ZigZag,
                this.MortalDescender,
                this.Test
        };
    }

    public int[] getRandomPath() {
        Random rand = new Random();
        int[][] paths = this.getPaths();
        int pos = 0;
        if(paths.length > 1) {
            pos = rand.generateInRange(0, paths.length - 1);
        }
        int[] path = paths[pos];
        return path;
    }
}
