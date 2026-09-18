package inventorysoftware.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 * PDF Generator utility compiling Project_Report.md into Project_Report.pdf.
 */
public class ReportPdfGenerator {

    public static void main(String[] args) {
        String mdPath = "Project_Report.md";
        String pdfPath = "Project_Report.pdf";

        File mdFile = new File(mdPath);
        if (!mdFile.exists()) {
            System.err.println("Project_Report.md not found!");
            return;
        }

        try {
            Document document = new Document(PageSize.A4, 40, 40, 50, 50);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.DARK_GRAY);
            Font h1Font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, new BaseColor(0, 51, 102));
            Font h2Font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, new BaseColor(0, 102, 153));
            Font bodyFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);
            Font codeFont = FontFactory.getFont(FontFactory.COURIER, 8, BaseColor.DARK_GRAY);

            BufferedReader reader = new BufferedReader(new FileReader(mdFile));
            String line;
            boolean inCodeBlock = false;
            StringBuilder codeBuffer = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("```")) {
                    if (inCodeBlock) {
                        PdfPTable table = new PdfPTable(1);
                        table.setWidthPercentage(100);
                        PdfPCell cell = new PdfPCell(new Phrase(codeBuffer.toString(), codeFont));
                        cell.setBackgroundColor(new BaseColor(245, 245, 245));
                        cell.setPadding(6);
                        cell.setBorderColor(new BaseColor(200, 200, 200));
                        table.addCell(cell);
                        document.add(table);
                        document.add(new Paragraph(" "));
                        codeBuffer.setLength(0);
                        inCodeBlock = false;
                    } else {
                        inCodeBlock = true;
                    }
                    continue;
                }

                if (inCodeBlock) {
                    codeBuffer.append(line).append("\n");
                    continue;
                }

                line = line.trim();
                if (line.isEmpty()) {
                    document.add(new Paragraph(" "));
                    continue;
                }

                if (line.startsWith("# ")) {
                    Paragraph p = new Paragraph(line.substring(2), titleFont);
                    p.setAlignment(Element.ALIGN_CENTER);
                    p.setSpacingAfter(12);
                    document.add(p);
                } else if (line.startsWith("## ")) {
                    Paragraph p = new Paragraph(line.substring(3), h1Font);
                    p.setSpacingBefore(10);
                    p.setSpacingAfter(4);
                    document.add(p);
                } else if (line.startsWith("### ")) {
                    Paragraph p = new Paragraph(line.substring(4), h2Font);
                    p.setSpacingBefore(8);
                    p.setSpacingAfter(3);
                    document.add(p);
                } else if (line.startsWith("---")) {
                    LineSeparator lineSep = new LineSeparator(0.5f, 100, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER, -2);
                    document.add(lineSep);
                } else if (line.startsWith("- ") || line.startsWith("* ")) {
                    Paragraph p = new Paragraph("  •  " + line.substring(2), bodyFont);
                    p.setSpacingAfter(2);
                    document.add(p);
                } else {
                    document.add(new Paragraph(line, bodyFont));
                }
            }

            reader.close();
            document.close();
            System.out.println("--> Successfully generated " + pdfPath);
        } catch (Exception e) {
            System.err.println("Error generating PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
