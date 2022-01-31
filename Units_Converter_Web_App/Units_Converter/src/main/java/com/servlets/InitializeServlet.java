package com.servlets;

import com.model.converter.Converter;
import com.model.converter.LengthConverter;
import com.model.converter.TimeConverter;
import com.model.converter.WeightConverter;
import com.model.container.ConverterType;
import com.model.container.Supplier;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InitializeServlet extends HttpServlet {

    Map<ConverterType, ArrayList<String>> supportedUnitsCollection = new HashMap<>();
    Map<ConverterType, Converter> converterCollection = new HashMap<>();
    Converter converter;

    private void readConfig(Supplier supplier) {
        try {
            converter = new LengthConverter();
            converterCollection.put(ConverterType.LENGTH, converter);
            supportedUnitsCollection.put(ConverterType.LENGTH, converter.getSupportedUnits());
            converter = new TimeConverter();
            converterCollection.put(ConverterType.TIME, converter);
            supportedUnitsCollection.put(ConverterType.TIME, converter.getSupportedUnits());
            converter = new WeightConverter();
            converterCollection.put(ConverterType.WEIGHT, converter);
            supportedUnitsCollection.put(ConverterType.WEIGHT, converter.getSupportedUnits());
        } catch (FileNotFoundException configFileNotFound) {
        }
        supplier.setConverterCollection(converterCollection);
        supplier.setSupportedUnitsCollection(supportedUnitsCollection);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Supplier supplier = new Supplier();
        this.readConfig(supplier);
        request.getSession().setAttribute("supplier", supplier);
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "<body>\n" +
                "<form action=\"print_units\" method=\"get\">\n" +
                "<center><label for=\"type_select\">Choose converter type:</label><br>\n" +
                "<select name=\"types\" id=\"type_select\">\n" +
                "<option value=\"LENGTH\">Length</option>\n" +
                "<option value=\"TIME\">Time</option>\n" +
                "<option value=\"WEIGHT\">Weight</option>\n" +
                "</select>\n" +
                "<br><input type=\"submit\" value=\"confirm\"/>" +
                "</form>\n"+
                "<br><h3>Last conversion:</h3>\n"
        );
        Cookie ck[] = request.getCookies();
        for (Cookie cookie: ck) {
            if (cookie.getName().equals("HistoryCookie")) {
                out.print(cookie.getValue() +"<br>"+ "\n");
            }
        }
        out.println(
                "</center></body>\n" +
                "</html>"
        );
    }

}
