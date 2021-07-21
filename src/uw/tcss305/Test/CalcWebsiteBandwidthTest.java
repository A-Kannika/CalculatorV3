package uw.tcss305.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uw.tcss305.Controller.CalcWebsiteBandwidth;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalcWebsiteBandwidthTest {

    @Test
    void calcBandwidthWithR() {
        Assertions.assertEquals(0.462962962962963, CalcWebsiteBandwidth.CalcBandwidthWithR(4, "5000", 2, "500", "2"));
    }

    @Test
    void calcBandwidth() {
        assertEquals( 0.2314814814814815, CalcWebsiteBandwidth.CalcBandwidth(4, "5000", 2, "500", "1"));
    }

    @Test
    void calcMonthlyUsage() {
        assertEquals( 76.09375, CalcWebsiteBandwidth.CalcMonthlyUsage(4, "5000", 2, "500", "1"));
    }

    @Test
    void calcMonthlyUsageWithR() {
        assertEquals( 152.1875, CalcWebsiteBandwidth.CalcMonthlyUsageWithR(4, "5000", 2, "500", "2"));
    }
}