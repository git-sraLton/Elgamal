package ch.fhnw.mada.key;

import java.math.BigInteger;
import java.util.Random;

public class KeyPair {
    private Key privateKey;
    private Key publicKey;

    public KeyPair(BigInteger group, BigInteger generator) {
        Random rnd = new Random();
        BigInteger number = new BigInteger(group.subtract(new BigInteger("1")).bitLength(), rnd);
        this.privateKey = new Key(group, generator, number);
        this.publicKey = new Key(group, generator, generator.modPow(number, group));
    }

    public KeyPair(Key privateKey, Key publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public Key getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(Key privateKey) {
        this.privateKey = privateKey;
    }

    public Key getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(Key publicKey) {
        this.publicKey = publicKey;
    }
}
