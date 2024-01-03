package com.itext.pdfgeneration.service;

import com.itext.pdfgeneration.utils.GeneratePDF;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
@Slf4j
@RequiredArgsConstructor
public class PdfServiceImpl {
  private final GeneratePDF generatePDF;

  public byte[] downloadInvoice() throws FileNotFoundException {
    return generatePDF.downloadBillingPdf();
  }
}
