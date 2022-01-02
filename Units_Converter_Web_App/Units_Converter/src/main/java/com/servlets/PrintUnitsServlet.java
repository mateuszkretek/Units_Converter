package com.servlets;

import com.supplier.ConverterType;
import com.supplier.Supplier;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PrintUnitsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ConverterType converterType = ConverterType.valueOf(request.getParameter("types"));
        HttpSession userSession = request.getSession();
        Supplier supplier = (Supplier) userSession.getAttribute("supplier");
        supplier.setConverterType(converterType);
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "<body>\n" +
                "<form action=\"print_units\" method=\"get\">\n" +
                "<center><label for=\"input_unit_select\">Choose converter type:</label>\n" +
                "<br><select name=\"types\" id=\"input_unit_select\"\n" +
                "<option value=\"\"></option>\n"
        );
        ArrayList<String> unitsList = supplier.getSupportedUnitsCollection().get(converterType);
        for (String unit: unitsList) {
            out.println("<option value=\"" + unit +"\">" + unit + "</option>\n" );
        }
        out.println(
                "</select>\n" +
                "<br><input type=\"submit\" value=\"confirm\"/></center>\n" +
                "</form>n \n" +
                "</body>\n" +
                "</html>\n"
        );
    }
}
