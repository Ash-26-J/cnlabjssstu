import java.util.*;

class Frame {
    int num;
    String data;

    Frame(int n, String d) {
        num = n;
        data = d;
    }
}

public class frames {
    static void sort(Frame[] f) {
        for (int i = 0; i < f.length; i++) {
            boolean flag = false;
            for (int j = 0; j < f.length - 1; j++) {
                if (f[j].num > f[j + 1].num) {
                    Frame temp = f[j];
                    f[j] = f[j + 1];
                    f[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of frames:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Frame[] f = new Frame[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the frame number:");
            int num = sc.nextInt();
            System.out.println("Enter the frame data:");
            String data = sc.next();
            f[i] = new Frame(num, data);
        }
        sort(f);
        System.out.println("The sorted frames are:");
        for (int i = 0; i < n; i++) {
            System.out.println(f[i].data);
        }
    }
}
 
