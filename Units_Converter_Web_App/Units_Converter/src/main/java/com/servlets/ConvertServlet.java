package com.servlets;

import com.model.exception.MismatchedValueException;
import com.supplier.Supplier;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ConvertServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession userSession = request.getSession();
        Supplier supplier = (Supplier) userSession.getAttribute("supplier");
        supplier.setInputValue(Integer.parseInt(request.getParameter("value")));
        supplier.setInputUnit(request.getParameter("input_unit"));
        supplier.setOutputUnit(request.getParameter("output_unit"));
        try {
            supplier.getConverterCollection().get(supplier.getConverterType()).convertValue(supplier.getInputData());
        } catch (MismatchedValueException exception) {
        }
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "<body>\n" +
                "<center><h1>" + supplier.getConvertedData().getConvertedValue() + " " + supplier.getConvertedData().getConvertedValueUnit() + "</h1></center>\n" +
                "</body>\n" +
                "</html>"
        );
    }
}
