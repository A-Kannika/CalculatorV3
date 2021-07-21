package uw.tcss305.Controller;

public class CalcWebsiteBandwidth extends BandwidthCalculator{

    public static void main(String[] args) {
        System.out.println(CalcBandwidth(1,"1", 1, "1", "1"));
        System.out.println(CalcBandwidthWithR(1,"1", 1, "1", "2"));
        System.out.println(CalcMonthlyUsage(1,"1", 1, "1", "1"));
        System.out.println(CalcMonthlyUsageWithR(1,"1", 1, "1", "2"));
    }
    // Use CalcBandwidthWithR in case that Redundancy factor > 1
    public static double CalcBandwidthWithR (int unit1, String pViewData, int unit2, String avgPSize, String rFactor){

        double result = 0;
        try{
            Double.parseDouble(pViewData);
            Double.parseDouble(avgPSize);
            Double.parseDouble(rFactor);
            double p = Double.parseDouble(pViewData);
            double a = Double.parseDouble(avgPSize);
            double r = Double.parseDouble(rFactor);
            if (p <= 0 || a <= 0){
                return -1;
            } else if (r < 1){
                return -2;
            } else {
                switch (unit1){
                    case 1: //Per Second
                        switch (unit2){
                            case 1: //Byte
                                result = r * p * a * 8/ 1_000_000L;
                                break;

                            case 2: //KByte
                                result = r * p * a * 8 / 1_000L;
                                break;

                            case 3: //MByte
                                result = r * p * a * 8 ;
                                break;

                            case 4: //GByte
                                result = r * p * a * 8 * 1000L;
                                break;

                            case 5: //TByte
                                result = r * p * a * 8 * 1_000_000L;
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 2: //Per Minute
                        switch (unit2){
                            case 1: //Byte
                                result = r * p * a * (8000 * 0.00004383) / (0.0026298 * 1_000_000_000L);
                                break;

                            case 2: //KByte
                                result = r * p * a * (8000 * 0.00004383) / (0.0026298 * 1_000_000L);
                                break;

                            case 3: //MByte
                                result = r * p * a * (8000 * 0.00004383) / (0.0026298 * 1_000L);
                                break;

                            case 4: //GByte
                                result = r * p * a * (8000 * 0.00004383 / 0.0026298);
                                break;

                            case 5: //TByte
                                result = r * p * a * (8 * 0.00004383 / 0.0026298);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 3: //Per Hour
                        switch (unit2){
                            case 1: //Byte
                                result = r * p * a * (8000 * 7.305 ) / (0.0026298 * 1_000_000_000L * 10_000_000L);
                                break;

                            case 2: //KByte
                                result = r * p * a * (8000 * 7.305 ) / (0.0026298 * 1_000_000L * 10_000_000L);
                                break;

                            case 3: //MByte
                                result = r * p * a * (8000 * 7.305 ) / (0.0026298 * 1_000L * 10_000_000L);
                                break;

                            case 4: //GByte
                                result = r * p * a * (8000 * 7.305 ) / (0.0026298 * 10_000_000L);
                                break;

                            case 5: //TByte
                                result = r * p * a * (8000 * 7.305 ) / (0.0026298 * 10_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 4: //Per Day
                        switch (unit2){
                            case 1: //Byte
                                result = r * p * a * (8000 * 3.04375 ) / (0.0026298 * 1_000_000_000L * 100_000_000L);
                                break;

                            case 2: //KByte
                                result = r * p * a * (8000 * 3.04375 ) / (0.0026298 * 1_000_000L * 100_000_000L);
                                break;

                            case 3: //MByte
                                result = r * p * a * (8000 * 3.04375 ) / (0.0026298 * 1_000L * 100_000_000L);
                                break;

                            case 4: //GByte
                                result = r * p * a * (8000 * 3.04375 ) / (0.0026298 * 100_000_000L);
                                break;

                            case 5: //TByte
                                result = r * p * a * (8000 * 3.04375 ) / (0.0026298 * 100_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 5: //Per Week
                        switch (unit2){
                            case 1: //Byte
                                result = r * p * a * (8000 * 4.3482142857143 ) / (0.0026298 * 1_000_000_000L * 1_000_000_000L);
                                break;

                            case 2: //KByte
                                result = r * p * a * (8000 * 4.3482142857143 ) / (0.0026298 * 1_000_000L * 1_000_000_000L);
                                break;

                            case 3: //MByte
                                result = r * p * a * (8000 * 4.3482142857143 ) / (0.0026298 * 1_000L * 1_000_000_000L);
                                break;

                            case 4: //GByte
                                result = r * p * a * (8000 * 4.3482142857143 ) / (0.0026298 * 1_000_000_000L);
                                break;

                            case 5: //TByte
                                result = r * p * a * (8000 * 4.3482142857143 ) / (0.0026298 * 1_000_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 6: //Per Month
                        switch (unit2){
                            case 1: //Byte
                                result = r * p * a * (8000) / (0.0026298 * 1_000_000_000L * 1_000_000_000L);
                                break;

                            case 2: //KByte
                                result = r * p * a * (8000) / (0.0026298 * 1_000_000_000L * 1_000_000L);
                                break;

                            case 3: //MByte
                                result = r * p * a * (8000) / (0.0026298 * 1_000_000_000L * 1_000L);
                                break;

                            case 4: //GByte
                                result = r * p * a * (8000) / (0.0026298 * 1_000_000_000L);
                                break;

                            case 5: //TByte
                                result = r * p * a * (8000) / (0.0026298 * 1_000_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 7: //Per Year
                        switch (unit2){
                            case 1: //Byte
                                result = r * p * a * (8000 * 0.083333333333333) / (0.0026298 * 1_000_000_000L);
                                break;

                            case 2: //KByte
                                result = r * p * a * (8000 * 0.083333333333333) / (0.0026298 * 1_000_000L);
                                break;

                            case 3: //MByte
                                result = r * p * a * (8000 * 0.083333333333333) / (0.0026298 * 1_000L);
                                break;

                            case 4: //GByte
                                result = r * p * a * (8000 * 0.083333333333333) / (0.0026298);
                                break;

                            case 5: //TByte
                                result = r *p * a * (8000 * 0.083333333333333 * 1_000L) / (0.0026298);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    default:
                        break;
                }
                return result;
            }
        } catch (NumberFormatException e) {
            return Math.sqrt(-1);
        }
    }

    // Use CalcBandwidth in case that Redundancy factor = 1
    public static double CalcBandwidth (int unit1, String pViewData, int unit2, String avgPSize, String rFactor){

        double result = 0;
        try{
            Double.parseDouble(pViewData);
            Double.parseDouble(avgPSize);
            Double.parseDouble(rFactor);
            double p = Double.parseDouble(pViewData);
            double a = Double.parseDouble(avgPSize);
            double r = Double.parseDouble(rFactor);
            if (p <= 0 || a <= 0){
                return -1;
            } else if (r < 1){
                return -2;
            } else {
                switch (unit1){
                    case 1: //Per Second
                        switch (unit2){
                            case 1: //Byte
                                result = p * a * 8/ 1_000_000L;
                                break;

                            case 2: //KByte
                                result = p * a * 8 / 1_000L;
                                break;

                            case 3: //MByte
                                result = p * a * 8 ;
                                break;

                            case 4: //GByte
                                result = p * a * 8 * 1000L;
                                break;

                            case 5: //TByte
                                result = p * a * 8 * 1_000_000L;
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 2: //Per Minute
                        switch (unit2){
                            case 1: //Byte
                                result = p * a * (8000 * 0.00004383) / (0.0026298 * 1_000_000_000L);
                                break;

                            case 2: //KByte
                                result = p * a * (8000 * 0.00004383) / (0.0026298 * 1_000_000L);
                                break;

                            case 3: //MByte
                                result = p * a * (8000 * 0.00004383) / (0.0026298 * 1_000L);
                                break;

                            case 4: //GByte
                                result = p * a * (8000 * 0.00004383 / 0.0026298);
                                break;

                            case 5: //TByte
                                result = p * a * (8 * 0.00004383 / 0.0026298);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 3: //Per Hour
                        switch (unit2){
                            case 1: //Byte
                                result = p * a * (8000 * 7.305 ) / (0.0026298 * 1_000_000_000L * 10_000_000L);
                                break;

                            case 2: //KByte
                                result = p * a * (8000 * 7.305 ) / (0.0026298 * 1_000_000L * 10_000_000L);
                                break;

                            case 3: //MByte
                                result = p * a * (8000 * 7.305 ) / (0.0026298 * 1_000L * 10_000_000L);
                                break;

                            case 4: //GByte
                                result = p * a * (8000 * 7.305 ) / (0.0026298 * 10_000_000L);
                                break;

                            case 5: //TByte
                                result = p * a * (8000 * 7.305 ) / (0.0026298 * 10_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 4: //Per Day
                        switch (unit2){
                            case 1: //Byte
                                result = p * a * (8000 * 3.04375 ) / (0.0026298 * 1_000_000_000L * 100_000_000L);
                                break;

                            case 2: //KByte
                                result = p * a * (8000 * 3.04375 ) / (0.0026298 * 1_000_000L * 100_000_000L);
                                break;

                            case 3: //MByte
                                result = p * a * (8000 * 3.04375 ) / (0.0026298 * 1_000L * 100_000_000L);
                                break;

                            case 4: //GByte
                                result = p * a * (8000 * 3.04375 ) / (0.0026298 * 100_000_000L);
                                break;

                            case 5: //TByte
                                result = p * a * (8000 * 3.04375 ) / (0.0026298 * 100_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 5: //Per Week
                        switch (unit2){
                            case 1: //Byte
                                result = p * a * (8000 * 4.3482142857143 ) / (0.0026298 * 1_000_000_000L * 1_000_000_000L);
                                break;

                            case 2: //KByte
                                result = p * a * (8000 * 4.3482142857143 ) / (0.0026298 * 1_000_000L * 1_000_000_000L);
                                break;

                            case 3: //MByte
                                result = p * a * (8000 * 4.3482142857143 ) / (0.0026298 * 1_000L * 1_000_000_000L);
                                break;

                            case 4: //GByte
                                result = p * a * (8000 * 4.3482142857143 ) / (0.0026298 * 1_000_000_000L);
                                break;

                            case 5: //TByte
                                result = p * a * (8000 * 4.3482142857143 ) / (0.0026298 * 1_000_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 6: //Per Month
                        switch (unit2){
                            case 1: //Byte
                                result = p * a * (8000) / (0.0026298 * 1_000_000_000L * 1_000_000_000L);
                                break;

                            case 2: //KByte
                                result = p * a * (8000) / (0.0026298 * 1_000_000_000L * 1_000_000L);
                                break;

                            case 3: //MByte
                                result = p * a * (8000) / (0.0026298 * 1_000_000_000L * 1_000L);
                                break;

                            case 4: //GByte
                                result = p * a * (8000) / (0.0026298 * 1_000_000_000L);
                                break;

                            case 5: //TByte
                                result = p * a * (8000) / (0.0026298 * 1_000_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 7: //Per Year
                        switch (unit2){
                            case 1: //Byte
                                result = p * a * (8000 * 0.083333333333333) / (0.0026298 * 1_000_000_000L);
                                break;

                            case 2: //KByte
                                result = p * a * (8000 * 0.083333333333333) / (0.0026298 * 1_000_000L);
                                break;

                            case 3: //MByte
                                result = p * a * (8000 * 0.083333333333333) / (0.0026298 * 1_000L);
                                break;

                            case 4: //GByte
                                result = p * a * (8000 * 0.083333333333333) / (0.0026298);
                                break;

                            case 5: //TByte
                                result = p * a * (8000 * 0.083333333333333 * 1_000L) / (0.0026298);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    default:
                        break;
                }
                return result;
            }
        } catch (NumberFormatException e) {
            return Math.sqrt(-1);
        }
    }

    // Use CalcMonthlyUsage in case that Redundancy factor = 1
    public static double CalcMonthlyUsage (int unit1, String pViewData, int unit2, String avgPSize, String rFactor){

        double result = 0;
        try{
            Double.parseDouble(pViewData);
            Double.parseDouble(avgPSize);
            Double.parseDouble(rFactor);
            double p = Double.parseDouble(pViewData);
            double a = Double.parseDouble(avgPSize);
            double r = Double.parseDouble(rFactor);
            if (p <= 0 || a <= 0){
                return -1;
            } else if (r < 1){
                return -2;
            } else {
                switch (unit1){
                    case 1: //Per Second
                        switch (unit2){
                            case 1: //Byte
//                                result = DataUnit.B2GB.convertData(a) * (p * CalcTime.sec2month.CalcTime(1));
                                result =  (p * a) * (0.0026298);
                                break;

                            case 2: //KByte
 //                               result = DataUnit.KB2GB.convertData(a) * (p * CalcTime.sec2month.CalcTime(1));
                                result = (p * a) * (0.0026298 * 1_000L);
                                break;

                            case 3: //MByte
  //                              result = DataUnit.MB2GB.convertData(a) * (p * CalcTime.sec2month.CalcTime(1));
                                result = (p * a) * (0.0026298 * 1_000_000L);
                                break;

                            case 4: //GByte
//                                result = a * (p * CalcTime.sec2month.CalcTime(1));
                                result = (p * a) * (0.0026298 * 1_000_000_000L);
                                break;

                            case 5: //TByte
//                                result = DataUnit.TB2GB.convertData(a) * (p * CalcTime.sec2month.CalcTime(1));
                                result = (p * a) * (0.0026298 * 1_000_000_000_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 2: //Per Minute
                        switch (unit2){
                            case 1: //Byte
//                                result = DataUnit.B2GB.convertData(a) * (p * CalcTime.minute2month.CalcTime(1));
                                result = p * a * (0.00004383);
                                break;

                            case 2: //KByte
//                                result = DataUnit.KB2GB.convertData(a) * (p * CalcTime.minute2month.CalcTime(1));
                                result = p * a * (0.00004383 * 1_000L);
                                break;

                            case 3: //MByte
//                                result = DataUnit.MB2GB.convertData(a) * (p * CalcTime.minute2month.CalcTime(1));
                                result = p * a * (0.00004383 * 1_000_000L);
                                break;

                            case 4: //GByte
//                                result = a * (p * CalcTime.minute2month.CalcTime(1));
                                result = p * a * (0.00004383 * 1_000_000_000L);
                                break;

                            case 5: //TByte
//                                result = DataUnit.TB2GB.convertData(a) * (p * CalcTime.minute2month.CalcTime(1));
                                result = p * a * (0.00004383 * 1_000_000_000_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 3: //Per Hour
                        switch (unit2){
                            case 1: //Byte
//                                result = DataUnit.B2GB.convertData(a) * (p * CalcTime.hour2month.CalcTime(1));
                                result = (p * a) * (7.305 / 10_000_000L);
                                break;

                            case 2: //KByte
//                                result = DataUnit.KB2GB.convertData(a) * (p * CalcTime.hour2month.CalcTime(1));
                                result = (p * a) * (7.305 / 10_000L);
                                break;

                            case 3: //MByte
//                                result = DataUnit.MB2GB.convertData(a) * (p * CalcTime.hour2month.CalcTime(1));
                                result = (p * a) * (7.305 / 10L);
                                break;

                            case 4: //GByte
//                                result = a * (p * CalcTime.hour2month.CalcTime(1));
                                result = (p * a) * (7.305 * 100L);
                                break;

                            case 5: //TByte
//                                result = DataUnit.TB2GB.convertData(a) * (p * CalcTime.hour2month.CalcTime(1));
                                result = (p * a) * (7.305 * 100_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 4: //Per Day
                        switch (unit2){
                            case 1: //Byte
                                //result = DataUnit.B2GB.convertData(a) * (p * CalcTime.day2month.CalcTime(1));
                                result = (p*a) * (3.04375 / 100_000_000L);
                                break;

                            case 2: //KByte
                                //result = DataUnit.KB2GB.convertData(a) * (p * CalcTime.day2month.CalcTime(1));
                                result = (p*a) * (3.04375 / 100_000L);
                                break;

                            case 3: //MByte
                                //result = DataUnit.MB2GB.convertData(a) * (p * CalcTime.day2month.CalcTime(1));
                                result = (p*a) * (3.04375 / 100L);
                                break;

                            case 4: //GByte
                                //result = a * (p * CalcTime.day2month.CalcTime(1));
                                result = (p*a) * (3.04375 * 10);
                                break;

                            case 5: //TByte
                                //result = DataUnit.TB2GB.convertData(a) * (p * CalcTime.day2month.CalcTime(1));
                                result = (p*a) * (3.04375 * 10_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 5: //Per Week
                        switch (unit2){
                            case 1: //Byte
                                //result = DataUnit.B2GB.convertData(a) * (p * CalcTime.week2month.CalcTime(1));
                                result = (p * a) * (4.3482142857143 / 1_000_000_000L);
                                break;

                            case 2: //KByte
                                //result = DataUnit.KB2GB.convertData(a) * (p * CalcTime.week2month.CalcTime(1));
                                result = (p * a) * (4.3482142857143 / 1_000_000L);
                                break;

                            case 3: //MByte
                                //result = DataUnit.MB2GB.convertData(a) * (p * CalcTime.week2month.CalcTime(1));
                                result = (p * a) * (4.3482142857143 / 1_000L);
                                break;

                            case 4: //GByte
//                                result = a * (p * CalcTime.week2month.CalcTime(1));
                                result = (p * a) * (4.3482142857143);
                                break;

                            case 5: //TByte
                                //result = DataUnit.TB2GB.convertData(a) * (p * CalcTime.week2month.CalcTime(1));
                                result = (p * a) * (4.3482142857143 * 1_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 6: //Per Month
                        switch (unit2){
                            case 1: //Byte
                                //result = DataUnit.B2GB.convertData(a) * p;
                                result = (p * a) / 1_000_000_000L;
                                break;

                            case 2: //KByte
                                //result = DataUnit.KB2GB.convertData(a) * p;
                                result = (p * a) / 1_000_000L;
                                break;

                            case 3: //MByte
                                //result = DataUnit.MB2GB.convertData(a) * p;
                                result = (p * a) / 1_000L;
                                break;

                            case 4: //GByte
                                result = p*a;
                                break;

                            case 5: //TByte
                                //result = DataUnit.TB2GB.convertData(a) * p;
                                result = (p * a) * 1_000L;
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 7: //Per Year
                        switch (unit2){
                            case 1: //Byte
                                //result = DataUnit.B2GB.convertData(a) * (p * CalcTime.year2month.CalcTime(1));
                                result = (p * a) * (0.083333333333333);
                                break;

                            case 2: //KByte
                                //result = DataUnit.KB2GB.convertData(a) * (p * CalcTime.year2month.CalcTime(1));
                                result = (p * a) * (0.083333333333333 * 1_000L);
                                break;

                            case 3: //MByte
                                //result = DataUnit.MB2GB.convertData(a) * (p * CalcTime.year2month.CalcTime(1));
                                result = (p * a) * (0.083333333333333 * 1_000_000L);
                                break;

                            case 4: //GByte
                                //result = a * (p * CalcTime.year2month.CalcTime(1));
                                result = (p * a) * (0.083333333333333 * 1_000_000_000L);
                                break;

                            case 5: //TByte
                                //result = DataUnit.TB2GB.convertData(a) * (p * CalcTime.year2month.CalcTime(1));
                                result = (p * a) * (0.083333333333333 * 1_000_000_000_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    default:
                        break;
                }
                return result;
            }
        } catch (NumberFormatException e) {
            return Math.sqrt(-1);
        }
    }

    // Use CalcMonthlyUsage in case that Redundancy factor > 1
    public static double CalcMonthlyUsageWithR (int unit1, String pViewData, int unit2, String avgPSize, String rFactor){

        double result = 0;
        try{
            Double.parseDouble(pViewData);
            Double.parseDouble(avgPSize);
            Double.parseDouble(rFactor);
            double p = Double.parseDouble(pViewData);
            double a = Double.parseDouble(avgPSize);
            double r = Double.parseDouble(rFactor);
            if (p <= 0 || a <= 0){
                return -1;
            } else if (r < 1){
                return -2;
            } else {
                switch (unit1){
                    case 1: //Per Second
                        switch (unit2){
                            case 1: //Byte
//                                result = DataUnit.B2GB.convertData(a) * (p * CalcTime.sec2month.CalcTime(1));
                                result =  r* (p * a) * (0.0026298);
                                break;

                            case 2: //KByte
                                //                               result = DataUnit.KB2GB.convertData(a) * (p * CalcTime.sec2month.CalcTime(1));
                                result = r * (p * a) * (0.0026298 * 1_000L);
                                break;

                            case 3: //MByte
                                //                              result = DataUnit.MB2GB.convertData(a) * (p * CalcTime.sec2month.CalcTime(1));
                                result = r * (p * a) * (0.0026298 * 1_000_000L);
                                break;

                            case 4: //GByte
//                                result = a * (p * CalcTime.sec2month.CalcTime(1));
                                result = r * (p * a) * (0.0026298 * 1_000_000_000L);
                                break;

                            case 5: //TByte
//                                result = DataUnit.TB2GB.convertData(a) * (p * CalcTime.sec2month.CalcTime(1));
                                result = r * (p * a) * (0.0026298 * 1_000_000_000_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 2: //Per Minute
                        switch (unit2){
                            case 1: //Byte
//                                result = DataUnit.B2GB.convertData(a) * (p * CalcTime.minute2month.CalcTime(1));
                                result = r * p * a * (0.00004383);
                                break;

                            case 2: //KByte
//                                result = DataUnit.KB2GB.convertData(a) * (p * CalcTime.minute2month.CalcTime(1));
                                result = r * p * a * (0.00004383 * 1_000L);
                                break;

                            case 3: //MByte
//                                result = DataUnit.MB2GB.convertData(a) * (p * CalcTime.minute2month.CalcTime(1));
                                result = r * p * a * (0.00004383 * 1_000_000L);
                                break;

                            case 4: //GByte
//                                result = a * (p * CalcTime.minute2month.CalcTime(1));
                                result = r * p * a * (0.00004383 * 1_000_000_000L);
                                break;

                            case 5: //TByte
//                                result = DataUnit.TB2GB.convertData(a) * (p * CalcTime.minute2month.CalcTime(1));
                                result = r * p * a * (0.00004383 * 1_000_000_000_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 3: //Per Hour
                        switch (unit2){
                            case 1: //Byte
//                                result = DataUnit.B2GB.convertData(a) * (p * CalcTime.hour2month.CalcTime(1));
                                result = r * (p * a) * (7.305 / 10_000_000L);
                                break;

                            case 2: //KByte
//                                result = DataUnit.KB2GB.convertData(a) * (p * CalcTime.hour2month.CalcTime(1));
                                result = r * (p * a) * (7.305 / 10_000L);
                                break;

                            case 3: //MByte
//                                result = DataUnit.MB2GB.convertData(a) * (p * CalcTime.hour2month.CalcTime(1));
                                result = r * (p * a) * (7.305 / 10L);
                                break;

                            case 4: //GByte
//                                result = a * (p * CalcTime.hour2month.CalcTime(1));
                                result = r * (p * a) * (7.305 * 100L);
                                break;

                            case 5: //TByte
//                                result = DataUnit.TB2GB.convertData(a) * (p * CalcTime.hour2month.CalcTime(1));
                                result = r * (p * a) * (7.305 * 100_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 4: //Per Day
                        switch (unit2){
                            case 1: //Byte
                                //result = DataUnit.B2GB.convertData(a) * (p * CalcTime.day2month.CalcTime(1));
                                result = r * (p*a) * (3.04375 / 100_000_000L);
                                break;

                            case 2: //KByte
                                //result = DataUnit.KB2GB.convertData(a) * (p * CalcTime.day2month.CalcTime(1));
                                result = r * (p*a) * (3.04375 / 100_000L);
                                break;

                            case 3: //MByte
                                //result = DataUnit.MB2GB.convertData(a) * (p * CalcTime.day2month.CalcTime(1));
                                result = r * (p*a) * (3.04375 / 100L);
                                break;

                            case 4: //GByte
                                //result = a * (p * CalcTime.day2month.CalcTime(1));
                                result = r * (p*a) * (3.04375 * 10);
                                break;

                            case 5: //TByte
                                //result = DataUnit.TB2GB.convertData(a) * (p * CalcTime.day2month.CalcTime(1));
                                result = r * (p*a) * (3.04375 * 10_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 5: //Per Week
                        switch (unit2){
                            case 1: //Byte
                                //result = DataUnit.B2GB.convertData(a) * (p * CalcTime.week2month.CalcTime(1));
                                result = r * (p * a) * (4.3482142857143 / 1_000_000_000L);
                                break;

                            case 2: //KByte
                                //result = DataUnit.KB2GB.convertData(a) * (p * CalcTime.week2month.CalcTime(1));
                                result = r * (p * a) * (4.3482142857143 / 1_000_000L);
                                break;

                            case 3: //MByte
                                //result = DataUnit.MB2GB.convertData(a) * (p * CalcTime.week2month.CalcTime(1));
                                result = r * (p * a) * (4.3482142857143 / 1_000L);
                                break;

                            case 4: //GByte
//                                result = a * (p * CalcTime.week2month.CalcTime(1));
                                result = r * (p * a) * (4.3482142857143);
                                break;

                            case 5: //TByte
                                //result = DataUnit.TB2GB.convertData(a) * (p * CalcTime.week2month.CalcTime(1));
                                result = r * (p * a) * (4.3482142857143 * 1_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 6: //Per Month
                        switch (unit2){
                            case 1: //Byte
                                //result = DataUnit.B2GB.convertData(a) * p;
                                result = r * (p * a) / 1_000_000_000L;
                                break;

                            case 2: //KByte
                                //result = DataUnit.KB2GB.convertData(a) * p;
                                result = r * (p * a) / 1_000_000L;
                                break;

                            case 3: //MByte
                                //result = DataUnit.MB2GB.convertData(a) * p;
                                result = r * (p * a) / 1_000L;
                                break;

                            case 4: //GByte
                                result = r * p*a;
                                break;

                            case 5: //TByte
                                //result = DataUnit.TB2GB.convertData(a) * p;
                                result = r * (p * a) * 1_000L;
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 7: //Per Year
                        switch (unit2){
                            case 1: //Byte
                                //result = DataUnit.B2GB.convertData(a) * (p * CalcTime.year2month.CalcTime(1));
                                result = r * (p * a) * (0.083333333333333);
                                break;

                            case 2: //KByte
                                //result = DataUnit.KB2GB.convertData(a) * (p * CalcTime.year2month.CalcTime(1));
                                result = r * (p * a) * (0.083333333333333 * 1_000L);
                                break;

                            case 3: //MByte
                                //result = DataUnit.MB2GB.convertData(a) * (p * CalcTime.year2month.CalcTime(1));
                                result = r * (p * a) * (0.083333333333333 * 1_000_000L);
                                break;

                            case 4: //GByte
                                //result = a * (p * CalcTime.year2month.CalcTime(1));
                                result = r * (p * a) * (0.083333333333333 * 1_000_000_000L);
                                break;

                            case 5: //TByte
                                //result = DataUnit.TB2GB.convertData(a) * (p * CalcTime.year2month.CalcTime(1));
                                result = r * (p * a) * (0.083333333333333 * 1_000_000_000_000L);
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                result = Math.sqrt(-1);
                                break;
                        }
                        break;

                    default:
                        break;
                }
                return result;
            }
        } catch (NumberFormatException e) {
            return Math.sqrt(-1);
        }
    }
}
