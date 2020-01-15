package Utils;

import Galaga.Config;

import java.io.PrintStream;

// This class intercetpts output so if we aren't on debug mode it's not shown
public class Interceptor extends PrintStream
{
    public Interceptor()
    {
        super(System.out, true);
    }
    @Override
    public void print(String s)
    {
        if(Config.DEBUG) {
            super.print(s);
        }
    }
}