package com.novi.eindproject.idrunk.version.july.invoices;

import java.util.List;

public class InvoiceGenerator {

    public String generateInvoice(List<OrderLine> orderLines) {
        var orderTotal = calculateOrderTotal(orderLines);

        StringBuilder invoiceBuilder = new StringBuilder();
        invoiceBuilder.append(generateHeader());
        invoiceBuilder.append(formatOrderLines(orderLines));
        invoiceBuilder.append(generateTotalSection(orderTotal));
        invoiceBuilder.append(generateFooter());

        return invoiceBuilder.toString();
    }

    public String generateHeader() {
        StringBuilder headerBuilder = new StringBuilder();

        headerBuilder.append("- - - - - - - - - - - - - -\n");
        headerBuilder.append("---------------------------\n");
        headerBuilder.append("-         INVOICE         -\n");
        headerBuilder.append("---------------------------\n");
        headerBuilder.append("- - - - - - - - - - - - - -\n");

        return headerBuilder.toString();
    }

    public String formatOrderLines(List<OrderLine> orderLines) {
        var linesBuilder = new StringBuilder();

        for (var line : orderLines) {
            var totalPrice = line.count * line.price;
            linesBuilder.append(String.format("%s  | %dx | $%.2f\n", line.name, line.count, totalPrice));
            linesBuilder.append("---------------------------\n");
        }

        return linesBuilder.toString();
    }

    public double calculateOrderTotal(List<OrderLine> orderLines) {
        var total = 0;
        for (var line : orderLines) {
            total += line.price * line.count;
        }

        return total;
    }

    public String generateTotalSection(double total) {
        var sectionBuilder = new StringBuilder();

        sectionBuilder.append("===========================\n");
        sectionBuilder.append(String.format("TOTAL: $ %.2f\n", total));
        sectionBuilder.append("===========================\n");

        return sectionBuilder.toString();
    }

    private String generateFooter() {
        var footerBuilder = new StringBuilder();

        footerBuilder.append("- - - - - - - - - - - - - -\n");
        footerBuilder.append("             2021          \n");
        footerBuilder.append("- - - - - - - - - - - - - -\n");

        return footerBuilder.toString();
    }
}
