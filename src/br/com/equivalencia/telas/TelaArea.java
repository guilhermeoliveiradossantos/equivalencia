
package br.com.equivalencia.telas;
import br.com.equivalencia.dao.ModuloConexao;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;



public class TelaArea extends javax.swing.JFrame {

  Connection conexao = null;
  PreparedStatement pst = null;
  ResultSet rs = null;
  
  //criando o metodo adcionar 
  private void adicionar (){
    String sql = "Insert into tb_area_tecnologica(nome_area) Values(?)";
    
    try {
     pst = conexao.prepareStatement(sql);
     pst.setString(1, txtNomeArea.getText());
     
  // validando campos de preencimento obrigatorio
  
            if (txtNomeArea.getText().isEmpty()) {
               JOptionPane.showMessageDialog(null, "Campos de preenchimento obrigatorio estao em branco!");
            }else{
                int adicionado = pst.executeUpdate();
                
                if (adicionado >0) {
                    JOptionPane.showMessageDialog(null, "Área Tecnologica cadastrada com sucesso");
                    txtNomeArea.setText(null);
                    txtNomeArea.requestFocus();
                }
            }
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
} 
  
  // metodo para alterar um registro no banco de dados  
  private void alterar(){
      String sql = "update tb_area_tecnologica set nome_area =?  where id_area =?";
      
      try {
          pst=conexao.prepareStatement(sql);
          pst.setString(1, txtNomeArea.getText());
          pst.setString(2, txtIdArea.getText());
       
          //Validacao dos campos obrigatorios
          if (txtIdArea.getText().isEmpty() || (txtNomeArea.getText().isEmpty())) {
              JOptionPane.showMessageDialog(null, "Campos de preenchimento obrigatório em branco");
              
          } else {
              int adicionado = pst.executeUpdate();
              
              if (adicionado >0){
                  JOptionPane.showMessageDialog(null, "Area Tecnologica alterada com sucesso!");
            
              }
          }
      } catch (Exception e) {
          
          JOptionPane.showMessageDialog(null, e);
          
      }
      
  }
  
  // metodo de pesquisa area tecnologica no banco de dados
  
  private void pesquisar_area(){
      String sql = "select id_area as ID, nome_area as 'Área_tecnologica' from tb_area_tecnologica where nome_area like ?";
      
      try {
          pst = conexao.prepareStatement(sql);
          pst.setString(1, txtPesquisarArea.getText()+"%");
          rs = pst.executeQuery();     
          tblArea.setModel(DbUtils.resultSetToTableModel(rs));
         
          
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
      }
  }
  
  private void setar_campos(){
      int setar = tblArea.getSelectedRow();
      txtIdArea.setText(tblArea.getModel().getValueAt(setar, 0).toString());
       txtNomeArea.setText(tblArea.getModel().getValueAt(setar, 1).toString());
  }
  
    
    public TelaArea() {
        initComponents();
        conexao = ModuloConexao.conector();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdArea = new javax.swing.JTextField();
        txtNomeArea = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArea = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtPesquisarArea = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("ID:");

        jLabel3.setText("Nome Área:");

        txtIdArea.setEnabled(false);

        txtNomeArea.setText("TESTE100");
        txtNomeArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeAreaKeyPressed(evt);
            }
        });

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/imagens/btnCadastro.png"))); // NOI18N
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/imagens/delete.png"))); // NOI18N

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equivalencia/imagens/edit.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        tblArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome Área"
            }
        ));
        tblArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblArea);

        jLabel4.setText("Pesquisar:");

        txtPesquisarArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarAreaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdArea, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNomeArea, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisarArea))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomeArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir)
                    .addComponent(btnCadastrar)
                    .addComponent(btnEditar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtPesquisarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
      adicionar ();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtNomeAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeAreaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            adicionar();
        }
    }//GEN-LAST:event_txtNomeAreaKeyPressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtPesquisarAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarAreaKeyReleased
        pesquisar_area();
    }//GEN-LAST:event_txtPesquisarAreaKeyReleased

    private void tblAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAreaMouseClicked
        // TODO add your handling code here:
        setar_campos();
    }//GEN-LAST:event_tblAreaMouseClicked

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaArea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblArea;
    private javax.swing.JTextField txtIdArea;
    private javax.swing.JTextField txtNomeArea;
    private javax.swing.JTextField txtPesquisarArea;
    // End of variables declaration//GEN-END:variables
}
