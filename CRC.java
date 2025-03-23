import java.util.*;

public class Main {
    public String crc(String poly, String data, boolean error) {
        String rem = data;
        if (!error) {
            for (int i = 0; i < poly.length() - 1; i++) {
                rem += "0";
            }
        }
        for (int i = 0; i < rem.length() - poly.length() + 1; i++) {
            if (rem.charAt(i) == '1') {
                String temp = "";
                for (int j = 0; j < poly.length(); j++) {
                    if (rem.charAt(i + j) == poly.charAt(j)) {
                        temp += '0';
                    } else {
                        temp += '1';
                    }
                }
                rem = rem.substring(0, i) + temp + rem.substring(i + poly.length()); // Corrected substring indices
            }
        }
        return rem.substring(rem.length() - poly.length() + 1); // Corrected remainder length
    }

    public static void main(String[] args) {
        Main nm = new Main();
        Scanner in = new Scanner(System.in);
        System.out.println("enter the polynomial");
        String poly = in.next();
        System.out.println("enter the data");
        String data = in.next();
        String rem = nm.crc(poly, data, false);
        String code = data + rem;
        System.out.println("remainder is " + rem);
        System.out.println("coded word is " + code);
        System.out.println("enter the received word");
        String recivd = in.next();
        String remrec = nm.crc(poly, recivd, true);
        if (Integer.parseInt(remrec, 2) == 0) {
            System.out.println("the data received is correct \n");
        } else {
            System.out.println("the data received is incorrect\n");
        }
    }
}
/*
o/p
enter the poly:
1101
 enter the data:
100100
 remainder is 001
 coded word is 100100001
 enter the recived word :
 100100001
 data is correct

 if recived word entered is 1001001
 data is in correct
 */

