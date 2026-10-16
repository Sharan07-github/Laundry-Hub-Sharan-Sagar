package com.servicehub.util;

import java.io.ByteArrayOutputStream;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import com.servicehub.model.Order;

public class InvoiceGenerator {

    public static byte[] generateInvoice(Order order) {

        try {

            ByteArrayOutputStream out = new ByteArrayOutputStream();

            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Laundry Service Hub"));
            document.add(new Paragraph("--------------------------"));

            document.add(new Paragraph("Order ID: " + order.getId()));
            document.add(new Paragraph("Total Amount: ₹" + order.getTotalAmount()));
            document.add(new Paragraph("Status: " + order.getStatus()));

            document.close();

            return out.toByteArray();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}