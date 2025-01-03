package ATM;

public class Notes implements Cloneable{
    protected int denomination;
    protected int amount;
    protected int note;

    public Notes(int denomination, int amount, int quantity) {
        this.denomination = denomination;
        this.amount = amount;
        this.note = quantity;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int a){
        this.note=a;
    }


    @Override
    public String toString() {
        return denomination + " * " + note + " = " + amount;
    }

    public int getDenomination() {
        return denomination;
    }

    public Notes clone() throws CloneNotSupportedException {
        return (Notes) super.clone();
    }
}

class Twoo extends Notes {
    public Twoo(int denomination, int amount, int quantity) {
        super(denomination, amount, quantity);
    }
}

class Five extends Notes {
    public Five(int denomination, int amount, int quantity) {
        super(denomination, amount, quantity);
    }
}

class Two extends Notes {
    public Two(int denomination, int amount, int quantity) {
        super(denomination, amount, quantity);
    }
}

class One extends Notes {
    public One(int denomination, int amount, int quantity) {
        super(denomination, amount, quantity);
    }
}
