package com.itext.pdfgeneration.service;

import com.itext.pdfgeneration.utils.GeneratePDF;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class PdfServiceImpl {
  private final GeneratePDF generatePDF;

  public byte[] downloadInvoice() throws IOException {
    return generatePDF.downloadBillingPdf();
  }
}
