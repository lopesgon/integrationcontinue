package presentation;

import base.ConnexionBase;
import domaine.Commande;
import domaine.Employe;
import java.util.ArrayList;
import metier.ListeEmployes;

/**
 * Application de gestion des commandes de capsules de café.
 *
 * @author fredericlopesmagalhaes Numéro du poste: HEG-WS-8468
 * 
 */
public class FrmMain extends java.awt.Frame {

  private final int DEFAULT_INDEX = 0;
  private final String LIBELLECOMMANDE = "Commande de ",
          LIBELLECOMMANDENULLE = "<Aucune>";
  private ListeEmployes listeEmployes;

  public FrmMain() {
    initComponents();
    initMetier();
    initFrame();
  }

  private void initMetier() {
    listeEmployes = new ListeEmployes();
  }

  private void fillListEmployes() {
    for (int i = 0, n = listeEmployes.size(); i < n; i++) {
      lstEmployes.add(listeEmployes.get(i).toString());
    }
  }

  private void initFrame() {
    lstEmployes.select(DEFAULT_INDEX);
    listeEmployes.setPos(DEFAULT_INDEX);
    fillListEmployes();
    updateComposantsEmploye();
    updateComposantsCommande();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        lstEmployes = new java.awt.List();
        lblCommandes = new java.awt.Label();
        lstCommandes = new java.awt.List();
        label2 = new java.awt.Label();
        tfTotal = new java.awt.TextField();
        btnCompleter = new java.awt.Button();

        setResizable(false);
        setTitle("Commandes de capsules de café");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        label1.setText("Employés");

        lstEmployes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectedEmployeChanged(evt);
            }
        });

        lblCommandes.setText("Commandes de ...");

        lstCommandes.setEnabled(false);

        label2.setText("Total de la commande");

        tfTotal.setEditable(false);
        tfTotal.setEnabled(false);

        btnCompleter.setLabel("Compléter la commande");
        btnCompleter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nouvelleCommande(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lstEmployes, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(tfTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblCommandes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompleter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lstCommandes, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCommandes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lstEmployes, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lstCommandes, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCompleter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    ConnexionBase.close();
    System.exit(0);
  }//GEN-LAST:event_formWindowClosed

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    dispose();
  }//GEN-LAST:event_formWindowClosing

    private void selectedEmployeChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectedEmployeChanged
      listeEmployes.setPos(lstEmployes.getSelectedIndex());
      updateComposantsEmploye();
      updateComposantsCommande();
    }//GEN-LAST:event_selectedEmployeChanged

    private void nouvelleCommande(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nouvelleCommande
      FrmNouvelleCommande frm = FrmNouvelleCommande.getInstance(this, listeEmployes.getCourant());
      frm.setVisible(true);
    }//GEN-LAST:event_nouvelleCommande

  private void updateComposantsEmploye() {
    Employe employe = listeEmployes.getCourant();
    lblCommandes.setText(LIBELLECOMMANDE + employe.toString());
  }

  private void fillListCommandes(ArrayList<Commande> commandes) {
    for(Commande commande : commandes) {
      lstCommandes.add(commande.toString());
    }
  }

  private void updateComposantsCommande() {
    Employe employe = listeEmployes.getCourant();
    ArrayList<Commande> commandes = employe.getCommandes();
    lstCommandes.removeAll();
    if (!commandes.isEmpty()) {
      fillListCommandes(commandes);
    } else {
      lstCommandes.add(LIBELLECOMMANDENULLE);
    }
    double total = employe.getTotalCommandes();
    tfTotal.setText("" + total);
  }

  public void addCommande(Commande commande) {
    listeEmployes.addCommande(commande);
    updateComposantsCommande();
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnCompleter;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label lblCommandes;
    private java.awt.List lstCommandes;
    private java.awt.List lstEmployes;
    private java.awt.TextField tfTotal;
    // End of variables declaration//GEN-END:variables

} // FrmMain
