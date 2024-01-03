package com.itext.pdfgeneration.utils;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

@Slf4j
@Component
public class GeneratePDF {

  public byte[] downloadBillingPdf() throws FileNotFoundException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    PdfWriter writer = new PdfWriter(out);
    PdfDocument pdf = new PdfDocument(writer);
    Document document = new Document(pdf);

//      document.add(getBillingLogo());
//      document.add(getInvoiceInfromationWithSenderAddress(invoice));
//      document.add(getReceiverAddressWithPriceHeaderTable(invoice));
//      document.add(getReceiverAddressWithPriceTable(invoice));
//      document.add(getSubscriptionDetailTable(invoice));
//      document.add(getCustomerUsageTable(invoice));
//      document.add(getAmountTable(invoice));
//      addFooter(pdf, "Powered by 314e Corporation");

    document.close();
    return out.toByteArray();
  }
}
