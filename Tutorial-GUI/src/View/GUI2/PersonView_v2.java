/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GUI2;

import java.awt.Component;
import java.util.ArrayList;
import model.BankCheckToUI;
import model.PersonToUI;

/**
 *
 * @author Profe
 */
public class PersonView_v2 extends javax.swing.JPanel {
    
    /**
     * Creates new form PersonView_v2
     */
    public PersonView_v2() {
        initComponents();
    }

    void setPerson (PersonToUI p, boolean spendMode) {
        jlText.setText ("Me llamo "+p.getName()+" y tengo "+p.getTotal()+" eurazos");
        jpChecks.removeAll();
        ArrayList<BankCheckToUI> checks = p.getBankChecks();
        BankCheckView_v2 checkView;
        int i = 0;
        for (BankCheckToUI c : checks) {
            checkView = new BankCheckView_v2();
            checkView.setBankCheck(c,i);
            checkView.setSpendMode(spendMode);
            jpChecks.add(checkView);
            i++;
        }
        repaint();
        revalidate();
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpChecks = new javax.swing.JPanel();

        jlText.setText("jLabel1");

        jpChecks.setBackground(new java.awt.Color(153, 255, 0));
        jpChecks.setPreferredSize(new java.awt.Dimension(500, 600));
        jScrollPane1.setViewportView(jpChecks);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlText)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    void setSpendMode(boolean onOff) {
        for (Component c : jpChecks.getComponents()) {
            ((BankCheckView_v2) c).setSpendMode(onOff);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlText;
    private javax.swing.JPanel jpChecks;
    // End of variables declaration//GEN-END:variables

}
