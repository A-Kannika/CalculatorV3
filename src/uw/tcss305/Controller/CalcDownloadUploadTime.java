package uw.tcss305.Controller;

import uw.tcss305.Model.DataUnit;

public class CalcDownloadUploadTime extends BandwidthCalculator{

//    public static void calcDownloadUploadTime (int unitF, String fileSizeData, int unitB, String bandwidthData){
//        double time = time(unitF, fileSizeData, unitB, bandwidthData);;
//        double remainder = 0;
//        long day = (long) CalcTime.sec2day.CalcTime(time);
//        remainder = time % 86400;
//        int hour = (int) CalcTime.sec2hour.CalcTime(remainder);
//        remainder %= 3600;
//        int minute = (int) CalcTime.sec2minute.CalcTime(remainder);
//        remainder = remainder % 60;
//        double second = remainder;
//
//        System.out.print("\nDownload or upload time needed is:\n ~");
//        if (day != 0){
//            if ( day == 1){
//                System.out.print(day + " day ");
//            } else {
//                System.out.print(day + " days ");
//            }
//        }
//        if (hour != 0){
//            if ( hour == 1){
//                System.out.print(hour + " hour ");
//            } else {
//                System.out.print(hour + " hours ");
//            }
//        }
//        if (minute != 0){
//            if ( minute == 1){
//                System.out.print(minute + " minute ");
//            } else {
//                System.out.print(minute + " minutes ");
//            }
//        }
//        if (second != 0){
//            if ( second == 1){
//                System.out.print(second + " second ");
//            } else {
//                System.out.print(second + " seconds ");
//            }
//        }
//    }

    public static double time(int unitF, String fileSizeData, int unitB, String bandwidthData){
        try {
            Double.parseDouble(fileSizeData);
            Double.parseDouble(bandwidthData);
            double fSize = Double.parseDouble(fileSizeData);
            double bWidth = Double.parseDouble(bandwidthData);
            double time = 0;
            long day = 0;
            int hour = 0;
            int minute = 0;
            double remainder = 0;
            if (fSize <= 0 || bWidth <= 0 ){
                time =  -1;
            } else {
                switch(unitF){
                    case 1: //Bytes
                        fSize = DataUnit.B2b.convertData(fSize);
                        switch(unitB){
                            case 1: // bit/s
                                time = fSize/bWidth;
                                break;

                            case 2: // kbit/s
                                bWidth = DataUnit.kb2b.convertData(bWidth);
                                time = fSize/bWidth;
                                break;

                            case 3: // mbit/s
                                bWidth = DataUnit.mb2b.convertData(bWidth);
                                time = fSize/bWidth;
                                break;

                            case 4: // gbit/s
                                bWidth = DataUnit.gb2b.convertData(bWidth);
                                time = fSize/bWidth;
                                break;

                            case 5: // tbit/s
                                bWidth = DataUnit.tb2b.convertData(bWidth);
                                time = fSize/bWidth;;
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                time = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 2: //KBytes
                        fSize = DataUnit.KB2b.convertData(fSize);
                        switch(unitB){
                            case 1: // bit/s
                                time = fSize/bWidth;
                                break;

                            case 2: // kbit/s
                                bWidth = DataUnit.kb2b.convertData(bWidth);
                                time = fSize/bWidth;
                                break;

                            case 3: // mbit/s
                                bWidth = DataUnit.mb2b.convertData(bWidth);
                                time = fSize/bWidth;
                                break;

                            case 4: // gbit/s
                                bWidth = DataUnit.gb2b.convertData(bWidth);
                                time = fSize/bWidth;
                                break;

                            case 5: // tbit/s
                                bWidth = DataUnit.tb2b.convertData(bWidth);
                                time = fSize/bWidth;;
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                time = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 3: //MBytes
                        fSize = DataUnit.MB2b.convertData(fSize);
                        switch(unitB){
                            case 1: // bit/s
                                time = fSize/bWidth;
                                break;

                            case 2: // kbit/s
                                bWidth = DataUnit.kb2b.convertData(bWidth);
                                time = fSize/bWidth;
                                break;

                            case 3: // mbit/s
                                bWidth = DataUnit.mb2b.convertData(bWidth);
                                time = fSize/bWidth;
                                break;

                            case 4: // gbit/s
                                bWidth = DataUnit.gb2b.convertData(bWidth);
                                time = fSize/bWidth;
                                break;

                            case 5: // tbit/s
                                bWidth = DataUnit.tb2b.convertData(bWidth);
                                time = fSize/bWidth;;
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                time = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 4: //GBytes
                        fSize = DataUnit.GB2b.convertData(fSize);
                        switch(unitB){
                            case 1: // bit/s
                                time = fSize/bWidth;
                                break;

                            case 2: // kbit/s
                                bWidth = DataUnit.kb2b.convertData(bWidth);
                                time = fSize/bWidth;
                                break;

                            case 3: // mbit/s
                                bWidth = DataUnit.mb2b.convertData(bWidth);
                                time = fSize/bWidth;
                                break;

                            case 4: // gbit/s
                                bWidth = DataUnit.gb2b.convertData(bWidth);
                                time = fSize/bWidth;
                                break;

                            case 5: // tbit/s
                                bWidth = DataUnit.tb2b.convertData(bWidth);
                                time = fSize/bWidth;;
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                time = Math.sqrt(-1);
                                break;
                        }
                        break;

                    case 5: //TBytes
                        fSize = DataUnit.TB2b.convertData(fSize);
                        switch(unitB){
                            case 1: // bit/s
                                time = fSize/bWidth;
                                break;

                            case 2: // kbit/s
                                bWidth = DataUnit.kb2b.convertData(bWidth);
                                time = fSize/bWidth;
                                break;

                            case 3: // mbit/s
                                bWidth = DataUnit.mb2b.convertData(bWidth);
                                time = fSize/bWidth;
                                break;

                            case 4: // gbit/s
                                bWidth = DataUnit.gb2b.convertData(bWidth);
                                time = fSize/bWidth;
                                break;

                            case 5: // tbit/s
                                bWidth = DataUnit.tb2b.convertData(bWidth);
                                time = fSize/bWidth;;
                                break;

                            default:
                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                                time = Math.sqrt(-1);
                                break;
                        }
                        break;

                    default:
                        System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                        time = Math.sqrt(-1);
                        break;
                }
            }
            return time;
        } catch (NumberFormatException e) {
            System.out.println(ConsoleColors.RED_BOLD + "\tPlease provide a positive value." + ConsoleColors.RESET);
            return Math.sqrt(-1);
        }
    }

//    public static double time(int unitF, String fileSizeData, int unitB, String bandwidthData){
//        try {
//            Double.parseDouble(fileSizeData);
//            Double.parseDouble(bandwidthData);
//            double fSize = Double.parseDouble(fileSizeData);
//            double bWidth = Double.parseDouble(bandwidthData);
//            double time = 0;
//            long day = 0;
//            int hour = 0;
//            int minute = 0;
//            double remainder = 0;
//            if (fSize <= 0 || bWidth <= 0 ){
//                time =  -1;
//            } else {
//                switch(unitF){
//                    case 1: //Bytes
//                        fSize = DataUnit.B2b.convertData(fSize);
//                        switch(unitB){
//                            case 1: // bit/s
//                                time = fSize/bWidth;
//                                break;
//
//                            case 2: // kbit/s
//                                bWidth = DataUnit.kb2b.convertData(bWidth);
//                                time = fSize/bWidth;
//                                break;
//
//                            case 3: // mbit/s
//                                bWidth = DataUnit.mb2b.convertData(bWidth);
//                                time = fSize/bWidth;
//                                break;
//
//                            case 4: // gbit/s
//                                bWidth = DataUnit.gb2b.convertData(bWidth);
//                                time = fSize/bWidth;
//                                break;
//
//                            case 5: // tbit/s
//                                bWidth = DataUnit.tb2b.convertData(bWidth);
//                                time = fSize/bWidth;;
//                                break;
//
//                            default:
//                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
//                                time = Math.sqrt(-1);
//                                break;
//                        }
//                        break;
//
//                    case 2: //KBytes
//                        fSize = DataUnit.KB2b.convertData(fSize);
//                        switch(unitB){
//                            case 1: // bit/s
//                                time = fSize/bWidth;
//                                break;
//
//                            case 2: // kbit/s
//                                bWidth = DataUnit.kb2b.convertData(bWidth);
//                                time = fSize/bWidth;
//                                break;
//
//                            case 3: // mbit/s
//                                bWidth = DataUnit.mb2b.convertData(bWidth);
//                                time = fSize/bWidth;
//                                break;
//
//                            case 4: // gbit/s
//                                bWidth = DataUnit.gb2b.convertData(bWidth);
//                                time = fSize/bWidth;
//                                break;
//
//                            case 5: // tbit/s
//                                bWidth = DataUnit.tb2b.convertData(bWidth);
//                                time = fSize/bWidth;;
//                                break;
//
//                            default:
//                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
//                                time = Math.sqrt(-1);
//                                break;
//                        }
//                        break;
//
//                    case 3: //MBytes
//                        fSize = DataUnit.MB2b.convertData(fSize);
//                        switch(unitB){
//                            case 1: // bit/s
//                                time = fSize/bWidth;
//                                break;
//
//                            case 2: // kbit/s
//                                bWidth = DataUnit.kb2b.convertData(bWidth);
//                                time = fSize/bWidth;
//                                break;
//
//                            case 3: // mbit/s
//                                bWidth = DataUnit.mb2b.convertData(bWidth);
//                                time = fSize/bWidth;
//                                break;
//
//                            case 4: // gbit/s
//                                bWidth = DataUnit.gb2b.convertData(bWidth);
//                                time = fSize/bWidth;
//                                break;
//
//                            case 5: // tbit/s
//                                bWidth = DataUnit.tb2b.convertData(bWidth);
//                                time = fSize/bWidth;;
//                                break;
//
//                            default:
//                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
//                                time = Math.sqrt(-1);
//                                break;
//                        }
//                        break;
//
//                    case 4: //GBytes
//                        fSize = DataUnit.GB2b.convertData(fSize);
//                        switch(unitB){
//                            case 1: // bit/s
//                                time = fSize/bWidth;
//                                break;
//
//                            case 2: // kbit/s
//                                bWidth = DataUnit.kb2b.convertData(bWidth);
//                                time = fSize/bWidth;
//                                break;
//
//                            case 3: // mbit/s
//                                bWidth = DataUnit.mb2b.convertData(bWidth);
//                                time = fSize/bWidth;
//                                break;
//
//                            case 4: // gbit/s
//                                bWidth = DataUnit.gb2b.convertData(bWidth);
//                                time = fSize/bWidth;
//                                break;
//
//                            case 5: // tbit/s
//                                bWidth = DataUnit.tb2b.convertData(bWidth);
//                                time = fSize/bWidth;;
//                                break;
//
//                            default:
//                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
//                                time = Math.sqrt(-1);
//                                break;
//                        }
//                        break;
//
//                    case 5: //TBytes
//                        fSize = DataUnit.TB2b.convertData(fSize);
//                        switch(unitB){
//                            case 1: // bit/s
//                                time = fSize/bWidth;
//                                break;
//
//                            case 2: // kbit/s
//                                bWidth = DataUnit.kb2b.convertData(bWidth);
//                                time = fSize/bWidth;
//                                break;
//
//                            case 3: // mbit/s
//                                bWidth = DataUnit.mb2b.convertData(bWidth);
//                                time = fSize/bWidth;
//                                break;
//
//                            case 4: // gbit/s
//                                bWidth = DataUnit.gb2b.convertData(bWidth);
//                                time = fSize/bWidth;
//                                break;
//
//                            case 5: // tbit/s
//                                bWidth = DataUnit.tb2b.convertData(bWidth);
//                                time = fSize/bWidth;;
//                                break;
//
//                            default:
//                                System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
//                                time = Math.sqrt(-1);
//                                break;
//                        }
//                        break;
//
//                    default:
//                        System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
//                        time = Math.sqrt(-1);
//                        break;
//                }
//            }
//            return time;
//        } catch (NumberFormatException e) {
//            System.out.println(ConsoleColors.RED_BOLD + "\tPlease provide a positive value." + ConsoleColors.RESET);
//            return Math.sqrt(-1);
//        }
//    }



//    public void calcDownloadUploadTimePrint(int unit1, String fileSize, int unit2, String bandwidth) {
//        try {
//            Double.parseDouble(fileSize);
//            Double.parseDouble(bandwidth);
//            if (fileSize.startsWith("-") && bandwidth.startsWith("-")) {
//                System.out.println(ConsoleColors.RED_BOLD + "\tPlease provide a positive file size.\n\tPlease provide a positive bandwidth." + ConsoleColors.RESET);
//            } else if (fileSize.startsWith("-")){
//                System.out.println(ConsoleColors.RED_BOLD + "\tPlease provide a positive file size." + ConsoleColors.RESET);
//            } else if (bandwidth.startsWith("-")){
//                System.out.println(ConsoleColors.RED_BOLD + "\tPlease provide a positive bandwidth." + ConsoleColors.RESET);
//            }
//            else if (Double.parseDouble(bandwidth) == 0) {
//                System.out.println(
//                        "\tDownload or upload time needed is: \n\t" + ConsoleColors.GREEN_BOLD
//                                + "~INF days NAN second : " + ConsoleColors.RESET);
//            } else {
//                double fileSizes = Double.parseDouble(fileSize);
//                double bandwidths = Double.parseDouble(bandwidth);
//                double time = 0;
//                long day = 0;
//                int hour = 0;
//                int minute = 0;
//                double remainder = 0;
//                switch (unit1) {
//                    case 1: // Calculate from Bytes
//                        switch (unit2) {
//// Calculate from bits per sec
//                            case 1 -> {
//                                time = DataUnit.B2b.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: \n\t" + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Kbits per sec
//                            case 2 -> {
//                                time = DataUnit.B2kb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Mbits per sec
//                            case 3 -> {
//                                time = DataUnit.B2mb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Gbits per sec
//                            case 4 -> {
//                                time = DataUnit.B2gb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Tbits per sec
//                            case 5 -> {
//                                time = DataUnit.B2tb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//                            default -> System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
//                        }
//                        break;
//                    case 2: // Calculate from KBytes
//                        switch (unit2) {
//// Calculate from bits per sec
//                            case 1 -> {
//                                time = DataUnit.KB2b.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Kbits per sec
//                            case 2 -> {
//                                time = DataUnit.KB2kb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Mbits per sec
//                            case 3 -> {
//                                time = DataUnit.KB2mb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Gbits per sec
//                            case 4 -> {
//                                time = DataUnit.KB2gb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Tbits per sec
//                            case 5 -> {
//                                time = DataUnit.KB2tb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//                            default -> System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
//                        }
//                        break;
//                    case 3: // Calculate from MBytes
//                        switch (unit2) {
//// Calculate from bits per sec
//                            case 1 -> {
//                                time = DataUnit.MB2b.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Kbits per sec
//                            case 2 -> {
//                                time = DataUnit.MB2kb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Mbits per sec
//                            case 3 -> {
//                                time = DataUnit.MB2mb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Gbits per sec
//                            case 4 -> {
//                                time = DataUnit.MB2gb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Tbits per sec
//                            case 5 -> {
//                                time = DataUnit.MB2tb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//                            default -> System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
//                        }
//                        break;
//                    case 4: // Calculate from GBytes
//                        switch (unit2) {
//// Calculate from bits per sec
//                            case 1 -> {
//                                time = DataUnit.GB2b.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Kbits per sec
//                            case 2 -> {
//                                time = DataUnit.GB2kb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Mbits per sec
//                            case 3 -> {
//                                time = DataUnit.GB2mb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Gbits per sec
//                            case 4 -> {
//                                time = DataUnit.GB2gb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Tbits per sec
//                            case 5 -> {
//                                time = DataUnit.GB2tb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//                            default -> System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
//                        }
//                        break;
//                    case 5: // Calculate from TBytes
//                        switch (unit2) {
//// Calculate from bits per sec
//                            case 1 -> {
//                                time = DataUnit.TB2b.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Kbits per sec
//                            case 2 -> {
//                                time = DataUnit.TB2kb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Mbits per sec
//                            case 3 -> {
//                                time = DataUnit.TB2mb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Gbits per sec
//                            case 4 -> {
//                                time = DataUnit.TB2gb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//// Calculate from Tbits per sec
//                            case 5 -> {
//                                time = DataUnit.TB2tb.convertData(fileSizes) / bandwidths;
//                                day = (long) time / 86400;
//                                remainder = time % 86400;
//                                hour = (int) remainder / 3600;
//                                remainder %= 3600;
//                                minute = (int) remainder / 60;
//                                remainder = remainder % 60;
//                                System.out.print("\tDownload or upload time needed is: " + ConsoleColors.GREEN_BOLD + "~" + ConsoleColors.RESET);
//                                if (day != 0) {
//                                    if (day == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " day ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + day + ConsoleColors.RESET + " days ");
//                                    }
//                                }
//                                if (hour != 0) {
//                                    if (hour == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hour ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + hour + ConsoleColors.RESET + " hours ");
//                                    }
//                                }
//                                if (minute != 0) {
//                                    if (minute == 1) {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minute ");
//                                    } else {
//                                        System.out.print(ConsoleColors.GREEN_BOLD + minute + ConsoleColors.RESET + " minutes ");
//                                    }
//                                }
//                                if (remainder != 0) {
//                                    if (remainder == 1) {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " second");
//                                    } else {
//                                        System.out.println(ConsoleColors.GREEN_BOLD + remainder + ConsoleColors.RESET + " seconds");
//                                    }
//                                }
//                            }
//                            default -> System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
//                        }
//                        break;
//
//                    default:
//                        System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
//                        break;
//                }
//            }
//        } catch (NumberFormatException e) {
//            System.out.println(ConsoleColors.RED_BOLD + "\tPlease provide a positive value." + ConsoleColors.RESET);
//        }
//    }

}
