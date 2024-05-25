package ch.fhnw.mada;

import ch.fhnw.mada.crypt.Crypt;
import ch.fhnw.mada.key.Key;
import ch.fhnw.mada.key.KeyPair;
import ch.fhnw.mada.tools.FileManager;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        // Aufgabe 1: create decimal BigInteger from hexadecimal number
        String hexadecimal = "FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966D670C354E4ABC9804F1746C08CA18217C32905E462E36CE3BE39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF6955817183995497CEA956AE515D2261898FA051015728E5A8AACAA68FFFFFFFFFFFFFFFF";
        BigInteger group = new BigInteger(hexadecimal, 16);
        BigInteger g = BigInteger.valueOf(2);

//        generateKeys(group, g);
//        encryptMessage(group, g);
        decryptMessage(group, g);
//        decryptGivenMessage(group, g);
    }

    private static void decryptGivenMessage(BigInteger group, BigInteger g) {
        Key privateKey = new Key(group, g, new BigInteger(FileManager.readFile("data/aufgabe5/sk.txt")));
        String result = Crypt.decryptText(FileManager.readFile("data/aufgabe5/chiffre.txt"), privateKey);
        FileManager.writeFile("data/aufgabe5/text-d.txt", result);
    }

    // Aufgabe 4: decrypt a text from chiffre.txt and private key from sk.txt and write the result in text-d.txt
    private static void decryptMessage(BigInteger group, BigInteger g) {
        Key privateKey = new Key(group, g, new BigInteger(FileManager.readFile("data/aufgabe4/sk.txt")));
        String result = Crypt.decryptText(FileManager.readFile("data/aufgabe4/chiffre.txt"), privateKey);
        FileManager.writeFile("data/aufgabe4/text-d.txt", result);
    }

    // Aufgabe 3: encrypt a text from text.txt and public key from pk.txt and write the result in text.txt
    private static void encryptMessage(BigInteger group, BigInteger g) {
        Key publicKey = new Key(group, g, new BigInteger(FileManager.readFile("data/aufgabe3/pk.txt")));
        String result = Crypt.encryptText(FileManager.readFile("data/aufgabe3/text.txt"), publicKey);
        FileManager.writeFile("data/aufgabe3/chiffre.txt", result);
    }

    // Aufgabe 2: create KeyPair from group and generator
    private static void generateKeys(BigInteger group, BigInteger g) {
        KeyPair keyPair = new KeyPair(group, g);
        // write public key to pk.txt
        FileManager.writeFile("data/aufgabe2/pk.txt", keyPair.getPublicKey().getNumber().toString());
        // write private key to sk.txt
        FileManager.writeFile("data/aufgabe2/sk.txt", keyPair.getPrivateKey().getNumber().toString());
    }

}
