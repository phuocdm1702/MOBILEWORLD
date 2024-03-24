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
public class HinhThucThanhToan {
    private String idHTTT;
    private String idHoaDon;
    private String idPTTT;
    private BigDecimal tienCK;
    private BigDecimal tienMat;
    private Float Delete;
    private LocalDateTime CcreateAt;
    private String createBy;
    private LocalDateTime updateAt;
    private String updateBy;

    public HinhThucThanhToan() {
    }

    public HinhThucThanhToan(String idHTTT, String idHoaDon, String idPTTT, BigDecimal tienCK, BigDecimal tienMat, Float Delete, LocalDateTime CcreateAt, String createBy, LocalDateTime updateAt, String updateBy) {
        this.idHTTT = idHTTT;
        this.idHoaDon = idHoaDon;
        this.idPTTT = idPTTT;
        this.tienCK = tienCK;
        this.tienMat = tienMat;
        this.Delete = Delete;
        this.CcreateAt = CcreateAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public String getIdHTTT() {
        return idHTTT;
    }

    public void setIdHTTT(String idHTTT) {
        this.idHTTT = idHTTT;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdPTTT() {
        return idPTTT;
    }

    public void setIdPTTT(String idPTTT) {
        this.idPTTT = idPTTT;
    }

    public BigDecimal getTienCK() {
        return tienCK;
    }

    public void setTienCK(BigDecimal tienCK) {
        this.tienCK = tienCK;
    }

    public BigDecimal getTienMat() {
        return tienMat;
    }

    public void setTienMat(BigDecimal tienMat) {
        this.tienMat = tienMat;
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
        return "HinhThucThanhToan{" + "idHTTT=" + idHTTT + ", idHoaDon=" + idHoaDon + ", idPTTT=" + idPTTT + ", tienCK=" + tienCK + ", tienMat=" + tienMat + ", Delete=" + Delete + ", CcreateAt=" + CcreateAt + ", createBy=" + createBy + ", updateAt=" + updateAt + ", updateBy=" + updateBy + '}';
    }
    
    
    
}
