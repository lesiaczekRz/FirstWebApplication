package app.view;

public abstract class DefaultView {

    /**
     * Główny szablon HTML (na potrzeby amatorskiej aplikacji)
     *
     * @param body {@link String}
     * @return String
     */
    @SuppressWarnings("SpellCheckingInspection")
    protected static String getMainTemplateHtml(String body) {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>My first Java web application</title>\n" +
                "<link rel=\"stylesheet\" href=\"styles.css\">" +
                "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\"" +
                "rel=\"stylesheet\" " +
                "integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" " +
                "crossorigin=\"anonymous\">" +
                "</head>\n" +
                "<body class=\"text-center\">\n" +
                body +
                "<!-- JavaScript Bundle with Popper -->\n" +
                "<script " +
                "src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" " +
                "integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" " +
                "crossorigin=\"anonymous\"></script>" +
                "</body>\n" +
                "</html>";
    }
}
