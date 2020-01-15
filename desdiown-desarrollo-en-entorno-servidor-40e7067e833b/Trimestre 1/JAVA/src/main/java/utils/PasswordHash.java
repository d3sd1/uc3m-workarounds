package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import yml.ConfigSecurity;

public class PasswordHash
{

    private static PasswordHash pass;

    private PasswordHash()
    {

    }

    public static PasswordHash getInstance()
    {

        if (pass == null)
        {
            pass = new PasswordHash();
        }
        return pass;
    }

    public String createHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        return createHash(password.toCharArray());
    }

    public String createHash(char[] password) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[ConfigSecurity.getInstance().getSaltByteSize()];
        random.nextBytes(salt);

        byte[] hash = pbkdf2(password, salt, ConfigSecurity.getInstance().getPBKDF2Iterations(), ConfigSecurity.getInstance().getHashByteSize());
        return ConfigSecurity.getInstance().getPBKDF2Iterations() + ":" + toHex(salt) + ":" + toHex(hash);
    }

    public boolean validatePassword(String password, String correctHash) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        return validatePassword(password.toCharArray(), correctHash);
    }

    public boolean validatePassword(char[] password, String correctHash) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        String[] params = correctHash.split(":");
        int iterations = Integer.parseInt(params[0]);
        byte[] salt = fromHex(params[1]);
        byte[] hash = fromHex(params[2]);
        byte[] testHash = pbkdf2(password, salt, iterations, hash.length);
        return slowEquals(hash, testHash);
    }

    private boolean slowEquals(byte[] a, byte[] b)
    {
        int diff = a.length ^ b.length;
        for (int i = 0; i < a.length && i < b.length; i++)
        {
            diff |= a[i] ^ b[i];
        }
        return diff == 0;
    }

    private byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes)
            throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(ConfigSecurity.getInstance().getPBKDF2Algorithm());
        return skf.generateSecret(spec).getEncoded();
    }

    public byte[] fromHex(String hex)
    {
        byte[] binary = new byte[hex.length() / 2];
        for (int i = 0; i < binary.length; i++)
        {
            binary[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return binary;
    }

    private String toHex(byte[] array)
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0)
        {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        }
        else
        {
            return hex;
        }
    }

    public byte[] cifra(String sinCifrar) throws Exception
    {
        final byte[] bytes = sinCifrar.getBytes("UTF-8");
        final Cipher aes = obtieneCipher(true);
        final byte[] cifrado = aes.doFinal(bytes);
        return cifrado;
    }

    public String descifra(byte[] cifrado) throws Exception
    {
        final Cipher aes = obtieneCipher(false);
        final byte[] bytes = aes.doFinal(cifrado);
        final String sinCifrar = new String(bytes, "UTF-8");
        return sinCifrar;
    }

    private Cipher obtieneCipher(boolean paraCifrar) throws Exception
    {
        final String frase = "FraseLargaConDiferentesLetrasNumerosYCaracteresEspeciales_áÁéÉíÍóÓúÚüÜñÑ1234567890!#%$&()=%_NO_USAR_ESTA_FRASE!_";
        final MessageDigest digest
                = MessageDigest.getInstance("SHA-1");
        digest.update(frase.getBytes("UTF-8"));
        final SecretKeySpec key = new SecretKeySpec(
                digest.digest(), 0, 16, "AES");

        final Cipher aes = Cipher.getInstance(
                "AES/ECB/PKCS5Padding");
        if (paraCifrar)
        {
            aes.init(Cipher.ENCRYPT_MODE, key);
        }
        else
        {
            aes.init(Cipher.DECRYPT_MODE, key);
        }

        return aes;
    }
}
