package com.itext.pdfgeneration.utils;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.itextpdf.io.font.constants.StandardFonts.HELVETICA_BOLD;

@Slf4j
@Component
public class GeneratePDF {
  private static final Color whiteColor = new DeviceRgb(255, 255, 255);
  private static final Color tableBackgroundHeadingColor = new DeviceRgb(236, 236, 241);
  private static final Color tableBorderColor = new DeviceRgb(128, 124, 124);
  private static final Color textColor = new DeviceRgb(69, 69, 69);
  private static final Color lightWhiteColor = new DeviceRgb(149, 149, 150);
  private static final Color purpleBackgroundColor = new DeviceRgb(240,236,252);
  private static final Color purpleColor = new DeviceRgb(104, 60, 196);
  private static final Border borderLine = new SolidBorder(tableBorderColor, 1);

  private static Paragraph getHeader() {
    Paragraph paragraph = new Paragraph("Invoice");
    paragraph.setFontSize(26)
      .setFontColor(purpleColor)
      .setBorder(Border.NO_BORDER);

    return paragraph;
  }

  private static Cell getEmptyCell() {
    Cell emptyCell = new Cell();
    emptyCell.setBorder(Border.NO_BORDER);
    return emptyCell;
  }

  public static Table getInvoiceInfo() throws IOException {
    // defining the fonts used in this table
//    PdfFont NormalFont = PdfFontFactory.createFont();
    PdfFont boldFont = PdfFontFactory.createFont(HELVETICA_BOLD);

    Table table = new Table(UnitValue.createPercentArray(new float[]{2, 6, 4}));
    table.setWidth(UnitValue.createPercentValue(100));
    table.setMarginTop(10);

    Cell cell;
    String firstColumnName;
    String secondColumnName;

    // Invoice No # || AH202401001259
    firstColumnName = "Invoice No #";
    cell = new Cell();
    cell.add(new Paragraph(firstColumnName))
      .setFontColor(tableBorderColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    secondColumnName = "AH202401001259";
    cell = new Cell();
    cell.add(new Paragraph(secondColumnName))
      .setFontColor(textColor)
      .setFont(boldFont)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    // Invoice Date || Jan 01, 2024
    firstColumnName = "Invoice Date";
    cell = new Cell();
    cell.add(new Paragraph(firstColumnName))
      .setFontColor(tableBorderColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    secondColumnName = "Jan 01, 2024";
    cell = new Cell();
    cell.add(new Paragraph(secondColumnName))
      .setFontColor(textColor)
      .setFont(boldFont)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    // Due Date     || Jan 05, 2024
    firstColumnName = "Due Date";
    cell = new Cell();
    cell.add(new Paragraph(firstColumnName))
      .setFontColor(tableBorderColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    secondColumnName = "Jan 05, 2024";
    cell = new Cell();
    cell.add(new Paragraph(secondColumnName))
      .setFontColor(textColor)
      .setFont(boldFont)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    // Bill For     || Property Management Services House Keeping
    firstColumnName = "Bill For";
    cell = new Cell();
    cell.add(new Paragraph(firstColumnName))
      .setFontColor(tableBorderColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    secondColumnName = "Property Management Services House Keeping";
    cell = new Cell();
    cell.add(new Paragraph(secondColumnName))
      .setFontColor(textColor)
      .setFont(boldFont)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    // Duration     || December 01, 2023 - December 31, 2023
    firstColumnName = "Duration";
    cell = new Cell();
    cell.add(new Paragraph(firstColumnName))
      .setFontColor(tableBorderColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    secondColumnName = "December 01, 2023 - December 31, 2023";
    cell = new Cell();
    cell.add(new Paragraph(secondColumnName))
      .setFontColor(textColor)
      .setFont(boldFont)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    return table;
  }

  public static Table getBillingAddress() throws IOException {
    PdfFont boldFont = PdfFontFactory.createFont(HELVETICA_BOLD);

    Table table = new Table(UnitValue.createPercentArray(new float[]{20, 1, 20}));
    table.setWidth(UnitValue.createPercentValue(100));
    table.setMarginTop(10);

    Cell cell;
    String firstColumnName;
    String secondColumnName;

    // Billed By                              || Billed To
    firstColumnName = "Billed By";
    cell = new Cell();
    cell.add(new Paragraph(firstColumnName))
      .setFontColor(purpleColor)
      .setFontSize(18)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingTop(5)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    secondColumnName = "Billed To";
    cell = new Cell();
    cell.add(new Paragraph(secondColumnName))
      .setFontColor(purpleColor)
      .setFontSize(18)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingTop(5)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    // Kuruvindha Property Management LLP     || Amrutha Heights Phase II
    firstColumnName = "Kuruvindha Property Management LLP";
    cell = new Cell();
    cell.add(new Paragraph(firstColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setFont(boldFont)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    secondColumnName = "Amrutha Heights Phase II";
    cell = new Cell();
    cell.add(new Paragraph(secondColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setFont(boldFont)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    // Borewell Road, Whitefield,             || Nalurahalli Junction, Whitefield,
    firstColumnName = "Borewell Road, Whitefield,";
    cell = new Cell();
    cell.add(new Paragraph(firstColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    secondColumnName = "Nalurahalli Junction, Whitefield,";
    cell = new Cell();
    cell.add(new Paragraph(secondColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    // BENGALURU,                             || Bengaluru,
    firstColumnName = "Bengaluru,";
    cell = new Cell();
    cell.add(new Paragraph(firstColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    secondColumnName = "Bengaluru,";
    cell = new Cell();
    cell.add(new Paragraph(secondColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    // Karnataka, India - 560066              || Karnataka, India - 560066
    firstColumnName = "Karnataka, India - 560066";
    cell = new Cell();
    cell.add(new Paragraph(firstColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    secondColumnName = "Karnataka, India - 560066";
    cell = new Cell();
    cell.add(new Paragraph(secondColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    // GSTIN: 29ABBFK1931E1ZL    || empty
    firstColumnName = "GSTIN: 29ABBFK1931E1ZL";
    cell = new Cell();
    cell.add(new Paragraph(firstColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    secondColumnName = "";
    cell = new Cell();
    cell.add(new Paragraph(secondColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    // PAN: ABBFK1931E    || empty
    firstColumnName = "PAN: ABBFK1931E";
    cell = new Cell();
    cell.add(new Paragraph(firstColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    secondColumnName = "";
    cell = new Cell();
    cell.add(new Paragraph(secondColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    // Email: kuruvindha@gmail.com    || empty
    firstColumnName = "Email: kuruvindha@gmail.com";
    cell = new Cell();
    cell.add(new Paragraph(firstColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    secondColumnName = "";
    cell = new Cell();
    cell.add(new Paragraph(secondColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    // Phone: +91 95910 32780    || empty
    firstColumnName = "Phone: +91 95910 32780";
    cell = new Cell();
    cell.add(new Paragraph(firstColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setPaddingBottom(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    secondColumnName = "";
    cell = new Cell();
    cell.add(new Paragraph(secondColumnName))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setPaddingBottom(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);
    // END

    return table;
  }

  public static Table getItemTable() {
    Table table = new Table(UnitValue.createPercentArray(new float[]{0.5F, 5.5F, 2, 2, 2}));
    table.setWidth(UnitValue.createPercentValue(100));
    table.setMarginTop(10);

    Cell cell;

    // _  Item                         Quantity   Rate      Amount
    cell = new Cell();
    cell.add(new Paragraph(""))
      .setFontColor(whiteColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleColor)
      .setPaddingTop(5)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("Item"))
      .setFontColor(whiteColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleColor)
      .setPaddingTop(5)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("Quantity"))
      .setFontColor(whiteColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleColor)
      .setPaddingTop(5)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("Rate"))
      .setFontColor(whiteColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleColor)
      .setPaddingTop(5)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("Amount"))
      .setFontColor(whiteColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleColor)
      .setPaddingTop(5)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    // 1. House Keeping Professionals  6          ₹13,000   ₹78,000
    cell = new Cell();
    cell.add(new Paragraph("1."))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("House Keeping Professionals"))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("6"))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("₹13,000"))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("₹78,000"))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    return table;
  }

  public static Table getAmountInWord() {
    Table table = new Table(UnitValue.createPercentArray(new float[]{8, 3, 3}));
    table.setWidth(UnitValue.createPercentValue(100));
    table.setMarginTop(10);

    Cell cell;

    //Total (in words) : SEVENTY EIGHT THOUSAND RUPEES ONLY || Total (INR) ||  ₹78,000
    cell = new Cell();
    cell.add(new Paragraph("Total (in words) : SEVENTY EIGHT THOUSAND RUPEES ONLY"))
      .setFontColor(textColor)
      .setFontSize(9)
      .setTextAlignment(TextAlignment.LEFT)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("Total (INR)"))
      .setFontColor(textColor)
      .setFontSize(15)
      .setTextAlignment(TextAlignment.LEFT)
      .setBorderLeft(Border.NO_BORDER)
      .setBorderRight(Border.NO_BORDER)
      .setBorderTop(borderLine)
      .setBorderBottom(borderLine);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("₹78,000"))
      .setFontColor(textColor)
      .setFontSize(15)
      .setTextAlignment(TextAlignment.LEFT)
      .setBorderLeft(Border.NO_BORDER)
      .setBorderRight(Border.NO_BORDER)
      .setBorderTop(borderLine)
      .setBorderBottom(borderLine);
    table.addCell(cell);

    // END
    return table;
  }

  public static Table getBankDetail() throws IOException {
    PdfFont boldFont = PdfFontFactory.createFont(HELVETICA_BOLD);

    Table table = new Table(UnitValue.createPercentArray(new float[]{2, 2, 6}));
    table.setWidth(UnitValue.createPercentValue(100));
    table.setMarginTop(10);

    Cell cell;

    // Bank Details  || empty
    cell = new Cell();
    cell.add(new Paragraph("Bank Details"))
      .setFontColor(purpleColor)
      .setFontSize(12)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setPaddingTop(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph(""))
      .setFontColor(purpleColor)
      .setFontSize(12)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setPaddingTop(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    //Account Holder || KURUVINDHA
    cell = new Cell();
    cell.add(new Paragraph("Account Holder"))
      .setFontColor(textColor)
      .setFont(boldFont)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("KURUVINDHA"))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    //Name           || PROPERTY
    cell = new Cell();
    cell.add(new Paragraph("Name"))
      .setFontColor(textColor)
      .setFont(boldFont)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("PROPERTY \nMANAGEMENT LLP"))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    //Account        || 10159027711
    cell = new Cell();
    cell.add(new Paragraph("Account Number"))
      .setFontColor(textColor)
      .setFont(boldFont)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("10159027711"))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    //IFSC           || IDFB0080192
    cell = new Cell();
    cell.add(new Paragraph("IFSC"))
      .setFontColor(textColor)
      .setFont(boldFont)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("IDFB0080192"))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    //Account Type   || Current
    cell = new Cell();
    cell.add(new Paragraph("Account Type"))
      .setFontColor(textColor)
      .setFont(boldFont)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("Current"))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    //Bank           || IDFC Bank
    cell = new Cell();
    cell.add(new Paragraph("Bank"))
      .setFontColor(textColor)
      .setFont(boldFont)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setPaddingBottom(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    cell = new Cell();
    cell.add(new Paragraph("IDFC Bank"))
      .setFontColor(textColor)
      .setFontSize(10)
      .setTextAlignment(TextAlignment.LEFT)
      .setBackgroundColor(purpleBackgroundColor)
      .setPaddingLeft(5)
      .setPaddingBottom(5)
      .setBorder(Border.NO_BORDER);
    table.addCell(cell);

    table.addCell(getEmptyCell());

    // END
    return table;
  }

  private static Paragraph getBottomLine() {
    String text  = "For any enquiry, reach out via email at kuruvindha@gmail.com, call on +91 95910 32780";
    Paragraph paragraph = new Paragraph(text);
    paragraph.setBorder(Border.NO_BORDER)
      .setFontSize(9)
      .setTextAlignment(TextAlignment.CENTER)
      .setPaddingTop(15);

    return paragraph;
  }

  private static void addFooter(PdfDocument pdf, String footerText) {
    Document document = new Document(pdf);

    // Create a Text object with the footer text
    Text footer = new Text(footerText).setFontColor(lightWhiteColor);

    // Create a Paragraph with the Text object
    Paragraph footerParagraph = new Paragraph(footer)
      .setFontSize(9)
      .setBackgroundColor(whiteColor)
      .setMarginBottom(0); // Set bottom margin to 0

    // Add the Paragraph to the document at the specified page number
    document.showTextAligned(footerParagraph, 36, 36, TextAlignment.LEFT, VerticalAlignment.BOTTOM);
  }

  public byte[] downloadBillingPdf() throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    PdfWriter writer = new PdfWriter(out);
    PdfDocument pdf = new PdfDocument(writer);
    Document document = new Document(pdf);

    document.add(getHeader());
    document.add(getInvoiceInfo());
    document.add(getBillingAddress());
    document.add(getItemTable());
    document.add(getAmountInWord());
    document.add(getBankDetail());
    document.add(getBottomLine());

    addFooter(pdf, "Powered by Refrens.com");

    document.close();
    return out.toByteArray();
  }
}
