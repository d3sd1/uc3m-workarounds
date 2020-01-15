package Utils;

public class Random {
    public int generateInRange(int min, int max) {
        return (int)Math.floor(Math.random()*(min-(max+1))+(max));
    }
    public boolean generateRandomCondition() {
        byte res = (byte) this.generateInRange(0,1);
        return res == 1;
    }
    public boolean generateRandomInPercentage(int prob, int contidioner) {
        return this.generateInRange(0,100) < prob * contidioner * 0.5;
    }
}
