/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mobileworld.config.DBConnect;

/**
 *
 * @author ADMIN
 */
public class InvoicePDFGenerator {

    public static void generatePDF(String filePath, String invoiceId) {
        Document document = new Document();

        try {
            // Append the invoiceId to the file name
            String fullFilePath = filePath.replace(".pdf", "_" + invoiceId + ".pdf");
            PdfWriter.getInstance(document, new FileOutputStream(fullFilePath));
            document.open();

            // Add content to the PDF
            addContentToPDF(document, invoiceId);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    private static void addContentToPDF(Document document, String invoiceId) throws DocumentException {
        // Connect to the database and retrieve data
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Get the database connection from your existing DBConnect class
            connection = DBConnect.getConnection();

            // Modify the SQL query based on your requirements
            String sqlQuery = "SELECT "
                    + "HoaDon.ID, "
                    + "KHACHHANG.Ten, "
                    + "KHACHHANG.SDT, "
                    + "KHACHHANG.DiaChi, "
                    + "HoaDon.IDNhanVien, "
                    + "NHANVIEN.TenNV, "
                    + "HoaDon.NgayTao, "
                    + "HoaDon.NgayThanhToan, "
                    + "HinhThucThanhToan.IDPhuongThucThanhToan, "
                    + "PhuongThucThanhToan.TenKieuThanhToan, "
                    + "HoaDon.TongTien "
                    + "FROM "
                    + "dbo.HoaDon "
                    + "INNER JOIN dbo.NHANVIEN ON HoaDon.IDNhanVien = NHANVIEN.ID "
                    + "INNER JOIN dbo.KHACHHANG ON HoaDon.IDKhachHang = KHACHHANG.ID "
                    + "INNER JOIN dbo.HinhThucThanhToan ON HoaDon.ID = HinhThucThanhToan.IDHoaDon "
                    + "INNER JOIN dbo.PhuongThucThanhToan ON HinhThucThanhToan.IDPhuongThucThanhToan = PhuongThucThanhToan.ID";

            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and add data to the PDF
            while (resultSet.next()) {
                String id = resultSet.getString("ID");

                // Skip records that don't match the specified invoiceId
                if (!id.equals(invoiceId)) {
                    continue;
                }

                String tenKH = resultSet.getString("Ten");
                String sdt = resultSet.getString("SDT");
                String diaChi = resultSet.getString("DiaChi");
                String idNhanVien = resultSet.getString("IDNhanVien");
                String tenNV = resultSet.getString("TenNV");
                String ngayTao = resultSet.getString("NgayTao");
                String ngayThanhToan = resultSet.getString("NgayThanhToan");
                String idPhuongThucThanhToan = resultSet.getString("IDPhuongThucThanhToan");
                String tenKieuThanhToan = resultSet.getString("TenKieuThanhToan");
                String tongTien = resultSet.getString("TongTien");

                // Add data to the PDF
                document.add(new Paragraph("ID: " + id));
                document.add(new Paragraph("Tên Khách Hàng: " + tenKH));
                document.add(new Paragraph("Số Điện Thoại: " + sdt));
                document.add(new Paragraph("Địa Chỉ: " + diaChi));
                document.add(new Paragraph("ID Nhân Viên: " + idNhanVien));
                document.add(new Paragraph("Tên Nhân Viên: " + tenNV));
                document.add(new Paragraph("Ngày Tạo: " + ngayTao));
                document.add(new Paragraph("Ngày Thanh Toán: " + ngayThanhToan));
                document.add(new Paragraph("ID Phương Thức Thanh Toán: " + idPhuongThucThanhToan));
                document.add(new Paragraph("Tên Kiểu Thanh Toán: " + tenKieuThanhToan));
                document.add(new Paragraph("Tổng Tiền: " + tongTien));

                // Add more fields as needed
                document.add(new Paragraph("\n")); // Add a newline between records
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//        generatePDF("your_invoice.pdf");
//    }
//
//    public static void generatePDF(String filePath) {
//        Document document = new Document();
//
//        try {
//            PdfWriter.getInstance(document, new FileOutputStream(filePath));
//            document.open();
//
//            // Add content to the PDF
//            addContentToPDF(document);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            document.close();
//        }
//    }
//
//    private static void addContentToPDF(Document document) throws DocumentException {
//        // Connect to the database and retrieve data
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        try {
//            // Get the database connection from your existing DBConnect class
//            connection = DBConnect.getConnection();
//
//            // Modify the SQL query based on your requirements
//            String sqlQuery = "SELECT "
//                    + "HoaDon.ID, "
//                    + "KHACHHANG.Ten, "
//                    + "KHACHHANG.SDT, "
//                    + "KHACHHANG.DiaChi, "
//                    + "HoaDon.IDNhanVien, "
//                    + "NHANVIEN.TenNV, "
//                    + "HoaDon.NgayTao, "
//                    + "HoaDon.NgayThanhToan, "
//                    + "HinhThucThanhToan.IDPhuongThucThanhToan, "
//                    + "PhuongThucThanhToan.TenKieuThanhToan, "
//                    + "HoaDon.TongTien "
//                    + "FROM "
//                    + "dbo.HoaDon "
//                    + "INNER JOIN dbo.NHANVIEN ON HoaDon.IDNhanVien = NHANVIEN.ID "
//                    + "INNER JOIN dbo.KHACHHANG ON HoaDon.IDKhachHang = KHACHHANG.ID "
//                    + "INNER JOIN dbo.HinhThucThanhToan ON HoaDon.ID = HinhThucThanhToan.IDHoaDon "
//                    + "INNER JOIN dbo.PhuongThucThanhToan ON HinhThucThanhToan.IDPhuongThucThanhToan = PhuongThucThanhToan.ID";
//
//            preparedStatement = connection.prepareStatement(sqlQuery);
//            resultSet = preparedStatement.executeQuery();
//
//            // Iterate through the result set and add data to the PDF
//            while (resultSet.next()) {
//                String id = resultSet.getString("ID");
//                String tenKH = resultSet.getString("Ten");
//                String sdt = resultSet.getString("SDT");
//                String diaChi = resultSet.getString("DiaChi");
//                String idNhanVien = resultSet.getString("IDNhanVien");
//                String tenNV = resultSet.getString("TenNV");
//                String ngayTao = resultSet.getString("NgayTao");
//                String ngayThanhToan = resultSet.getString("NgayThanhToan");
//                String idPhuongThucThanhToan = resultSet.getString("IDPhuongThucThanhToan");
//                String tenKieuThanhToan = resultSet.getString("TenKieuThanhToan");
//                String tongTien = resultSet.getString("TongTien");
//
//                // Add data to the PDF
//                document.add(new Paragraph("ID: " + id));
//                document.add(new Paragraph("Tên Khách Hàng: " + tenKH));
//                document.add(new Paragraph("Số Điện Thoại: " + sdt));
//                document.add(new Paragraph("Địa Chỉ: " + diaChi));
//                document.add(new Paragraph("ID Nhân Viên: " + idNhanVien));
//                document.add(new Paragraph("Tên Nhân Viên: " + tenNV));
//                document.add(new Paragraph("Ngày Tạo: " + ngayTao));
//                document.add(new Paragraph("Ngày Thanh Toán: " + ngayThanhToan));
//                document.add(new Paragraph("ID Phương Thức Thanh Toán: " + idPhuongThucThanhToan));
//                document.add(new Paragraph("Tên Kiểu Thanh Toán: " + tenKieuThanhToan));
//                document.add(new Paragraph("Tổng Tiền: " + tongTien));
//
//                // Add more fields as needed
//                document.add(new Paragraph("\n")); // Add a newline between records
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
}
