package inventorysoftware.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import inventorysoftware.dao.BillingDAO;
import inventorysoftware.model.BillingItem;
import inventorysoftware.model.Product;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BillingService {

    private final BillingDAO billingDAO;
    private final InventoryService inventoryService;

    public BillingService() {
        this.billingDAO = new BillingDAO();
        this.inventoryService = new InventoryService();
    }

    public BillingService(BillingDAO billingDAO, InventoryService inventoryService) {
        this.billingDAO = billingDAO;
        this.inventoryService = inventoryService;
    }

    public double calculateLineTotal(double unitPrice, int quantity) {
        return unitPrice * quantity;
    }

    public double calculateDiscountedTotal(double subtotal, double discountPercentage) {
        if (discountPercentage <= 0) return subtotal;
        double discountAmount = (subtotal * discountPercentage) / 100.0;
        return subtotal - discountAmount;
    }

    public double calculateReturnAmount(double paidAmount, double finalTotal) {
        return Math.max(0, paidAmount - finalTotal);
    }

    public boolean processTransaction(String invoiceId, String customerId, List<BillingItem> items, double discountPercentage, double paidAmount) throws SQLException {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Cannot process empty billing cart.");
        }

        double subtotal = 0;
        for (BillingItem item : items) {
            subtotal += item.getTotal();
        }

        double discountAmount = (subtotal * discountPercentage) / 100.0;
        double finalTotal = subtotal - discountAmount;
        double returnAmount = calculateReturnAmount(paidAmount, finalTotal);

        String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());

        for (BillingItem item : items) {
            item.setId(invoiceId);
            item.setDate(currentDate);
            item.setTime(currentTime);
            item.setCustomerId(customerId);
            item.setTotalAmount(finalTotal);
            item.setDiscount(discountPercentage);
            item.setDiscountAmount(discountAmount);
            item.setPaidAmount(paidAmount);
            item.setReturnAmount(returnAmount);

            // Save to DB
            billingDAO.addBillingRecord(item);

            // Decrement Stock
            inventoryService.decrementStock(item.getProductId(), item.getQuantity());
        }

        return true;
    }

    public String generateReceiptPDF(String invoiceId, String customerName, List<BillingItem> items, double grandTotal, double discount, double paid, double returnAmt) {
        String pdfPath = "invoice_" + invoiceId + ".pdf";
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(pdfPath));
            doc.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.DARK_GRAY);
            Font subTitleFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.GRAY);
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
            Font bodyFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);

            Paragraph pTitle = new Paragraph("VARIETY STORE - POS INVOICE", titleFont);
            pTitle.setAlignment(Element.ALIGN_CENTER);
            doc.add(pTitle);

            Paragraph pSub = new Paragraph("Date: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + " | Invoice ID: " + invoiceId, subTitleFont);
            pSub.setAlignment(Element.ALIGN_CENTER);
            doc.add(pSub);
            doc.add(new Paragraph("Customer Name: " + (customerName != null ? customerName : "Walk-in Customer"), bodyFont));
            doc.add(new Paragraph("\n"));

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);

            String[] headers = {"Item ID", "Product Name", "Price ($)", "Qty", "Total ($)"};
            for (String h : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(h, headerFont));
                cell.setBackgroundColor(BaseColor.DARK_GRAY);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            for (BillingItem item : items) {
                table.addCell(new Phrase(item.getProductId(), bodyFont));
                table.addCell(new Phrase(item.getProductName(), bodyFont));
                table.addCell(new Phrase(String.format("%.2f", item.getPrice()), bodyFont));
                table.addCell(new Phrase(String.valueOf(item.getQuantity()), bodyFont));
                table.addCell(new Phrase(String.format("%.2f", item.getTotal()), bodyFont));
            }

            doc.add(table);
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph(String.format("Grand Total: $%.2f", grandTotal), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
            doc.add(new Paragraph(String.format("Discount Applied: %.1f%%", discount), bodyFont));
            doc.add(new Paragraph(String.format("Paid Amount: $%.2f", paid), bodyFont));
            doc.add(new Paragraph(String.format("Change Returned: $%.2f", returnAmt), bodyFont));

            doc.close();
            return pdfPath;
        } catch (Exception e) {
            System.err.println("Error generating receipt PDF: " + e.getMessage());
            return null;
        }
    }
}
