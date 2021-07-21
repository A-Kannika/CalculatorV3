package uw.tcss305.Test;

import org.junit.jupiter.api.Test;
import uw.tcss305.Controller.CalcDownloadUploadTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalcDownloadUploadTimeTest {

    @Test
    void time() {
        double result = 800.0;
        assertEquals(result, CalcDownloadUploadTime.time(3,"500", 3, "5"));
    }
}