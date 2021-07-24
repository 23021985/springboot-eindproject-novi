package com.novi.eindproject.idrunk.version.july;

import com.novi.eindproject.idrunk.version.july.invoices.InvoiceGenerator;
import com.novi.eindproject.idrunk.version.july.invoices.OrderLine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

//@EnableJpaRepositories
@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @SpringBootApplication
    public static class DemoFileUpload {

        public void main(String[] args) {
            SpringApplication.run(DemoFileUpload.class, args);
        }

    }
    public static class invoiceGenerator {

        public static void main(String[] args) {
            InvoiceGenerator generator = new InvoiceGenerator();

            var orderLines = List.of(new OrderLine(5, 2.99, "Product 1"), new OrderLine(2, 2.00, "Product 2"),
                    new OrderLine(1, 6.99, "Product 3"), new OrderLine(3, 12.00, "Product 4"));

            var invoice = generator.generateInvoice(orderLines);

            System.out.println(invoice);
        }
    }
}
