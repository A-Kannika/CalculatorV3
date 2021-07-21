package uw.tcss305.Model;

public enum CalcTime {

    sec2minute, sec2hour, sec2day, sec2week, sec2month, sec2year,
    minute2sec, hour2sec, day2sec, week2sec, month2sec, year2sec,
    minute2month, hour2month, day2month, week2month, year2month;

    public double CalcTime(double b){
        return switch (this) {
            case sec2minute -> b / 60.0;
            case sec2hour -> b / (60 * 60.0);
            case sec2day -> b / (24 * 60 * 60.0);
            case sec2week -> b / (7 * 24 * 60 * 60.0);
            case sec2month -> b / (30.4375 * 24 * 60 * 60.0);
            case sec2year -> b / (365.25 * 24 * 60 * 60.0);
            case minute2sec -> b * 60.0;
            case hour2sec -> b * (60 * 60.0);
            case day2sec -> b * (24 * 60 * 60.0);
            case week2sec -> b * (7 * 24 * 60 * 60.0);
            case month2sec -> b * (30.4375 * 24 * 60 * 60.0);
            case year2sec -> b * (365.25 * 24 * 60 * 60.0);
            case minute2month -> b / (30.4375 * 24 * 60.0);
            case hour2month -> b / (30.4375 * 24);
            case day2month -> b / (30.4375);
            case week2month -> b * 7 / 30.4375;
            case year2month -> b * 365.25 / 30.4375;
        };
    }
}
