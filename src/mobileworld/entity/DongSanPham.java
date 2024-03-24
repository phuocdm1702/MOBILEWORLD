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
public class DongSanPham {
    private String idDSP;
    private String tenDSP;
    private Float Delete;
    private LocalDateTime CcreateAt;
    private String createBy;
    private LocalDateTime updateAt;
    private String updateBy;

    public DongSanPham() {
    }

    public DongSanPham(String idDSP, String tenDSP, Float Delete, LocalDateTime CcreateAt, String createBy, LocalDateTime updateAt, String updateBy) {
        this.idDSP = idDSP;
        this.tenDSP = tenDSP;
        this.Delete = Delete;
        this.CcreateAt = CcreateAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public String getIdDSP() {
        return idDSP;
    }

    public void setIdDSP(String idDSP) {
        this.idDSP = idDSP;
    }

    public String getTenDSP() {
        return tenDSP;
    }

    public void setTenDSP(String tenDSP) {
        this.tenDSP = tenDSP;
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
        return "DongSanPham{" + "idDSP=" + idDSP + ", tenDSP=" + tenDSP + ", Delete=" + Delete + ", CcreateAt=" + CcreateAt + ", createBy=" + createBy + ", updateAt=" + updateAt + ", updateBy=" + updateBy + '}';
    }
    
    
}
