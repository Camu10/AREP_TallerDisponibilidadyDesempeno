package edu.escuelaing.arep.app;

import edu.escuelaing.arep.app.services.MergeSort;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        port(getPort());
        staticFiles.location("/public");
        get("/order", (req, res) -> {
            String string = req.queryParams("list");
            String[] list = toArray(string);
            MergeSort sort = new MergeSort();
            String[] ans = sort.sort(list);
            return toString(ans);
        });
    }

    public static String[] toArray(String string){
        String[] list,elements = string.split(",");
        list = new String[elements.length];
        for (int i = 0; i < elements.length; i++) {
            list[i] = elements[i];
        }
        return list;
    }

    public static String toString(String[] list){
        String string = "";
        string += "[";
        for(int i=0;i<list.length;i++){
            string+=list[i];
            if(i!= list.length-1){
                string+=",";
            }
        }
        string += "]";
        return string;
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     * @return returns default port if heroku-port isn't set (i.e. on localhost)
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
