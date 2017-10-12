package server;

import java.io.Serializable;

/**
 * Created by bakla410 on 08.10.17.
 */
public class Operation implements Serializable{

    private CurrencyType type;
    private Double count;

    public Operation(CurrencyType type, Double count) {
        this.type = type;
        this.count = count;
    }

    public CurrencyType getType() {
        return type;
    }

    public void setType(CurrencyType type) {
        this.type = type;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

}
