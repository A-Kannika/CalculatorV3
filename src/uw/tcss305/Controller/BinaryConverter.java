package uw.tcss305.Controller;

import uw.tcss305.Model.BigIntNum;
import uw.tcss305.Model.BinNum;
import uw.tcss305.Model.DecNum;

public interface BinaryConverter {

    BinNum Dec2Bin (DecNum number);

    DecNum Bin2Dec (BinNum number);

    BinNum BigInt2Bin (BigIntNum number);

    BigIntNum Bin2BigInt (BinNum number);


}
