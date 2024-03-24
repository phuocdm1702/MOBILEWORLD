/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobileworld.entity;

import java.time.LocalDateTime;

/**
 *
 * @author ADMIN
 */
public class LichSuHoaDon {
    private String idLSHD;
    private String idHD;
    private String idNV;
    private String hanhDong;
    private Float Delete;
    private LocalDateTime CcreateAt;
    private String createBy;
    private LocalDateTime updateAt;
    private String updateBy;

    public LichSuHoaDon() {
    }

    public LichSuHoaDon(String idLSHD, String idHD, String idNV, String hanhDong, Float Delete, LocalDateTime CcreateAt, String createBy, LocalDateTime updateAt, String updateBy) {
        this.idLSHD = idLSHD;
        this.idHD = idHD;
        this.idNV = idNV;
        this.hanhDong = hanhDong;
        this.Delete = Delete;
        this.CcreateAt = CcreateAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public String getIdLSHD() {
        return idLSHD;
    }

    public void setIdLSHD(String idLSHD) {
        this.idLSHD = idLSHD;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getHanhDong() {
        return hanhDong;
    }

    public void setHanhDong(String hanhDong) {
        this.hanhDong = hanhDong;
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
        return "LichSuHoaDon{" + "idLSHD=" + idLSHD + ", idHD=" + idHD + ", idNV=" + idNV + ", hanhDong=" + hanhDong + ", Delete=" + Delete + ", CcreateAt=" + CcreateAt + ", createBy=" + createBy + ", updateAt=" + updateAt + ", updateBy=" + updateBy + '}';
    }
    
    
}
