package ch.fhnw.mada;

import ch.fhnw.mada.key.KeyPair;
import ch.fhnw.mada.tools.FileManager;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        String hexadecimal = "FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966DE39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF6955817183995497CEA956AE515D2261898FA051015728E5A8AACAA68FFFFFFFFFFFFFFFF";
        BigInteger group = new BigInteger(hexadecimal, 16);
        BigInteger g = BigInteger.valueOf(2);
        // create KeyPair from group and generator
        KeyPair keyPair = new KeyPair(group, g);
        // write public key to pk.txt
        FileManager.writeFile("data/aufgabe2/pk.txt", keyPair.getPublicKey().getNumber().toString());
        // write private key to sk.txt
        FileManager.writeFile("data/aufgabe2/sk.txt", keyPair.getPrivateKey().getNumber().toString());
    }

}
