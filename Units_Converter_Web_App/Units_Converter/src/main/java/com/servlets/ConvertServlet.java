package com.servlets;

import com.model.container.ConvertedData;
import com.model.container.InputData;
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
        InputData inputData = new InputData();
        inputData.setInputValue(Integer.parseInt(request.getParameter("value")));
        inputData.setInputUnit(request.getParameter("input_unit"));
        inputData.setOutputUnit(request.getParameter("output_unit"));
        ConvertedData convertedData = new ConvertedData(0.0, " ");
        try {
            convertedData = supplier.getConverterCollection().get(supplier.getConverterType()).convertValue(inputData);
        } catch (MismatchedValueException exception) {
        }
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "<body>\n" +
                "<form action=\"init\" method=\"get\">\n" +
                "<center><h1>" + convertedData.getConvertedValue() + " " + convertedData.getConvertedValueUnit() + "</h1>\n" +
                "<input type=\"submit\" value=\"continue\"/></center>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>"
        );
    }
}
