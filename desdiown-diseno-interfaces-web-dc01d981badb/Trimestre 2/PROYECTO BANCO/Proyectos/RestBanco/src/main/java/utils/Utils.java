package utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.User;

public class Utils
{

    private final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final String NUMERIC_STRING = "0123456789";

    public String generateUserToken(User user)
    {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + Constantes.MINUTOS_EXPIRACION_LOGIN_TOKEN * 60 * 1000);
        String token;
        token = Jwts.builder()
                .setIssuer("BBVA")
                .setSubject("INTERNAL_LOGIN")
                .claim("name", user.getName() + " " + user.getSurnames())
                .claim("dni", user.getDni())
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, Constantes.CLAVE_PRIVADA_TOKENS)
                .compact();
        return token;
    }

    public String randomAlphaNumeric(int count)
    {
        StringBuilder builder = new StringBuilder();
        Random r = new SecureRandom();

        while (count-- != 0)
        {
            int character = (int) (r.nextInt(ALPHA_NUMERIC_STRING.length()));
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
    public int generatePin()
    {
        String builder = "";
        int pinLength = 4;
        Random r = new SecureRandom();

        while (pinLength-- != 0)
        {
            int character = (int) (r.nextInt(NUMERIC_STRING.length()));
            builder = builder + NUMERIC_STRING.charAt(character);
        }
        return Integer.parseInt(builder);
    }

    public boolean comprobarFormatoCuenta(String numeroCuenta)
    {
        int suma = 0;
        for (int i = 0; i < numeroCuenta.length(); i++)
        {
            if (i < 9)
            {
                int numero = Integer.parseInt(numeroCuenta.substring(i, i + 1));
                suma += numero;
            }
            else
            {
                break;
            }
        }
        int numeroFinalResultado = suma % 9;
        return numeroFinalResultado == Integer.parseInt(numeroCuenta.substring(9, 10));
    }

    public boolean comprobarDni(String dni)
    {
        Pattern pattern = Pattern.compile("[0-9]{8}[A-Z]{1}");

        Matcher matcher = pattern.matcher(dni);
        return matcher.matches();
    }
}
