package cz.muni.fi.uco359952.simplesimreader;

import com.johnhite.blog.TextAreaOutputStream;
import cz.muni.fi.uco359952.simplesimreader.exceptions.NoReaderFoundException;
import cz.muni.fi.uco359952.simplesimreader.exceptions.WrongPINCharactersException;
import cz.muni.fi.uco359952.simplesimreader.exceptions.WrongLengthOfPINException;
import cz.muni.fi.uco359952.simplesimreader.exceptions.WrongPINException;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.CardNotPresentException;
import javax.swing.*;

/**
 * Main class for GUI.
 *
 * @author Andrej
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates and holds information about CardManager.
     */
    protected static WriteIntoSystemOut writer = new WriteIntoSystemOut();
    /**
     * Holds information about whether card is connected.
     */
    protected static boolean cardIsConnected = false;

    /**
     * Creates new form GUI
     */
    public GUI() {

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        consoleText = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        Card = new javax.swing.JMenu();
        Connect = new javax.swing.JMenuItem();
        Disconnect = new javax.swing.JMenuItem();
        Data = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        ReadWithoutPIN = new javax.swing.JMenuItem();
        EnterPIN = new javax.swing.JMenuItem();
        ReadWithPIN = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple SIM Reader");

        consoleText.setColumns(20);
        consoleText.setEditable(false);
        consoleText.setRows(5);
        consoleText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        consoleText.setInheritsPopupMenu(true);
        jScrollPane2.setViewportView(consoleText);

        File.setText("File");

        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        File.add(jMenuItem2);

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        File.add(jMenuItem1);

        jMenuBar1.add(File);

        Card.setText("Card");

        Connect.setText("Connect");
        Connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectActionPerformed(evt);
            }
        });
        Card.add(Connect);

        Disconnect.setText("Disconnect");
        Disconnect.setEnabled(false);
        Disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisconnectActionPerformed(evt);
            }
        });
        Card.add(Disconnect);

        jMenuBar1.add(Card);

        Data.setText("Data");

        jMenuItem3.setText("Clear");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Data.add(jMenuItem3);

        ReadWithoutPIN.setText("Read without PIN");
        ReadWithoutPIN.setEnabled(false);
        ReadWithoutPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReadWithoutPINActionPerformed(evt);
            }
        });
        Data.add(ReadWithoutPIN);

        EnterPIN.setText("Enter PIN");
        EnterPIN.setEnabled(false);
        EnterPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterPINActionPerformed(evt);
            }
        });
        Data.add(EnterPIN);

        ReadWithPIN.setText("Read with PIN");
        ReadWithPIN.setEnabled(false);
        ReadWithPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReadWithPINActionPerformed(evt);
            }
        });
        Data.add(ReadWithPIN);

        jMenuBar1.add(Data);

        jMenu1.setText("Help");

        jMenuItem4.setText("About");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if (cardIsConnected) {
            try {
                writer.getters.worker.manager.DisconnectFromCard();
            } catch (Exception ex) {
            }
        }
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void ReadWithoutPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReadWithoutPINActionPerformed
        // TODO add your handling code here:

        if (!cardIsConnected) {
            JOptionPane.showMessageDialog(null, "No card connection", "Connection info", JOptionPane.ERROR_MESSAGE);
        } else {
            SwingWorkerGUI temp = new SwingWorkerGUI(0);
            temp.execute();
        }
    }//GEN-LAST:event_ReadWithoutPINActionPerformed

    private void ConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectActionPerformed

        try {
            if (cardIsConnected) {
                JOptionPane.showMessageDialog(null, "Already connected to: " + CardManager.getTerminal(), "Connection info", JOptionPane.WARNING_MESSAGE);
            } else {
                if (writer.getters.worker.manager.ConnectToCard()) {
                    cardIsConnected = true;
                    ReadWithoutPIN.setEnabled(true);
                    Connect.setEnabled(false);
                    Disconnect.setEnabled(true);
                    EnterPIN.setEnabled(true);
                    TextAreaOutputStream textOut = new TextAreaOutputStream(consoleText);
                    PrintStream outStream = new PrintStream(textOut, true);
                    System.setOut(outStream);
                    JOptionPane.showMessageDialog(null, "Successfully conntected to: " + CardManager.getTerminal(), "Connection info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (NoReaderFoundException ex) {
            JOptionPane.showMessageDialog(null, "No terminal found", "Connection info", JOptionPane.ERROR_MESSAGE);
            System.err.println("No terminal found");
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CardNotPresentException ex) {
            JOptionPane.showMessageDialog(null, "No card found", "Connection info", JOptionPane.ERROR_MESSAGE);
            System.err.println("No card found");
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Undefined error", "Connection info", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ConnectActionPerformed

    private void DisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisconnectActionPerformed
        // TODO add your handling code here:
        try {
            if (!cardIsConnected) {
                JOptionPane.showMessageDialog(null, "Not connected to any card", "Disconnection info", JOptionPane.WARNING_MESSAGE);
            } else {
                writer.getters.worker.manager.DisconnectFromCard();
                ReadWithPIN.setEnabled(false);
                ReadWithoutPIN.setEnabled(false);
                Connect.setEnabled(true);
                Disconnect.setEnabled(false);
                EnterPIN.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Successfully disconnected from " + CardManager.getTerminal(), "Disconnection info", JOptionPane.INFORMATION_MESSAGE);
                cardIsConnected = false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Undefined error", "Disconnection info", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DisconnectActionPerformed

    private void EnterPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterPINActionPerformed
        JLabel jPassword = new JLabel("Enter your PIN: ");
        JTextField password = new JPasswordField();
        Object[] ob = {jPassword, password};
        int result = JOptionPane.showConfirmDialog(this, ob, "PIN ", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String passwordValue = password.getText();
            try {
                writer.getters.worker.manager.VerifyPin(passwordValue);
                JOptionPane.showMessageDialog(null, "PIN successfully verified" + CardManager.getTerminal(), "", JOptionPane.INFORMATION_MESSAGE);
                ReadWithPIN.setEnabled(true);
                EnterPIN.setEnabled(false);
            } catch (WrongPINException ex) {
                System.err.println("Wrong PIN entered");
                JOptionPane.showMessageDialog(null, "Wrong PIN entered", "", JOptionPane.ERROR_MESSAGE);
            } catch (WrongLengthOfPINException ex) {
                System.err.println("Wrong PIN length entered: PIN must have 4-8 characters");
                JOptionPane.showMessageDialog(null, "Wrong PIN length entered: PIN must have 4-8 characters", "", JOptionPane.ERROR_MESSAGE);
            } catch (WrongPINCharactersException ex) {
                System.err.println("PIN must consist only of numerical characters");
                JOptionPane.showMessageDialog(null, "PIN must consist only of numerical characters", "", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "something went wrong", "", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_EnterPINActionPerformed

    private void ReadWithPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReadWithPINActionPerformed
        SwingWorkerGUI temp = new SwingWorkerGUI(1);
        temp.execute();
    }//GEN-LAST:event_ReadWithPINActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // declare JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // let the user choose the destination file
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            // indicates whether the user still wants to export the settings
            boolean doExport = true;

            // indicates whether to override an already existing file
            boolean overrideExistingFile = false;

            // get destination file
            File destinationFile = new File(fileChooser.getSelectedFile().getAbsolutePath());

            // check if file already exists
            while (doExport && destinationFile.exists() && !overrideExistingFile) {
                // let the user decide whether to override the existing file
                overrideExistingFile = (JOptionPane.showConfirmDialog(this, "Replace file?", "Export Settings", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);

                // let the user choose another file if the existing file shall not be overridden
                if (!overrideExistingFile) {
                    if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                        // get new destination file
                        destinationFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    } else {
                        // seems like the user does not want to export the settings any longer
                        doExport = false;
                    }
                }
            }

            // perform the actual export
            if (doExport) {
                try {
                    try (BufferedWriter out = new BufferedWriter(new FileWriter(destinationFile))) {
                        out.write(consoleText.getText());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        consoleText.setText(null);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        JOptionPane.showMessageDialog(this, "Simple SIM Reader\nVersion 1.00\nCreated by: Andrej Šimko\nandrej.simko@mail.muni.cz", "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */


        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                GUI temp = new GUI();
                temp.setVisible(true);

            }
        });



    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Card;
    private javax.swing.JMenuItem Connect;
    private javax.swing.JMenu Data;
    private javax.swing.JMenuItem Disconnect;
    private javax.swing.JMenuItem EnterPIN;
    private javax.swing.JMenu File;
    private javax.swing.JMenuItem ReadWithPIN;
    private javax.swing.JMenuItem ReadWithoutPIN;
    private javax.swing.JTextArea consoleText;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
