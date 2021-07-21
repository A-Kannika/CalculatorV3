package uw.tcss305.Model;

import java.math.BigDecimal;

public enum DataUnit {

    b2kb, b2mb, b2gb, b2tb, b2B, b2KB, b2MB, b2GB, b2TB,
    kb2b, kb2mb, kb2gb, kb2tb, kb2B, kb2KB, kb2MB, kb2GB, kb2TB,
    mb2b, mb2kb, mb2gb, mb2tb, mb2B, mb2KB, mb2MB, mb2GB, mb2TB,
    gb2b, gb2kb, gb2mb, gb2tb, gb2B, gb2KB, gb2MB, gb2GB, gb2TB,
    tb2b, tb2kb, tb2mb, tb2gb, tb2B, tb2KB, tb2MB, tb2GB, tb2TB,
    B2b, B2kb, B2mb, B2gb, B2tb, B2KB, B2MB, B2GB, B2TB,
    KB2b, KB2kb, KB2mb, KB2gb, KB2tb, KB2B, KB2MB, KB2GB, KB2TB,
    MB2b, MB2kb, MB2mb, MB2gb, MB2tb, MB2B, MB2KB, MB2GB, MB2TB,
    GB2b, GB2kb, GB2mb, GB2gb, GB2tb, GB2B, GB2KB, GB2MB, GB2TB,
    TB2b, TB2kb, TB2mb, TB2gb, TB2tb, TB2B, TB2KB, TB2MB, TB2GB;

    public double convertData(double b){

        return switch (this) {
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
            case B2KB -> new BigDecimal(Double.toString(b / 1_000L)).doubleValue();
            case B2MB -> new BigDecimal(Double.toString(b / 1_000_000L)).doubleValue();
            case B2GB -> new BigDecimal(Double.toString(b / 1_000_000_000L)).doubleValue();
            case B2TB -> new BigDecimal(Double.toString(b / 1_000_000_000_000L)).doubleValue();
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
