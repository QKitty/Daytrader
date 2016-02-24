/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daytrader.gui;

import daytrader.historicRequestSystem.TWSAccount;
import daytrader.interfaces.observerpattern.IObserver;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roy
 */
public class HistoricAccountRequestDisplay extends javax.swing.JPanel implements IObserver {

    private TWSAccount model;
    private AtomicBoolean blnDoUpdate;
    private Thread updater;

    /**
     * Creates new form HistoricAccountRequestDisplay
     */
    public HistoricAccountRequestDisplay() {
        initComponents();
        this.blnDoUpdate = new AtomicBoolean(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAccName = new javax.swing.JLabel();
        jpbUsage = new javax.swing.JProgressBar();

        lblAccName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAccName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAccName.setText("Account: ");

        jpbUsage.setMaximum(60);
        jpbUsage.setString("0 / 60");
        jpbUsage.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAccName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpbUsage, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAccName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpbUsage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jpbUsage;
    private javax.swing.JLabel lblAccName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
        this.blnDoUpdate.set(true);
    }

    private void refreshDisplay() {
        if (null != this.model) {
            this.lblAccName.setText("Account: " + this.model.getAccName());
            int requestsUsed = this.model.getRequestsUsed();
            this.jpbUsage.setValue(requestsUsed);
            this.jpbUsage.setString(requestsUsed + " / " + this.jpbUsage.getMaximum());
        } else {
            this.lblAccName.setText("Account: NO ACCOUNT");
            this.jpbUsage.setValue(0);
            this.jpbUsage.setString("0 / " + this.jpbUsage.getMaximum());
        }
        this.blnDoUpdate.set(false);
    }

    /**
     * @param model the model to set
     */
    public void setModel(TWSAccount model) {
        if (null != this.model) {
            this.model.removeObserver(this);
        }
        this.model = model;
        this.model.registerObserver(this);
        this.refreshDisplay();
    }

    @Override
    public void addNotify() {
        super.addNotify(); //To change body of generated methods, choose Tools | Templates.
        this.startMonitorThread();
    }

    @Override
    public void removeNotify() {
        super.removeNotify();
        if(null != this.updater){
            this.updater.interrupt();
            this.updater = null;
        }
    }
    
    private void startMonitorThread(){
        if(null != this.updater){
            this.updater.interrupt();
            this.updater = null;
        }
        this.updater = new Updater();
        this.updater.start();
    }

    private class Updater extends Thread {

        @Override
        public void run() {
            while (!this.isInterrupted()) {
                if (blnDoUpdate.get()) {
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            refreshDisplay();
                        }
                    });
                    try {
                        //Wait 1 sec for update
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(HistoricAccountRequestDisplay.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                yield();
            }
        }
    }
}