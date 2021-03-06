/**
 * @Description:
 * @author: zuozhen
 * @date: 2018-07-09 09:25:23
 */
public class Movie {
    public static final int CHILDRENS=2;
    public static final int REGULAR=0;
    public static final int NEW_RELEASE=1;

    private String _title;
    private int _priceCode;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }

    public String get_title() {
        return _title;
    }

    public int get_priceCode() {
        return _priceCode;
    }

    public void set_priceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }
}
