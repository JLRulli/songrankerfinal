package webapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        //dispatch to listArtist
        request.setAttribute("artistName", aname);
        RequestDispatcher rd = request.getRequestDispatcher("/listArtists.jsp");
        rd.forward(request,response);

    }
}
