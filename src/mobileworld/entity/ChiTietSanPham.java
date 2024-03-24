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
public class ChiTietSanPham {
    private String idCTSP;
    private String idNSX;
    private String idDSP;
    private String idMauSac;
    private String idPin;
    private String idManHinh;
    private String idRam;
    private String idRom;
    private String idCPU;
    private String idTinhTrang;
    private String ghiChu;
    private BigDecimal giaBan;
    private Float Delete;
    private LocalDateTime CcreateAt;
    private String createBy;
    private LocalDateTime updateAt;
    private String updateBy;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String idCTSP, String idNSX, String idDSP, String idMauSac, String idPin, String idManHinh, String idRam, String idRom, String idCPU, String idTinhTrang, String ghiChu, BigDecimal giaBan, Float Delete, LocalDateTime CcreateAt, String createBy, LocalDateTime updateAt, String updateBy) {
        this.idCTSP = idCTSP;
        this.idNSX = idNSX;
        this.idDSP = idDSP;
        this.idMauSac = idMauSac;
        this.idPin = idPin;
        this.idManHinh = idManHinh;
        this.idRam = idRam;
        this.idRom = idRom;
        this.idCPU = idCPU;
        this.idTinhTrang = idTinhTrang;
        this.ghiChu = ghiChu;
        this.giaBan = giaBan;
        this.Delete = Delete;
        this.CcreateAt = CcreateAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public String getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(String idCTSP) {
        this.idCTSP = idCTSP;
    }

    public String getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(String idNSX) {
        this.idNSX = idNSX;
    }

    public String getIdDSP() {
        return idDSP;
    }

    public void setIdDSP(String idDSP) {
        this.idDSP = idDSP;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdPin() {
        return idPin;
    }

    public void setIdPin(String idPin) {
        this.idPin = idPin;
    }

    public String getIdManHinh() {
        return idManHinh;
    }

    public void setIdManHinh(String idManHinh) {
        this.idManHinh = idManHinh;
    }

    public String getIdRam() {
        return idRam;
    }

    public void setIdRam(String idRam) {
        this.idRam = idRam;
    }

    public String getIdRom() {
        return idRom;
    }

    public void setIdRom(String idRom) {
        this.idRom = idRom;
    }

    public String getIdCPU() {
        return idCPU;
    }

    public void setIdCPU(String idCPU) {
        this.idCPU = idCPU;
    }

    public String getIdTinhTrang() {
        return idTinhTrang;
    }

    public void setIdTinhTrang(String idTinhTrang) {
        this.idTinhTrang = idTinhTrang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
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

    @Override
    public String toString() {
        return "ChiTietSanPham{" + "idCTSP=" + idCTSP + ", idNSX=" + idNSX + ", idDSP=" + idDSP + ", idMauSac=" + idMauSac + ", idPin=" + idPin + ", idManHinh=" + idManHinh + ", idRam=" + idRam + ", idRom=" + idRom + ", idCPU=" + idCPU + ", idTinhTrang=" + idTinhTrang + ", ghiChu=" + ghiChu + ", giaBan=" + giaBan + ", Delete=" + Delete + ", CcreateAt=" + CcreateAt + ", createBy=" + createBy + ", updateAt=" + updateAt + ", updateBy=" + updateBy + '}';
    }
    
    
}
