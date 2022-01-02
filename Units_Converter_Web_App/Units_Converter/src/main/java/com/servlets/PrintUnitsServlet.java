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
                "<form action=\"convert\" method=\"get\">\n" +
                "<center><label for=\"value\">Input value: </label>\n" +
                "<input type=\"text\" id=\"value\" name=\"value\"><br></center>\n" +
                "<center><label for=\"input_unit_select\">Choose input unit: </label>\n" +
                "<select name=\"input_unit\" id=\"input_unit_select\">\n"
        );
        ArrayList<String> unitsList = supplier.getSupportedUnitsCollection().get(converterType);
        for (String unit : unitsList) {
            out.println("<option value=\"" + unit + "\">" + unit + "</option>\n");
        }
        out.println("</select>\n" +
                "<br><center><label for=\"output_unit_select\">Choose output unit: </label>\n" +
                "<select name=\"output_unit\" id=\"output_unit_select\">\n"
        );
        for (String unit : unitsList) {
            out.println("<option value=\"" + unit + "\">" + unit + "</option>\n");
        }
        out.println(
                "</select>\n" +
                        "<br><br><input type=\"submit\" value=\"confirm\"/></center>\n" +
                        "</form>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }
}
