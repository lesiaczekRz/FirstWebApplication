package app.view;

import app.model.Invoice;

import java.text.DecimalFormat;
import java.util.List;

public class InvoiceView extends DefaultView {

    private static final DecimalFormat DF_POLISH = new DecimalFormat("###,###.00");

    public static String displayInvoices(List<Invoice> invoiceList) {
        StringBuilder html = new StringBuilder(displayMenu());
        html.append("<table class=\"table table-striped table-hover\">");
        html.append("<tr><th scope=\"col\">L.p.</th><th scope=\"col\">Numer faktury</th>");
        html.append("<th scope=\"col\">Kwota</th><th scope=\"col\">Data</th><th>Funkcje</th></tr>");
        int lp = 0;
        for (Invoice invoice : invoiceList) {
            html.append("<tr>");
            html.append("<td scope=\"row\">").append(++lp).append("</td>");
            html.append("<td>").append(invoice.getNumberInvoice()).append("</td>");
            html.append("<td>").append(DF_POLISH.format(invoice.getAmount())).append("</td>");
            html.append("<td>").append(invoice.getDate().toString(), 0, 10).append("</td>");
            html.append("<td>");
            html.append("<a href=\"/invoices/edit/").append(invoice.getId()).append("\" class=\"btn btn-secondary\">");
            html.append("Edytuj");
            html.append("</a>");
            html.append("<a href=\"/invoices/delete/").append(invoice.getId()).append("\" class=\"btn btn-secondary\">");
            html.append("Usuń");
            html.append("</a>");
            html.append("</td>");
            html.append("</tr>");
        }
        html.append("</table>");
        return getMainTemplateHtml(html.toString());
    }

    private static String displayMenu() {
        StringBuilder html;
        html = new StringBuilder();
        html.append("<div id=\"div-menu\">");
        html.append("<a href=\"/new-invoice\" class=\"btn btn-secondary\">");
        html.append("Nowa faktura");
        html.append("</a>");
        html.append("</div>");
        return html.toString();
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static String displayNewInvoice() {
        StringBuilder html;
        html = new StringBuilder();
        html.append("<form action=\"/save-new-invoice\" method=\"post\">");

        html.append("<div id=\"div-new-invoice\">");

        html.append("<input type=\"hidden\" name=\"numberInvoice\" value=\"\" />");

        html.append("<div class=\"row\">");
        html.append("<div class=\"col-lg\">").append("<div class=\"form-group\">");
        html.append("<label for=\"amount\">Kwota</label>");
        html.append("<input type=\"text\" class=\"form-control\" name=\"amount\" ");
        html.append("id=\"amount\" />");
        html.append("</div>").append("</div>").append("</div>");

        html.append("<div class=\"row\">");
        html.append("<div class=\"col-lg\">").append("<div class=\"form-group\">");
        html.append("<label for=\"date\">Data faktury [RRRR-MM-DD]</label>");
        html.append("<input type=\"text\" class=\"form-control\" name=\"date\" ");
        html.append("id=\"date\" />");
        html.append("</div>").append("</div>").append("</div>");

        html.append("</div>");

        html.append("<button class=\"btn btn-secondary\" type=\"submit\" ");
        html.append("id=\"button-save-new-invoice\">Zapisz</button>");
        html.append("</form>");
        return getMainTemplateHtml(html.toString());
    }

    public static String displayDelete(Long id, String numberInvoice) {
        StringBuilder html;
        html = new StringBuilder();

        html.append("<form action=\"/invoices/").append(id).append("?_method=DELETE\" method=\"post\">");
        html.append("<h2>Usunąć fakturę ").append(numberInvoice).append("?</h2>");
        html.append("<a href=\"/invoices\" class=\"btn btn-secondary\">Nie</a>");
        html.append("<button type=\"submit\" class=\"btn btn-secondary\">Tak</button>");
        html.append("</form>");
        return getMainTemplateHtml(html.toString());
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static String displayEdit(Long id, Invoice data) {
        StringBuilder html;
        html = new StringBuilder();

        html.append("<form action=\"/invoices/").append(id).append("?_method=PUT\" method=\"post\">");
        html.append("<h2>Edycja faktury ").append(data.getNumberInvoice()).append("</h2>");
        html.append("<div id=\"div-edit-invoice\">");

        html.append("<input type=\"hidden\" name=\"numberInvoice\" value=\"\" />");

        html.append("<div class=\"row\">");
        html.append("<div class=\"col-lg\">").append("<div class=\"form-group\">");
        html.append("<label for=\"amount\">Kwota</label>");
        html.append("<input type=\"text\" class=\"form-control\" name=\"amount\" ");
        html.append("id=\"amount\" value=\"").append(data.getAmount()).append("\" />");
        html.append("</div>").append("</div>").append("</div>");

        html.append("<div class=\"row\">");
        html.append("<div class=\"col-lg\">").append("<div class=\"form-group\">");
        html.append("<label for=\"date\">Data faktury [RRRR-MM-DD]</label>");
        html.append("<input type=\"text\" class=\"form-control\" name=\"date\" ");
        html.append("id=\"date\" value=\"").append(data.getDate().toString(), 0, 10).append("\" />");
        html.append("</div>").append("</div>").append("</div>");

        html.append("</div>");

        html.append("<button class=\"btn btn-secondary\" type=\"submit\" ");
        html.append("id=\"button-save-edit-invoice\">Zapisz</button>");
        html.append("</form>");
        return getMainTemplateHtml(html.toString());
    }
}
