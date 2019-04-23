package webapp;

import dataLayer.DB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

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
        if (db.isArtist(aname)) {

            System.out.println("EXISTS");

            HashMap<String, Integer> hashMap = db.data(aname);
            System.out.println(Arrays.asList(hashMap));

            //dispatch to listArtist
            request.setAttribute("artistName", aname);
            RequestDispatcher rd = request.getRequestDispatcher("/listArtists.jsp");
            rd.forward(request,response);
        } else {

        }


    }
}
