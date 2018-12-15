import java.util.Scanner;
import java.io.*;

class URL_Test {
    public static void main(String[] args) {
        int counter = 0;
        hashable h = new hashable();
        hash[] my_hash = new hash[100];
        for (int i = 0; i < my_hash.length; i++) {
            my_hash[i] = new hash();
        }
        Scanner sc = new Scanner(System.in);
        String url = sc.next();
        String dir = sc.next();
        int depth = sc.nextInt();
        check myCheck = new check();
        int isValidURL = myCheck.checkURL(url);
        int isValidDir = myCheck.checkDir(dir);
        int isValidDepth = myCheck.checkDepth(depth);
        doc jsoup = new doc();
        String parsedHTML = jsoup.parseHTML(url);
        counter = jsoup.fileWriting(dir, counter, parsedHTML);
        String[] arrStr = jsoup.selectAnchors(parsedHTML, url);
        // for (int i = 0; i < arrStr.length; i++) {
        // System.out.println(i + " " + arrStr[i]);
        // }
        my_hash = h.set(my_hash, arrStr, 1);
        for (int i = 0; i < my_hash.length; i++) {
            System.out.println(i);
            my_hash[i].print();
        }
    }
}
