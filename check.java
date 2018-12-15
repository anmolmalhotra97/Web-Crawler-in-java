
import java.net.*;
import java.io.*;

class check {
    int checkDepth(int depth) {
        if (depth < 0)
            return 0;
        return 1;
    }

    int checkDir(String dir) {
        File file = new File(dir);
        if (file.canExecute() && file.canRead() && file.canWrite()) {
            return 1;
        }
        return 0;

    }

    int checkURL(String url) {
        try {
            URL url1 = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            String connType = (conn.getContentType());
            String connTypeSplit[] = connType.split(" ");
            if (connTypeSplit[0].equals("text/html;"))
                return 1;
        } catch (MalformedURLException e) {
            System.out.println(e.toString());
        } catch (ProtocolException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return 0;
    }
}
