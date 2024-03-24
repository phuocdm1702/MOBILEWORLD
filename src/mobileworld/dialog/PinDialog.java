package mobileworld.dialog;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import mobileworld.entity.PinEntity;
import mobileworld.event.EventPinDialog;
import mobileworld.service.PinService;

public class PinDialog extends javax.swing.JFrame {

    private DefaultTableModel tblModel = new DefaultTableModel();
    public PinService service = new PinService();
    public EventPinDialog eventPinDialog;

    public PinDialog() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Pin");
        tblModel = (DefaultTableModel) tblPin.getModel();
        showDataTableSanPham(service.getAll());
        pack();
    }

    public void setEventPinDialog(EventPinDialog eventPinDialog) {
        this.eventPinDialog = eventPinDialog;
    }

    private void showDataTableSanPham(List<PinEntity> lists) {
        tblModel.setRowCount(0);
        int stt = 0;
        for (PinEntity pe : lists) {
            stt++;
            tblModel.addRow(new Object[]{
                pe.getDungLuongPin()
            });
        }
    }

    private PinEntity getFormData() {
        String tenPin = txtPin.getText();
        LocalDate dateTime = LocalDate.now();

        PinEntity pin = new PinEntity(tenPin, 1, dateTime, "NV0003");
        return pin;
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
        tblPin = new mobileworld.swing.Table();
        txtPin = new mobileworld.swing.TextField();
        buttonCustom1 = new mobileworld.swing.ButtonCustom();
        buttonCustom2 = new mobileworld.swing.ButtonCustom();
        buttonCustom3 = new mobileworld.swing.ButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        tblPin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Dung Lượng Pin"
            }
        ));
        tblPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPinMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPin);

        txtPin.setLabelText("Dung Lượng Pin");

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
                        .addComponent(txtPin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        int i = tblPin.getSelectedRow();
        PinEntity pin = service.getAll().get(i);
        service.update(getFormData(), pin.getId());
        showDataTableSanPham(service.getAll());
        notifyDataChangeListeners();
    }//GEN-LAST:event_buttonCustom2ActionPerformed

    private void buttonCustom3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCustom3ActionPerformed
        int i = tblPin.getSelectedRow();
        PinEntity pin = service.getAll().get(i);
        service.remove(pin.getId());
        showDataTableSanPham(service.getAll());
        txtPin.setText("");
        notifyDataChangeListeners();
    }//GEN-LAST:event_buttonCustom3ActionPerformed

    private void tblPinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPinMouseClicked
        int i = tblPin.getSelectedRow();
        PinEntity pin = service.getAll().get(i);
        txtPin.setText(pin.getDungLuongPin());
    }//GEN-LAST:event_tblPinMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mobileworld.swing.ButtonCustom buttonCustom1;
    private mobileworld.swing.ButtonCustom buttonCustom2;
    private mobileworld.swing.ButtonCustom buttonCustom3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private mobileworld.swing.Table tblPin;
    private mobileworld.swing.TextField txtPin;
    // End of variables declaration//GEN-END:variables
}
