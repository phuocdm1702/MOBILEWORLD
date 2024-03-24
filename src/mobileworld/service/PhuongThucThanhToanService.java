/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobileworld.service;

import java.util.List;
import mobileworld.entity.PhuongThucThanhToan;
import mobileworld.repository.PhuongThucThanhToanRepository;

/**
 *
 * @author ADMIN
 */
public class PhuongThucThanhToanService {
    PhuongThucThanhToanRepository repo = new PhuongThucThanhToanRepository();
        public List<PhuongThucThanhToan> getAll(){
            return repo.getAll();
        }

}
