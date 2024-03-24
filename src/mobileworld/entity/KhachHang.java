/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobileworld.entity;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class KhachHang {
    private String idKH;
    private String tenKH;
    private String sdt;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private Float Delete;
    private LocalDateTime CcreateAt;
    private String createBy;
    private LocalDateTime updateAt;
    private String updateBy;

    public KhachHang() {
    }

    public KhachHang(String idKH, String tenKH, String sdt, boolean gioiTinh, Date ngaySinh, String diaChi, Float Delete, LocalDateTime CcreateAt, String createBy, LocalDateTime updateAt, String updateBy) {
        this.idKH = idKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.Delete = Delete;
        this.CcreateAt = CcreateAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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
        return "KhachHang{" + "idKH=" + idKH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", Delete=" + Delete + ", CcreateAt=" + CcreateAt + ", createBy=" + createBy + ", updateAt=" + updateAt + ", updateBy=" + updateBy + '}';
    }
    
    
}
