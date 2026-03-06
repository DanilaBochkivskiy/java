import java.util.Objects;

public class Dvigatel {
    private String tip;
    private int moshnost;

    public Dvigatel(String tip, int moshnost) {
        this.tip = tip;
        this.moshnost = moshnost;
    }

    public String getTip() {
        return tip;
    }

    public int getMoshnost() {
        return moshnost;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setMoshnost(int moshnost) {
        this.moshnost = moshnost;
    }

    @Override
    public String toString() {
        return "Двигатель(" + "тип=" + tip + '\'' + ", мошность=" + moshnost + ')';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dvigatel dvigatel = (Dvigatel) obj;
        return moshnost == dvigatel.moshnost &&
                Objects.equals(tip, dvigatel.tip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tip, moshnost);
    }

}
