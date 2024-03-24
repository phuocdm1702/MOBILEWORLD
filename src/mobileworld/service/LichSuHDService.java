/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobileworld.service;

import java.util.List;
import mobileworld.repository.LichSuHDRepository;
import mobileworld.viewModel.LichSuHDModel;

/**
 *
 * @author ADMIN
 */
public class LichSuHDService {
    LichSuHDRepository repo = new LichSuHDRepository();
        public List<LichSuHDModel> getAll(String idLSHD) {
            return repo.getAll(idLSHD);
        }

}
