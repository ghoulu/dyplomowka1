package dyplomowka;

public class ParametryTemp {
    int tempWysw;
    int tempZadana;

    public ParametryTemp(int tempWysw, int tempZadana) {
        this.tempWysw = tempWysw;
        this.tempZadana = tempZadana;

    }

    public ParametryTemp(int tempWysw) {
        this.tempWysw = tempWysw;
    }

    public ParametryTemp() {

    }

    public int getTempWysw() {
        return tempWysw;
    }

    public int getTempZadana() {
        return tempZadana;
    }

    public void setTempWysw(int tempWysw) {
        this.tempWysw = tempWysw;
    }

    public void setTempZadana(int tempZadana) {
        this.tempZadana = tempZadana;
    }
}
