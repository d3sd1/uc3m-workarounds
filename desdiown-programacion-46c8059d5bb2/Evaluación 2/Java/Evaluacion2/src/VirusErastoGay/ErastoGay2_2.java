package VirusErastoGay;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class ErastoGay2_2 extends Frame
{
    private Button boton;
    public static void main(String[]args)
    {
        new ErastoGay2_2();
    }
    public ErastoGay2_2()
    {
        super("VIRUS ERASTO GAY 2.2");
        setLayout(new FlowLayout());
        addMouseMotionListener(new EscuchaMouse());
        boton=new Button("¡Sierrame pendejó!");
        add(boton);
        setSize(ThreadLocalRandom.current().nextInt(200,801),ThreadLocalRandom.current().nextInt(200,801));
        setVisible(true);
    }
    class EscuchaMouse implements MouseMotionListener
    {
        public void mouseMoved(MouseEvent e)
        {
            new ErastoGay2_2();
            int distancia=10;
            Point pMouse=e.getPoint();
            Dimension dimBoton=boton.getSize();
            Point pBoton=boton.getLocation();
            int difX1=Math.abs(pBoton.x-pMouse.x);
            int difX2=Math.abs((pBoton.x+dimBoton.width)-pMouse.x);
            int difY1=Math.abs(pBoton.y-pMouse.y);
            int difY2=Math.abs((pBoton.y+dimBoton.height)-pMouse.y);
            if(difX1<distancia||difX2<distancia||difY1<distancia||difY2<distancia)
            {
                Dimension dimVentana=getSize();
                Dimension dimScreen=getToolkit().getScreenSize();
                int y=(int)(Math.random()*(dimScreen.height-dimVentana.height));
                int x=(int)(Math.random()*(dimScreen.width-dimVentana.width));
                setLocation(x,y);
            }
            setSize(ThreadLocalRandom.current().nextInt(200,801),ThreadLocalRandom.current().nextInt(200,801));
        }
        public void mouseDragged(MouseEvent e) {}
    }
     public class FileCopy {
	public FileCopy(String sourceFile, String destinationFile) {
		System.out.println("Desde: " + sourceFile);
		System.out.println("Hacia: " + destinationFile);

		try {
			File inFile = new File(sourceFile);
			File outFile = new File(destinationFile);

			FileInputStream in = new FileInputStream(inFile);
			FileOutputStream out = new FileOutputStream(outFile);

			int c;
			while( (c = in.read() ) != -1)
				out.write(c);

			in.close();
			out.close();
		} catch(IOException e) {
			System.err.println("Hubo un error de entrada/salida!!!");
		}
	}
    }
}
