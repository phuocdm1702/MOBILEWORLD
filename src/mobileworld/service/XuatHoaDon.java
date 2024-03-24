/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobileworld.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mobileworld.repository.DBConnect;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ADMIN
 */
public class XuatHoaDon {

    public static void main(String[] args) {
        try {
            // Lấy kết nối từ DBConnect
            Connection connection = DBConnect.getConnection();

            // Truy vấn dữ liệu hóa đơn từ cơ sở dữ liệu
            String query = "SELECT "
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

            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {

                // Tạo một workbook mới (định dạng .xlsx)
                Workbook workbook = new XSSFWorkbook();

                while (resultSet.next()) {
                    // Tạo một sheet mới cho mỗi hóa đơn
                    Sheet sheet = workbook.createSheet("HoaDon_" + resultSet.getString("ID"));

                    // Tạo dữ liệu hóa đơn từ kết quả truy vấn
                    Object[][] invoiceData = {
                        {"ID", "Tên KH", "SDT KH", "Địa chỉ", "ID NV", "Tên NV", "Ngày tạo", "Ngày thanh toán", "ID PT", "Tên PT", "Tổng tiền"},
                        {resultSet.getString("ID"),
                            resultSet.getString("Ten"),
                            resultSet.getString("SDT"),
                            resultSet.getString("DiaChi"),
                            resultSet.getString("IDNhanVien"),
                            resultSet.getString("TenNV"),
                            resultSet.getTimestamp("NgayTao").toLocalDateTime(),
                            resultSet.getTimestamp("NgayThanhToan").toLocalDateTime(),
                            resultSet.getString("IDPhuongThucThanhToan"),
                            resultSet.getString("TenKieuThanhToan"),
                            resultSet.getBigDecimal("TongTien")}, // Thêm dữ liệu hóa đơn khác tại đây
                    };

                    // Ghi dữ liệu vào sheet
                    int rowNum = 0;
                    for (Object[] rowData : invoiceData) {
                        Row row = sheet.createRow(rowNum++);
                        int colNum = 0;
                        for (Object field : rowData) {
                            Cell cell = row.createCell(colNum++);
                            if (field != null) {
                                if (field instanceof String) {
                                    cell.setCellValue((String) field);
                                } else if (field instanceof java.util.Date) {
                                    cell.setCellValue((java.util.Date) field);
                                } else if (field instanceof Integer) {
                                    cell.setCellValue((Integer) field);
                                } else if (field instanceof Double) {
                                    cell.setCellValue((Double) field);
                                }
                            } else {
                                // Xử lý giá trị NULL
                                cell.setCellValue("");
                            }
                        }
                    }
                }

                // Lưu workbook vào một file với tên duy nhất
                try (FileOutputStream outputStream = new FileOutputStream("HoaDon_" + System.currentTimeMillis() + ".xlsx")) {
                    workbook.write(outputStream);
                }

                System.out.println("Hóa đơn đã được xuất thành công!");
            }

            // Đóng kết nối đến cơ sở dữ liệu
            connection.close();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        try {
//            // Lấy kết nối từ DBConnect
//            Connection connection = (Connection) DBConnect.getConnection();
//
//            // Truy vấn dữ liệu hóa đơn từ cơ sở dữ liệu
//            String query = """
//                           SELECT 
//                                                    HoaDon.ID, 
//                                                    KHACHHANG.Ten, 
//                                                    KHACHHANG.SDT, 
//                                                    KHACHHANG.DiaChi, 
//                                                    HoaDon.IDNhanVien, 
//                                                    NHANVIEN.TenNV, 
//                                                    HoaDon.NgayTao, 
//                                                    HoaDon.NgayThanhToan, 
//                                                    HinhThucThanhToan.IDPhuongThucThanhToan, 
//                                                    PhuongThucThanhToan.TenKieuThanhToan, 
//                                                    HoaDon.TongTien
//                                                FROM   
//                                                    dbo.HoaDon
//                                                INNER JOIN
//                                                    dbo.NHANVIEN ON HoaDon.IDNhanVien = NHANVIEN.ID
//                                                INNER JOIN
//                                                    dbo.KHACHHANG ON HoaDon.IDKhachHang = KHACHHANG.ID
//                                                INNER JOIN
//                                                    dbo.HinhThucThanhToan ON HoaDon.ID = HinhThucThanhToan.IDHoaDon
//                                                INNER JOIN
//                                                    dbo.PhuongThucThanhToan ON HinhThucThanhToan.IDPhuongThucThanhToan = PhuongThucThanhToan.ID;
//                           """;
//            try (PreparedStatement statement = connection.prepareStatement(query);
//                 ResultSet resultSet = statement.executeQuery()) {
//
//                // Tạo một workbook mới (định dạng .xlsx)
//                Workbook workbook = new XSSFWorkbook();
//
//                while (resultSet.next()) {
//                    // Tạo một sheet mới cho mỗi hóa đơn
//                    Sheet sheet = workbook.createSheet("HoaDon_" + resultSet.getString("MaHD"));
//
//                    // Tạo dữ liệu hóa đơn từ kết quả truy vấn
//                    Object[][] invoiceData = {
//                            {"STT", "Mã HD", "Tên KH", "SDT KH", "Dia chi", "Thành tiền"},
//                            {1, resultSet.getString("MaHD"), resultSet.getString("TenKH"), resultSet.getString("SDTKH"), resultSet.getString("DiaChi"), resultSet.getDouble("ThanhTien")},
//                            // Thêm dữ liệu hóa đơn khác tại đây
//                    };
//
//                    // Ghi dữ liệu vào sheet
//                    int rowNum = 0;
//                    for (Object[] rowData : invoiceData) {
//                        Row row = sheet.createRow(rowNum++);
//                        int colNum = 0;
//                        for (Object field : rowData) {
//                            Cell cell = row.createCell(colNum++);
//                            if (field instanceof String) {
//                                cell.setCellValue((String) field);
//                            } else if (field instanceof Double) {
//                                cell.setCellValue((Double) field);
//                            }
//                        }
//                    }
//                }
//
//                // Lưu workbook vào một file với tên duy nhất
//                try (FileOutputStream outputStream = new FileOutputStream("HoaDon_" + System.currentTimeMillis() + ".xlsx")) {
//                    workbook.write(outputStream);
//                }
//
//                System.out.println("Hóa đơn đã được xuất thành công!");
//            }
//
//            // Đóng kết nối đến cơ sở dữ liệu
//            connection.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException ex) {
//            Logger.getLogger(XuatHoaDon.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//    public static void main(String[] args) {
//        try {
//            // Tạo một workbook mới (định dạng .xlsx)
//            Workbook workbook = new XSSFWorkbook();
//
//            // Tạo một sheet mới
//            Sheet sheet = workbook.createSheet("HoaDon");
//
//            // Tạo dữ liệu hóa đơn giả định
//            Object[][] invoiceData = {
//                    {"STT", "Mã HD", "Tên KH", "SDT KH", "Dia chi", "Thành tiền"},
//                    {1, "SP001", "Sản phẩm 1", 5, 10.5, 52.5},
//                    {2, "SP002", "Sản phẩm 2", 3, 15.2, 45.6},
//                    {3, "SP003", "Sản phẩm 3", 7, 8.0, 56.0},
//                    // Thêm dữ liệu hóa đơn khác tại đây
//            };
//
//            // Ghi dữ liệu vào sheet
//            int rowNum = 0;
//            for (Object[] rowData : invoiceData) {
//                Row row = sheet.createRow(rowNum++);
//                int colNum = 0;
//                for (Object field : rowData) {
//                    Cell cell = row.createCell(colNum++);
//                    if (field instanceof String) {
//                        cell.setCellValue((String) field);
//                    } else if (field instanceof Integer) {
//                        cell.setCellValue((Integer) field);
//                    } else if (field instanceof Double) {
//                        cell.setCellValue((Double) field);
//                    }
//                }
//            }
//
//            // Lưu workbook vào một file
//            try (FileOutputStream outputStream = new FileOutputStream("HoaDon.xlsx")) {
//                workbook.write(outputStream);
//            }
//
//            System.out.println("Hóa đơn đã được xuất thành công!");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
