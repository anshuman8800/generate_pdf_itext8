package com.itext.pdfgeneration.controller;

import com.itext.pdfgeneration.service.PdfServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/")
@Slf4j
public class GeneratePDFController {
  private final PdfServiceImpl pdfService;

  public GeneratePDFController(PdfServiceImpl pdfService) {
    this.pdfService = pdfService;
  }

  @GetMapping(value = "/")
  public String home() {
    return "For pdf generation go to /pdf";
  }

  @GetMapping(value = "/pdf")
  public ResponseEntity<byte[]> downloadPdf() throws FileNotFoundException {
    log.debug("Making request to download the pdf.");

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_PDF);
    headers.setContentDispositionFormData("attachment", "generated-pdf.pdf");

    return ResponseEntity.ok()
      .headers(headers)
      .body(pdfService.downloadInvoice());
  }
}
