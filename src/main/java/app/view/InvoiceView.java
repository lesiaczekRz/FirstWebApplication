package app.view;

import app.model.Invoice;

import java.text.DecimalFormat;
import java.util.List;

public class InvoiceView extends DefaultView {

    private static final DecimalFormat DF_POLISH = new DecimalFormat("###,###.00");

    public static String displayInvoices(List<Invoice> invoiceList) {
        StringBuilder html;
        html = new StringBuilder();
        html.append("<table class=\"table table-striped table-hover\">");
        html.append("<tr><th scope=\"col\">L.p.</th><th scope=\"col\">Numer faktury</th>");
        html.append("<th scope=\"col\">Kwota</th><th scope=\"col\">Data</th></tr>");
        int lp = 0;
        for (Invoice invoice : invoiceList) {
            html.append("<tr>");
            html.append("<td scope=\"row\">").append(++lp).append("</td>");
            html.append("<td>").append(invoice.getNumberInvoice()).append("</td>");
            html.append("<td>").append(DF_POLISH.format(invoice.getAmount())).append("</td>");
            html.append("<td>").append(invoice.getDate().toString(), 0, 10).append("</td>");
            html.append("</tr>");
        }
        html.append("</table>");
        return getMainTemplateHtml(html.toString());
    }


}
