package mobileworld.dialog;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import mobileworld.entity.CPUEntity;
import mobileworld.event.EventCPUDialog;
import mobileworld.service.CpuService;

public class CPUDialog extends javax.swing.JFrame {

    private DefaultTableModel tblModel = new DefaultTableModel();
    public CpuService service = new CpuService();
    public EventCPUDialog cPUDialog;

    public CPUDialog() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("CPU");
        tblModel = (DefaultTableModel) tblCPU.getModel();
        showDataTableSanPham(service.getAll());
        pack();
    }

    public void setEventCPUDialog(EventCPUDialog cPUDialog) {
        this.cPUDialog = cPUDialog;
    }

    private void showDataTableSanPham(List<CPUEntity> lists) {
        tblModel.setRowCount(0);
        int stt = 0;
        for (CPUEntity cpu : lists) {
            stt++;
            tblModel.addRow(new Object[]{
                cpu.getCpu()
            });
        }
    }

    private CPUEntity getFormData() {
        String tenCPU = txtCPU.getText();
        LocalDate dateTime = LocalDate.now();

        CPUEntity cpu = new CPUEntity(tenCPU, 1, dateTime, "NV0003");
        return cpu;
    }

    public interface DataChangeListener {

        void onDataChange();
    }

    private final List<DataChangeListener> dataChangeListeners = new ArrayList<>();

    public void addDataChangeListener(DataChangeListener listener) {
        dataChangeListeners.add(listener);
    }

    public void removeDataChangeListener(DataChangeListener listener) {
        dataChangeListeners.remove(listener);
    }

    private void notifyDataChangeListeners() {
        for (DataChangeListener listener : dataChangeListeners) {
            listener.onDataChange();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCPU = new mobileworld.swing.Table();
        txtCPU = new mobileworld.swing.TextField();
        buttonCustom1 = new mobileworld.swing.ButtonCustom();
        buttonCustom2 = new mobileworld.swing.ButtonCustom();
        buttonCustom3 = new mobileworld.swing.ButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        tblCPU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "CPU"
            }
        ));
        tblCPU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCPUMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCPU);

        txtCPU.setLabelText("CPU");

        buttonCustom1.setForeground(new java.awt.Color(255, 255, 255));
        buttonCustom1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobileworld/icon/icons8-add-24.png"))); // NOI18N
        buttonCustom1.setText("Thêm");
        buttonCustom1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonCustom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCustom1ActionPerformed(evt);
            }
        });

        buttonCustom2.setForeground(new java.awt.Color(255, 255, 255));
        buttonCustom2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobileworld/icon/icons8-refresh-24.png"))); // NOI18N
        buttonCustom2.setText("Sửa");
        buttonCustom2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonCustom2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCustom2ActionPerformed(evt);
            }
        });

        buttonCustom3.setForeground(new java.awt.Color(255, 255, 255));
        buttonCustom3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobileworld/icon/icons8-delete-24.png"))); // NOI18N
        buttonCustom3.setText("Xóa");
        buttonCustom3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonCustom3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCustom3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCustom3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(buttonCustom2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCustom1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCPU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCustom3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCustom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCustom1ActionPerformed
        service.add(getFormData());
        showDataTableSanPham(service.getAll());
        notifyDataChangeListeners();
    }//GEN-LAST:event_buttonCustom1ActionPerformed

    private void buttonCustom2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCustom2ActionPerformed
        int i = tblCPU.getSelectedRow();
        CPUEntity cpu = service.getAll().get(i);
        service.update(getFormData(), cpu.getId());
        showDataTableSanPham(service.getAll());
        notifyDataChangeListeners();
    }//GEN-LAST:event_buttonCustom2ActionPerformed

    private void buttonCustom3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCustom3ActionPerformed
        int i = tblCPU.getSelectedRow();
        CPUEntity cpu = service.getAll().get(i);
        service.remove(cpu.getId());
        showDataTableSanPham(service.getAll());
        txtCPU.setText("");
        notifyDataChangeListeners();
    }//GEN-LAST:event_buttonCustom3ActionPerformed

    private void tblCPUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCPUMouseClicked
        int i = tblCPU.getSelectedRow();
        CPUEntity cpu = service.getAll().get(i);
        txtCPU.setText(cpu.getCpu());
    }//GEN-LAST:event_tblCPUMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mobileworld.swing.ButtonCustom buttonCustom1;
    private mobileworld.swing.ButtonCustom buttonCustom2;
    private mobileworld.swing.ButtonCustom buttonCustom3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private mobileworld.swing.Table tblCPU;
    private mobileworld.swing.TextField txtCPU;
    // End of variables declaration//GEN-END:variables
}
