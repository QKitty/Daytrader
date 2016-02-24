/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daytrader.gui;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import rules.IGLimitEntry;

/**
 *
 * @author Roy
 */
public class IGLimitEntryDisplay extends javax.swing.JPanel {
    
    private IGLimitEntry myIGEntry;
    private ChangeListener changes;

    /**
     * Creates new form IGLimitEntryDisplay
     */
    public IGLimitEntryDisplay() {
        initComponents();
        initialise();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblScore = new javax.swing.JLabel();
        spnScore = new javax.swing.JSpinner();
        lblPrice = new javax.swing.JLabel();
        spnPrice = new javax.swing.JSpinner();

        lblScore.setText("Score: ");

        spnScore.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.04d), Double.valueOf(0.0d), null, Double.valueOf(0.01d)));

        lblPrice.setText("Price");

        spnPrice.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(15.0d), Double.valueOf(0.0d), null, Double.valueOf(1.0d)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnScore, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spnPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblScore)
                .addComponent(spnScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblPrice)
                .addComponent(spnPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblScore;
    private javax.swing.JSpinner spnPrice;
    private javax.swing.JSpinner spnScore;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the myIGEntry
     */
    public IGLimitEntry getMyIGEntry() {
        return myIGEntry;
    }

    /**
     * @param myIGEntry the myIGEntry to set
     */
    public void setMyIGEntry(IGLimitEntry myIGEntry) {
        this.myIGEntry = myIGEntry;
        this.refreshDisplay();
    }
    
    private void refreshDisplay(){
        if(null != this.myIGEntry){
            this.removeListeners();
            this.spnScore.setValue(this.myIGEntry.getScore());
            this.spnPrice.setValue(this.myIGEntry.getPrice());
            this.addListeners();
        }
    }
    
    private void storeData(){
        if(null != this.myIGEntry){
            Object scoreVal = this.spnScore.getValue();
            if(scoreVal instanceof Double){
                Double val = (Double)scoreVal;
                this.myIGEntry.setScore(val);
            }
            Object priceVal = this.spnPrice.getValue();
            if(priceVal instanceof Double){
                Double val = (Double)priceVal;
                this.myIGEntry.setPrice(val);
            }
        }
    }

    private void initialise() {
        this.addListeners();
    }
    
    private void addListeners(){
        if(null == this.changes){
            this.changes = new Changed();
        }
        this.spnScore.addChangeListener(this.changes);
        this.spnPrice.addChangeListener(this.changes);
    }
    
    private void removeListeners(){
        if(null == this.changes){
            this.changes = new Changed();
        }
        this.spnScore.removeChangeListener(this.changes);
        this.spnPrice.removeChangeListener(this.changes);
    }
    
    //Inner Class to monitor changes
    private class Changed implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            storeData();
        }
    }
}
