package labs.lab6;

import java.io.IOException;

public class Lab6 {
    public static void main(String[] args) throws IOException {
        System.out.println(CustomEncodingHelper.encode("abcd", 1));
        System.out.println(CustomEncodingHelper.decode("bcde", 1));
    }
}
