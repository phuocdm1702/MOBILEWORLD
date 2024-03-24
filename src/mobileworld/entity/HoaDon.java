/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobileworld.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author ADMIN
 */
public class HoaDon {
    private String idHD;
    private String idKH;
    private String idNV;
    private LocalDateTime NgayTao;
    private LocalDateTime ngayThanhToan;
    private String idCTDG;
    private BigDecimal tongTien;
    private String idHTTT;
    private String tenKH;
    private String sdtKH;
    private String diaChiKH;
    private Float Delete;
    private LocalDateTime CcreateAt;
    private String createBy;
    private LocalDateTime updateAt;
    private String updateBy;
    private int trangthai;
    public HoaDon() {
    }

    public HoaDon(String idHD, String idKH, String idNV, LocalDateTime NgayTao, LocalDateTime ngayThanhToan, String idCTDG, BigDecimal tongTien, String idHTTT, String tenKH, String sdtKH, String diaChiKH, Float Delete, LocalDateTime CcreateAt, String createBy, LocalDateTime updateAt, String updateBy, int trangthai) {
        this.idHD = idHD;
        this.idKH = idKH;
        this.idNV = idNV;
        this.NgayTao = NgayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.idCTDG = idCTDG;
        this.tongTien = tongTien;
        this.idHTTT = idHTTT;
        this.tenKH = tenKH;
        this.sdtKH = sdtKH;
        this.diaChiKH = diaChiKH;
        this.Delete = Delete;
        this.CcreateAt = CcreateAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
        this.trangthai = trangthai;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public LocalDateTime getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(LocalDateTime NgayTao) {
        this.NgayTao = NgayTao;
    }

    public LocalDateTime getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(LocalDateTime ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getIdCTDG() {
        return idCTDG;
    }

    public void setIdCTDG(String idCTDG) {
        this.idCTDG = idCTDG;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getIdHTTT() {
        return idHTTT;
    }

    public void setIdHTTT(String idHTTT) {
        this.idHTTT = idHTTT;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public Float getDelete() {
        return Delete;
    }

    public void setDelete(Float Delete) {
        this.Delete = Delete;
    }

    public LocalDateTime getCcreateAt() {
        return CcreateAt;
    }

    public void setCcreateAt(LocalDateTime CcreateAt) {
        this.CcreateAt = CcreateAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "idHD=" + idHD + ", idKH=" + idKH + ", idNV=" + idNV + ", NgayTao=" + NgayTao + ", ngayThanhToan=" + ngayThanhToan + ", idCTDG=" + idCTDG + ", tongTien=" + tongTien + ", idHTTT=" + idHTTT + ", tenKH=" + tenKH + ", sdtKH=" + sdtKH + ", diaChiKH=" + diaChiKH + ", Delete=" + Delete + ", CcreateAt=" + CcreateAt + ", createBy=" + createBy + ", updateAt=" + updateAt + ", updateBy=" + updateBy + ", trangthai=" + trangthai + '}';
    }

    
}
