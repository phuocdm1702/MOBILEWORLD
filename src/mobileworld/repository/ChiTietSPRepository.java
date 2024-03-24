package mobileworld.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mobileworld.config.DBConnect;
import mobileworld.entity.ChiTietSPEntity;
import mobileworld.viewModel.ChiTietSanPhamViewModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class ChiTietSPRepository {

    public List<ChiTietSanPhamViewModel> getAll() {
        List<ChiTietSanPhamViewModel> listSP = new ArrayList<>();

        String sql = """
                SELECT
                CTS.Imel,
                CTS.IDNSX,
                CTS.IDDSP,
                CTS.IDMauSac,
                CTS.IDPin,
                CTS.IDManHinh,
                CTS.IDRam,
                CTS.IDBoNho,
                CTS.IDCPU,
                CTS.IDTinhTrang,
                DS.TenDSP,
		NSX.[Tên NSX],
                Pin.DungLuongPin,
                ManHinh.LoaiManHinh,
                CPU.CPU,
                Ram.DungLuongRam,
                BoNho.DungLuongBoNho,
                MauSac.TenMau,
                CTS.GiaBan,
                CTS.GhiChu,
                COUNT(CTS.ID) AS SoLuong,
                TinhTrang.TinhTrang,
        	CTS.ID
            FROM
                dbo.ChiTietSP AS CTS
                INNER JOIN dbo.NhaSanXuat AS NSX ON CTS.IDNSX = NSX.ID
                INNER JOIN dbo.DongSP AS DS ON CTS.IDDSP = DS.ID
                INNER JOIN dbo.Pin ON CTS.IDPin = Pin.ID
                INNER JOIN dbo.ManHinh ON CTS.IDManHinh = ManHinh.ID
                INNER JOIN dbo.CPU ON CTS.IDCPU = CPU.ID
                INNER JOIN dbo.Ram ON CTS.IDRam = Ram.ID
                INNER JOIN dbo.BoNho ON CTS.IDBoNho = BoNho.ID
                INNER JOIN dbo.MauSac ON CTS.IDMauSac = MauSac.ID
                INNER JOIN dbo.TinhTrang ON CTS.IDTinhTrang = TinhTrang.ID
        		WHERE CTS.Deleted = 1
            GROUP BY
                CTS.Imel,
                CTS.IDNSX,
                CTS.IDDSP,
                CTS.IDMauSac,
                CTS.IDPin,
                CTS.IDManHinh,
                CTS.IDRam,
                CTS.IDBoNho,
                CTS.IDCPU,
                CTS.IDTinhTrang,
                DS.TenDSP,
		NSX.[Tên NSX],
                Pin.DungLuongPin,
                ManHinh.LoaiManHinh,
                CPU.CPU,
                Ram.DungLuongRam,
                BoNho.DungLuongBoNho,
                MauSac.TenMau,
                CTS.GiaBan,
                CTS.GhiChu,
                TinhTrang.TinhTrang,
        	CTS.ID
            ORDER BY
                CTS.ID DESC
        """;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPhamViewModel spvm = new ChiTietSanPhamViewModel();
                spvm.setImel(rs.getString(1));
                spvm.setIdNsx(rs.getString(2));
                spvm.setIdDsp(rs.getString(3));
                spvm.setIdMauSac(rs.getString(4));
                spvm.setIdPin(rs.getString(5));
                spvm.setIdManHinh(rs.getString(6));
                spvm.setIdRam(rs.getString(7));
                spvm.setIdboNho(rs.getString(8));
                spvm.setIdCpu(rs.getString(9));
                spvm.setIdTinhTrang(rs.getString(10));
                spvm.setTenDsp(rs.getString(11));
                spvm.setTenNsx(rs.getString(12));
                spvm.setDungLuongPin(rs.getString(13));
                spvm.setLoaiManHinh(rs.getString(14));
                spvm.setCpu(rs.getString(15));
                spvm.setDungLuongRam(rs.getString(16));
                spvm.setDungLuongBoNho(rs.getString(17));
                spvm.setTenMau(rs.getString(18));
                spvm.setGiaBan(rs.getBigDecimal(19));
                spvm.setGhiChu(rs.getString(20));
                spvm.setSoLuong(rs.getInt(21));
                spvm.setTinhTrang(rs.getString(22));
                spvm.setId(rs.getString(23));
                listSP.add(spvm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<ChiTietSPEntity> getImel() {
        List<ChiTietSPEntity> listImel = new ArrayList<>();

        String sql = """
            select Imel from ChiTietSP
        """;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSPEntity ctsp = new ChiTietSPEntity();
                ctsp.setImel(rs.getString(1));
                listImel.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listImel;
    }
    
    

    public boolean add(ChiTietSPEntity ctsp) {
        String sql = """
                        INSERT INTO dbo.ChiTietSP (
                                                      IDDSP, IDMauSac, IDPin, IDManHinh, IDRam, IDBoNho, IDCPU, IDTinhTrang, IDNSX,
                                                      GiaBan, Imel, GhiChu, [Deleted], [Created at], [Created by]
                                                  ) VALUES (
                                                      (SELECT ID FROM dbo.DongSP WHERE TenDSP = ?),
                                                      (SELECT TOP 1 ID FROM dbo.MauSac WHERE TenMau = ?),
                                                      (SELECT TOP 1 ID FROM dbo.Pin WHERE DungLuongPin = ?),
                                                      (SELECT TOP 1 ID FROM dbo.ManHinh WHERE LoaiManHinh = ?),
                                                      (SELECT TOP 1 ID FROM dbo.Ram WHERE DungLuongRam = ?),
                                                      (SELECT TOP 1 ID FROM dbo.BoNho WHERE DungLuongBoNho = ?),
                                                      (SELECT TOP 1 ID FROM dbo.CPU WHERE CPU = ?),
                                                      (SELECT TOP 1 ID FROM dbo.TinhTrang WHERE TinhTrang = ?),
                                                      (SELECT TOP 1 ID FROM dbo.NhaSanXuat WHERE [Tên NSX] = ?),
                                                      ?, ?, ?, ?, ?, ?
                                                  );
                     """;
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ctsp.getIdDsp());
            ps.setObject(2, ctsp.getIdMauSac());
            ps.setObject(3, ctsp.getIdPin());
            ps.setObject(4, ctsp.getIdManHinh());
            ps.setObject(5, ctsp.getIdRam());
            ps.setObject(6, ctsp.getIdboNho());
            ps.setObject(7, ctsp.getIdCpu());
            ps.setObject(8, ctsp.getIdTinhTrang());
            ps.setObject(9, ctsp.getIdNsx());
            ps.setObject(10, ctsp.getGiaBan());
            ps.setObject(11, ctsp.getImel());
            ps.setObject(12, ctsp.getGhiChu());
            ps.setObject(13, ctsp.getDeleted());
            ps.setObject(14, ctsp.getCreatedAt());
            ps.setObject(15, ctsp.getCreatedBy());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return check > 0;
    }

    public boolean remove(String id) {
        int check = 0;
        String sql = """
            UPDATE [dbo].[ChiTietSP]
               SET 
                  [Deleted] = 0
             WHERE ID = ?
        """;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean khoiPhucSP(String id) {
        int check = 0;
        String sql = """
        UPDATE [dbo].[ChiTietSP]
                           SET 
                              [Deleted] = 1
                         WHERE ID = ?
        """;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(ChiTietSPEntity ctsp, String id) {
        String sql = """
                 UPDATE dbo.ChiTietSP
                 SET IDDSP = (SELECT ID FROM dbo.DongSP WHERE TenDSP = ?),
                     IDMauSac = (SELECT TOP 1 ID FROM dbo.MauSac WHERE TenMau = ?),
                     IDPin = (SELECT TOP 1 ID FROM dbo.Pin WHERE DungLuongPin = ?),
                     IDManHinh = (SELECT TOP 1 ID FROM dbo.ManHinh WHERE LoaiManHinh = ?),
                     IDRam = (SELECT TOP 1 ID FROM dbo.Ram WHERE DungLuongRam = ?),
                     IDBoNho = (SELECT TOP 1 ID FROM dbo.BoNho WHERE DungLuongBoNho = ?),
                     IDCPU = (SELECT TOP 1 ID FROM dbo.CPU WHERE CPU = ?),
                     IDTinhTrang = (SELECT TOP 1 ID FROM dbo.TinhTrang WHERE TinhTrang = ?),
                     IDNSX = (SELECT TOP 1 ID FROM dbo.NhaSanXuat WHERE [Tên NSX] = ?),
                     GiaBan = ?,
                     GhiChu = ?,
                     Imel = ?,
                     [Deleted] = ?,
                     [Updated at] = ?,
                     [Updated by] = ?
                 WHERE ID = ?
                 """;
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ctsp.getIdDsp());
            ps.setObject(2, ctsp.getIdMauSac());
            ps.setObject(3, ctsp.getIdPin());
            ps.setObject(4, ctsp.getIdManHinh());
            ps.setObject(5, ctsp.getIdRam());
            ps.setObject(6, ctsp.getIdboNho());
            ps.setObject(7, ctsp.getIdCpu());
            ps.setObject(8, ctsp.getIdTinhTrang());
            ps.setObject(9, ctsp.getIdNsx());
            ps.setObject(10, ctsp.getGiaBan());
            ps.setObject(11, ctsp.getGhiChu());
            ps.setObject(12, ctsp.getImel());
            ps.setObject(13, ctsp.getDeleted());
            ps.setObject(14, ctsp.getUpdatedAt());
            ps.setObject(15, ctsp.getUpdateBy());
            ps.setObject(16, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public List<ChiTietSanPhamViewModel> search(String sreach) {
        List<ChiTietSanPhamViewModel> listSP = new ArrayList<>();

        String sql = """
            SELECT
            CTS.Imel,
            CTS.IDNSX,
            CTS.IDDSP,
            CTS.IDMauSac,
            CTS.IDPin,
            CTS.IDManHinh,
            CTS.IDRam,
            CTS.IDBoNho,
            CTS.IDCPU,
            CTS.IDTinhTrang,
            DS.TenDSP,
            NSX.[Tên NSX],
            Pin.DungLuongPin,
            ManHinh.LoaiManHinh,
            CPU.CPU,
            Ram.DungLuongRam,
            BoNho.DungLuongBoNho,
            MauSac.TenMau,
            CTS.GiaBan,
            CTS.GhiChu,
            COUNT(CTS.ID) AS SoLuong,
            TinhTrang.TinhTrang,
            CTS.ID
        FROM
            dbo.ChiTietSP AS CTS
            INNER JOIN dbo.NhaSanXuat AS NSX ON CTS.IDNSX = NSX.ID
            INNER JOIN dbo.DongSP AS DS ON CTS.IDDSP = DS.ID
            INNER JOIN dbo.Pin ON CTS.IDPin = Pin.ID
            INNER JOIN dbo.ManHinh ON CTS.IDManHinh = ManHinh.ID
            INNER JOIN dbo.CPU ON CTS.IDCPU = CPU.ID
            INNER JOIN dbo.Ram ON CTS.IDRam = Ram.ID
            INNER JOIN dbo.BoNho ON CTS.IDBoNho = BoNho.ID
            INNER JOIN dbo.MauSac ON CTS.IDMauSac = MauSac.ID
            INNER JOIN dbo.TinhTrang ON CTS.IDTinhTrang = TinhTrang.ID
        WHERE
            CTS.Deleted = 1
            AND (
                CTS.Imel LIKE ? ESCAPE '!' OR
                DS.TenDSP LIKE ? ESCAPE '!' OR
                NSX.[Tên NSX] LIKE ? ESCAPE '!'OR
                Pin.DungLuongPin LIKE ? ESCAPE '!' OR
                ManHinh.LoaiManHinh LIKE ? ESCAPE '!' OR
                CPU.CPU LIKE ? ESCAPE '!' OR
                Ram.DungLuongRam LIKE ? ESCAPE '!' OR
                BoNho.DungLuongBoNho LIKE ? ESCAPE '!' OR
                CTS.GiaBan LIKE ? ESCAPE '!' OR
                TinhTrang.TinhTrang LIKE ? ESCAPE '!' 
            )
        GROUP BY
            CTS.Imel,
            CTS.IDNSX,
            CTS.IDDSP,
            CTS.IDMauSac,
            CTS.IDPin,
            CTS.IDManHinh,
            CTS.IDRam,
            CTS.IDBoNho,
            CTS.IDCPU,
            CTS.IDTinhTrang,
            DS.TenDSP,
            NSX.[Tên NSX],
            Pin.DungLuongPin,
            ManHinh.LoaiManHinh,
            CPU.CPU,
            Ram.DungLuongRam,
            BoNho.DungLuongBoNho,
            MauSac.TenMau,
            CTS.GiaBan,
            CTS.GhiChu,
            TinhTrang.TinhTrang,
            CTS.ID
        ORDER BY
            CTS.ID DESC;
    """;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            for (int i = 0; i < 10; i++) {
                ps.setString(i + 1, "%" + sreach + "%");
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPhamViewModel spvm = new ChiTietSanPhamViewModel();
                spvm.setImel(rs.getString(1));
                spvm.setIdNsx(rs.getString(2));
                spvm.setIdDsp(rs.getString(3));
                spvm.setIdMauSac(rs.getString(4));
                spvm.setIdPin(rs.getString(5));
                spvm.setIdManHinh(rs.getString(6));
                spvm.setIdRam(rs.getString(7));
                spvm.setIdboNho(rs.getString(8));
                spvm.setIdCpu(rs.getString(9));
                spvm.setIdTinhTrang(rs.getString(10));
                spvm.setTenDsp(rs.getString(11));
                spvm.setTenNsx(rs.getString(12));
                spvm.setDungLuongPin(rs.getString(13));
                spvm.setLoaiManHinh(rs.getString(14));
                spvm.setCpu(rs.getString(15));
                spvm.setDungLuongRam(rs.getString(16));
                spvm.setDungLuongBoNho(rs.getString(17));
                spvm.setTenMau(rs.getString(18));
                spvm.setGiaBan(rs.getBigDecimal(19));
                spvm.setGhiChu(rs.getString(20));
                spvm.setSoLuong(rs.getInt(21));
                spvm.setTinhTrang(rs.getString(22));
                spvm.setId(rs.getString(23));
                listSP.add(spvm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    //san pham da xoa
    public List<ChiTietSanPhamViewModel> getAllRemove() {
        List<ChiTietSanPhamViewModel> listSP = new ArrayList<>();

        String sql = """
                SELECT
                CTS.Imel,
                CTS.IDNSX,
                CTS.IDDSP,
                CTS.IDMauSac,
                CTS.IDPin,
                CTS.IDManHinh,
                CTS.IDRam,
                CTS.IDBoNho,
                CTS.IDCPU,
                CTS.IDTinhTrang,
                DS.TenDSP,
		NSX.[Tên NSX],
                Pin.DungLuongPin,
                ManHinh.LoaiManHinh,
                CPU.CPU,
                Ram.DungLuongRam,
                BoNho.DungLuongBoNho,
                MauSac.TenMau,
                CTS.GiaBan,
                CTS.GhiChu,
                COUNT(CTS.ID) AS SoLuong,
                TinhTrang.TinhTrang,
        	CTS.ID
            FROM
                dbo.ChiTietSP AS CTS
                INNER JOIN dbo.NhaSanXuat AS NSX ON CTS.IDNSX = NSX.ID
                INNER JOIN dbo.DongSP AS DS ON CTS.IDDSP = DS.ID
                INNER JOIN dbo.Pin ON CTS.IDPin = Pin.ID
                INNER JOIN dbo.ManHinh ON CTS.IDManHinh = ManHinh.ID
                INNER JOIN dbo.CPU ON CTS.IDCPU = CPU.ID
                INNER JOIN dbo.Ram ON CTS.IDRam = Ram.ID
                INNER JOIN dbo.BoNho ON CTS.IDBoNho = BoNho.ID
                INNER JOIN dbo.MauSac ON CTS.IDMauSac = MauSac.ID
                INNER JOIN dbo.TinhTrang ON CTS.IDTinhTrang = TinhTrang.ID
        	WHERE CTS.Deleted = 0
            GROUP BY
                CTS.Imel,
                CTS.IDNSX,
                CTS.IDDSP,
                CTS.IDMauSac,
                CTS.IDPin,
                CTS.IDManHinh,
                CTS.IDRam,
                CTS.IDBoNho,
                CTS.IDCPU,
                CTS.IDTinhTrang,
                DS.TenDSP,
		NSX.[Tên NSX],
                Pin.DungLuongPin,
                ManHinh.LoaiManHinh,
                CPU.CPU,
                Ram.DungLuongRam,
                BoNho.DungLuongBoNho,
                MauSac.TenMau,
                CTS.GiaBan,
                CTS.GhiChu,
                TinhTrang.TinhTrang,
        	CTS.ID
            ORDER BY
                CTS.ID DESC
        """;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPhamViewModel spvm = new ChiTietSanPhamViewModel();
                spvm.setImel(rs.getString(1));
                spvm.setIdNsx(rs.getString(2));
                spvm.setIdDsp(rs.getString(3));
                spvm.setIdMauSac(rs.getString(4));
                spvm.setIdPin(rs.getString(5));
                spvm.setIdManHinh(rs.getString(6));
                spvm.setIdRam(rs.getString(7));
                spvm.setIdboNho(rs.getString(8));
                spvm.setIdCpu(rs.getString(9));
                spvm.setIdTinhTrang(rs.getString(10));
                spvm.setTenDsp(rs.getString(11));
                spvm.setTenNsx(rs.getString(12));
                spvm.setDungLuongPin(rs.getString(13));
                spvm.setLoaiManHinh(rs.getString(14));
                spvm.setCpu(rs.getString(15));
                spvm.setDungLuongRam(rs.getString(16));
                spvm.setDungLuongBoNho(rs.getString(17));
                spvm.setTenMau(rs.getString(18));
                spvm.setGiaBan(rs.getBigDecimal(19));
                spvm.setGhiChu(rs.getString(20));
                spvm.setSoLuong(rs.getInt(21));
                spvm.setTinhTrang(rs.getString(22));
                spvm.setId(rs.getString(23));
                listSP.add(spvm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public boolean xuatSanPham() {
        try ( Connection connection = DBConnect.getConnection()) {
            String query = """
            SELECT
                CTS.Imel,
                CTS.IDNSX,
                CTS.IDDSP,
                CTS.IDMauSac,
                CTS.IDPin,
                CTS.IDManHinh,
                CTS.IDRam,
                CTS.IDBoNho,
                CTS.IDCPU,
                CTS.IDTinhTrang,
                DS.TenDSP,
                NSX.[Tên NSX],
                Pin.DungLuongPin,
                ManHinh.LoaiManHinh,
                CPU.CPU,
                Ram.DungLuongRam,
                BoNho.DungLuongBoNho,
                MauSac.TenMau,
                CTS.GiaBan,
                CTS.GhiChu,
                COUNT(CTS.ID) AS SoLuong,
                TinhTrang.TinhTrang,
                CTS.ID
            FROM
                dbo.ChiTietSP AS CTS
                INNER JOIN dbo.NhaSanXuat AS NSX ON CTS.IDNSX = NSX.ID
                INNER JOIN dbo.DongSP AS DS ON CTS.IDDSP = DS.ID
                INNER JOIN dbo.Pin ON CTS.IDPin = Pin.ID
                INNER JOIN dbo.ManHinh ON CTS.IDManHinh = ManHinh.ID
                INNER JOIN dbo.CPU ON CTS.IDCPU = CPU.ID
                INNER JOIN dbo.Ram ON CTS.IDRam = Ram.ID
                INNER JOIN dbo.BoNho ON CTS.IDBoNho = BoNho.ID
                INNER JOIN dbo.MauSac ON CTS.IDMauSac = MauSac.ID
                INNER JOIN dbo.TinhTrang ON CTS.IDTinhTrang = TinhTrang.ID
            WHERE
                CTS.Deleted = 1
            GROUP BY
                CTS.Imel,
                CTS.IDNSX,
                CTS.IDDSP,
                CTS.IDMauSac,
                CTS.IDPin,
                CTS.IDManHinh,
                CTS.IDRam,
                CTS.IDBoNho,
                CTS.IDCPU,
                CTS.IDTinhTrang,
                DS.TenDSP,
                NSX.[Tên NSX],
                Pin.DungLuongPin,
                ManHinh.LoaiManHinh,
                CPU.CPU,
                Ram.DungLuongRam,
                BoNho.DungLuongBoNho,
                MauSac.TenMau,
                CTS.GiaBan,
                CTS.GhiChu,
                TinhTrang.TinhTrang,
                CTS.ID
            ORDER BY
                CTS.ID DESC
                           
            """;

            try ( PreparedStatement statement = connection.prepareStatement(query);  ResultSet resultSet = statement.executeQuery()) {

                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Danh sách sản phẩm");

                // Tạo phông in đậm
                Font font = workbook.createFont();
                font.setBold(true);
                CellStyle style = workbook.createCellStyle();
                style.setFont(font);

                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                Row headerRow = sheet.createRow(0);

                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Cell cell = headerRow.createCell(i - 1);
                    cell.setCellValue(columnName);
                    cell.setCellStyle(style);
                }

                int rowIndex = 1;
                while (resultSet.next()) {
                    Row row = sheet.createRow(rowIndex++);

                    row.createCell(0).setCellValue(resultSet.getString("Imel"));
                    row.createCell(1).setCellValue(resultSet.getString("IDNSX"));
                    row.createCell(2).setCellValue(resultSet.getString("IDDSP"));
                    row.createCell(3).setCellValue(resultSet.getString("IDMauSac"));
                    row.createCell(4).setCellValue(resultSet.getString("IDPin"));
                    row.createCell(5).setCellValue(resultSet.getString("IDManHinh"));
                    row.createCell(6).setCellValue(resultSet.getString("IDRam"));
                    row.createCell(7).setCellValue(resultSet.getString("IDBoNho"));
                    row.createCell(8).setCellValue(resultSet.getString("IDCPU"));
                    row.createCell(9).setCellValue(resultSet.getString("IDTinhTrang"));
                    row.createCell(10).setCellValue(resultSet.getString("TenDSP"));
                    row.createCell(11).setCellValue(resultSet.getString("Tên NSX"));
                    row.createCell(12).setCellValue(resultSet.getString("DungLuongPin"));
                    row.createCell(13).setCellValue(resultSet.getString("LoaiManHinh"));
                    row.createCell(14).setCellValue(resultSet.getString("CPU"));
                    row.createCell(15).setCellValue(resultSet.getString("DungLuongRam"));
                    row.createCell(16).setCellValue(resultSet.getString("DungLuongBoNho"));
                    row.createCell(17).setCellValue(resultSet.getString("TenMau"));
                    row.createCell(18).setCellValue(resultSet.getDouble("GiaBan"));
                    row.createCell(19).setCellValue(resultSet.getString("GhiChu"));
                    row.createCell(20).setCellValue(resultSet.getInt("SoLuong"));
                    row.createCell(21).setCellValue(resultSet.getString("TinhTrang"));
                    row.createCell(22).setCellValue(resultSet.getString("ID"));
                }

                String fileName = "DanhSachSanPham_" + System.currentTimeMillis() + ".xlsx";
                try ( FileOutputStream fileOut = new FileOutputStream(fileName)) {
                    workbook.write(fileOut);
                }
                System.out.println("Đã xuất file Excel: " + fileName);
                return true;
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean themSanPhamTuExcel(File excelFile) {
        try ( Connection connection = DBConnect.getConnection()) {
            Workbook workbook = WorkbookFactory.create(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            LocalDate dateTime = LocalDate.now();

            // Bỏ qua hàng tiêu đề
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            String query = """
                           INSERT INTO dbo.ChiTietSP (
                               IDDSP, IDMauSac, IDPin, IDManHinh, IDRam, IDBoNho, IDCPU, IDTinhTrang, IDNSX,
                               GiaBan, Imel, GhiChu, [Deleted], [Created at], [Created by]
                           ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);
                       """;

            try ( PreparedStatement ps = connection.prepareStatement(query)) {
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();

                    // Đọc dữ liệu từ cột trong hàng Excel
                    String idDSP = row.getCell(0).getStringCellValue();
                    String idMauSac = row.getCell(1).getStringCellValue();
                    String idPin = row.getCell(2).getStringCellValue();
                    String idManHinh = row.getCell(3).getStringCellValue();
                    String idRam = row.getCell(4).getStringCellValue();
                    String idBoNho = row.getCell(5).getStringCellValue();
                    String idCPU = row.getCell(6).getStringCellValue();
                    String idTinhTrang = row.getCell(7).getStringCellValue();
                    String idNSX = row.getCell(8).getStringCellValue();
                    BigDecimal giaBan = BigDecimal.valueOf(row.getCell(9).getNumericCellValue());
                    String imel = row.getCell(10).getStringCellValue();
                    String ghiChu = row.getCell(11).getStringCellValue();

                    // Đặt các giá trị vào câu lệnh SQL
                    ps.setObject(1, idDSP);
                    ps.setObject(2, idMauSac);
                    ps.setObject(3, idPin);
                    ps.setObject(4, idManHinh);
                    ps.setObject(5, idRam);
                    ps.setObject(6, idBoNho);
                    ps.setObject(7, idCPU);
                    ps.setObject(8, idTinhTrang);
                    ps.setObject(9, idNSX);
                    ps.setObject(10, giaBan);
                    ps.setObject(11, imel);
                    ps.setObject(12, ghiChu);
                    ps.setObject(13, 1);
                    ps.setObject(14, dateTime);
                    ps.setObject(15, "Admin");
                    ps.executeUpdate();
                }
                return true;
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
