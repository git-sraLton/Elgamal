package ch.fhnw.mada.key;

import java.math.BigInteger;

public class Key {
    private BigInteger group;
    private BigInteger generator;
    private BigInteger number; // third part

    public Key(BigInteger group, BigInteger generator, BigInteger number) {
        this.group = group;
        this.generator = generator;
        this.number = number;
    }

    public BigInteger getGroup() {
        return group;
    }

    public void setGroup(BigInteger group) {
        this.group = group;
    }

    public BigInteger getGenerator() {
        return generator;
    }

    public void setGenerator(BigInteger generator) {
        this.generator = generator;
    }

    public BigInteger getNumber() {
        return number;
    }

    public void setNumber(BigInteger number) {
        this.number = number;
    }
}
