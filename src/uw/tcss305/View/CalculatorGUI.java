package uw.tcss305.View;

import uw.tcss305.Controller.*;
import uw.tcss305.Model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.Objects;

public class CalculatorGUI {
    public static void main(String[] args) {
        CalculatorGuiFrame frame = new CalculatorGuiFrame();
        frame.setTitle("Calculator");
//        frame.setSize(800, 500);
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class CalculatorGuiFrame extends JFrame{

    CalculatorGuiFrame(){
        preparePanel();
    }

    void preparePanel(){

        //Add all panels on the tabbed panel
        add(tabbedPane);
        tabbedPane.add("Calculator", calcPanel);
        tabbedPane.add("Binary Calculator", binPanel);
        tabbedPane.add("Hexadecimal Calculator", hexPanel);
        tabbedPane.add("Decimal Calculator", decPanel);
        tabbedPane.add("Big Integer Calculator", bigIntPanel);
        tabbedPane.add("Bandwidth Calculator", bandwidthPanel);


        ////////////////////////////////////////////////////////////
        //////////////// Calculator Panel: Cover Panel//////////////
        ////////////////////////////////////////////////////////////

        MainPanelView();

        ////////////////////////////////////////////////////////////
        //////////////// Binary calculator panels///////////////////
        ////////////////////////////////////////////////////////////

        BinaryView();


        ////////////////////////////////////////////////////////////
        //////////////// Hexadecimal calculator panels//////////////
        ////////////////////////////////////////////////////////////

        HexadecimalView();

        ////////////////////////////////////////////////////////////
        //////////////// Decimal calculator panels//////////////////
        ////////////////////////////////////////////////////////////

        DecimalView();

        ////////////////////////////////////////////////////////////
        //////////////// Big Integer calculator panels//////////////
        ////////////////////////////////////////////////////////////

        BigIntegerView();

        ////////////////////////////////////////////////////////////
        //////////////// Bandwidth calculator panels////////////////
        ////////////////////////////////////////////////////////////

        BandwidthView();

    }

    private void BandwidthView() {
        bandwidthPanel.setBorder(new EmptyBorder(10,10,10,10));
        bandwidthPanel.setLayout(new BoxLayout(bandwidthPanel, BoxLayout.Y_AXIS));
        bandwidthPanel.add(upperPanel);
        bandwidthPanel.add(lowerPanel);
        lowerPanel.setBorder(new EmptyBorder(5,-1,-1,-1));

        //upper panel: data unit converter & website bandwidth calculator
        upperPanel.setLayout(new GridLayout(1,2, 5,-1));
        upperPanel.add(convDataUnitPanel);
        convDataUnitPanel.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        upperPanel.add(convHostBWidth);
        convHostBWidth.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));


        //Data unit converter

        DataUnitConverter();

        //Website Bandwidth Calculator

        WebsiteBandwidthCalculator();

        //lower panel: download/upload time calculator & hosting bandwidth calculator
        lowerPanel.setLayout(new GridLayout(1,2, 5,-1));
        lowerPanel.add(calcDownloadUploadTimePanel);
        calcDownloadUploadTimePanel.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        lowerPanel.add(calcWebBWidthPanel);
        calcWebBWidthPanel.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));



        //Download/Upload Time Calculator

        DownloadUploadTimeView();


        //Hosting Bandwidth Converter
        ConvertHostingBandwidth();
    }

    private void WebsiteBandwidthCalculator() {
        calcWebBWidthPanel.setLayout(new BoxLayout(calcWebBWidthPanel, BoxLayout.Y_AXIS));
        calcWebBWidthPanel.add(webBWidthPanel);
        calcWebBWidthPanel.add(panel21);
        calcWebBWidthPanel.add(panel22);
        calcWebBWidthPanel.add(calcWebBWidthResult);

        webBWidthPanel.add(webBWidthLabel);
        webBWidthLabel.setFont(new Font("Serif", Font.BOLD, 16));
        webBWidthLabel.setForeground(Color.decode("#FF8000"));

        panel21.setLayout(new GridLayout(3,3,2,2));
        panel21.add(pViewLabel);
        panel21.add(pViewTField);
        panel21.add(pViewUnitList);
        panel21.add(avgPSizeLabel);
        panel21.add(avgPSizeTField);
        panel21.add(avgPSizeUnitList);
        panel21.add(rFactorLabel);
        panel21.add(rFactorTField);

        panel22.setLayout(new FlowLayout());
        panel22.add(calcWebBWidthBtn);

//        JTextField pViewTField = new JTextField();
//        String[] pViewUnit = {"Per Second", "Per Minute", "Per Hour", "Per Day", "Per Week", "Per Month", "Per Year"};
//        JComboBox pViewUnitList = new JComboBox(pViewUnit);
//        JLabel avgPSizeLabel = new JLabel("  Average Page Size");
//        JTextField avgPSizeTField = new JTextField();
//        String[] avgPSizeUnit = {"Bytes (B)" , "Kilobytes (KB)" , "Megabytes (MB)" , "Gigabytes (GB)" , "Terabytes (TB)"};
//        JComboBox avgPSizeUnitList = new JComboBox(avgPSizeUnit);
//        JLabel rFactorLabel = new JLabel("  Redundancy Factor");
//        JTextField rFactorTField = new JTextField();

        calcWebBWidthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p = pViewTField.getText();
                String a = avgPSizeTField.getText();
                String r = rFactorTField.getText();
                String PUnit = (String) pViewUnitList.getSelectedItem();
                String AUnit = (String) avgPSizeUnitList.getSelectedItem();
                try {
                    Double.parseDouble(p);
                    Double.parseDouble(a);
                    Double.parseDouble(r);
                    if (Double.parseDouble(p) <= 0 || Double.parseDouble(a) <= 0) {
                        calcWebBWidthResult.setText("\n   Please provide a positive value to calculate.");
                        calcWebBWidthResult.setEnabled(false);
                        calcWebBWidthResult.setDisabledTextColor(Color.RED);
                    } else if (Double.parseDouble(r) < 1) {
                        calcWebBWidthResult.setText("\n   Please provide a redundancy factor that is 1 or larger.");
                        calcWebBWidthResult.setEnabled(false);
                        calcWebBWidthResult.setDisabledTextColor(Color.RED);
                    } else if (Double.parseDouble(r) == 1) {
                        switch (Objects.requireNonNull(PUnit)) {
                            case "Per Second":
                                switch (Objects.requireNonNull(AUnit)) {
                                    case "Bytes (B)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(1, p, 1, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(1, p, 1, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Kilobytes (KB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(1, p, 2, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(1, p, 2, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Megabytes (MB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(1, p, 3, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(1, p, 3, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Gigabytes (GB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(1, p, 4, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(1, p, 4, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Terabytes (TB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(1, p, 5, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(1, p, 5, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                }
                                break;

                            case "Per Minute":
                                switch (Objects.requireNonNull(AUnit)) {
                                    case "Bytes (B)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(2, p, 1, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(2, p, 1, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Kilobytes (KB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(2, p, 2, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(2, p, 2, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Megabytes (MB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(2, p, 3, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(2, p, 3, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Gigabytes (GB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(2, p, 4, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(2, p, 4, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Terabytes (TB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(2, p, 5, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(2, p, 5, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                }
                                break;

                            case "Per Hour":
                                switch (Objects.requireNonNull(AUnit)) {
                                    case "Bytes (B)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(3, p, 1, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(3, p, 1, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Kilobytes (KB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(3, p, 2, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(3, p, 2, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Megabytes (MB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(3, p, 3, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(3, p, 3, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Gigabytes (GB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(3, p, 4, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(3, p, 4, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Terabytes (TB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(3, p, 5, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(3, p, 5, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                }
                                break;

                            case "Per Day":
                                switch (Objects.requireNonNull(AUnit)) {
                                    case "Bytes (B)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(4, p, 1, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(4, p, 1, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Kilobytes (KB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(4, p, 2, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(4, p, 2, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Megabytes (MB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(4, p, 3, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(4, p, 3, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Gigabytes (GB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(4, p, 4, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(4, p, 4, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Terabytes (TB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(4, p, 5, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(4, p, 5, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                }
                                break;

                            case "Per Week":
                                switch (Objects.requireNonNull(AUnit)) {
                                    case "Bytes (B)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(5, p, 1, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(5, p, 1, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Kilobytes (KB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(5, p, 2, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(5, p, 2, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Megabytes (MB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(5, p, 3, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(5, p, 3, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Gigabytes (GB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(5, p, 4, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(5, p, 4, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Terabytes (TB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(5, p, 5, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(5, p, 5, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                }
                                break;

                            case "Per Month":
                                switch (Objects.requireNonNull(AUnit)) {
                                    case "Bytes (B)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(6, p, 1, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(6, p, 1, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Kilobytes (KB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(6, p, 2, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(6, p, 2, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Megabytes (MB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(6, p, 3, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(6, p, 3, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Gigabytes (GB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(6, p, 4, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(6, p, 4, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Terabytes (TB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(6, p, 5, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(6, p, 5, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                }
                                break;

                            case "Per Year":
                                switch (Objects.requireNonNull(AUnit)) {
                                    case "Bytes (B)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(7, p, 1, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(7, p, 1, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Kilobytes (KB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(7, p, 2, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(7, p, 2, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Megabytes (MB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(7, p, 3, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(7, p, 3, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Gigabytes (GB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(7, p, 4, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(7, p, 4, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Terabytes (TB)":
                                        calcWebBWidthResult.setText("\nBandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(7, p, 5, a, "1") + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(7, p, 5, a, "1") + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                }
                                break;
                        }
                    } else {
                        switch (Objects.requireNonNull(PUnit)) {
                            case "Per Second":
                                switch (Objects.requireNonNull(AUnit)) {
                                    case "Bytes (B)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(1, p, 1, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(1, p, 1, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(1, p, 1, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(1, p, 1, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Kilobytes (KB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(1, p, 2, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(1, p, 2, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(1, p, 2, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(1, p, 2, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Megabytes (MB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(1, p, 3, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(1, p, 3, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(1, p, 3, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(1, p, 3, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Gigabytes (GB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(1, p, 4, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(1, p, 4, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(1, p, 4, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(1, p, 4, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Terabytes (TB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(1, p, 5, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(1, p, 5, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(1, p, 5, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(1, p, 5, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                }
                                break;

                            case "Per Minute":
                                switch (Objects.requireNonNull(AUnit)) {
                                    case "Bytes (B)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(2, p, 1, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(2, p, 1, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(2, p, 1, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(2, p, 1, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Kilobytes (KB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(2, p, 2, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(2, p, 2, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(2, p, 2, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(2, p, 2, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Megabytes (MB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(2, p, 3, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(2, p, 3, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(2, p, 3, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(2, p, 3, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Gigabytes (GB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(2, p, 4, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(2, p, 4, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(2, p, 4, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(2, p, 4, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Terabytes (TB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(2, p, 5, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(2, p, 5, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(2, p, 5, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(2, p, 5, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                }
                                break;

                            case "Per Hour":
                                switch (Objects.requireNonNull(AUnit)) {
                                    case "Bytes (B)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(3, p, 1, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(3, p, 1, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(3, p, 1, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(3, p, 1, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Kilobytes (KB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(3, p, 2, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(3, p, 2, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(3, p, 2, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(3, p, 2, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Megabytes (MB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(3, p, 3, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(3, p, 3, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(3, p, 3, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(3, p, 3, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Gigabytes (GB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(3, p, 4, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(3, p, 4, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(3, p, 4, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(3, p, 4, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Terabytes (TB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(3, p, 5, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(3, p, 5, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(3, p, 5, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(3, p, 5, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                }
                                break;

                            case "Per Day":
                                switch (Objects.requireNonNull(AUnit)) {
                                    case "Bytes (B)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(4, p, 1, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(4, p, 1, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(4, p, 1, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(4, p, 1, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Kilobytes (KB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(4, p, 2, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(4, p, 2, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(4, p, 2, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(4, p, 2, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Megabytes (MB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(4, p, 3, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(4, p, 3, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(4, p, 3, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(4, p, 3, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Gigabytes (GB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(4, p, 4, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(4, p, 4, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(4, p, 4, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(4, p, 4, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Terabytes (TB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(4, p, 5, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(4, p, 5, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(4, p, 5, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(4, p, 5, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                }
                                break;

                            case "Per Week":
                                switch (Objects.requireNonNull(AUnit)) {
                                    case "Bytes (B)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(5, p, 1, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(5, p, 1, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(5, p, 1, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(5, p, 1, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Kilobytes (KB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(5, p, 2, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(5, p, 2, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(5, p, 2, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(5, p, 2, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Megabytes (MB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(5, p, 3, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(5, p, 3, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(5, p, 3, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(5, p, 3, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Gigabytes (GB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(5, p, 4, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(5, p, 4, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(5, p, 4, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(5, p, 4, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Terabytes (TB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(5, p, 5, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(5, p, 5, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(5, p, 5, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(5, p, 5, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                }
                                break;

                            case "Per Month":
                                switch (Objects.requireNonNull(AUnit)) {
                                    case "Bytes (B)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(6, p, 1, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(6, p, 1, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(6, p, 1, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(6, p, 1, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Kilobytes (KB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(6, p, 2, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(6, p, 2, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(6, p, 2, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(6, p, 2, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Megabytes (MB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(6, p, 3, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(6, p, 3, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(6, p, 3, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(6, p, 3, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Gigabytes (GB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(6, p, 4, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(6, p, 4, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(6, p, 4, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(6, p, 4, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Terabytes (TB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(6, p, 5, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(6, p, 5, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(6, p, 5, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(6, p, 5, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                }
                                break;

                            case "Per Year":
                                switch (Objects.requireNonNull(AUnit)) {
                                    case "Bytes (B)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(7, p, 1, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(7, p, 1, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(7, p, 1, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(7, p, 1, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Kilobytes (KB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(7, p, 2, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(7, p, 2, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(7, p, 2, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(7, p, 2, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Megabytes (MB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(7, p, 3, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(7, p, 3, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(7, p, 3, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(7, p, 3, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Gigabytes (GB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(7, p, 4, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(7, p, 4, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(7, p, 4, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(7, p, 4, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                    case "Terabytes (TB)":
                                        calcWebBWidthResult.setText("\nActual bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidth(7, p, 5, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsage(7, p, 5, a, r) + " GB per month.\n\n"
                                                + "With redundancy factor of " + r + ", the bandwidth needed is "
                                                + CalcWebsiteBandwidth.CalcBandwidthWithR(7, p, 5, a, r) + " Mbits/s or "
                                                + CalcWebsiteBandwidth.CalcMonthlyUsageWithR(7, p, 5, a, r) + " GB per month.");
                                        calcWebBWidthResult.setEnabled(false);
                                        calcWebBWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcWebBWidthResult.setLineWrap(true);
                                        calcWebBWidthResult.setWrapStyleWord(true);
                                        break;
                                }
                                break;
                        }
                    }
                } catch (NumberFormatException ect) {
                    calcWebBWidthResult.setText("\n   Please provide a positive value to calculate.");
                    calcWebBWidthResult.setEnabled(false);
                    calcWebBWidthResult.setDisabledTextColor(Color.RED);
                }

            }
        });

        calcWebBWidthResult.setBorder(BorderFactory.createTitledBorder("Result"));
        calcWebBWidthResult.setFont(new Font("Serif", Font.BOLD, 14));
    }

    private void ConvertHostingBandwidth() {
        convHostBWidth.setLayout(new BoxLayout(convHostBWidth, BoxLayout.Y_AXIS));
        convHostBWidth.add(hostBWidthPanel);
        convHostBWidth.add(panel41);
        convHostBWidth.add(panel42);
        convHostBWidth.add(MUsage2BWidthResult);
        convHostBWidth.add(panel43);
        convHostBWidth.add(panel44);
        convHostBWidth.add(BWidth2MUsageResult);

        hostBWidthPanel.add(hostBWidthLabel);
        hostBWidthLabel.setFont(new Font("Serif", Font.BOLD, 16));
        hostBWidthLabel.setForeground(Color.decode("#FF8000"));

        panel41.setLayout(new GridLayout(1,3,2,2));
        panel41.add(MUsageLabel);
        panel41.add(MUsageTField);
        panel41.add(MUsageUnitList);

        panel42.setLayout(new FlowLayout());
        panel42.add(MUsage2BWidthBtn);
        panel42.add(BWUnitList);

        MUsage2BWidthResult.setBorder(BorderFactory.createTitledBorder("Result"));
        MUsage2BWidthResult.setFont(new Font("Serif", Font.BOLD, 14));

//        JTextField MUsageTField = new JTextField();
//        String[] MUsageUnit = {"Bytes (B)" , "Kilobytes (KB)" , "Megabytes (MB)" , "Gigabytes (GB)" , "Terabytes (TB)"};
//        JComboBox MUsageUnitList = new JComboBox(MUsageUnit);
//        String[] BWUnit = {"bit/s" , "Kbit/s" , "Mbit/s" , "Gbit/s" , "Tbit/s"};
//        JComboBox BWUnitList = new JComboBox(BWidthUnit);


        MUsage2BWidthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String MUsage = MUsageTField.getText();
                String MUnit = (String) MUsageUnitList.getSelectedItem();
                String BUnit = (String) BWUnitList.getSelectedItem();

                try {
                    Double.parseDouble(MUsage);
                    if (Double.parseDouble(MUsage) <= 0) {
                        MUsage2BWidthResult.setText("\n   Please provide a positive value to convert.");
                        MUsage2BWidthResult.setEnabled(false);
                        MUsage2BWidthResult.setDisabledTextColor(Color.RED);
                    }else {
                        switch (Objects.requireNonNull(MUnit)) {
                            // convert from Bytes
                            case "Bytes (B)":
                                switch (Objects.requireNonNull(BUnit)){
                                    case "bit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Bytes (B) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(1, MUsage, 1) + " bit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Kbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Bytes (B) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(1, MUsage, 2) + " Kbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Mbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Bytes (B) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(1, MUsage, 3) + " Mbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Gbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Bytes (B) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(1, MUsage, 4) + " Gbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Tbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Bytes (B) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(1, MUsage, 5) + " Tbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                }
                                break;

                            // convert from Kilobytes
                            case "Kilobytes (KB)":
                                switch (Objects.requireNonNull(BUnit)){
                                    case "bit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Kilobytes (KB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(2, MUsage, 1) + " bit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Kbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Kilobytes (KB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(2, MUsage, 2) + " Kbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Mbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Kilobytes (KB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(2, MUsage, 3) + " Mbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Gbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Kilobytes (KB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(2, MUsage, 4) + " Gbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Tbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Kilobytes (KB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(2, MUsage, 5) + " Tbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                }
                                break;

                            // convert from Megabytes
                            case "Megabytes (MB)":
                                switch (Objects.requireNonNull(BUnit)){
                                    case "bit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Megabytes (MB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(3, MUsage, 1) + " bit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Kbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Megabytes (MB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(3, MUsage, 2) + " Kbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Mbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Megabytes (MB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(3, MUsage, 3) + " Mbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Gbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Megabytes (MB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(3, MUsage, 4) + " Gbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Tbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Megabytes (MB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(3, MUsage, 5) + " Tbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                }
                                break;

                            // convert from Gigabytes
                            case "Gigabytes (GB)":
                                switch (Objects.requireNonNull(BUnit)){
                                    case "bit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Gigabytes (GB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(4, MUsage, 1) + " bit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Kbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Gigabytes (GB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(4, MUsage, 2) + " Kbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Mbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Gigabytes (GB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(4, MUsage, 3) + " Mbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Gbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Gigabytes (GB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(4, MUsage, 4) + " Gbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Tbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Gigabytes (GB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(4, MUsage, 5) + " Tbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                }
                                break;
                            // convert from Terabytes
                            case "Terabytes (TB)":
                                switch (Objects.requireNonNull(BUnit)){
                                    case "bit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Terabytes (TB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(5, MUsage, 1) + " bit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Kbit/s":
                                        MUsage2BWidthResult.setText("   " + MUsage + " Terabytes (TB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(5, MUsage, 2) + " Kbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Mbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Terabytes (TB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(5, MUsage, 3) + " Mbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Gbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Terabytes (TB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(5, MUsage, 4) + " Gbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                    case "Tbit/s":
                                        MUsage2BWidthResult.setText(MUsage + " Terabytes (TB) per month is equivalent to "
                                                + ConvertHostingBandwidth.ConvertMUsage2BWidth(5, MUsage, 5) + " Tbit/s");
                                        MUsage2BWidthResult.setEnabled(false);
                                        MUsage2BWidthResult.setDisabledTextColor(Color.decode("#009900"));
                                        MUsage2BWidthResult.setLineWrap(true);
                                        MUsage2BWidthResult.setWrapStyleWord(true);
                                        break;

                                }
                                break;
                        }
                    }
                } catch (NumberFormatException ect) {
                    MUsage2BWidthResult.setText("\n   Please provide a positive value to convert.");
                    MUsage2BWidthResult.setEnabled(false);
                    MUsage2BWidthResult.setDisabledTextColor(Color.RED);
                }
            }
        });


        panel43.setLayout(new GridLayout(1,3,2,2));
        panel43.add(BWidthLabel);
        panel43.add(BWidthTField);
        panel43.add(BWidthUnitList);

        panel44.setLayout(new FlowLayout());
        panel44.add(BWidth2MUsageBtn);
        panel44.add(MUnitList);

        BWidth2MUsageResult.setBorder(BorderFactory.createTitledBorder( "Result"));
        BWidth2MUsageResult.setFont(new Font("Serif", Font.BOLD, 14));

//        JTextField BWidthTField = new JTextField();
//        String[] BWidthUnit = {"bit/s" , "Kbit/s" , "Mbit/s" , "Gbit/s" , "Tbit/s"};
//        JComboBox BWidthUnitList = new JComboBox(BWidthUnit);
//        String[] MUnit = {"Bytes (B)" , "Kilobytes (KB)" , "Megabytes (MB)" , "Gigabytes (GB)" , "Terabytes (TB)"};
//        JComboBox MUnitList = new JComboBox(MUsageUnit);
        BWidth2MUsageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String BWidth = BWidthTField.getText();
                String MUnit = (String) MUnitList.getSelectedItem();
                String BUnit = (String) BWidthUnitList.getSelectedItem();
                try {
                    Double.parseDouble(BWidth);
                    if (Double.parseDouble(BWidth) <= 0) {
                        BWidth2MUsageResult.setText("\n   Please provide a positive value to convert.");
                        BWidth2MUsageResult.setEnabled(false);
                        BWidth2MUsageResult.setDisabledTextColor(Color.RED);
                    }else {
                        switch (Objects.requireNonNull(BUnit)) {
                            // convert from Bytes
                            case "bit/s":
                                switch (Objects.requireNonNull(MUnit)){
                                    case "Bytes (B)":
                                        BWidth2MUsageResult.setText(BWidth + " bit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(1, BWidth, 1)
                                                + " Bytes (B) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Kilobytes (KB)":
                                        BWidth2MUsageResult.setText(BWidth + " bit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(1, BWidth, 2)
                                                + " Kilobytes (KB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Megabytes (MB)":
                                        BWidth2MUsageResult.setText(BWidth + " bit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(1, BWidth, 3)
                                                + " Megabytes (MB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Gigabytes (GB)":
                                        BWidth2MUsageResult.setText(BWidth + " bit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(1, BWidth, 4)
                                                + " Gigabytes (GB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Terabytes (TB)":
                                        BWidth2MUsageResult.setText(BWidth + " bit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(1, BWidth, 5)
                                                + " Terabytes (TB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                }
                                break;

                            // convert from Kilobytes
                            case "Kbit/s":
                                switch (Objects.requireNonNull(MUnit)){
                                    case "Bytes (B)":
                                        BWidth2MUsageResult.setText(BWidth + " Kbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(2, BWidth, 1)
                                                + " Bytes (B) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Kilobytes (KB)":
                                        BWidth2MUsageResult.setText(BWidth + " Kbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(2, BWidth, 2)
                                                + " Kilobytes (KB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Megabytes (MB)":
                                        BWidth2MUsageResult.setText(BWidth + " Kbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(2, BWidth, 3)
                                                + " Megabytes (MB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Gigabytes (GB)":
                                        BWidth2MUsageResult.setText(BWidth + " Kbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(2, BWidth, 4)
                                                + " Gigabytes (GB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Terabytes (TB)":
                                        BWidth2MUsageResult.setText(BWidth + " Kbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(2, BWidth, 5)
                                                + " Terabytes (TB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                }
                                break;

                            // convert from Megabytes
                            case "Mbit/s":
                                switch (Objects.requireNonNull(MUnit)){
                                    case "Bytes (B)":
                                        BWidth2MUsageResult.setText(BWidth + " Mbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(3, BWidth, 1)
                                                + " Bytes (B) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Kilobytes (KB)":
                                        BWidth2MUsageResult.setText(BWidth + " Mbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(3, BWidth, 2)
                                                + " Kilobytes (KB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Megabytes (MB)":
                                        BWidth2MUsageResult.setText(BWidth + " Mbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(3, BWidth, 3)
                                                + " Megabytes (MB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Gigabytes (GB)":
                                        BWidth2MUsageResult.setText(BWidth + " Mbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(3, BWidth, 4)
                                                + " Gigabytes (GB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Terabytes (TB)":
                                        BWidth2MUsageResult.setText(BWidth + " Mbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(3, BWidth, 5)
                                                + " Terabytes (TB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                }
                                break;

                            // convert from Gigabytes
                            case "Gbit/s":
                                switch (Objects.requireNonNull(MUnit)){
                                    case "Bytes (B)":
                                        BWidth2MUsageResult.setText(BWidth + " Gbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(4, BWidth, 1)
                                                + " Bytes (B) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Kilobytes (KB)":
                                        BWidth2MUsageResult.setText(BWidth + " Gbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(4, BWidth, 2)
                                                + " Kilobytes (KB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Megabytes (MB)":
                                        BWidth2MUsageResult.setText(BWidth + " Gbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(4, BWidth, 3)
                                                + " Megabytes (MB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Gigabytes (GB)":
                                        BWidth2MUsageResult.setText(BWidth + " Gbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(4, BWidth, 4)
                                                + " Gigabytes (GB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Terabytes (TB)":
                                        BWidth2MUsageResult.setText(BWidth + " Gbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(4, BWidth, 5)
                                                + " Terabytes (TB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                }
                                break;
                            // convert from Terabytes
                            case "Tbit/s":
                                switch (Objects.requireNonNull(MUnit)){
                                    case "Bytes (B)":
                                        BWidth2MUsageResult.setText(BWidth + " Tbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(5, BWidth, 1)
                                                + " Bytes (B) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Kilobytes (KB)":
                                        BWidth2MUsageResult.setText(BWidth + " Tbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(5, BWidth, 2)
                                                + " Kilobytes (KB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Megabytes (MB)":
                                        BWidth2MUsageResult.setText(BWidth + " Tbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(5, BWidth, 3)
                                                + " Megabytes (MB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Gigabytes (GB)":
                                        BWidth2MUsageResult.setText(BWidth + " Tbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(5, BWidth, 4)
                                                + " Gigabytes (GB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                    case "Terabytes (TB)":
                                        BWidth2MUsageResult.setText(BWidth + " Tbit/s is equivalent to "
                                                + ConvertHostingBandwidth.ConvertBWidth2MUsage(5, BWidth, 5)
                                                + " Terabytes (TB) per month");
                                        BWidth2MUsageResult.setEnabled(false);
                                        BWidth2MUsageResult.setDisabledTextColor(Color.decode("#009900"));
                                        BWidth2MUsageResult.setLineWrap(true);
                                        BWidth2MUsageResult.setWrapStyleWord(true);
                                        break;

                                }
                                break;
                        }
                    }
                } catch (NumberFormatException ect) {
                    BWidth2MUsageResult.setText("\n   Please provide a positive value to convert.");
                    BWidth2MUsageResult.setEnabled(false);
                    BWidth2MUsageResult.setDisabledTextColor(Color.RED);
                }
            }
        });

    }

    private void DownloadUploadTimeView() {
        calcDownloadUploadTimePanel.setLayout(new BoxLayout(calcDownloadUploadTimePanel, BoxLayout.Y_AXIS));
        calcDownloadUploadTimePanel.add(downUpTimePanel);
        calcDownloadUploadTimePanel.add(panel31);
        calcDownloadUploadTimePanel.add(panel32);
        calcDownloadUploadTimePanel.add(calcUpDownTimeResult);

        downUpTimePanel.add(downUpTimeLabel);
        downUpTimeLabel.setFont(new Font("Serif", Font.BOLD, 16));
        downUpTimeLabel.setForeground(Color.decode("#FF8000"));

        panel31.setLayout(new GridLayout(2,3,2,2));
        panel31.add(fileSizeLabel);
        panel31.add(fileSizeTField);
        panel31.add(fileSizeUnitList);
        panel31.add(bWidthLabel);
        panel31.add(bWidthTField);
        panel31.add(bWidthUnitList);

        panel32.setLayout(new FlowLayout());
        panel32.add(calcUpDownTimeBtn);

//        JTextField fileSizeTField = new JTextField();
//        String[] fileSizeUnit = {"Bytes (B)" , "Kilobytes (KB)" , "Megabytes (MB)" , "Gigabytes (GB)" , "Terabytes (TB)"};
//        JComboBox fileSizeUnitList = new JComboBox(fileSizeUnit);
//        JLabel bWidthLabel = new JLabel("  Bandwidth");
//        JTextField bWidthTField = new JTextField();
//        String[] bWidthUnit = {"bit/s" , "Kbit/s" , "Mbit/s" , "Gbit/s" , "Tbit/s"};
//        JComboBox bWidthUnitList = new JComboBox(bWidthUnit);

        calcUpDownTimeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String f = fileSizeTField.getText();
                String b = bWidthTField.getText();
                String fUnit = (String) fileSizeUnitList.getSelectedItem();
                String bUnit = (String) bWidthUnitList.getSelectedItem();
                try{
                    Double.parseDouble(f);
                    Double.parseDouble(b);
                    if (Double.parseDouble(f) <= 0 || Double.parseDouble(b) <= 0) {
                        calcUpDownTimeResult.setText("\n   Please provide a positive value to calculate.");
                        calcUpDownTimeResult.setEnabled(false);
                        calcUpDownTimeResult.setDisabledTextColor(Color.RED);
                    }else {
                        double fData = Double.parseDouble(f);
                        double bData = Double.parseDouble(b);
                        double time = 0;
                        double remainder = 0;
                        long day = 0;
                        int hour = 0;
                        int minute = 0;
                        double second = 0;
                        switch (Objects.requireNonNull(fUnit)) {
                            case "Bytes (B)":
                                switch (Objects.requireNonNull(bUnit)) {
                                    case "bit/s":
                                        time = CalcDownloadUploadTime.time(1, f, 1, b);
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Kbit/s":
                                        time = CalcDownloadUploadTime.time(1, f, 2, b);
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Mbit/s":
                                        time = CalcDownloadUploadTime.time(1, f, 3, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Gbit/s":
                                        time = CalcDownloadUploadTime.time(1, f, 4, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Tbit/s":
                                        time = CalcDownloadUploadTime.time(1, f, 5, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                }
                                break;

                            case "Kilobytes (KB)":
                                switch (Objects.requireNonNull(bUnit)) {
                                    case "bit/s":
                                        time = CalcDownloadUploadTime.time(2, f, 1, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Kbit/s":
                                        time = CalcDownloadUploadTime.time(2, f, 2, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Mbit/s":
                                        time = CalcDownloadUploadTime.time(2, f, 3, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Gbit/s":
                                        time = CalcDownloadUploadTime.time(2, f, 4, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Tbit/s":
                                        time = CalcDownloadUploadTime.time(2, f, 5, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                }
                                break;

                            case "Megabytes (MB)":
                                switch (Objects.requireNonNull(bUnit)) {
                                    case "bit/s":
                                        time = CalcDownloadUploadTime.time(3, f, 1, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Kbit/s":
                                        time = CalcDownloadUploadTime.time(3, f, 2, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Mbit/s":
                                        time = CalcDownloadUploadTime.time(3, f, 3, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Gbit/s":
                                        time = CalcDownloadUploadTime.time(3, f, 4, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Tbit/s":
                                        time = CalcDownloadUploadTime.time(3, f, 5, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                }
                                break;

                            case "Gigabytes (GB)":
                                switch (Objects.requireNonNull(bUnit)) {
                                    case "bit/s":
                                        time = CalcDownloadUploadTime.time(4, f, 1, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Kbit/s":
                                        time = CalcDownloadUploadTime.time(4, f, 2, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Mbit/s":
                                        time = CalcDownloadUploadTime.time(4, f, 3, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Gbit/s":
                                        time = CalcDownloadUploadTime.time(4, f, 4, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Tbit/s":
                                        time = CalcDownloadUploadTime.time(4, f, 5, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                }
                                break;

                            case "Terabytes (TB)":
                                switch (Objects.requireNonNull(bUnit)) {
                                    case "bit/s":
                                        time = CalcDownloadUploadTime.time(5, f, 1, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Kbit/s":
                                        time = CalcDownloadUploadTime.time(5, f, 2, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Mbit/s":
                                        time = CalcDownloadUploadTime.time(5, f, 3, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Gbit/s":
                                        time = CalcDownloadUploadTime.time(5, f, 4, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                    case "Tbit/s":
                                        time = CalcDownloadUploadTime.time(5, f, 5, b);;
                                        day = (long) CalcTime.sec2day.CalcTime(time);
                                        remainder = time % 86400;
                                        hour = (int) CalcTime.sec2hour.CalcTime(remainder);
                                        remainder %= 3600;
                                        minute = (int) CalcTime.sec2minute.CalcTime(remainder);
                                        remainder = remainder % 60;
                                        second = remainder;
                                        calcUpDownTimeResult.setText("\n Download or upload time needed is:\n  ~");
                                        if (day != 0){
                                            if ( day == 1){
                                                calcUpDownTimeResult.append(day + " day ");
                                            } else {
                                                calcUpDownTimeResult.append(day + " days ");
                                            }
                                        }
                                        if (hour != 0){
                                            if ( hour == 1){
                                                calcUpDownTimeResult.append(hour + " hour ");
                                            } else {
                                                calcUpDownTimeResult.append(hour + " hours ");
                                            }
                                        }
                                        if (minute != 0){
                                            if ( minute == 1){
                                                calcUpDownTimeResult.append(minute + " minute ");
                                            } else {
                                                calcUpDownTimeResult.append(minute + " minutes " );
                                            }
                                        }
                                        if (second != 0){
                                            if ( second == 1){
                                                calcUpDownTimeResult.append(second + " second");
                                            } else {
                                                calcUpDownTimeResult.append(second + " seconds");
                                            }
                                        }
                                        calcUpDownTimeResult.setEnabled(false);
                                        calcUpDownTimeResult.setDisabledTextColor(Color.decode("#009900"));
                                        calcUpDownTimeResult.setLineWrap(true);
                                        calcUpDownTimeResult.setWrapStyleWord(true);
                                        break;

                                }
                                break;
                        }
                    }
                } catch (NumberFormatException ect) {
                    calcUpDownTimeResult.setText("\n   Please provide a positive value to calculate.");
                    calcUpDownTimeResult.setEnabled(false);
                    calcUpDownTimeResult.setDisabledTextColor(Color.RED);
                }
            }
        });


        calcUpDownTimeResult.setBorder(BorderFactory.createTitledBorder("Result"));
        calcUpDownTimeResult.setFont(new Font("Serif", Font.BOLD, 14));
    }

    private void DataUnitConverter() {
        convDataUnitPanel.setLayout(new BoxLayout(convDataUnitPanel, BoxLayout.Y_AXIS));
        convDataUnitPanel.add(dataUnitLabelPanel);
        convDataUnitPanel.add(panel11);
        convDataUnitPanel.add(panel12);
        convDataUnitPanel.add(dataUnitResult);


        dataUnitLabelPanel.add(convDataUnitLabel);


        convDataUnitLabel.setFont(new Font("Serif", Font.BOLD, 16));
        convDataUnitLabel.setForeground(Color.decode("#FF8000"));

        panel11.setLayout(new FlowLayout());
        panel11.add(dataUnit);
        dataUnit.setColumns(20);
        panel11.add(dataUnitList);

//        String[] dataUnitStr = { "bits (b)", "kilobits (kb)", "megabits (mb)", "gigabits (gb)", "terabits (tb)" ,
//                "Bytes (B)" , "Kilobytes (KB)" , "Megabytes (MB)" , "Gigabytes (GB)" , "Terabytes (TB)"};
//        JComboBox dataUnitList = new JComboBox(dataUnitStr);

        dataUnitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num = dataUnit.getText();
                String s = (String) dataUnitList.getSelectedItem();
                try {
                    Double.parseDouble(num);
                    if (Double.parseDouble(num) <= 0) {
                        dataUnitResult.setText("\n   Please provide a positive value to convert.");
                        dataUnitResult.setEnabled(false);
                        dataUnitResult.setDisabledTextColor(Color.RED);
                    }else {
                        double b = Double.parseDouble(num);
                        switch (Objects.requireNonNull(s)) {
                            //convert from bits
                            case "bits (b)" -> {
                                dataUnitResult.setText("   " +b + " b" + " is equivalent to any of the following:\n\t"
                                        + DataUnit.b2kb.convertData(b) + " kilobits (kb)\n\t"
                                        + DataUnit.b2mb.convertData(b) + " megabits (mb)\n\t"
                                        + DataUnit.b2gb.convertData(b) + " gigabits (gb)\n\t"
                                        + DataUnit.b2tb.convertData(b) + " terabits (tb)\n\t"
                                        + DataUnit.b2B.convertData(b) + " Bytes (B)\n\t"
                                        + DataUnit.b2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                        + DataUnit.b2MB.convertData(b) + " Megabytes (MB)\n\t"
                                        + DataUnit.b2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                        + DataUnit.b2TB.convertData(b) + " Terabytes (TB)");
                                dataUnitResult.setEnabled(false);
                                dataUnitResult.setDisabledTextColor(Color.decode("#009900"));

                            }
                            // convert from kilobits
                            case "kilobits (kb)" -> {
                                dataUnitResult.setText("   " +b + " kb" + " is equivalent to any of the following:\n\t"
                                        + DataUnit.kb2b.convertData(b) + " bits (b)\n\t"
                                        + DataUnit.kb2mb.convertData(b) + " megabits (mb)\n\t"
                                        + DataUnit.kb2gb.convertData(b) + " gigabits (gb)\n\t"
                                        + DataUnit.kb2tb.convertData(b) + " terabits (tb)\n\t"
                                        + DataUnit.kb2B.convertData(b) + " Bytes (B)\n\t"
                                        + DataUnit.kb2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                        + DataUnit.kb2MB.convertData(b) + " Megabytes (MB)\n\t"
                                        + DataUnit.kb2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                        + DataUnit.kb2TB.convertData(b) + " Terabytes (TB)");
                                dataUnitResult.setEnabled(false);
                                dataUnitResult.setDisabledTextColor(Color.decode("#009900"));

                            }
                            // convert from megabits
                            case "megabits (mb)" -> {
                                dataUnitResult.setText("   " +b + " mb" + " is equivalent to any of the following:\n\t"
                                        + DataUnit.mb2b.convertData(b) + " bits (b)\n\t"
                                        + DataUnit.mb2kb.convertData(b) + " kilobits (kb)\n\t"
                                        + DataUnit.mb2gb.convertData(b) + " gigabits (gb)\n\t"
                                        + DataUnit.mb2tb.convertData(b) + " terabits (tb)\n\t"
                                        + DataUnit.mb2B.convertData(b) + " Bytes (B)\n\t"
                                        + DataUnit.mb2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                        + DataUnit.mb2MB.convertData(b) + " Megabytes (MB)\n\t"
                                        + DataUnit.mb2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                        + DataUnit.mb2TB.convertData(b) + " Terabytes (TB)");
                                dataUnitResult.setEnabled(false);
                                dataUnitResult.setDisabledTextColor(Color.decode("#009900"));

                            }
                            // convert from gigabits
                            case "gigabits (gb)" -> {

                                dataUnitResult.setText("   " +b + " gb" + " is equivalent to any of the following:\n\t"
                                        + DataUnit.gb2b.convertData(b) + " bits (b)\n\t"
                                        + DataUnit.gb2kb.convertData(b) + " kilobits (kb)\n\t"
                                        + DataUnit.gb2mb.convertData(b) + " megabits (mb)\n\t"
                                        + DataUnit.gb2tb.convertData(b) + " terabits (tb)\n\t"
                                        + DataUnit.gb2B.convertData(b) + " Bytes (B)\n\t"
                                        + DataUnit.gb2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                        + DataUnit.gb2MB.convertData(b) + " Megabytes (MB)\n\t"
                                        + DataUnit.gb2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                        + DataUnit.gb2TB.convertData(b) + " Terabytes (TB)");
                                dataUnitResult.setEnabled(false);
                                dataUnitResult.setDisabledTextColor(Color.decode("#009900"));

                            }
                            // convert from terabits
                            case "terabits (tb)" -> {
                                dataUnitResult.setText("   " +b + " tb" + " is equivalent to any of the following:\n\t"
                                        + DataUnit.tb2b.convertData(b) + " bits (b)\n\t"
                                        + DataUnit.tb2kb.convertData(b) + " kilobits (kb)\n\t"
                                        + DataUnit.tb2mb.convertData(b) + " megabits (mb)\n\t"
                                        + DataUnit.tb2gb.convertData(b) + " gigabits (gb)\n\t"
                                        + DataUnit.tb2B.convertData(b) + " Bytes (B)\n\t"
                                        + DataUnit.tb2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                        + DataUnit.tb2MB.convertData(b) + " Megabytes (MB)\n\t"
                                        + DataUnit.tb2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                        + DataUnit.tb2TB.convertData(b) + " Terabytes (TB)");
                                dataUnitResult.setEnabled(false);
                                dataUnitResult.setDisabledTextColor(Color.decode("#009900"));

                            }
                            // convert from Bytes
                            case "Bytes (B)" -> {
                                dataUnitResult.setText("   " +b + " B" + " is equivalent to any of the following:\n\t"
                                        + DataUnit.B2b.convertData(b) + " bits (b)\n\t"
                                        + DataUnit.B2kb.convertData(b) + " kilobits (kb)\n\t"
                                        + DataUnit.B2mb.convertData(b) + " megabits (mb)\n\t"
                                        + DataUnit.B2gb.convertData(b) + " gigabits (gb)\n\t"
                                        + DataUnit.B2tb.convertData(b) + " terabits (tb)\n\t"
                                        + DataUnit.B2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                        + DataUnit.B2MB.convertData(b) + " Megabytes (MB)\n\t"
                                        + DataUnit.B2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                        + DataUnit.B2TB.convertData(b) + " Terabytes (TB)");
                                dataUnitResult.setEnabled(false);
                                dataUnitResult.setDisabledTextColor(Color.decode("#009900"));

                            }
                            // convert from Kilobytes
                            case "Kilobytes (KB)" -> {
                                dataUnitResult.setText("   " +b + " KB" + " is equivalent to any of the following:\n\t"
                                        + DataUnit.KB2b.convertData(b) + " bits (b)\n\t"
                                        + DataUnit.KB2kb.convertData(b) + " kilobits (kb)\n\t"
                                        + DataUnit.KB2mb.convertData(b) + " megabits (mb)\n\t"
                                        + DataUnit.KB2gb.convertData(b) + " gigabits (gb)\n\t"
                                        + DataUnit.KB2tb.convertData(b) + " terabits (tb)\n\t"
                                        + DataUnit.KB2B.convertData(b) + " Bytes (B)\n\t"
                                        + DataUnit.KB2MB.convertData(b) + " Megabytes (MB)\n\t"
                                        + DataUnit.KB2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                        + DataUnit.KB2TB.convertData(b) + " Terabytes (TB)");
                                dataUnitResult.setEnabled(false);
                                dataUnitResult.setDisabledTextColor(Color.decode("#009900"));

                            }
                            // convert from Megabytes
                            case "Megabytes (MB)" -> {
                                dataUnitResult.setText("   " +b + " MB" + " is equivalent to any of the following:\n\t"
                                        + DataUnit.MB2b.convertData(b) + " bits (b)\n\t"
                                        + DataUnit.MB2kb.convertData(b) + " kilobits (kb)\n\t"
                                        + DataUnit.MB2mb.convertData(b) + " megabits (mb)\n\t"
                                        + DataUnit.MB2gb.convertData(b) + " gigabits (gb)\n\t"
                                        + DataUnit.MB2tb.convertData(b) + " terabits (tb)\n\t"
                                        + DataUnit.MB2B.convertData(b) + " Bytes (B)\n\t"
                                        + DataUnit.MB2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                        + DataUnit.MB2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                        + DataUnit.MB2TB.convertData(b) + " Terabytes (TB)");
                                dataUnitResult.setEnabled(false);
                                dataUnitResult.setDisabledTextColor(Color.decode("#009900"));

                            }
                            // convert from Gigabytes
                            case "Gigabytes (GB)" -> {
                                dataUnitResult.setText("   " +b + " GB" + " is equivalent to any of the following:\n\t"
                                        + DataUnit.GB2b.convertData(b) + " bits (b)\n\t"
                                        + DataUnit.GB2kb.convertData(b) + " kilobits (kb)\n\t"
                                        + DataUnit.GB2mb.convertData(b) + " megabits (mb)\n\t"
                                        + DataUnit.GB2gb.convertData(b) + " gigabits (gb)\n\t"
                                        + DataUnit.GB2tb.convertData(b) + " terabits (tb)\n\t"
                                        + DataUnit.GB2B.convertData(b) + " Bytes (B)\n\t"
                                        + DataUnit.GB2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                        + DataUnit.GB2MB.convertData(b) + " Megabytes (MB)\n\t"
                                        + DataUnit.GB2TB.convertData(b) + " Terabytes (TB)");
                                dataUnitResult.setEnabled(false);
                                dataUnitResult.setDisabledTextColor(Color.decode("#009900"));

                            }
                            // convert from Terabytes
                            case "Terabytes (TB)" -> {
                                dataUnitResult.setText("   " +b + " TB" + " is equivalent to any of the following:\n\t"
                                        + DataUnit.TB2b.convertData(b) + " bits (b)\n\t"
                                        + DataUnit.TB2kb.convertData(b) + " kilobits (kb)\n\t"
                                        + DataUnit.TB2mb.convertData(b) + " megabits (mb)\n\t"
                                        + DataUnit.TB2gb.convertData(b) + " gigabits (gb)\n\t"
                                        + DataUnit.TB2tb.convertData(b) + " terabits (tb)\n\t"
                                        + DataUnit.TB2B.convertData(b) + " Bytes (B)\n\t"
                                        + DataUnit.TB2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                        + DataUnit.TB2MB.convertData(b) + " Megabytes (MB)\n\t"
                                        + DataUnit.TB2GB.convertData(b) + " Gigabytes (GB)");
                                dataUnitResult.setEnabled(false);
                                dataUnitResult.setDisabledTextColor(Color.decode("#009900"));

                            }
                        }
                    }
                } catch (NumberFormatException ect) {
                    dataUnitResult.setText("\n   Please provide a positive value to convert.");
                    dataUnitResult.setEnabled(false);
                    dataUnitResult.setDisabledTextColor(Color.RED);
                }
            }
        });

        panel12.setLayout(new FlowLayout());
        panel12.add(dataUnitBtn);

        dataUnitResult.setBorder(BorderFactory.createTitledBorder("Result"));
        dataUnitResult.setFont(new Font("Serif", Font.BOLD, 14));
        //       dataUnitResult.setMaximumSize(new Dimension(Integer.MAX_VALUE,  dataUnitResult.getPreferredSize().height));
    }

    private void BigIntegerView() {
        bigIntPanel.setBorder(new EmptyBorder(10,10,10,10));
        bigIntPanel.setLayout(new GridLayout(1,2,10,10));
        bigIntPanel.add(calcBigIntPanel);
        bigIntPanel.add(convBigIntPanel);

        calcBigIntPanel.setLayout(new BoxLayout(calcBigIntPanel, BoxLayout.Y_AXIS));
        calcBigIntPanel.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        calcBigIntPanel.add(calcBigIntLabelPanel);
        calcBigIntPanel.add(bigInt1);
        calcBigIntPanel.add(bigInt2);
        calcBigIntPanel.add(operatorBigIntPanel);
        calcBigIntPanel.add(calcBigIntResult);

        calcBigIntLabelPanel.add(calcBigIntLabel);

        calcBigIntLabel.setFont(new Font("Serif", Font.BOLD, 20));
        calcBigIntLabel.setForeground(Color.decode("#000066"));

        bigInt1.setBorder(BorderFactory.createTitledBorder("Enter First Big Integer Value"));
        bigInt2.setBorder(BorderFactory.createTitledBorder("Enter Second Big Integer Value"));
        bigInt1.setMaximumSize(new Dimension(Integer.MAX_VALUE, hex1.getPreferredSize().height));
        bigInt2.setMaximumSize(new Dimension(Integer.MAX_VALUE, hex1.getPreferredSize().height));

        operatorBigIntPanel.setLayout(new FlowLayout());
        operatorBigIntPanel.add(bigIntAdd);
        operatorBigIntPanel.add(bigIntSub);
        operatorBigIntPanel.add(bigIntMul);
        operatorBigIntPanel.add(bigIntDiv);

        final BigIntNum[] bigIntegerNumber = {new BigIntNum(), new BigIntNum()};
        final BigIntNum[] resultBigInt = {new BigIntNum(), new BigIntNum()};
        BigIntegerCalculator bigIntCalc = new BigIntegerCalculator();

        bigIntAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bigIntegerNumber[0] = new BigIntNum(bigInt1.getText());
                bigIntegerNumber[1] = new BigIntNum(bigInt2.getText());
                if(bigIntegerNumber[0].bigIntNum.equals("Z") || bigIntegerNumber[1].bigIntNum.equals("Z")){
                    calcBigIntResult.setText("\nThe number need to be numeric.");
                    calcBigIntResult.setEnabled(false);
                    calcBigIntResult.setDisabledTextColor(Color.RED);
                } else {
                    resultBigInt[0] = BigIntegerCalculator.add(bigIntegerNumber[0], bigIntegerNumber[1]);
                    calcBigIntResult.setText("\nBig Integer Value:\n " + bigIntegerNumber[0].bigIntNum + " + " +
                            bigIntegerNumber[1].bigIntNum + "\n = " + resultBigInt[0].bigIntNum);
                    calcBigIntResult.setEnabled(false);
                    calcBigIntResult.setDisabledTextColor(Color.decode("#009900"));
                    calcBigIntResult.setLineWrap(true);
                    calcBigIntResult.setWrapStyleWord(true);
                }
            }
        });

        bigIntSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bigIntegerNumber[0] = new BigIntNum(bigInt1.getText());
                bigIntegerNumber[1] = new BigIntNum(bigInt2.getText());
                if(bigIntegerNumber[0].bigIntNum.equals("Z") || bigIntegerNumber[1].bigIntNum.equals("Z")){
                    calcBigIntResult.setText("\nThe number need to be numeric.");
                    calcBigIntResult.setEnabled(false);
                    calcBigIntResult.setDisabledTextColor(Color.RED);
                } else {
                    resultBigInt[0] = BigIntegerCalculator.subtract(bigIntegerNumber[0], bigIntegerNumber[1]);
                    calcBigIntResult.setText("\nBig Integer Value:\n " + bigIntegerNumber[0].bigIntNum + " - " +
                            bigIntegerNumber[1].bigIntNum + "\n = " + resultBigInt[0].bigIntNum);
                    calcBigIntResult.setEnabled(false);
                    calcBigIntResult.setDisabledTextColor(Color.decode("#009900"));
                    calcBigIntResult.setLineWrap(true);
                    calcBigIntResult.setWrapStyleWord(true);
                }
            }
        });

        bigIntMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bigIntegerNumber[0] = new BigIntNum(bigInt1.getText());
                bigIntegerNumber[1] = new BigIntNum(bigInt2.getText());
                if(bigIntegerNumber[0].bigIntNum.equals("Z") || bigIntegerNumber[1].bigIntNum.equals("Z")){
                    calcBigIntResult.setText("\nThe number need to be numeric.");
                    calcBigIntResult.setEnabled(false);
                    calcBigIntResult.setDisabledTextColor(Color.RED);
                } else {
                    resultBigInt[0] = BigIntegerCalculator.multiply(bigIntegerNumber[0], bigIntegerNumber[1]);
                    calcBigIntResult.setText("\nBig Integer Value:\n " + bigIntegerNumber[0].bigIntNum + " * " +
                            bigIntegerNumber[1].bigIntNum + "\n = " + resultBigInt[0].bigIntNum);
                    calcBigIntResult.setEnabled(false);
                    calcBigIntResult.setDisabledTextColor(Color.decode("#009900"));
                    calcBigIntResult.setLineWrap(true);
                    calcBigIntResult.setWrapStyleWord(true);
                }
            }
        });

        bigIntDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bigIntegerNumber[0] = new BigIntNum(bigInt1.getText());
                bigIntegerNumber[1] = new BigIntNum(bigInt2.getText());
                if(bigIntegerNumber[0].bigIntNum.equals("Z") || bigIntegerNumber[1].bigIntNum.equals("Z")){
                    calcBigIntResult.setText("\nThe number need to be numeric.");
                    calcBigIntResult.setEnabled(false);
                    calcBigIntResult.setDisabledTextColor(Color.RED);
                } else {
                    if (bigIntegerNumber[1].bigIntNum.equals("0")){
                        calcDecResult.setText("\nThe divider cannot be zero.");
                        calcDecResult.setEnabled(false);
                        calcDecResult.setDisabledTextColor(Color.RED);
                    }else {
                        if (BigIntegerCalculator.remainder(bigIntegerNumber[0], bigIntegerNumber[1]).bigIntNum.equals("0")) {
                            resultBigInt[0] = BigIntegerCalculator.divide(bigIntegerNumber[0], bigIntegerNumber[1]);
                            calcBigIntResult.setText("\nBig Integer Value:\n " + bigIntegerNumber[0].bigIntNum + " / " +
                                    bigIntegerNumber[1].bigIntNum + "\n = " + resultBigInt[0].bigIntNum);
                            calcBigIntResult.setEnabled(false);
                            calcBigIntResult.setDisabledTextColor(Color.decode("#009900"));
                            calcBigIntResult.setLineWrap(true);
                            calcBigIntResult.setWrapStyleWord(true);
                        } else {
                            resultBigInt[0] = BigIntegerCalculator.divide(bigIntegerNumber[0], bigIntegerNumber[1]);
                            resultBigInt[1] = BigIntegerCalculator.remainder(bigIntegerNumber[0], bigIntegerNumber[1]);
                            calcBigIntResult.setText("\nBig Integer Value:\n " + bigIntegerNumber[0].bigIntNum + " / " +
                                    bigIntegerNumber[1].bigIntNum + "\n = " + resultBigInt[0].bigIntNum
                                    + " Remainder: " + resultBigInt[1].bigIntNum);
                            calcBigIntResult.setEnabled(false);
                            calcBigIntResult.setDisabledTextColor(Color.decode("#009900"));
                            calcBigIntResult.setLineWrap(true);
                            calcBigIntResult.setWrapStyleWord(true);
                        }
                    }
                }
            }
        });


        calcBigIntResult.setBorder(BorderFactory.createTitledBorder("Result"));
        calcBigIntResult.setFont(new Font("Serif", Font.BOLD, 16));

        //Binary converter panel
        convBigIntPanel.setLayout(new BoxLayout(convBigIntPanel, BoxLayout.Y_AXIS));
        convBigIntPanel.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        convBigIntPanel.add(convBigIntLabelPanel);
        convBigIntPanel.add(bigIntNum);
        convBigIntPanel.add(convBigInt2BinBtnPanel);
        convBigIntPanel.add(convBigInt2BinResult);
        convBigIntPanel.add(convBigInt2HexBtnPanel);
        convBigIntPanel.add(convBigInt2HexResult);

        convBigInt2BinBtnPanel.setLayout(new FlowLayout());
        convBigInt2BinBtnPanel.add(bigInt2bin);
        convBigInt2HexBtnPanel.setLayout(new FlowLayout());
        convBigInt2HexBtnPanel.add(bigInt2hex);

        convBigIntLabelPanel.add(convBigIntLabel);
        convBigIntLabel.setFont(new Font("Serif", Font.BOLD, 20));
        convBigIntLabel.setForeground(Color.decode("#000066"));

        bigIntNum.setBorder(BorderFactory.createTitledBorder("Enter Big Integer Value"));
        bigIntNum.setMaximumSize(new Dimension(Integer.MAX_VALUE, bin1.getPreferredSize().height));

        convBigInt2BinResult.setBorder(BorderFactory.createTitledBorder("Result"));
        convBigInt2BinResult.setFont(new Font("Serif", Font.BOLD, 16));
        convBigInt2HexResult.setBorder(BorderFactory.createTitledBorder("Result"));
        convBigInt2HexResult.setFont(new Font("Serif", Font.BOLD, 16));

        final HexNum[] bigInt2hexResult = {new HexNum()};
        final BinNum[] bigInt2binResult = {new BinNum()};
        BinaryCalculator BigInt2BinCalculator = new BinaryCalculator();
        bigInt2bin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bigIntegerNumber[0] = new BigIntNum(bigIntNum.getText());
                if(bigIntegerNumber[0].bigIntNum.equals("Z")){
                    convBigInt2BinResult.setText("\nThe number need to be numeric.");
                    convBigInt2BinResult.setEnabled(false);
                    convBigInt2BinResult.setDisabledTextColor(Color.RED);
                } else {
                    if (bigIntegerNumber[0].bigIntNum.startsWith("-")) {
                        bigInt2binResult[0] = BigInt2BinCalculator.BigInt2Bin(bigIntegerNumber[0]);
                        convBigInt2BinResult.setText("\nBinary Value: -" + bigInt2binResult[0].binNum);
                        convBigInt2BinResult.setEnabled(false);
                        convBigInt2BinResult.setDisabledTextColor(Color.decode("#009900"));
                        convBigInt2BinResult.setLineWrap(true);
                        convBigInt2BinResult.setWrapStyleWord(true);
                    } else {
                        bigInt2binResult[0] = BigInt2BinCalculator.BigInt2Bin(bigIntegerNumber[0]);
                        convBigInt2BinResult.setText("\nBinary Value: " + bigInt2binResult[0].binNum);
                        convBigInt2BinResult.setEnabled(false);
                        convBigInt2BinResult.setDisabledTextColor(Color.decode("#009900"));
                        convBigInt2BinResult.setLineWrap(true);
                        convBigInt2BinResult.setWrapStyleWord(true);
                    }
                }
            }
        });

        HexadecimalCalculator BigInt2HexCalculator = new HexadecimalCalculator();

        bigInt2hex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bigIntegerNumber[0] = new BigIntNum(bigIntNum.getText());
                if(bigIntegerNumber[0].bigIntNum.equals("Z")){
                    convBigInt2HexResult.setText("\nThe number need to be numeric.");
                    convBigInt2HexResult.setEnabled(false);
                    convBigInt2HexResult.setDisabledTextColor(Color.RED);
                } else {
                    if (bigIntegerNumber[0].bigIntNum.startsWith("-")) {
                        bigInt2hexResult[0] = BigInt2HexCalculator.BigInt2Hex(bigIntegerNumber[0]);
                        convBigInt2HexResult.setText("\nHexadecimal Value: -" + bigInt2hexResult[0].hexNum);
                        convBigInt2HexResult.setEnabled(false);
                        convBigInt2HexResult.setDisabledTextColor(Color.decode("#009900"));
                        convBigInt2HexResult.setLineWrap(true);
                        convBigInt2HexResult.setWrapStyleWord(true);
                    } else {
                        bigInt2hexResult[0] = BigInt2HexCalculator.BigInt2Hex(bigIntegerNumber[0]);
                        convBigInt2HexResult.setText("\nHexadecimal Value: " + bigInt2hexResult[0].hexNum);
                        convBigInt2HexResult.setEnabled(false);
                        convBigInt2HexResult.setDisabledTextColor(Color.decode("#009900"));
                        convBigInt2HexResult.setLineWrap(true);
                        convBigInt2HexResult.setWrapStyleWord(true);
                    }
                }
            }
        });
    }

    private void DecimalView() {
        decPanel.setBorder(new EmptyBorder(10,10,10,10));
        decPanel.setLayout(new GridLayout(1,2,10,10));
        decPanel.add(calcDecPanel);
        decPanel.add(convDecPanel);

        calcDecPanel.setLayout(new BoxLayout(calcDecPanel, BoxLayout.Y_AXIS));
        calcDecPanel.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        calcDecPanel.add(calcDecLabelPanel);
        calcDecPanel.add(dec1);
        calcDecPanel.add(dec2);
        calcDecPanel.add(operatorDecPanel);
        calcDecPanel.add(calcDecResult);

        calcDecLabelPanel.add(calcDecLabel);

        calcDecLabel.setFont(new Font("Serif", Font.BOLD, 20));
        calcDecLabel.setForeground(Color.decode("#CC0066"));

        dec1.setBorder(BorderFactory.createTitledBorder("Enter First Decimal Value"));
        dec2.setBorder(BorderFactory.createTitledBorder("Enter Second Decimal Value"));
        dec1.setMaximumSize(new Dimension(Integer.MAX_VALUE, hex1.getPreferredSize().height));
        dec2.setMaximumSize(new Dimension(Integer.MAX_VALUE, hex1.getPreferredSize().height));

        operatorDecPanel.setLayout(new FlowLayout());
        operatorDecPanel.add(decAdd);
        operatorDecPanel.add(decSub);
        operatorDecPanel.add(decMul);
        operatorDecPanel.add(decDiv);

        final DecNum[] decimalNumber = {new DecNum(), new DecNum()};
        final DecNum[] resultDec = {new DecNum(), new DecNum()};
        DecimalCalculator decimalCalc = new DecimalCalculator();

        decAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decimalNumber[0] = new DecNum(dec1.getText());
                decimalNumber[1] = new DecNum(dec2.getText());
                if(decimalNumber[0].decNum.equals("Z") || decimalNumber[1].decNum.equals("Z")){
                    calcDecResult.setText("\nThe number need to be numeric.");
                    calcDecResult.setEnabled(false);
                    calcDecResult.setDisabledTextColor(Color.RED);
                } else {
                    resultDec[0] = decimalCalc.add(decimalNumber[0], decimalNumber[1]);
                    calcDecResult.setText("\nDecimal Value:\n " + decimalNumber[0].decNum + " + " +
                        decimalNumber[1].decNum + "\n = " + resultDec[0].decNum);
                    calcDecResult.setEnabled(false);
                    calcDecResult.setDisabledTextColor(Color.decode("#009900"));
                    calcDecResult.setLineWrap(true);
                    calcDecResult.setWrapStyleWord(true);
                }
            }
        });
        decSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decimalNumber[0] = new DecNum(dec1.getText());
                decimalNumber[1] = new DecNum(dec2.getText());
                if(decimalNumber[0].decNum.equals("Z") || decimalNumber[1].decNum.equals("Z")){
                    calcDecResult.setText("\nThe number need to be numeric.");
                    calcDecResult.setEnabled(false);
                    calcDecResult.setDisabledTextColor(Color.RED);
                } else {
                    resultDec[0] = decimalCalc.subtract(decimalNumber[0], decimalNumber[1]);
                    calcDecResult.setText("\nDecimal Value:\n " + decimalNumber[0].decNum + " - " +
                            decimalNumber[1].decNum + "\n = " + resultDec[0].decNum);
                    calcDecResult.setEnabled(false);
                    calcDecResult.setDisabledTextColor(Color.decode("#009900"));
                    calcDecResult.setLineWrap(true);
                    calcDecResult.setWrapStyleWord(true);
                }
            }
        });
        decMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decimalNumber[0] = new DecNum(dec1.getText());
                decimalNumber[1] = new DecNum(dec2.getText());
                if(decimalNumber[0].decNum.equals("Z") || decimalNumber[1].decNum.equals("Z")){
                    calcDecResult.setText("\nThe number need to be numeric.");
                    calcDecResult.setEnabled(false);
                    calcDecResult.setDisabledTextColor(Color.RED);
                } else {
                    resultDec[0] = decimalCalc.multiply(decimalNumber[0], decimalNumber[1]);
                    calcDecResult.setText("\nDecimal Value:\n " + decimalNumber[0].decNum + " * " +
                            decimalNumber[1].decNum + "\n = " + resultDec[0].decNum);
                    calcDecResult.setEnabled(false);
                    calcDecResult.setDisabledTextColor(Color.decode("#009900"));
                    calcDecResult.setLineWrap(true);
                    calcDecResult.setWrapStyleWord(true);
                }
            }
        });
        decDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decimalNumber[0] = new DecNum(dec1.getText());
                decimalNumber[1] = new DecNum(dec2.getText());
                if(decimalNumber[0].decNum.equals("Z") || decimalNumber[1].decNum.equals("Z")){
                    calcDecResult.setText("\nThe number need to be numeric.");
                    calcDecResult.setEnabled(false);
                    calcDecResult.setDisabledTextColor(Color.RED);
                } else {
                    if (decimalNumber[1].decNum.equals("0")){
                        calcDecResult.setText("\nThe divider cannot be zero.");
                        calcDecResult.setEnabled(false);
                        calcDecResult.setDisabledTextColor(Color.RED);
                    }else {
                        if (decimalCalc.remainder(decimalNumber[0], decimalNumber[1]).decNum.equals("0")) {
                            resultDec[0] = decimalCalc.divide(decimalNumber[0], decimalNumber[1]);
                            calcDecResult.setText("\nDecimal Value:\n " + decimalNumber[0].decNum + " / " +
                                    decimalNumber[1].decNum + "\n = " + resultDec[0].decNum);
                            calcDecResult.setEnabled(false);
                            calcDecResult.setDisabledTextColor(Color.decode("#009900"));
                            calcDecResult.setLineWrap(true);
                            calcDecResult.setWrapStyleWord(true);
                        } else {
                            resultDec[0] = decimalCalc.divide(decimalNumber[0], decimalNumber[1]);
                            resultDec[1] = decimalCalc.remainder(decimalNumber[0], decimalNumber[1]);
                            calcDecResult.setText("\nDecimal Value:\n " + decimalNumber[0].decNum + " / " +
                                    decimalNumber[1].decNum + "\n = " + resultDec[0].decNum
                                    + " Remainder: " + resultDec[1].decNum);
                            calcDecResult.setEnabled(false);
                            calcDecResult.setDisabledTextColor(Color.decode("#009900"));
                            calcDecResult.setLineWrap(true);
                            calcDecResult.setWrapStyleWord(true);
                        }
                    }
                }
            }
        });


        calcDecResult.setBorder(BorderFactory.createTitledBorder("Result"));
        calcDecResult.setFont(new Font("Serif", Font.BOLD, 16));

        //Binary converter panel
        convDecPanel.setLayout(new BoxLayout(convDecPanel, BoxLayout.Y_AXIS));
        convDecPanel.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        convDecPanel.add(convDecLabelPanel);
        convDecPanel.add(decNum);
        convDecPanel.add(convDec2BinBtnPanel);
        convDecPanel.add(convDec2BinResult);
        convDecPanel.add(convDec2HexBtnPanel);
        convDecPanel.add(convDec2HexResult);

        convDec2BinBtnPanel.setLayout(new FlowLayout());
        convDec2BinBtnPanel.add(dec2bin);
        convDec2HexBtnPanel.setLayout(new FlowLayout());
        convDec2HexBtnPanel.add(dec2hex);

        convDecLabelPanel.add(convDecLabel);
        convDecLabel.setFont(new Font("Serif", Font.BOLD, 20));
        convDecLabel.setForeground(Color.decode("#CC0066"));

        decNum.setBorder(BorderFactory.createTitledBorder("Enter Decimal Value"));
        decNum.setMaximumSize(new Dimension(Integer.MAX_VALUE, bin1.getPreferredSize().height));

        convDec2BinResult.setBorder(BorderFactory.createTitledBorder("Result"));
        convDec2BinResult.setFont(new Font("Serif", Font.BOLD, 16));
        convDec2HexResult.setBorder(BorderFactory.createTitledBorder("Result"));
        convDec2HexResult.setFont(new Font("Serif", Font.BOLD, 16));

        final HexNum[] dec2hexResult = {new HexNum()};
        final BinNum[] dec2binResult = {new BinNum()};
        BinaryCalculator decimalCalculator = new BinaryCalculator();
        dec2bin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decimalNumber[0] = new DecNum(decNum.getText());
                if(decimalNumber[0].decNum.equals("Z")){
                    convDec2BinResult.setText("\nThe number need to be numeric.");
                    convDec2BinResult.setEnabled(false);
                    convDec2BinResult.setDisabledTextColor(Color.RED);
                } else {
                    if (decimalNumber[0].decNum.startsWith("-")) {
                        dec2binResult[0] = decimalCalculator.Dec2Bin(decimalNumber[0]);
                        convDec2BinResult.setText("\nBinary Value: -" + dec2binResult[0].binNum);
                        convDec2BinResult.setEnabled(false);
                        convDec2BinResult.setDisabledTextColor(Color.decode("#009900"));
                        convDec2BinResult.setLineWrap(true);
                        convDec2BinResult.setWrapStyleWord(true);
                    } else {
                        dec2binResult[0] = decimalCalculator.Dec2Bin(decimalNumber[0]);
                        convDec2BinResult.setText("\nBinary Value: " + dec2binResult[0].binNum);
                        convDec2BinResult.setEnabled(false);
                        convDec2BinResult.setDisabledTextColor(Color.decode("#009900"));
                        convDec2BinResult.setLineWrap(true);
                        convDec2BinResult.setWrapStyleWord(true);
                    }
                }
            }
        });

        HexadecimalCalculator decimalCalculator2 = new HexadecimalCalculator();

        dec2hex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decimalNumber[0] = new DecNum(decNum.getText());
                if(decimalNumber[0].decNum.equals("Z")){
                    convDec2HexResult.setText("\nThe number need to be numeric.");
                    convDec2HexResult.setEnabled(false);
                    convDec2HexResult.setDisabledTextColor(Color.RED);
                } else {
                    if (decimalNumber[0].decNum.startsWith("-")){
                        dec2hexResult[0] = decimalCalculator2.Dec2Hex(decimalNumber[0]);
                        convDec2HexResult.setText("\nHexadecimal Value: -" + dec2hexResult[0].hexNum);
                        convDec2HexResult.setEnabled(false);
                        convDec2HexResult.setDisabledTextColor(Color.decode("#009900"));
                        convDec2HexResult.setLineWrap(true);
                        convDec2HexResult.setWrapStyleWord(true);
                    } else {
                        dec2hexResult[0] = decimalCalculator2.Dec2Hex(decimalNumber[0]);
                        convDec2HexResult.setText("\nHexadecimal Value: " + dec2hexResult[0].hexNum);
                        convDec2HexResult.setEnabled(false);
                        convDec2HexResult.setDisabledTextColor(Color.decode("#009900"));
                        convDec2HexResult.setLineWrap(true);
                        convDec2HexResult.setWrapStyleWord(true);
                    }
                }
            }
        });
    }

    private void HexadecimalView() {
        hexPanel.setBorder(new EmptyBorder(10,10,10,10));
        hexPanel.setLayout(new GridLayout(1,2,10,10));
        hexPanel.add(calcHexPanel);
        hexPanel.add(convHexPanel);

        calcHexPanel.setLayout(new BoxLayout(calcHexPanel, BoxLayout.Y_AXIS));
        calcHexPanel.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        calcHexPanel.add(calcHexLabelPanel);
        calcHexPanel.add(hex1);
        calcHexPanel.add(hex2);
        calcHexPanel.add(operatorHexPanel);
        calcHexPanel.add(calcHexResult);

        calcHexLabelPanel.add(calcHexLabel);

        calcHexLabel.setFont(new Font("Serif", Font.BOLD, 20));
        calcHexLabel.setForeground(Color.decode("#666600"));

        hex1.setBorder(BorderFactory.createTitledBorder("Enter First Hexadecimal Value"));
        hex2.setBorder(BorderFactory.createTitledBorder("Enter Second Hexadecimal Value"));
        hex1.setMaximumSize(new Dimension(Integer.MAX_VALUE, hex1.getPreferredSize().height));
        hex2.setMaximumSize(new Dimension(Integer.MAX_VALUE, hex1.getPreferredSize().height));

        operatorHexPanel.setLayout(new FlowLayout());
        operatorHexPanel.add(hexAdd);
        operatorHexPanel.add(hexSub);
        operatorHexPanel.add(hexMul);
        operatorHexPanel.add(hexDiv);

        final HexNum[] hexNumber = {new HexNum(), new HexNum()};
        final HexNum[] resultHex = {new HexNum(), new HexNum()};
        final DecNum[] hex2decResult = {new DecNum()};
        final BigIntNum[] hex2bigIntResult = {new BigIntNum()};
        HexadecimalCalculator hexCalculator = new HexadecimalCalculator();
        hexAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hexNumber[0] = new HexNum(hex1.getText());
                hexNumber[1] = new HexNum(hex2.getText());
                if(hexNumber[0].hexNum.equals("Z") || hexNumber[1].hexNum.equals("Z")){
                    calcHexResult.setText("\nThe number need to contain 0-9 and A-F only.");
                    calcHexResult.setEnabled(false);
                    calcHexResult.setDisabledTextColor(Color.RED);
                } else {
                    resultHex[0] = hexCalculator.add(hexNumber[0], hexNumber[1]);
                    calcHexResult.setText("\nHexadecimal Value:\n " + hexNumber[0].hexNum + " + " +
                            hexNumber[1].hexNum + "\n = " + resultHex[0].hexNum);
                    calcHexResult.setEnabled(false);
                    calcHexResult.setDisabledTextColor(Color.decode("#009900"));
                    calcHexResult.setLineWrap(true);
                    calcHexResult.setWrapStyleWord(true);
                }
            }
        });
        hexSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hexNumber[0] = new HexNum(hex1.getText());
                hexNumber[1] = new HexNum(hex2.getText());
                if(hexNumber[0].hexNum.equals("Z") || hexNumber[1].hexNum.equals("Z")){
                    calcHexResult.setText("\nThe number need to contain 0-9 and A-F only.");
                    calcHexResult.setEnabled(false);
                    calcHexResult.setDisabledTextColor(Color.RED);
                } else {
                    resultHex[0] = hexCalculator.subtract(hexNumber[0], hexNumber[1]);
//                    BigInteger result = new BigInteger(String.valueOf
//                            (new BigInteger(hexNumber[0].hexNum).divide(new BigInteger(hexNumber[1].hexNum))));
//                    if (result.equals(BigInteger.ZERO)){
//                        calcHexResult.setText("\nHexadecimal Value:\n " + hexNumber[0].hexNum + " - " +
//                                hexNumber[1].hexNum + "\n = -" + resultHex[0].hexNum);
//                        calcHexResult.setEnabled(false);
//                        calcHexResult.setDisabledTextColor(Color.decode("#009900"));
//                    } else {
                        calcHexResult.setText("\nHexadecimal Value:\n " + hexNumber[0].hexNum + " - " +
                                hexNumber[1].hexNum + "\n = " + resultHex[0].hexNum);
                        calcHexResult.setEnabled(false);
                        calcHexResult.setDisabledTextColor(Color.decode("#009900"));
                    calcHexResult.setLineWrap(true);
                    calcHexResult.setWrapStyleWord(true);
 //                   }
                }
            }
        });
        hexMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hexNumber[0] = new HexNum(hex1.getText());
                hexNumber[1] = new HexNum(hex2.getText());
                if(hexNumber[0].hexNum.equals("Z") || hexNumber[1].hexNum.equals("Z")){
                    calcHexResult.setText("\nThe number need to contain 0-9 and A-F only.");
                    calcHexResult.setEnabled(false);
                    calcHexResult.setDisabledTextColor(Color.RED);
                } else {
                    resultHex[0] = hexCalculator.multiply(hexNumber[0], hexNumber[1]);
                    calcHexResult.setText("\nHexadecimal Value:\n " + hexNumber[0].hexNum + " * " +
                            hexNumber[1].hexNum + "\n = " + resultHex[0].hexNum);
                    calcHexResult.setEnabled(false);
                    calcHexResult.setDisabledTextColor(Color.decode("#009900"));
                    calcHexResult.setLineWrap(true);
                    calcHexResult.setWrapStyleWord(true);
                }
            }
        });
        hexDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hexNumber[0] = new HexNum(hex1.getText());
                hexNumber[1] = new HexNum(hex2.getText());
                if(hexNumber[0].hexNum.equals("Z") || hexNumber[1].hexNum.equals("Z")){
                    calcHexResult.setText("\nThe number need to contain 0-9 and A-F only.");
                    calcHexResult.setEnabled(false);
                    calcHexResult.setDisabledTextColor(Color.RED);
                } else {
                    if (hexNumber[1].hexNum.equals("0")){
                        calcHexResult.setText("\nThe divider cannot be zero.");
                        calcHexResult.setEnabled(false);
                        calcHexResult.setDisabledTextColor(Color.RED);
                    } else if (hexCalculator.remainder(hexNumber[0], hexNumber[1]).hexNum.equals("0")) {
                        resultHex[0] = hexCalculator.divide(hexNumber[0], hexNumber[1]);
                        calcHexResult.setText("\nHexadecimal Value:\n " + hexNumber[0].hexNum + " / " +
                                hexNumber[1].hexNum + "\n = " + resultHex[0].hexNum);
                        calcHexResult.setEnabled(false);
                        calcHexResult.setDisabledTextColor(Color.decode("#009900"));
                        calcHexResult.setLineWrap(true);
                        calcHexResult.setWrapStyleWord(true);
                    } else {
                        resultHex[0] = hexCalculator.divide(hexNumber[0], hexNumber[1]);
                        resultHex[1] = hexCalculator.remainder(hexNumber[0], hexNumber[1]);
                        calcHexResult.setText("\nHexadecimal Value:\n " + hexNumber[0].hexNum + " / " +
                                hexNumber[1].hexNum + "\n = " + resultHex[0].hexNum
                                + " Remainder: " + resultHex[1].hexNum);
                        calcHexResult.setEnabled(false);
                        calcHexResult.setDisabledTextColor(Color.decode("#009900"));
                        calcHexResult.setLineWrap(true);
                        calcHexResult.setWrapStyleWord(true);
                    }
                }
            }
        });

        calcHexResult.setBorder(BorderFactory.createTitledBorder("Result"));
        calcHexResult.setFont(new Font("Serif", Font.BOLD, 16));

        //Binary converter panel
        convHexPanel.setLayout(new BoxLayout(convHexPanel, BoxLayout.Y_AXIS));
        convHexPanel.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        convHexPanel.add(convHexLabelPanel);
        convHexPanel.add(hexNum);
        convHexPanel.add(convHex2DecBtnPanel);
        convHexPanel.add(convHex2DecResult);
        convHexPanel.add(convHex2BigIntBtnPanel);
        convHexPanel.add(convHex2BigIntResult);

        convHex2DecBtnPanel.setLayout(new FlowLayout());
        convHex2DecBtnPanel.add(hex2dec);
        convHex2BigIntBtnPanel.setLayout(new FlowLayout());
        convHex2BigIntBtnPanel.add(hex2bigInt);

        convHexLabelPanel.add(convHexLabel);
        convHexLabel.setFont(new Font("Serif", Font.BOLD, 20));
        convHexLabel.setForeground(Color.decode("#666600"));

        hexNum.setBorder(BorderFactory.createTitledBorder("Enter Hexadecimal Value"));
        hexNum.setMaximumSize(new Dimension(Integer.MAX_VALUE, bin1.getPreferredSize().height));

        convHex2DecResult.setBorder(BorderFactory.createTitledBorder("Result"));
        convHex2DecResult.setFont(new Font("Serif", Font.BOLD, 16));
        convHex2BigIntResult.setBorder(BorderFactory.createTitledBorder("Result"));
        convHex2BigIntResult.setFont(new Font("Serif", Font.BOLD, 16));

        hex2dec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hexNumber[0] = new HexNum(hexNum.getText());
                if(hexNumber[0].hexNum.equals("Z")){
                    convHex2DecResult.setText("\nThe number need to contain 0-9 and A-F only.");
                    convHex2DecResult.setEnabled(false);
                    convHex2DecResult.setDisabledTextColor(Color.RED);
                } else {
                    hex2decResult[0] = hexCalculator.Hex2Dec(hexNumber[0]);
                    convHex2DecResult.setText("\nDecimal Value: " + hex2decResult[0].decNum);
                    convHex2DecResult.setEnabled(false);
                    convHex2DecResult.setDisabledTextColor(Color.decode("#009900"));
                    convHex2DecResult.setLineWrap(true);
                    convHex2DecResult.setWrapStyleWord(true);
                }
            }
        });
        hex2bigInt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hexNumber[0] = new HexNum(hexNum.getText());
                if(hexNumber[0].hexNum.equals("Z")){
                    convHex2BigIntResult.setText("\nThe number need to contain 0-9 and A-F only.");
                    convHex2BigIntResult.setEnabled(false);
                    convHex2BigIntResult.setDisabledTextColor(Color.RED);
                } else {
                    hex2bigIntResult[0] = hexCalculator.Hex2BigInt(hexNumber[0]);
                    convHex2BigIntResult.setText("\nBig Integer Value: " + hex2bigIntResult[0].bigIntNum);
                    convHex2BigIntResult.setEnabled(false);
                    convHex2BigIntResult.setDisabledTextColor(Color.decode("#009900"));
                    convHex2BigIntResult.setLineWrap(true);
                    convHex2BigIntResult.setWrapStyleWord(true);
                }
            }
        });
    }

    private void MainPanelView() {
        calcPanel.setLayout(new BoxLayout(calcPanel, BoxLayout.Y_AXIS));
        calcPanel.setBorder(new EmptyBorder(20,100,50,100));
        calcPanel.add(calcLabel);
        calcLabel.setFont(new Font("Serif", Font.BOLD, 28));
        calcLabel.setForeground(Color.BLUE);
        calcLabel.setMaximumSize(getMaximumSize());

        calcPanel.add(binBtn);
        binBtn.setMaximumSize(getMaximumSize());
        binBtn.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        binBtn.setFont(new Font("Serif", Font.BOLD, 20));
        binBtn.setForeground(Color.decode("#006600"));
        binBtn.setBackground(Color.decode("#E5FFCC"));
        binBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(1);
            }
        });

        calcPanel.add(hexBtn);
        hexBtn.setMaximumSize(getMaximumSize());
        hexBtn.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        hexBtn.setFont(new Font("Serif", Font.BOLD, 20));
        hexBtn.setForeground(Color.decode("#666600"));
        hexBtn.setBackground(Color.decode("#FFCCCC"));
        hexBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(2);
            }
        });

        calcPanel.add(decBtn);
        decBtn.setMaximumSize(getMaximumSize());
        decBtn.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        decBtn.setFont(new Font("Serif", Font.BOLD, 20));
        decBtn.setForeground(Color.decode("#CC0066"));
        decBtn.setBackground(Color.decode("#FFCCE5"));
        decBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(3);
            }
        });

        calcPanel.add(bigIntBtn);
        bigIntBtn.setMaximumSize(getMaximumSize());
        bigIntBtn.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        bigIntBtn.setFont(new Font("Serif", Font.BOLD, 20));
        bigIntBtn.setForeground(Color.decode("#000066"));
        bigIntBtn.setBackground(Color.decode("#CCFFFF"));
        bigIntBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(4);
            }
        });

        calcPanel.add(bWidthBtn);
        bWidthBtn.setMaximumSize(getMaximumSize());
        bWidthBtn.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        bWidthBtn.setFont(new Font("Serif", Font.BOLD, 20));
        bWidthBtn.setForeground(Color.decode("#FF8000"));
        bWidthBtn.setBackground(Color.decode("#FFFFCC"));
        bWidthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(5);
            }
        });
    }

    private void BinaryView() {
        binPanel.setBorder(new EmptyBorder(10,10,10,10));
        binPanel.setLayout(new GridLayout(1,2,10,10));
        binPanel.add(calcBinPanel);
        binPanel.add(convBinPanel);

        // Add all panel on the main panel
        calcBinPanel.setLayout(new BoxLayout(calcBinPanel, BoxLayout.Y_AXIS));
        calcBinPanel.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        calcBinPanel.add(calcBinLabelPanel);
        calcBinPanel.add(bin1);
        calcBinPanel.add(bin2);
        calcBinPanel.add(operatorPanel);
        calcBinPanel.add(calcBinResult);

        //Set header label
        calcBinLabelPanel.add(calcBinLabel);
        calcBinLabel.setFont(new Font("Serif", Font.BOLD, 20));
        calcBinLabel.setForeground(Color.decode("#006600"));

        //Set input contents
        bin1.setBorder(BorderFactory.createTitledBorder("Enter First Binary Value"));
        bin2.setBorder(BorderFactory.createTitledBorder("Enter Second Binary Value"));
        bin1.setMaximumSize(new Dimension(Integer.MAX_VALUE, bin1.getPreferredSize().height));
        bin2.setMaximumSize(new Dimension(Integer.MAX_VALUE, bin1.getPreferredSize().height));


        //Set operator contents
        operatorPanel.setLayout(new FlowLayout());
        operatorPanel.add(binAdd);
        operatorPanel.add(binSub);
        operatorPanel.add(binMul);
        operatorPanel.add(binDiv);
        final BinNum[] binaryNumber = {new BinNum(), new BinNum()};
        final BinNum[] resultBin = {new BinNum(), new BinNum()};
        final DecNum[] bin2decResult = {new DecNum()};
        final BigIntNum[] bin2bigIntResult = {new BigIntNum()};
        BinaryCalculator binaryCalculator = new BinaryCalculator();
        binAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                binaryNumber[0] = new BinNum(bin1.getText());
                binaryNumber[1] = new BinNum(bin2.getText());
                if(binaryNumber[0].binNum.equals("Z") || binaryNumber[1].binNum.equals("Z")){
                    calcBinResult.setText("\nThe number need to contain 0 and 1 only.");
                    calcBinResult.setEnabled(false);
                    calcBinResult.setDisabledTextColor(Color.RED);
                } else {
                    resultBin[0] = binaryCalculator.add(binaryNumber[0], binaryNumber[1]);
                    calcBinResult.setText("\nBinary Value:\n " + binaryNumber[0].binNum + " + " +
                                    binaryNumber[1].binNum + "\n = " + resultBin[0].binNum);
                    calcBinResult.setEnabled(false);
                    calcBinResult.setDisabledTextColor(Color.decode("#009900"));
                    calcBinResult.setLineWrap(true);
                    calcBinResult.setWrapStyleWord(true);
                }
            }
        });
        binSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                binaryNumber[0] = new BinNum(bin1.getText());
                binaryNumber[1] = new BinNum(bin2.getText());
                if(binaryNumber[0].binNum.equals("Z") || binaryNumber[1].binNum.equals("Z")){
                    calcBinResult.setText("\nThe number need to contain 0 and 1 only.");
                    calcBinResult.setEnabled(false);
                    calcBinResult.setDisabledTextColor(Color.RED);
                } else {
                    resultBin[0] = binaryCalculator.subtract(binaryNumber[0], binaryNumber[1]);
                    BigInteger result = new BigInteger(String.valueOf
                            (new BigInteger(binaryNumber[0].binNum).divide(new BigInteger(binaryNumber[1].binNum))));
                    if (result.equals(BigInteger.ZERO)){
                        calcBinResult.setText("\nBinary Value:\n " + binaryNumber[0].binNum + " - " +
                                binaryNumber[1].binNum + "\n = -" + resultBin[0].binNum);
                        calcBinResult.setEnabled(false);
                        calcBinResult.setDisabledTextColor(Color.decode("#009900"));
                        calcBinResult.setLineWrap(true);
                        calcBinResult.setWrapStyleWord(true);
                    } else {
                        calcBinResult.setText("\nBinary Value:\n " + binaryNumber[0].binNum + " - " +
                                binaryNumber[1].binNum + "\n = " + resultBin[0].binNum);
                        calcBinResult.setEnabled(false);
                        calcBinResult.setDisabledTextColor(Color.decode("#009900"));
                        calcBinResult.setLineWrap(true);
                        calcBinResult.setWrapStyleWord(true);
                    }
                }
            }
        });
        binMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                binaryNumber[0] = new BinNum(bin1.getText());
                binaryNumber[1] = new BinNum(bin2.getText());
                if(binaryNumber[0].binNum.equals("Z") || binaryNumber[1].binNum.equals("Z")){
                    calcBinResult.setText("\nThe number need to contain 0 and 1 only.");
                    calcBinResult.setEnabled(false);
                    calcBinResult.setDisabledTextColor(Color.RED);
                } else {
                    resultBin[0] = binaryCalculator.multiply(binaryNumber[0], binaryNumber[1]);
                    calcBinResult.setText("\nBinary Value:\n " + binaryNumber[0].binNum + " * " +
                            binaryNumber[1].binNum + "\n = " + resultBin[0].binNum);
                    calcBinResult.setEnabled(false);
                    calcBinResult.setDisabledTextColor(Color.decode("#009900"));
                    calcBinResult.setLineWrap(true);
                    calcBinResult.setWrapStyleWord(true);
                }
            }
        });
        binDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                binaryNumber[0] = new BinNum(bin1.getText());
                binaryNumber[1] = new BinNum(bin2.getText());
                if(binaryNumber[0].binNum.equals("Z") || binaryNumber[1].binNum.equals("Z")){
                    calcBinResult.setText("\nThe number need to contain 0 and 1 only.");
                    calcBinResult.setEnabled(false);
                    calcBinResult.setDisabledTextColor(Color.RED);
                } else {
                    if (binaryNumber[1].binNum.equals("0")){
                        calcBinResult.setText("\nThe divider cannot be zero.");
                        calcBinResult.setEnabled(false);
                        calcBinResult.setDisabledTextColor(Color.RED);
                    } else if (binaryCalculator.remainder(binaryNumber[0], binaryNumber[1]).binNum.equals("0")) {
                        resultBin[0] = binaryCalculator.divide(binaryNumber[0], binaryNumber[1]);
                        calcBinResult.setText("\nBinary Value:\n " + binaryNumber[0].binNum + " / " +
                                binaryNumber[1].binNum + "\n = " + resultBin[0].binNum);
                        calcBinResult.setEnabled(false);
                        calcBinResult.setDisabledTextColor(Color.decode("#009900"));
                        calcBinResult.setLineWrap(true);
                        calcBinResult.setWrapStyleWord(true);
                    } else {
                        resultBin[0] = binaryCalculator.divide(binaryNumber[0], binaryNumber[1]);
                        resultBin[1] = binaryCalculator.remainder(binaryNumber[0], binaryNumber[1]);
                        calcBinResult.setText("\nBinary Value:\n " + binaryNumber[0].binNum + " / " +
                                binaryNumber[1].binNum + "\n = " + resultBin[0].binNum
                                + " Remainder: " + resultBin[1].binNum);
                        calcBinResult.setEnabled(false);
                        calcBinResult.setDisabledTextColor(Color.decode("#009900"));
                        calcBinResult.setLineWrap(true);
                        calcBinResult.setWrapStyleWord(true);
                    }
                }
            }
        });

        //set calculator result
        calcBinResult.setBorder(BorderFactory.createTitledBorder("Result"));
        calcBinResult.setFont(new Font("Serif", Font.BOLD, 16));


        //Binary converter panel
        convBinPanel.setLayout(new BoxLayout(convBinPanel, BoxLayout.Y_AXIS));
        convBinPanel.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        convBinPanel.add(convBinLabelPanel);
        convBinPanel.add(binNum);
        convBinPanel.add(convBin2DecBtnPanel);
        convBinPanel.add(convBin2DecResult);
        convBinPanel.add(convBin2BigIntBtnPanel);
        convBinPanel.add(convBin2BigIntResult);

        convBin2DecBtnPanel.setLayout(new FlowLayout());
        convBin2DecBtnPanel.add(bin2dec);
        convBin2BigIntBtnPanel.setLayout(new FlowLayout());
        convBin2BigIntBtnPanel.add(bin2bigInt);


        convBinLabelPanel.add(convBinLabel);
        convBinLabel.setFont(new Font("Serif", Font.BOLD, 20));
        convBinLabel.setForeground(Color.decode("#006600"));

        binNum.setBorder(BorderFactory.createTitledBorder("Enter Binary Value"));
        binNum.setMaximumSize(new Dimension(Integer.MAX_VALUE, bin1.getPreferredSize().height));

        convBin2DecResult.setBorder(BorderFactory.createTitledBorder("Result"));
        convBin2DecResult.setFont(new Font("Serif", Font.BOLD, 16));
        convBin2BigIntResult.setBorder(BorderFactory.createTitledBorder("Result"));
        convBin2BigIntResult.setFont(new Font("Serif", Font.BOLD, 16));

        bin2dec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                binaryNumber[0] = new BinNum(binNum.getText());
                if(binaryNumber[0].binNum.equals("Z")){
                    convBin2DecResult.setText("\nThe number need to contain 0 and 1 only.");
                    convBin2DecResult.setEnabled(false);
                    convBin2DecResult.setDisabledTextColor(Color.RED);
                } else {
                    bin2decResult[0] = binaryCalculator.Bin2Dec(binaryNumber[0]);
                    convBin2DecResult.setText(String.valueOf(bin2decResult[0].decNum));
                    convBin2DecResult.setEnabled(false);
                    convBin2DecResult.setDisabledTextColor(Color.decode("#009900"));
                    convBin2DecResult.setLineWrap(true);
                    convBin2DecResult.setWrapStyleWord(true);
                }
            }
        });
        bin2bigInt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                binaryNumber[0] = new BinNum(binNum.getText());
                if(binaryNumber[0].binNum.equals("Z")){
                    convBin2BigIntResult.setText("\nThe number need to contain 0 and 1 only.");
                    convBin2BigIntResult.setEnabled(false);
                    convBin2BigIntResult.setDisabledTextColor(Color.RED);
                } else {
                    bin2bigIntResult[0] = binaryCalculator.Bin2BigInt(binaryNumber[0]);
                    convBin2BigIntResult.setText(String.valueOf(bin2bigIntResult[0].bigIntNum));
                    convBin2BigIntResult.setEnabled(false);
                    convBin2BigIntResult.setDisabledTextColor(Color.decode("#009900"));
                    convBin2BigIntResult.setLineWrap(true);
                    convBin2BigIntResult.setWrapStyleWord(true);

                }
            }
        });
    }

    JTabbedPane tabbedPane = new JTabbedPane();

    //first tab item
    JPanel calcPanel = new JPanel();
    JPanel binPanel = new JPanel();
    JPanel hexPanel = new JPanel();
    JPanel decPanel = new JPanel();
    JPanel bigIntPanel = new JPanel();
    JPanel bandwidthPanel = new JPanel();
    JButton binBtn = new JButton("Binary Calculator");
    JButton hexBtn = new JButton("Hexadecimal Calculator");
    JButton decBtn = new JButton("Decimal Calculator");
    JButton bigIntBtn = new JButton("Big Integer Calculator");
    JButton bWidthBtn = new JButton("Bandwidth Calculator");

    // contents in Calculator panel
    JLabel calcLabel = new JLabel("Multi-functions Calculator", SwingConstants.CENTER);

    //contents in Binary Calculator
    JPanel convBinPanel = new JPanel();
    JPanel calcBinPanel = new JPanel();

    //Binary calculator panel contents
    JTextField bin1 = new JTextField();
    JTextField bin2 = new JTextField();

    JPanel operatorPanel = new JPanel();
    JButton binAdd = new JButton("+");
    JButton binSub = new JButton("-");
    JButton binMul = new JButton("*");
    JButton binDiv = new JButton("/");

    JTextArea calcBinResult = new JTextArea();

    JLabel calcBinLabel = new JLabel("Binary Calculator", SwingConstants.CENTER);
    JPanel calcBinLabelPanel = new JPanel();
    JLabel convBinLabel = new JLabel("Binary Converter", SwingConstants.CENTER);
    JPanel convBinLabelPanel = new JPanel();



    // contents in Binary converter
    JTextField binNum = new JTextField();
    JPanel convBin2DecBtnPanel = new JPanel();
    JButton bin2dec = new JButton("Convert to Decimal Value");
    JTextArea convBin2DecResult = new JTextArea();
    JPanel convBin2BigIntBtnPanel = new JPanel();
    JButton bin2bigInt = new JButton("Convert to Big Integer Value");
    JTextArea convBin2BigIntResult = new JTextArea();

    //contents in Hexadecimal Calculator
    JPanel convHexPanel = new JPanel();
    JPanel calcHexPanel = new JPanel();

    //Hex calculator panel contents
    JTextField hex1 = new JTextField();
    JTextField hex2 = new JTextField();

    JPanel operatorHexPanel = new JPanel();
    JButton hexAdd = new JButton("+");
    JButton hexSub = new JButton("-");
    JButton hexMul = new JButton("*");
    JButton hexDiv = new JButton("/");

    JTextArea calcHexResult = new JTextArea();

    JLabel calcHexLabel = new JLabel("Hexadecimal Calculator", SwingConstants.CENTER);
    JPanel calcHexLabelPanel = new JPanel();
    JLabel convHexLabel = new JLabel("Hexadecimal Converter", SwingConstants.CENTER);
    JPanel convHexLabelPanel = new JPanel();

    // contents in Hex converter
    JTextField hexNum = new JTextField();
    JPanel convHex2DecBtnPanel = new JPanel();
    JButton hex2dec = new JButton("Convert to Decimal Value");
    JTextArea convHex2DecResult = new JTextArea();
    JPanel convHex2BigIntBtnPanel = new JPanel();
    JButton hex2bigInt = new JButton("Convert to Big Integer Value");
    JTextArea convHex2BigIntResult = new JTextArea();


    //contents in Decimal Calculator
    JPanel convDecPanel = new JPanel();
    JPanel calcDecPanel = new JPanel();

    //Dec calculator panel contents
    JTextField dec1 = new JTextField();
    JTextField dec2 = new JTextField();

    JPanel operatorDecPanel = new JPanel();
    JButton decAdd = new JButton("+");
    JButton decSub = new JButton("-");
    JButton decMul = new JButton("*");
    JButton decDiv = new JButton("/");

    JTextArea calcDecResult = new JTextArea();

    JLabel calcDecLabel = new JLabel("Decimal Calculator", SwingConstants.CENTER);
    JPanel calcDecLabelPanel = new JPanel();
    JLabel convDecLabel = new JLabel("Decimal Converter", SwingConstants.CENTER);
    JPanel convDecLabelPanel = new JPanel();

    // contents in Dec converter
    JTextField decNum = new JTextField();
    JPanel convDec2BinBtnPanel = new JPanel();
    JButton dec2bin = new JButton("Convert to Binary Value");
    JTextArea convDec2BinResult = new JTextArea();

    JPanel convDec2HexBtnPanel = new JPanel();
    JButton dec2hex = new JButton("Convert to Hexadecimal Value");
    JTextArea convDec2HexResult = new JTextArea();

    //contents in Big Integer Calculator
    JPanel convBigIntPanel = new JPanel();
    JPanel calcBigIntPanel = new JPanel();

    //Big Int calculator panel contents
    JTextField bigInt1 = new JTextField();
    JTextField bigInt2 = new JTextField();

    JPanel operatorBigIntPanel = new JPanel();
    JButton bigIntAdd = new JButton("+");
    JButton bigIntSub = new JButton("-");
    JButton bigIntMul = new JButton("*");
    JButton bigIntDiv = new JButton("/");

    JTextArea calcBigIntResult = new JTextArea();

    JLabel calcBigIntLabel = new JLabel("Big Integer Calculator", SwingConstants.CENTER);
    JPanel calcBigIntLabelPanel = new JPanel();
    JLabel convBigIntLabel = new JLabel("Big Integer Converter", SwingConstants.CENTER);
    JPanel convBigIntLabelPanel = new JPanel();

    // contents in Big Int converter
    JTextField bigIntNum = new JTextField();
    JPanel convBigInt2BinBtnPanel = new JPanel();
    JButton bigInt2bin = new JButton("Convert to Binary Value");
    JTextArea convBigInt2BinResult = new JTextArea();

    JPanel convBigInt2HexBtnPanel = new JPanel();
    JButton bigInt2hex = new JButton("Convert to Hexadecimal Value");
    JTextArea convBigInt2HexResult = new JTextArea();

    //Bandwidth calculator contents
    JPanel upperPanel = new JPanel();
    JPanel lowerPanel = new JPanel();
    JPanel convDataUnitPanel = new JPanel();
    JPanel calcWebBWidthPanel = new JPanel();
    JPanel calcDownloadUploadTimePanel = new JPanel();
    JPanel convHostBWidth = new JPanel();

    //Data Unit Converter
    JPanel dataUnitLabelPanel = new JPanel();
    JLabel convDataUnitLabel = new JLabel("Data Unit Converter", SwingConstants.CENTER);

    JPanel panel11 = new JPanel();
    JTextField dataUnit = new JTextField();
    String[] dataUnitStr = { "bits (b)", "kilobits (kb)", "megabits (mb)", "gigabits (gb)", "terabits (tb)" ,
            "Bytes (B)" , "Kilobytes (KB)" , "Megabytes (MB)" , "Gigabytes (GB)" , "Terabytes (TB)"};
    JComboBox dataUnitList = new JComboBox(dataUnitStr);

    JPanel panel12 = new JPanel();
    JButton dataUnitBtn = new JButton("Calculate");

    JTextArea dataUnitResult = new JTextArea();

    //Website Bandwidth Calculator
    JPanel webBWidthPanel = new JPanel();
    JLabel webBWidthLabel = new JLabel("Website Bandwidth Calculator", SwingConstants.CENTER);

    JPanel panel21 = new JPanel();
    JLabel pViewLabel = new JLabel("  Page Views");
    JTextField pViewTField = new JTextField();
    String[] pViewUnit = {"Per Second", "Per Minute", "Per Hour", "Per Day", "Per Week", "Per Month", "Per Year"};
    JComboBox pViewUnitList = new JComboBox(pViewUnit);
    JLabel avgPSizeLabel = new JLabel("  Average Page Size");
    JTextField avgPSizeTField = new JTextField();
    String[] avgPSizeUnit = {"Bytes (B)" , "Kilobytes (KB)" , "Megabytes (MB)" , "Gigabytes (GB)" , "Terabytes (TB)"};
    JComboBox avgPSizeUnitList = new JComboBox(avgPSizeUnit);
    JLabel rFactorLabel = new JLabel("  Redundancy Factor");
    JTextField rFactorTField = new JTextField();

    JPanel panel22 = new JPanel();
    JButton calcWebBWidthBtn = new JButton("Calculate");

    JTextArea calcWebBWidthResult = new JTextArea();

    //Download/Upload Time Calculator contents
    JPanel downUpTimePanel = new JPanel();
    JLabel downUpTimeLabel = new JLabel("Download/Upload Time Calculator", SwingConstants.CENTER);

    JPanel panel31 = new JPanel();
    JLabel fileSizeLabel = new JLabel("  File Size");
    JTextField fileSizeTField = new JTextField();
    String[] fileSizeUnit = {"Bytes (B)" , "Kilobytes (KB)" , "Megabytes (MB)" , "Gigabytes (GB)" , "Terabytes (TB)"};
    JComboBox fileSizeUnitList = new JComboBox(fileSizeUnit);
    JLabel bWidthLabel = new JLabel("  Bandwidth");
    JTextField bWidthTField = new JTextField();
    String[] bWidthUnit = {"bit/s" , "Kbit/s" , "Mbit/s" , "Gbit/s" , "Tbit/s"};
    JComboBox bWidthUnitList = new JComboBox(bWidthUnit);

    JPanel panel32 = new JPanel();
    JButton calcUpDownTimeBtn = new JButton("Calculate");

    JTextArea calcUpDownTimeResult = new JTextArea();

    //Hosting Bandwidth Converter
    JPanel hostBWidthPanel = new JPanel();
    JLabel hostBWidthLabel = new JLabel("Hosting Bandwidth Converter", SwingConstants.CENTER);

    JPanel panel41 = new JPanel();
    JLabel MUsageLabel = new JLabel("  Monthly Usage");
    JTextField MUsageTField = new JTextField();
    String[] MUsageUnit = {"Bytes (B)" , "Kilobytes (KB)" , "Megabytes (MB)" , "Gigabytes (GB)" , "Terabytes (TB)"};
    JComboBox MUsageUnitList = new JComboBox(MUsageUnit);
    String[] BWUnit = {"bit/s" , "Kbit/s" , "Mbit/s" , "Gbit/s" , "Tbit/s"};
    JComboBox BWUnitList = new JComboBox(BWUnit);


    JPanel panel42 = new JPanel();
    JButton MUsage2BWidthBtn = new JButton("Convert to Bandwidth");

    JTextArea MUsage2BWidthResult = new JTextArea();

    JPanel panel43 = new JPanel();
    JLabel BWidthLabel = new JLabel("  Bandwidth");
    JTextField BWidthTField = new JTextField();
    String[] BWidthUnit = {"bit/s" , "Kbit/s" , "Mbit/s" , "Gbit/s" , "Tbit/s"};
    JComboBox BWidthUnitList = new JComboBox(BWidthUnit);
    String[] MUnit = {"Bytes (B)" , "Kilobytes (KB)" , "Megabytes (MB)" , "Gigabytes (GB)" , "Terabytes (TB)"};
    JComboBox MUnitList = new JComboBox(MUnit);


    JPanel panel44 = new JPanel();
    JButton BWidth2MUsageBtn = new JButton("Convert to Monthly Usage");

    JTextArea BWidth2MUsageResult = new JTextArea();

}

