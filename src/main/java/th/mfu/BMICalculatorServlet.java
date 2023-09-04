package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet(urlPatterns = "/calbmi")
public class BMICalculatorServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String weightStr = request.getParameter("weight");
        String heightStr = request.getParameter("height");

            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);
         
        //TODO: calculate bmi
            double bmi = weight / (height * height);
            int roundedBMI = (int) Math.round(bmi); //make it not be to decimal number
        //TODO: determine the built from BMI
              String category;
            if (roundedBMI < 18.5) {
                category = "underweight";
            } else if (roundedBMI >= 18.5 && roundedBMI < 25) {
                category = "normal";
            } else if (roundedBMI >= 25 && roundedBMI < 30) {
                category = "oerweight";
            } else if (roundedBMI >= 30 && roundedBMI < 35) {
                category = "obese";
            } else {
                category = "extremely Obese";
            }
        //TODO: add bmi and built to the request's attribute
            request.setAttribute("bmi", roundedBMI);
            request.setAttribute("built", category);
        //TODO: forward to jsp
           request.getRequestDispatcher("/bmi_result.jsp").forward(request, response);

        }
    
}
