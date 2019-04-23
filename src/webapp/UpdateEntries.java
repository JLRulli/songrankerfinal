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

@WebServlet(
        name = "UpdateEntries",
        urlPatterns = {"/UpdateEntries"}
)
public class UpdateEntries extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String aname = request.getParameter("artistName");
        String s1 = request.getParameter("s1");
        String s2 = request.getParameter("s2");
        String s3 = request.getParameter("s3");
        String s4 = request.getParameter("s4");
        String s5 = request.getParameter("s5");

        DB db = new DB();
        db.update(aname, s1, s2, s3, s4, s5);

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

    }
}











