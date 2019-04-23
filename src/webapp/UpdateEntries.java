package webapp;

import dataLayer.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    }
}











