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
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Frame[] f = new Frame[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the frame number:");
            int num = in.nextInt();
            System.out.println("Enter the frame data:");
            String data = in.next();
            f[i] = new Frame(num, data);
        }
        sort(f);
        System.out.println("The sorted frames are:");
        for (int i = 0; i < n; i++) {
            System.out.println(f[i].data);
        }
    }
}
 
/*o/p
* sample out put format*
enter the number of frames
    5
    enter the frame number :1
    enter the data:sri
    enter the frame numbetr:2
    enter the data:jaya
    enter the frame number:3
    enter the data:chamrajendra
    enter the frame number :4
    enter the data:college
    enter the frame number:5
    enter the data :mysore
    the sorted frames are :
   sri jaya chamrajendra college mysore
    */
    
