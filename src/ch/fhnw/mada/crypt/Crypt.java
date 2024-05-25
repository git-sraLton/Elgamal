package ch.fhnw.mada.crypt;

import ch.fhnw.mada.key.Key;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Crypt {

    public static String decryptText(String text, Key privateKey) {
        String[] encryptedChars = text.split(";");
        return Arrays.stream(encryptedChars).map(string -> String.valueOf(decryptChar(string, privateKey))).collect(Collectors.joining());

    }

    public static String encryptText(String text, Key publicKey) {
        return text.chars().mapToObj(character -> encryptChar(character, publicKey)).collect(Collectors.joining(";"));
    }

    private static String encryptChar(int character, Key publicKey) {
        BigInteger a = Key.randomNumberFromGroup(publicKey.getGroup());
        BigInteger y1 = publicKey.getGenerator().modPow(a, publicKey.getGroup());
        BigInteger y2 = publicKey.getNumber().modPow(a, publicKey.getGroup())
                .multiply(BigInteger.valueOf(character))
                .mod(publicKey.getGroup());
        return "(" + y1 + "," + y2 + ")";
    }

    private static char decryptChar(String encrypted, Key privateKey) {
        String[] y1y2 = encrypted.substring(1, encrypted.length()-1).split(",");
        BigInteger y1 = new BigInteger(y1y2[0]);
        BigInteger y2 = new BigInteger(y1y2[1]);
        BigInteger result = y2.multiply(y1.modPow(privateKey.getNumber(), privateKey.getGroup()).modInverse(privateKey.getGroup())).mod(privateKey.getGroup());
        return (char) Integer.parseInt(result.toString());
    }
}
