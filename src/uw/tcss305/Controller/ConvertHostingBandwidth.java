package uw.tcss305.Controller;

import uw.tcss305.Model.CalcTime;
import uw.tcss305.Model.DataUnit;

public class ConvertHostingBandwidth extends BandwidthCalculator {

    public static void main(String[] args) {
        System.out.println(ConvertBWidth2MUsage(1,"1",3));

    }

    //Convert Monthly usage to Bandwidth
    public static double ConvertMUsage2BWidth(int unit1, String num, int unit2) {
        try {
            Double.parseDouble(num);
            double MUsage = Double.parseDouble(num);
            double BWidth = 0;
            if (MUsage <= 0) {
                return  -1;
            } else {
                switch (unit1){
                    case 1: //from Byte/Month
                        switch (unit2){
                            case 1: //bit/s
                                BWidth = DataUnit.B2b.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 2: //kbit/s
                                BWidth = DataUnit.B2kb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 3: //mbit/s
                                BWidth = DataUnit.B2mb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 4: //gbit/s
                                BWidth = DataUnit.B2gb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 5: //tbit/s
                                BWidth = DataUnit.B2tb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                BWidth = Math.sqrt(-1);
                                break;

                        }
                        break;

                    case 2: //from KByte/Month
                        switch (unit2){
                            case 1: //bit/s
                                BWidth = DataUnit.KB2b.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 2: //kbit/s
                                BWidth = DataUnit.KB2kb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 3: //mbit/s
                                BWidth = DataUnit.KB2mb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 4: //gbit/s
                                BWidth = DataUnit.KB2gb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 5: //tbit/s
                                BWidth = DataUnit.KB2tb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                BWidth = Math.sqrt(-1);
                                break;

                        }
                        break;

                    case 3: //from MByte/Month
                        switch (unit2){
                            case 1: //bit/s
                                BWidth = DataUnit.MB2b.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 2: //kbit/s
                                BWidth = DataUnit.MB2kb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 3: //mbit/s
                                BWidth = DataUnit.MB2mb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 4: //gbit/s
                                BWidth = DataUnit.MB2gb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 5: //tbit/s
                                BWidth = DataUnit.MB2tb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                BWidth = Math.sqrt(-1);
                                break;

                        }
                        break;

                    case 4: //from GByte/Month
                        switch (unit2){
                            case 1: //bit/s
                                BWidth = DataUnit.GB2b.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 2: //kbit/s
                                BWidth = DataUnit.GB2kb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 3: //mbit/s
                                BWidth = DataUnit.GB2mb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 4: //gbit/s
                                BWidth = DataUnit.GB2gb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 5: //tbit/s
                                BWidth = DataUnit.GB2tb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                BWidth = Math.sqrt(-1);
                                break;

                        }
                        break;

                    case 5: //from TByte/Month
                        switch (unit2){
                            case 1: //bit/s
                                BWidth = DataUnit.TB2b.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 2: //kbit/s
                                BWidth = DataUnit.TB2kb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 3: //mbit/s
                                BWidth = DataUnit.TB2mb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 4: //gbit/s
                                BWidth = DataUnit.TB2gb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            case 5: //tbit/s
                                BWidth = DataUnit.TB2tb.convertData(MUsage)/ CalcTime.month2sec.CalcTime(1);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                BWidth = Math.sqrt(-1);
                                break;

                        }
                        break;

                    default:
                        System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                        BWidth = Math.sqrt(-1);
                        break;
                }

                return BWidth;
            }
        } catch (NumberFormatException e) {
            return Math.sqrt(-1);
        }
    }

    //Convert Bandwidth to Monthly usage
    public static double ConvertBWidth2MUsage(int unit1, String num, int unit2) {
        try {
            Double.parseDouble(num);
            double BWidth = Double.parseDouble(num);
            double MUsage = 0;
            if (BWidth <= 0) {
                return  -1;
            } else {
                switch (unit1){
                    case 1: //from bit/s
                        switch (unit2){
                            case 1: //Byte/Month
                                MUsage = DataUnit.b2B.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 2: //KByte/Month
                                MUsage = DataUnit.b2KB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 3: //MByte/Month
                                MUsage = DataUnit.b2MB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 4: //GByte/Month
                                MUsage = DataUnit.b2GB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 5: //TByte/Month
                                MUsage = DataUnit.b2TB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                BWidth = Math.sqrt(-1);
                                break;

                        }
                        break;

                    case 2: //from kbit/s
                        switch (unit2){
                            case 1: //Byte/Month
                                MUsage = DataUnit.kb2B.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 2: //KByte/Month
                                MUsage = DataUnit.kb2KB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 3: //MByte/Month
                                MUsage = DataUnit.kb2MB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 4: //GByte/Month
                                MUsage = DataUnit.kb2GB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 5: //TByte/Month
                                MUsage = DataUnit.kb2TB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                BWidth = Math.sqrt(-1);
                                break;

                        }
                        break;

                    case 3: //from mbit/s
                        switch (unit2){
                            case 1: //Byte/Month
                                MUsage = DataUnit.mb2B.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 2: //KByte/Month
                                MUsage = DataUnit.mb2KB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 3: //MByte/Month
                                MUsage = DataUnit.mb2MB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 4: //GByte/Month
                                MUsage = DataUnit.mb2GB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 5: //TByte/Month
                                MUsage = DataUnit.mb2TB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                BWidth = Math.sqrt(-1);
                                break;

                        }
                        break;

                    case 4: //from gbit/s
                        switch (unit2){
                            case 1: //Byte/Month
                                MUsage = DataUnit.gb2B.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 2: //KByte/Month
                                MUsage = DataUnit.gb2KB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 3: //MByte/Month
                                MUsage = DataUnit.gb2MB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 4: //GByte/Month
                                MUsage = DataUnit.gb2GB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 5: //TByte/Month
                                MUsage = DataUnit.gb2TB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                BWidth = Math.sqrt(-1);
                                break;

                        }
                        break;

                    case 5: //from tbit/s
                        switch (unit2){
                            case 1: //Byte/Month
                                MUsage = DataUnit.tb2B.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 2: //KByte/Month
                                MUsage = DataUnit.tb2KB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 3: //MByte/Month
                                MUsage = DataUnit.tb2MB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 4: //GByte/Month
                                MUsage = DataUnit.tb2GB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            case 5: //TByte/Month
                                MUsage = DataUnit.tb2TB.convertData(BWidth)/ CalcTime.sec2month.CalcTime(1);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                BWidth = Math.sqrt(-1);
                                break;

                        }
                        break;

                    default:
                        System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                        MUsage = Math.sqrt(-1);
                        break;
                }

                return MUsage;
            }
        } catch (NumberFormatException e) {
            return Math.sqrt(-1);
        }
    }
}
