package Utils;

public class Sleep {
    public void sleepThread(Thread t, long millis) {
        synchronized(t) {
            // how to put to bed the same thread ?
            try {
                t.wait(millis);
            }
            catch(Exception e) {

            }
        }
    }
    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        }
        catch(Exception e) {

        }
    }
}
