package com.cleo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class Block{

    private String hash, previousHash,proof;
    private long timeStamp;

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public Block(String proof, String previousHash){
        this.proof = proof;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();

    }

    @Override
    public String toString() {
        return this.proof;
    }

    public String calculateHash(){

       return Cryptography.sha256(previousHash + Long.toString(timeStamp) + proof);

    }


    /*@Override
    public int hashCode() {
        return super.hashCode();
    }*/
}

class Cryptography {
    // Function that takes the string input
    // and returns the hashed string.
    public static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");//Money Comes building this algorithm securely..
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            int i = 0;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < hash.length; j++) {
                // hex will contain
                // the Hexadecimal hash
                String hex = Integer.toHexString(0xff & hash[i]);//?
               // System.out.println(hex);
                if (hex.length() == 1)
                    builder.append('0');

                builder.append(hex);


            }
         //   System.out.println(builder);
            return builder.toString();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}

public class Blockchain {

    private static final List<Block> blockChain = new ArrayList<>();
    public static Boolean isChainValid(){
        Block currentBlock, previousBlock;

        for (int i = 1; i < blockChain.size()-1; i++) {
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i-1);
            System.out.println(currentBlock.toString());
            if(!currentBlock.getHash().equals(currentBlock.calculateHash())){
                System.out.println("Invalid current Hash, Error, blockchain corrupt");
                return false;

            }
            if(!previousBlock.getHash().equals(currentBlock.getPreviousHash())){
                System.out.println("Invalid Previous Hash, error aborting ");
                return false;
            }



        }
        return true;
    }

    public static void main(String[] args) {

        blockChain.add(
                new Block("First Block","0"));
        blockChain.add(
                new Block("Second Block",blockChain.get(blockChain.size()-1).getHash()));
        blockChain.add(

                new Block("Third Block",blockChain.get(blockChain.size()-1).getHash()));
        blockChain.add(

                new Block("Fourth Block",blockChain.get(blockChain.size()-1).getHash()));
        blockChain.add(

                new Block("Fifth Block",blockChain.get(blockChain.size()-1).getHash()));
        for (Block block : blockChain) {
            System.out.println(block.calculateHash());
        }

        if(isChainValid()){
            System.out.println("Valid Chain ");
        }else
            System.out.println("Block chain corrupt");
    }


}

