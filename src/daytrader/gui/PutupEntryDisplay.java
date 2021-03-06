/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daytrader.gui;

import daytrader.datamodel.AtrClassEnum;
import daytrader.datamodel.DTConstants;
import daytrader.datamodel.MarketEnum;
import daytrader.datamodel.MonthEnum;
import daytrader.datamodel.Putup;
import daytrader.datamodel.PutupTypeEnum;
import daytrader.datamodel.YLineLoadStatus;
import daytrader.utils.DTUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Roy
 */
public class PutupEntryDisplay extends javax.swing.JPanel {

    private Putup myPutup;
    private Changes changes;
    private YLineToggle YToggle;
    private YearMonthChange YMLisener;

    /**
     * Creates new form PutupEntryDisplay
     */
    public PutupEntryDisplay() {
        initComponents();
        this.initialiseYLineTime();
        this.addChangesListener();
        this.refreshDisplay();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTicker = new javax.swing.JLabel();
        txtTicker = new javax.swing.JTextField();
        lblMarket = new javax.swing.JLabel();
        cbxMarket = new javax.swing.JComboBox();
        chxActive = new javax.swing.JCheckBox();
        lbl3MLPrice = new javax.swing.JLabel();
        spn3ML = new javax.swing.JSpinner();
        lblAtrClass = new javax.swing.JLabel();
        cbxClass = new javax.swing.JComboBox();
        pnlYLines = new javax.swing.JPanel();
        cbxUseYLineDate = new javax.swing.JCheckBox();
        cbxYYear = new javax.swing.JComboBox();
        cbxYMonth = new javax.swing.JComboBox();
        cbxYDay = new javax.swing.JComboBox();
        btnPreLoad = new javax.swing.JButton();
        lblType = new javax.swing.JLabel();
        cbxType = new javax.swing.JComboBox();

        lblTicker.setText("Stock Ticker");

        lblMarket.setText("Market");

        cbxMarket.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        chxActive.setSelected(true);
        chxActive.setText("Active");

        lbl3MLPrice.setText("3ML Price");

        spn3ML.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99999, 1));

        lblAtrClass.setText("Class");

        cbxClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxUseYLineDate.setText("Set Y Line Date");

        cbxYYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxYYear.setPreferredSize(new java.awt.Dimension(75, 22));

        cbxYMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxYMonth.setPreferredSize(new java.awt.Dimension(75, 22));

        cbxYDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnPreLoad.setText("Start Pre-Load");
        btnPreLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlYLinesLayout = new javax.swing.GroupLayout(pnlYLines);
        pnlYLines.setLayout(pnlYLinesLayout);
        pnlYLinesLayout.setHorizontalGroup(
            pnlYLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlYLinesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxUseYLineDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPreLoad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxYYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxYMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxYDay, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlYLinesLayout.setVerticalGroup(
            pnlYLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlYLinesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlYLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxUseYLineDate)
                    .addComponent(cbxYYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxYMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxYDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPreLoad)))
        );

        lblType.setText("Type:");

        cbxType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chxActive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTicker)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTicker, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMarket, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxMarket, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl3MLPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spn3ML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAtrClass, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxClass, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlYLines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlYLines, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblTicker)
                .addComponent(txtTicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblMarket)
                .addComponent(cbxMarket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(chxActive)
                .addComponent(lbl3MLPrice)
                .addComponent(spn3ML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblAtrClass)
                .addComponent(cbxClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblType)
                .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DefaultComboBoxModel model = new DefaultComboBoxModel(MarketEnum.values());
        cbxMarket.setModel(model);
        DefaultComboBoxModel modelClass = new DefaultComboBoxModel(daytrader.datamodel.AtrClassEnum.values());
        cbxClass.setModel(modelClass);
        DefaultComboBoxModel modelPutupType = new DefaultComboBoxModel(daytrader.datamodel.PutupTypeEnum.values());
        cbxType.setModel(modelPutupType);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreLoadActionPerformed
        // TODO add your handling code here:
        startPreLoad();
    }//GEN-LAST:event_btnPreLoadActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPreLoad;
    private javax.swing.JComboBox cbxClass;
    private javax.swing.JComboBox cbxMarket;
    private javax.swing.JComboBox cbxType;
    private javax.swing.JCheckBox cbxUseYLineDate;
    private javax.swing.JComboBox cbxYDay;
    private javax.swing.JComboBox cbxYMonth;
    private javax.swing.JComboBox cbxYYear;
    private javax.swing.JCheckBox chxActive;
    private javax.swing.JLabel lbl3MLPrice;
    private javax.swing.JLabel lblAtrClass;
    private javax.swing.JLabel lblMarket;
    private javax.swing.JLabel lblTicker;
    private javax.swing.JLabel lblType;
    private javax.swing.JPanel pnlYLines;
    private javax.swing.JSpinner spn3ML;
    private javax.swing.JTextField txtTicker;
    // End of variables declaration//GEN-END:variables

    private void addChangesListener() {
        if (null == this.changes) {
            this.changes = new Changes();
        }
        if (null == this.YToggle) {
            this.YToggle = new YLineToggle();
        }
        if (null == this.YMLisener) {
            this.YMLisener = new YearMonthChange();
        }
        this.chxActive.addActionListener(changes);
        this.cbxMarket.addActionListener(changes);
        this.cbxType.addActionListener(changes);
        this.cbxClass.addActionListener(changes);
        this.spn3ML.addChangeListener(changes);
        this.txtTicker.getDocument().addDocumentListener(changes);
        this.cbxUseYLineDate.addActionListener(YToggle);
        this.cbxYYear.addActionListener(YMLisener);
        this.cbxYMonth.addActionListener(YMLisener);
        this.cbxYDay.addActionListener(changes);
        this.btnPreLoad.addActionListener(YToggle);
    }

    private void removeChangesListener() {
        this.chxActive.removeActionListener(changes);
        this.cbxMarket.removeActionListener(changes);
        this.cbxType.removeActionListener(changes);
        this.cbxClass.removeActionListener(changes);
        this.spn3ML.removeChangeListener(changes);
        this.txtTicker.getDocument().removeDocumentListener(changes);
        this.cbxUseYLineDate.removeActionListener(YToggle);
        this.cbxYYear.removeActionListener(YMLisener);
        this.cbxYMonth.removeActionListener(YMLisener);
        this.cbxYDay.removeActionListener(changes);
        this.btnPreLoad.removeActionListener(YToggle);
    }

    private void refreshDisplay() {
        if (null != this.myPutup) {
            this.removeChangesListener();
            chxActive.setSelected(this.getMyPutup().isActive());
            txtTicker.setText(this.getMyPutup().getTickerCode());
            cbxMarket.setSelectedItem(this.getMyPutup().getMarket());
            cbxType.setSelectedItem(this.getMyPutup().getPutupType());
            spn3ML.setValue(this.getMyPutup().getThreeMlPrice());
            cbxClass.setSelectedItem(this.getMyPutup().getAtrClass());
            if (null == this.myPutup.getMaxYLineDate()) {
                this.cbxUseYLineDate.setSelected(false);
                disableYLineDateEntry();
            } else {
                enableYLineEntry();
                Calendar maxYLineDate = this.myPutup.getMaxYLineDate();
                Integer year = maxYLineDate.get(Calendar.YEAR);
                Integer day = maxYLineDate.get(Calendar.DAY_OF_MONTH);
                MonthEnum month = MonthEnum.fromCalEnum(maxYLineDate.get(Calendar.MONTH));
                //Replace day model for the new month
                int maxDay = maxYLineDate.getActualMaximum(Calendar.DAY_OF_MONTH);
                ArrayList<Integer> arlDays = new ArrayList<Integer>();
                for (int i = 1; i <= maxDay; i++) {
                    arlDays.add(i);
                }
                DefaultComboBoxModel dayModel = new DefaultComboBoxModel(arlDays.toArray());
                this.cbxYDay.setModel(dayModel);
                //Now select values
                this.cbxYYear.setSelectedItem(year);
                this.cbxYMonth.setSelectedItem(month);
                this.cbxYDay.setSelectedItem(day);
                if (!this.cbxUseYLineDate.isSelected()) {
                    this.cbxUseYLineDate.setSelected(true);
                }
            }
            this.addChangesListener();
        }
    }

    private void storeData() {
        if (null != this.myPutup) {
            this.myPutup.setActive(chxActive.isSelected());
            this.myPutup.setTickerCode(txtTicker.getText());
            Object typeItem = cbxType.getSelectedItem();
            if (typeItem instanceof PutupTypeEnum) {
                this.myPutup.setPutupType((PutupTypeEnum) typeItem);
            }
            Object marketItem = cbxMarket.getSelectedItem();
            if (marketItem instanceof MarketEnum) {
                this.myPutup.setMarket((MarketEnum) marketItem);
            }
            Object tmlValue = spn3ML.getValue();
            if (tmlValue instanceof Integer) {
                this.myPutup.setThreeMlPrice((Integer) tmlValue);
            }
            Object classItem = cbxClass.getSelectedItem();
            if (classItem instanceof AtrClassEnum) {
                this.myPutup.setAtrClass((AtrClassEnum) classItem);
            }
            if (this.cbxUseYLineDate.isSelected()) {
                enableYLineEntry();
                Calendar exchCal = DTUtil.getExchOpeningTime();
                Integer year = 0;
                Integer day = 0;
                MonthEnum month = MonthEnum.JANUARY;
                Object yearItem = this.cbxYYear.getSelectedItem();
                Object monthItem = this.cbxYMonth.getSelectedItem();
                Object dayItem = this.cbxYDay.getSelectedItem();
                boolean canProceed = false;
                if (yearItem instanceof Integer) {
                    year = (Integer) yearItem;
                    if (monthItem instanceof MonthEnum) {
                        month = (MonthEnum) monthItem;
                        if (dayItem instanceof Integer) {
                            day = (Integer) dayItem;
                            canProceed = true;
                        }
                    }
                }
                if (canProceed) {
                    exchCal.set(Calendar.YEAR, year);
                    exchCal.set(Calendar.MONTH, month.toCalEnum());
                    exchCal.set(Calendar.DAY_OF_MONTH, day);
                    this.myPutup.setMaxYLineDate(exchCal);
                } else {
                    this.myPutup.setMaxYLineDate(null);
                }
            } else {
                disableYLineDateEntry();
                this.myPutup.setMaxYLineDate(null);
            }
        }
    }

    /**
     * @return the myPutup
     */
    public Putup getMyPutup() {
        return myPutup;
    }

    /**
     * @param myPutup the myPutup to set
     */
    public void setMyPutup(Putup myPutup) {
        this.myPutup = myPutup;
        this.refreshDisplay();
    }

    private void initialiseYLineTime() {
        Calendar nowCal = Calendar.getInstance(DTConstants.EXCH_TIME_ZONE);
        int year = nowCal.get(Calendar.YEAR);
        Integer[] years = new Integer[5];
        for (int i = 0; i < 5; i++) {
            years[i] = (year - i);
        }
        DefaultComboBoxModel yearModel = new DefaultComboBoxModel(years);
        this.cbxYYear.setModel(yearModel);
        this.cbxYYear.setSelectedIndex(0);
        DefaultComboBoxModel monthModel = new DefaultComboBoxModel(MonthEnum.values());
        this.cbxYMonth.setModel(monthModel);
        this.cbxYMonth.setSelectedItem(MonthEnum.fromCalEnum(nowCal.get(Calendar.MONTH)));
        int maxDay = nowCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        ArrayList<Integer> arlDays = new ArrayList<Integer>();
        for (int i = 1; i <= maxDay; i++) {
            arlDays.add(i);
        }
        DefaultComboBoxModel dayModel = new DefaultComboBoxModel(arlDays.toArray());
        this.cbxYDay.setModel(dayModel);
        Integer currDay = nowCal.get(Calendar.DAY_OF_MONTH);
        this.cbxYDay.setSelectedItem(currDay);
        this.cbxUseYLineDate.setSelected(false);
        this.disableYLineDateEntry();
    }

    private void disableYLineDateEntry() {
        this.cbxYYear.setEnabled(false);
        this.cbxYMonth.setEnabled(false);
        this.cbxYDay.setEnabled(false);
        this.btnPreLoad.setEnabled(false);
    }

    private void enableYLineEntry() {
        this.cbxYYear.setEnabled(true);
        this.cbxYMonth.setEnabled(true);
        this.cbxYDay.setEnabled(true);
        if (this.myPutup.getYLineStatus() == YLineLoadStatus.YLINESNOTLOADED) {
            this.btnPreLoad.setEnabled(true);
        } else {
            this.btnPreLoad.setEnabled(false);
        }
    }

    private void startPreLoad() {
        this.myPutup.preLoadYLines();
        this.btnPreLoad.setEnabled(false);
    }

    private class Changes implements ActionListener, ChangeListener, DocumentListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            storeData();
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            storeData();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            storeData();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            storeData();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            storeData();
        }
    }

    private class YLineToggle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (cbxUseYLineDate.isSelected()) {
                enableYLineEntry();
                storeData();
            } else {
                disableYLineDateEntry();
                storeData();
            }
        }
    }

    private class YearMonthChange implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar exchCal = DTUtil.getExchOpeningTime();
            Integer year = 0;
            Integer day = 0;
            MonthEnum month = MonthEnum.JANUARY;
            Object yearItem = cbxYYear.getSelectedItem();
            Object monthItem = cbxYMonth.getSelectedItem();
            Object dayItem = cbxYDay.getSelectedItem();
            boolean canProceed = false;
            if (yearItem instanceof Integer) {
                year = (Integer) yearItem;
                if (monthItem instanceof MonthEnum) {
                    month = (MonthEnum) monthItem;
                    if (dayItem instanceof Integer) {
                        day = (Integer) dayItem;
                        canProceed = true;
                    }
                }
            }
            if (canProceed) {
                exchCal.set(Calendar.YEAR, year);
                exchCal.set(Calendar.MONTH, month.toCalEnum());
                //Create new day model
                int maxDay = exchCal.getActualMaximum(Calendar.DAY_OF_MONTH);
                ArrayList<Integer> arlDays = new ArrayList<Integer>();
                for (int i = 1; i <= maxDay; i++) {
                    arlDays.add(i);
                }
                DefaultComboBoxModel dayModel = new DefaultComboBoxModel(arlDays.toArray());
                cbxYDay.setModel(dayModel);
                if (maxDay >= day) {
                    cbxYDay.setSelectedItem(day);
                } else {
                    cbxYDay.setSelectedItem(1);
                }
                storeData();
            }
        }
    }
}
