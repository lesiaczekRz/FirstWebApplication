package app.view;

import app.model.Invoice;

import java.text.DecimalFormat;
import java.util.List;

public class InvoiceView {

    private static final DecimalFormat DF_POLISH = new DecimalFormat("###,###.00");

    public static String displayInvoices(List<Invoice> invoiceList) {
        StringBuilder html;
        html = new StringBuilder("<table>");
        html.append("<tr><th>L.p.</th><th>Kwota</th><th>Data</th></tr>");
        int lp = 0;
        for (Invoice invoice : invoiceList) {
            html.append("<tr>");
            html.append("<td>").append(++lp).append("</td>");
            html.append("<td>").append(DF_POLISH.format(invoice.getAmount())).append("</td>");
            html.append("<td>").append(invoice.getDate().toString().substring(0, 10)).append("</td>");
            html.append("</tr>");
        }
        html.append("</table>");
        return html.toString();
    }
}
