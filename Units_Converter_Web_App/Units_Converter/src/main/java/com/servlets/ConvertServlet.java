package com.servlets;

import com.model.container.ConvertedData;
import com.model.container.InputData;
import com.model.exception.MismatchedValueException;
import com.model.container.Supplier;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ConvertServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession userSession = request.getSession();
        Supplier supplier = (Supplier) userSession.getAttribute("supplier");
        if(supplier != null) {
            InputData inputData = new InputData(0, "", "");
            PrintWriter out = response.getWriter();
            try {
                inputData.setInputValue(Integer.parseInt(request.getParameter("value")));
            } catch (NumberFormatException exception) {
/*            out.println("<html>\n" +
                    "<body><center>\n" +
                    "<div class=\"alert\">\n" +
                    "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
                    "Value should be a number.\n" +
                    "</div>" +
                    "</center></body>\n" +
                    "</html>"
            );*/

                out.println("<html>\n" +
                        "<body>\n" +
                        "<form action=\"init\" method=\"post\">\n" +
                        "<center><h1>" + "Value should be a number.\n" + "</h1>\n" +
                        "<input type=\"submit\" value=\"continue\"/></center>\n" +
                        "</form>\n" +
                        "</body>\n" +
                        "</html>"
                );
                return;
            }
            inputData.setInputUnit(request.getParameter("input_unit"));
            inputData.setOutputUnit(request.getParameter("output_unit"));
            ConvertedData convertedData;
            try {
                convertedData = supplier.getConverterCollection().get(supplier.getConverterType()).convertValue(inputData);
            } catch (MismatchedValueException exception) {
/*            out.println("<html>\n" +
                    "<body><center>\n" +
                    "<div class=\"alert\">\n" +
                    "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
                    exception.getMessage() + "\n" +
                    "</div>" +
                    "</center></body>\n" +
                    "</html>"
            );*/

                out.println("<html>\n" +
                        "<body>\n" +
                        "<form action=\"init\" method=\"post\">\n" +
                        "<center><h1>" + exception.getMessage() + "\n" + "</h1>\n" +
                        "<input type=\"submit\" value=\"continue\"/></center>\n" +
                        "</form>\n" +
                        "</body>\n" +
                        "</html>"
                );
                return;
            }
            Cookie historyCookie = new Cookie("HistoryCookie",
                    String.valueOf(inputData.getInputValue()) + " " +inputData.getInputUnit() + " = " +
                            String.valueOf(convertedData.getConvertedValue())+ " " +convertedData.getConvertedValueUnit());
            response.addCookie(historyCookie);

            out.println("<html>\n" +
                    "<body>\n" +
                    "<form action=\"init\" method=\"post\">\n" +
                    "<center><h1>" + convertedData.getConvertedValue() + " " + convertedData.getConvertedValueUnit() + "</h1>\n" +
                    "<input type=\"submit\" value=\"continue\"/></center>\n" +
                    "</form>\n" +
                    "</body>\n" +
                    "</html>"
            );
        }
    }
}
