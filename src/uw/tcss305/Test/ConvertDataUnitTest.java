package uw.tcss305.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uw.tcss305.Controller.ConvertDataUnit;
import uw.tcss305.Model.DataUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertDataUnitTest {

    @Test
    void convertData() {
        Assertions.assertEquals(4000_000_000L, ConvertDataUnit.convertData(DataUnit.MB2b, 500));
        assertEquals(4000_000L, ConvertDataUnit.convertData(DataUnit.MB2kb, 500));
        assertEquals(4000L, ConvertDataUnit.convertData(DataUnit.MB2mb, 500));
        assertEquals(4, ConvertDataUnit.convertData(DataUnit.MB2gb, 500));
        assertEquals(0.004, ConvertDataUnit.convertData(DataUnit.MB2tb, 500));
        assertEquals(500_000_000L, ConvertDataUnit.convertData(DataUnit.MB2B, 500));
        assertEquals(500_000L, ConvertDataUnit.convertData(DataUnit.MB2KB, 500));
        assertEquals(0.5, ConvertDataUnit.convertData(DataUnit.MB2GB, 500));
        assertEquals(0.0005, ConvertDataUnit.convertData(DataUnit.MB2TB, 500));

    }
}