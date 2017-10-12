package server; /**
 * Created by bakla410 on 08.10.17.
 */

/**
 * Тип наличных денег
 *
 */
public enum CurrencyType {

    RUR("рубль"),
    EUR("евро"),
    USD("доллар");

    private String name;

    CurrencyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
