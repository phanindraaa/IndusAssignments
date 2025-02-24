package com.indus.training.core.impl;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OracleByteStream {

    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("src/main/resources/xanadu.txt");
            out = new FileOutputStream("src/main/resources/outagain.txt");
            int c;
           

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}

