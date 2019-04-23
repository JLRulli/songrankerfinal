package webapp;

import dataLayer.DB;
import dataLayer.HashMaps;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(
        name = "SearchArtists",
        urlPatterns = {"/SearchArtists"}
)
public class SearchArtists extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get artistName
        String aname = request.getParameter("artistName");

        DB db = new DB();
        //artist exists
        if (db.isArtist(aname)) {

            System.out.println("EXISTS");

            HashMap<String, Integer> hashMap = db.data(aname);
            HashMaps hashMaps = new HashMaps();
            HashMap<String, Integer> temp = hashMaps.sort(hashMap);
            System.out.println(Arrays.asList(hashMaps.sort(hashMap)));
            int count = 0;
            HashMap<String, Integer> fin = new HashMap<>();
            for (Map.Entry<String, Integer> entry : temp.entrySet()) {
                if (count >= 5) {
                    break;
                }
                System.out.println((entry.getKey() + entry.getValue()));
                request.setAttribute("n" + String.valueOf(count), entry.getKey());
                request.setAttribute("r" + String.valueOf(count), entry.getValue());
                count++;
            }
            //System.out.println(Arrays.asList(fin));

            //dispatch to listArtist
            request.setAttribute("artistName", aname);
            RequestDispatcher rd = request.getRequestDispatcher("/listArtists.jsp");
            rd.forward(request,response);
        } else {

        }

    }

}
