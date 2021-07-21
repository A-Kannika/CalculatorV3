package uw.tcss305.Controller;

import uw.tcss305.Model.BigIntNum;
import uw.tcss305.Model.DecNum;
import uw.tcss305.Model.HexNum;

public interface HexadecimalConverter {

    HexNum Dec2Hex(DecNum number);
    DecNum Hex2Dec(HexNum number);
    HexNum BigInt2Hex(BigIntNum number);
    BigIntNum Hex2BigInt(HexNum number);

}
