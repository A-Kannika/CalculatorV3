package uw.tcss305.Test;

import org.junit.jupiter.api.Test;
import uw.tcss305.Controller.ConvertHostingBandwidth;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertHostingBandwidthTest {

    @Test
    void convertMUsage2BWidth() {
        assertEquals(3.042056430146779, ConvertHostingBandwidth.ConvertMUsage2BWidth(4,"1000",3));
    }

    @Test
    void convertBWidth2MUsage() {
        assertEquals(328725, ConvertHostingBandwidth.ConvertBWidth2MUsage(3, "1000", 4));
    }
}