package uw.tcss305.Controller;

import uw.tcss305.Model.DataUnit;

import java.math.BigDecimal;

public class ConvertDataUnit extends BandwidthCalculator{

   

    DataUnit dataUnit;

    public ConvertDataUnit(DataUnit dataUnit) {
        this.dataUnit = dataUnit;
    }

    public void convertDataUnit(int unit, String num){
        try {
            Double.parseDouble(num);
            if (num.startsWith("-")) {
                System.out.println("Please provide a positive value to convert.");
            }else {
                double b = Double.parseDouble(num);
                switch (unit) {
                    //convert from bits
                    case 1 -> {
                        System.out.println(ConsoleColors.GREEN_BOLD + b + " b" + ConsoleColors.RESET + " is equivalent to any of the following:");
                        System.out.println(ConsoleColors.GREEN_BOLD + "\t" + DataUnit.b2kb.convertData(b) + " kilobits (kb)\n\t"
                                + DataUnit.b2mb.convertData(b) + " megabits (mb)\n\t"
                                + DataUnit.b2gb.convertData(b) + " gigabits (gb)\n\t"
                                + DataUnit.b2tb.convertData(b) + " terabits (tb)\n\t"
                                + DataUnit.b2B.convertData(b) + " Bytes (B)\n\t"
                                + DataUnit.b2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                + DataUnit.b2MB.convertData(b) + " Megabytes (MB)\n\t"
                                + DataUnit.b2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                + DataUnit.b2TB.convertData(b) + " Terabytes (TB)" + ConsoleColors.RESET);
                    }
                    // convert from kilobits
                    case 2 -> {
                        System.out.println(ConsoleColors.GREEN_BOLD + b + " kb " + ConsoleColors.RESET + "is equivalent to any of the following:\t");
                        System.out.println(ConsoleColors.GREEN_BOLD + "\t" + DataUnit.kb2b.convertData(b) + " bits (b)\n\t"
                                + DataUnit.kb2mb.convertData(b) + " megabits (mb)\n\t"
                                + DataUnit.kb2gb.convertData(b) + " gigabits (gb)\n\t"
                                + DataUnit.kb2tb.convertData(b) + " terabits (tb)\n\t"
                                + DataUnit.kb2B.convertData(b) + " Bytes (B)\n\t"
                                + DataUnit.kb2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                + DataUnit.kb2MB.convertData(b) + " Megabytes (MB)\n\t"
                                + DataUnit.kb2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                + DataUnit.kb2TB.convertData(b) + " Terabytes (TB)" + ConsoleColors.RESET);
                    }
                    // convert from megabits
                    case 3 -> {
                        System.out.println(ConsoleColors.GREEN_BOLD + b + " mb " + ConsoleColors.RESET + "is equivalent to any of the following:\t");
                        System.out.println(ConsoleColors.GREEN_BOLD + "\t" + DataUnit.mb2b.convertData(b) + " bits (b)\n\t"
                                + DataUnit.mb2kb.convertData(b) + " kilobits (kb)\n\t"
                                + DataUnit.mb2gb.convertData(b) + " gigabits (gb)\n\t"
                                + DataUnit.mb2tb.convertData(b) + " terabits (tb)\n\t"
                                + DataUnit.mb2B.convertData(b) + " Bytes (B)\n\t"
                                + DataUnit.mb2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                + DataUnit.mb2MB.convertData(b) + " Megabytes (MB)\n\t"
                                + DataUnit.mb2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                + DataUnit.mb2TB.convertData(b) + " Terabytes (TB)" + ConsoleColors.RESET);
                    }
                    // convert from gigabits
                    case 4 -> {
                        System.out.println(ConsoleColors.GREEN_BOLD + b + " gb " + ConsoleColors.RESET + "is equivalent to any of the following:\t");
                        System.out.println(ConsoleColors.GREEN_BOLD + "\t" + DataUnit.gb2b.convertData(b) + " bits (b)\n\t"
                                + DataUnit.gb2kb.convertData(b) + " kilobits (kb)\n\t"
                                + DataUnit.gb2mb.convertData(b) + " megabits (mb)\n\t"
                                + DataUnit.gb2tb.convertData(b) + " terabits (tb)\n\t"
                                + DataUnit.gb2B.convertData(b) + " Bytes (B)\n\t"
                                + DataUnit.gb2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                + DataUnit.gb2MB.convertData(b) + " Megabytes (MB)\n\t"
                                + DataUnit.gb2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                + DataUnit.gb2TB.convertData(b) + " Terabytes (TB)" + ConsoleColors.RESET);
                    }
                    // convert from terabits
                    case 5 -> {
                        System.out.println(ConsoleColors.GREEN_BOLD + b + " tb " + ConsoleColors.RESET + "is equivalent to any of the following:\t");
                        System.out.println(ConsoleColors.GREEN_BOLD + "\t" + DataUnit.tb2b.convertData(b) + " bits (b)\n\t"
                                + DataUnit.tb2kb.convertData(b) + " kilobits (kb)\n\t"
                                + DataUnit.tb2mb.convertData(b) + " megabits (mb)\n\t"
                                + DataUnit.tb2gb.convertData(b) + " gigabits (gb)\n\t"
                                + DataUnit.tb2B.convertData(b) + " Bytes (B)\n\t"
                                + DataUnit.tb2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                + DataUnit.tb2MB.convertData(b) + " Megabytes (MB)\n\t"
                                + DataUnit.tb2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                + DataUnit.tb2TB.convertData(b) + " Terabytes (TB)" + ConsoleColors.RESET);
                    }
                    // convert from Bytes
                    case 6 -> {
                        System.out.println(ConsoleColors.GREEN_BOLD + b + " B " + ConsoleColors.RESET + "is equivalent to any of the following:\t");
                        System.out.println(ConsoleColors.GREEN_BOLD + "\t" + DataUnit.B2b.convertData(b) + " bits (b)\n\t"
                                + DataUnit.B2kb.convertData(b) + " kilobits (kb)\n\t"
                                + DataUnit.B2mb.convertData(b) + " megabits (mb)\n\t"
                                + DataUnit.B2gb.convertData(b) + " gigabits (gb)\n\t"
                                + DataUnit.B2tb.convertData(b) + " terabits (tb)\n\t"
                                + DataUnit.B2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                + DataUnit.B2MB.convertData(b) + " Megabytes (MB)\n\t"
                                + DataUnit.B2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                + DataUnit.B2TB.convertData(b) + " Terabytes (TB)" + ConsoleColors.RESET);
                    }
                    // convert from Kilobytes
                    case 7 -> {
                        System.out.println(ConsoleColors.GREEN_BOLD + b + " KB " + ConsoleColors.RESET + "is equivalent to any of the following:\t");
                        System.out.println(ConsoleColors.GREEN_BOLD + "\t" + DataUnit.KB2b.convertData(b) + " bits (b)\n\t"
                                + DataUnit.KB2kb.convertData(b) + " kilobits (kb)\n\t"
                                + DataUnit.KB2mb.convertData(b) + " megabits (mb)\n\t"
                                + DataUnit.KB2gb.convertData(b) + " gigabits (gb)\n\t"
                                + DataUnit.KB2tb.convertData(b) + " terabits (tb)\n\t"
                                + DataUnit.KB2B.convertData(b) + " Bytes (B)\n\t"
                                + DataUnit.KB2MB.convertData(b) + " Megabytes (MB)\n\t"
                                + DataUnit.KB2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                + DataUnit.KB2TB.convertData(b) + " Terabytes (TB)" + ConsoleColors.RESET);
                    }
                    // convert from Megabytes
                    case 8 -> {
                        System.out.println(ConsoleColors.GREEN_BOLD + b + " MB " + ConsoleColors.RESET + "is equivalent to any of the following:\t");
                        System.out.println(ConsoleColors.GREEN_BOLD + "\t" + DataUnit.MB2b.convertData(b) + " bits (b)\n\t"
                                + DataUnit.MB2kb.convertData(b) + " kilobits (kb)\n\t"
                                + DataUnit.MB2mb.convertData(b) + " megabits (mb)\n\t"
                                + DataUnit.MB2gb.convertData(b) + " gigabits (gb)\n\t"
                                + DataUnit.MB2tb.convertData(b) + " terabits (tb)\n\t"
                                + DataUnit.MB2B.convertData(b) + " Bytes (B)\n\t"
                                + DataUnit.MB2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                + DataUnit.MB2GB.convertData(b) + " Gigabytes (GB)\n\t"
                                + DataUnit.MB2TB.convertData(b) + " Terabytes (TB)" + ConsoleColors.RESET);
                    }
                    // convert from Gigabytes
                    case 9 -> {
                        System.out.println(ConsoleColors.GREEN_BOLD + b + " GB " + ConsoleColors.RESET + "is equivalent to any of the following:\t");
                        System.out.println(ConsoleColors.GREEN_BOLD + "\t" + DataUnit.GB2b.convertData(b) + " bits (b)\n\t"
                                + DataUnit.GB2kb.convertData(b) + " kilobits (kb)\n\t"
                                + DataUnit.GB2mb.convertData(b) + " megabits (mb)\n\t"
                                + DataUnit.GB2gb.convertData(b) + " gigabits (gb)\n\t"
                                + DataUnit.GB2tb.convertData(b) + " terabits (tb)\n\t"
                                + DataUnit.GB2B.convertData(b) + " Bytes (B)\n\t"
                                + DataUnit.GB2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                + DataUnit.GB2MB.convertData(b) + " Megabytes (MB)\n\t"
                                + DataUnit.GB2TB.convertData(b) + " Terabytes (TB)" + ConsoleColors.RESET);
                    }
                    // convert from Terabytes
                    case 10 -> {
                        System.out.println(ConsoleColors.GREEN_BOLD + b + " TB " + ConsoleColors.RESET + "is equivalent to any of the following:\t");
                        System.out.println(ConsoleColors.GREEN_BOLD + "\t" + DataUnit.TB2b.convertData(b) + " bits (b)\n\t"
                                + DataUnit.TB2kb.convertData(b) + " kilobits (kb)\n\t"
                                + DataUnit.TB2mb.convertData(b) + " megabits (mb)\n\t"
                                + DataUnit.TB2gb.convertData(b) + " gigabits (gb)\n\t"
                                + DataUnit.TB2tb.convertData(b) + " terabits (tb)\n\t"
                                + DataUnit.TB2B.convertData(b) + " Bytes (B)\n\t"
                                + DataUnit.TB2KB.convertData(b) + " Kilobytes (KB)\n\t"
                                + DataUnit.TB2MB.convertData(b) + " Megabytes (MB)\n\t"
                                + DataUnit.TB2GB.convertData(b) + " Gigabytes (GB)" + ConsoleColors.RESET);
                    }
                    default -> System.out.println(ConsoleColors.RED_BOLD + "\tYou choose invalid unit!" + ConsoleColors.RESET);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please provide a positive value to convert.");
        }
    }
    public static double convertData(DataUnit dataUnit, double b){

        return switch (dataUnit) {
            case b2kb -> new BigDecimal(Double.toString(b / 1_000L)).doubleValue();
            case b2mb -> new BigDecimal(Double.toString(b / 1_000_000L)).doubleValue();
            case b2gb -> new BigDecimal(Double.toString(b / 1_000_000_000L)).doubleValue();
            case b2tb -> new BigDecimal(Double.toString(b / 1_000_000_000_000L)).doubleValue();
            case b2B -> new BigDecimal(Double.toString(b / 8L)).doubleValue();
            case b2KB -> new BigDecimal(Double.toString(b / 8_000L)).doubleValue();
            case b2MB -> new BigDecimal(Double.toString(b / 8_000_000L)).doubleValue();
            case b2GB -> new BigDecimal(Double.toString(b / 8_000_000_000L)).doubleValue();
            case b2TB -> new BigDecimal(Double.toString(b / 8_000_000_000_000L)).doubleValue();
            case kb2b -> new BigDecimal(Double.toString(b * 1_000L)).doubleValue();
            case kb2mb -> new BigDecimal(Double.toString(b / 1_000L)).doubleValue();
            case kb2gb -> new BigDecimal(Double.toString(b / 1_000_000L)).doubleValue();
            case kb2tb -> new BigDecimal(Double.toString(b / 1_000_000_000L)).doubleValue();
            case kb2B -> new BigDecimal(Double.toString(b * 1000L / 8)).doubleValue();
            case kb2KB -> new BigDecimal(Double.toString(b / 8L)).doubleValue();
            case kb2MB -> new BigDecimal(Double.toString(b / 8_000L)).doubleValue();
            case kb2GB -> new BigDecimal(Double.toString(b / 8_000_000L)).doubleValue();
            case kb2TB -> new BigDecimal(Double.toString(b / 8_000_000_000L)).doubleValue();
            case mb2b -> new BigDecimal(Double.toString(b * 1_000_000L)).doubleValue();
            case mb2kb -> new BigDecimal(Double.toString(b * 1_000L)).doubleValue();
            case mb2gb -> new BigDecimal(Double.toString(b / 1_000L)).doubleValue();
            case mb2tb -> new BigDecimal(Double.toString(b / 1_000_000L)).doubleValue();
            case mb2B -> new BigDecimal(Double.toString(b * 1_000_000L / 8)).doubleValue();
            case mb2KB -> new BigDecimal(Double.toString(b * 1_000L / 8)).doubleValue();
            case mb2MB -> new BigDecimal(Double.toString(b / 8L)).doubleValue();
            case mb2GB -> new BigDecimal(Double.toString(b / 8_000L)).doubleValue();
            case mb2TB -> new BigDecimal(Double.toString(b / 8_000_000L)).doubleValue();
            case gb2b -> new BigDecimal(Double.toString(b * 1_000_000_000L)).doubleValue();
            case gb2kb -> new BigDecimal(Double.toString(b * 1_000_000L)).doubleValue();
            case gb2mb -> new BigDecimal(Double.toString(b * 1_000L)).doubleValue();
            case gb2tb -> new BigDecimal(Double.toString(b / 1_000L)).doubleValue();
            case gb2B -> new BigDecimal(Double.toString(b * 1_000_000_000L / 8)).doubleValue();
            case gb2KB -> new BigDecimal(Double.toString(b * 1_000_000L / 8)).doubleValue();
            case gb2MB -> new BigDecimal(Double.toString(b * 1_000L / 8)).doubleValue();
            case gb2GB -> new BigDecimal(Double.toString(b / 8)).doubleValue();
            case gb2TB -> new BigDecimal(Double.toString(b / 8_000L)).doubleValue();
            case tb2b -> new BigDecimal(Double.toString(b * 1_000_000_000_000L)).doubleValue();
            case tb2kb -> new BigDecimal(Double.toString(b * 1_000_000_000L)).doubleValue();
            case tb2mb -> new BigDecimal(Double.toString(b * 1_000_000L)).doubleValue();
            case tb2gb -> new BigDecimal(Double.toString(b * 1_000L)).doubleValue();
            case tb2B -> new BigDecimal(Double.toString(b * 1_000_000_000_000L / 8)).doubleValue();
            case tb2KB -> new BigDecimal(Double.toString(b * 1_000_000_000L / 8)).doubleValue();
            case tb2MB -> new BigDecimal(Double.toString(b * 1_000_000L / 8)).doubleValue();
            case tb2GB -> new BigDecimal(Double.toString(b * 1_000L / 8)).doubleValue();
            case tb2TB -> new BigDecimal(Double.toString(b / 8L)).doubleValue();
            case B2b -> new BigDecimal(Double.toString(b * 8)).doubleValue();
            case B2kb -> new BigDecimal(Double.toString(b * 8 / 1_000L)).doubleValue();
            case B2mb -> new BigDecimal(Double.toString(b * 8 / 1_000_000L)).doubleValue();
            case B2gb -> new BigDecimal(Double.toString(b * 8 / 1_000_000_000L)).doubleValue();
            case B2tb -> new BigDecimal(Double.toString(b * 8 / 1_000_000_000_000L)).doubleValue();
            case B2KB -> new BigDecimal(Double.toString(b * 1_000L)).doubleValue();
            case B2MB -> new BigDecimal(Double.toString(b * 1_000_000L)).doubleValue();
            case B2GB -> new BigDecimal(Double.toString(b * 1_000_000_000L)).doubleValue();
            case B2TB -> new BigDecimal(Double.toString(b * 1_000_000_000_000L)).doubleValue();
            case KB2b -> new BigDecimal(Double.toString(b * 8_000L)).doubleValue();
            case KB2kb -> new BigDecimal(Double.toString(b * 8L)).doubleValue();
            case KB2mb -> new BigDecimal(Double.toString(b * 8 / 1_000L)).doubleValue();
            case KB2gb -> new BigDecimal(Double.toString(b * 8 / 1_000_000L)).doubleValue();
            case KB2tb -> new BigDecimal(Double.toString(b * 8 / 1_000_000_000L)).doubleValue();
            case KB2B -> new BigDecimal(Double.toString(b * 1_000L)).doubleValue();
            case KB2MB -> new BigDecimal(Double.toString(b / 1_000L)).doubleValue();
            case KB2GB -> new BigDecimal(Double.toString(b / 1_000_000L)).doubleValue();
            case KB2TB -> new BigDecimal(Double.toString(b / 1_000_000_000L)).doubleValue();
            case MB2b -> new BigDecimal(Double.toString(b * 8_000_000L)).doubleValue();
            case MB2kb -> new BigDecimal(Double.toString(b * 8_000L)).doubleValue();
            case MB2mb -> new BigDecimal(Double.toString(b * 8L)).doubleValue();
            case MB2gb -> new BigDecimal(Double.toString(b * 8 / 1_000L)).doubleValue();
            case MB2tb -> new BigDecimal(Double.toString(b * 8 / 1_000_000L)).doubleValue();
            case MB2B -> new BigDecimal(Double.toString(b * 1_000_000L)).doubleValue();
            case MB2KB -> new BigDecimal(Double.toString(b * 1_000L)).doubleValue();
            case MB2GB -> new BigDecimal(Double.toString(b / 1_000L)).doubleValue();
            case MB2TB -> new BigDecimal(Double.toString(b / 1_000_000L)).doubleValue();
            case GB2b -> new BigDecimal(Double.toString(b * 8_000_000_000L)).doubleValue();
            case GB2kb -> new BigDecimal(Double.toString(b * 8_000_000L)).doubleValue();
            case GB2mb -> new BigDecimal(Double.toString(b * 8_000L)).doubleValue();
            case GB2gb -> new BigDecimal(Double.toString(b * 8L)).doubleValue();
            case GB2tb -> new BigDecimal(Double.toString(b * 8 / 1_000L)).doubleValue();
            case GB2B -> new BigDecimal(Double.toString(b * 1_000_000_000L)).doubleValue();
            case GB2KB -> new BigDecimal(Double.toString(b * 1_000_000L)).doubleValue();
            case GB2MB -> new BigDecimal(Double.toString(b * 1_000L)).doubleValue();
            case GB2TB -> new BigDecimal(Double.toString(b / 1_000L)).doubleValue();
            case TB2b -> new BigDecimal(Double.toString(b * 8_000_000_000_000L)).doubleValue();
            case TB2kb -> new BigDecimal(Double.toString(b * 8_000_000_000L)).doubleValue();
            case TB2mb -> new BigDecimal(Double.toString(b * 8_000_000L)).doubleValue();
            case TB2gb -> new BigDecimal(Double.toString(b * 8_000L)).doubleValue();
            case TB2tb -> new BigDecimal(Double.toString(b * 8L)).doubleValue();
            case TB2B -> new BigDecimal(Double.toString(b * 1_000_000_000_000L)).doubleValue();
            case TB2KB -> new BigDecimal(Double.toString(b * 1_000_000_000L)).doubleValue();
            case TB2MB -> new BigDecimal(Double.toString(b * 1_000_000L)).doubleValue();
            case TB2GB -> new BigDecimal(Double.toString(b * 1_000L)).doubleValue();
        };
    }
}
