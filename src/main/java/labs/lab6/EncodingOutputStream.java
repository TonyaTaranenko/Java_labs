package labs.lab6;

import java.io.*;

public class EncodingOutputStream extends FilterOutputStream {
    private int key;

    public EncodingOutputStream(OutputStream out, int key) {
        super(out);
        this.key = key;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b + key);
    }
}
