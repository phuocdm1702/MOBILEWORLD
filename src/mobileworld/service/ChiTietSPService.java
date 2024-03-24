package mobileworld.service;

import java.io.File;
import java.util.List;
import mobileworld.entity.ChiTietSPEntity;
import mobileworld.repository.ChiTietSPRepository;
import mobileworld.viewModel.ChiTietSanPhamViewModel;

public class ChiTietSPService {

    private final ChiTietSPRepository repo = new ChiTietSPRepository();

    public List<ChiTietSanPhamViewModel> getAll() {
        return repo.getAll();
    }

    public List<ChiTietSPEntity> getImel() {
        return repo.getImel();
    }

    public boolean add(ChiTietSPEntity ctsp) {
        return repo.add(ctsp);
    }

    public boolean remove(String id) {
        return repo.remove(id);
    }

    public boolean update(ChiTietSPEntity ctsp, String id) {
        return repo.update(ctsp, id);
    }

    public List<ChiTietSanPhamViewModel> search(String sreach) {
        return repo.search(sreach);
    }

    public List<ChiTietSanPhamViewModel> getAllRemove() {
        return repo.getAllRemove();
    }

    public boolean khoiPhucSP(String id) {
        return repo.khoiPhucSP(id);
    }

    public boolean xuatSanPham() {
        return repo.xuatSanPham();
    }

    public boolean themSanPhamTuExcel(File excelFile) {
        return repo.themSanPhamTuExcel(excelFile);
    }

}
