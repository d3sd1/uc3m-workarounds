package Semana10.Ejercicio5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.getProperty("line.separator"));
        Banda banda = new Banda();

        //Introducir banda
        System.out.println("Introduce el nombre de la banda");
        banda.setNombre(input.next());
        System.out.println("Introduce el año de creación de la banda");
        banda.setAnyoCreacion(input.nextInt());
        ArrayList<Persona> miembros = new ArrayList<>();
        miembros: while(true) {
            Persona persona = new Persona();
            System.out.println("Introduce el nombre del miembro " + (miembros.size() + 1));
            persona.setNombre(input.next());
            System.out.println("Introduce el año de nacimiento del miembro " + (miembros.size() + 1));
            persona.setAnyoNacimiento(input.nextInt());

            Iterator personas = miembros.iterator( );
            boolean personaDuplicada = false;
            while (personas.hasNext()) {
                //Comprobar que el nombre no está duplicado.
                if(((Persona) personas.next()).getNombre().toLowerCase().equals(
                        persona.getNombre().toLowerCase()
                )) {
                    personaDuplicada = true;
                }
            }
            if(!personaDuplicada) {
                miembros.add(persona);
            }
            else {
                System.out.println("Miembro duplicado.");
            }

            System.out.println("¿Quieres seguir introducidendo miembros? (S/N)");
            switch (input.next().toLowerCase().charAt(0))
            {
                case 'n':
                    break miembros;
            }
        }
        banda.setMiembros(miembros);


        //ALBUMS DE LA BANDA
        ArrayList<Album> albumsList = new ArrayList<>();

        albums: while(true) {
            Album album = new Album();
            System.out.println("Introduce el título del álbum " + (albumsList.size() + 1));
            album.setTitulo(input.next());
            System.out.println("Introduce el año de publicación del álbum " + album.getTitulo());
            album.setAnyoPublicacion(input.nextInt());
            System.out.println("Introduce el PVP del álbum " + album.getTitulo());
            album.setPvp(input.nextFloat());

            //Introducir canciones
            ArrayList<Cancion> songList = new ArrayList<>();
            canciones: while(true) {
                Cancion cancion = new Cancion();
                System.out.println("Introduce el título de la canción " + (songList.size() + 1) + " (album " + album.getTitulo() + ")");
                cancion.setTitulo(input.next());
                System.out.println("Introduce la duración (segundos) de la canción " + cancion.getTitulo() + " (album " + album.getTitulo() + ")");
                cancion.setDuracion(input.nextInt());


                Persona autor = new Persona();
                System.out.println("Introduce el nombre autor de la canción " + cancion.getTitulo());
                autor.setNombre(input.next());
                System.out.println("Introduce el año de nacimiento del autor de la canción " + cancion.getTitulo());
                autor.setAnyoNacimiento(input.nextInt());
                cancion.setAutor(autor);

                songList.add(cancion);

                System.out.println("¿Quieres seguir introducidendo canciones? (S/N)");
                switch (input.next().toLowerCase().charAt(0))
                {
                    case 'n':
                        break canciones;
                }
            }

            album.setCanciones(songList);
            albumsList.add(album);

            System.out.println("¿Quieres seguir introducidendo albumes? (S/N)");
            switch (input.next().toLowerCase().charAt(0))
            {
                case 'n':
                    break albums;
            }
        }

        banda.setAlbumes(albumsList);


        //MOSTRAR MENSAJE
        for(Album album : banda.getAlbumes()) {
            System.out.println("Album: " + album.getTitulo() + " (" + album.getAnyoPublicacion() + ") " + album.getPvp() + "€");
            System.out.println("By: " + banda.getNombre());
            for(Persona miembro : banda.getMiembros()) {
                System.out.println("    " + miembro.getNombre() + " (" + miembro.getAnyoNacimiento() + ")");
            }
            System.out.println("Songs:");
            for(int i = 0; i < album.getCanciones().size(); i++) {
                Cancion cancion = album.getCanciones().get(i);
                System.out.println("    " + i + ": " + cancion.getTitulo() + " (" + cancion.getDuracion() + " seconds)");
            }
            System.out.println("---------------");
        }
    }
}
