package cz.com.simplefirst;

import java.io.Serializable;

public class Bean implements Serializable {
    private String name;
    private int id11, id12, id13, id21, id22, id23, id31, id32, id33;

    public Bean(String name, int id11, int id12, int id13, int id21, int id22, int id23, int id31, int id32, int id33) {
        this.name = name;
        this.id11 = id11;
        this.id12 = id12;
        this.id13 = id13;
        this.id21 = id21;
        this.id22 = id22;
        this.id23 = id23;
        this.id31 = id31;
        this.id32 = id32;
        this.id33 = id33;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId11() {
        return id11;
    }

    public void setId11(int id11) {
        this.id11 = id11;
    }

    public int getId12() {
        return id12;
    }

    public void setId12(int id12) {
        this.id12 = id12;
    }

    public int getId13() {
        return id13;
    }

    public void setId13(int id13) {
        this.id13 = id13;
    }

    public int getId21() {
        return id21;
    }

    public void setId21(int id21) {
        this.id21 = id21;
    }

    public int getId22() {
        return id22;
    }

    public void setId22(int id22) {
        this.id22 = id22;
    }

    public int getId23() {
        return id23;
    }

    public void setId23(int id23) {
        this.id23 = id23;
    }

    public int getId31() {
        return id31;
    }

    public void setId31(int id31) {
        this.id31 = id31;
    }

    public int getId32() {
        return id32;
    }

    public void setId32(int id32) {
        this.id32 = id32;
    }

    public int getId33() {
        return id33;
    }

    public void setId33(int id33) {
        this.id33 = id33;
    }
}
