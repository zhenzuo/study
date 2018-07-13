import java.util.Enumeration;
import java.util.Vector;

/**
 * @Description:
 * @author: zuozhen
 * @date: 2018-07-09 09:31:28
 */
public class Customer {
    private String name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rentals Record for" + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
            thisAmount = amountFor(each);
            //determine amounts for each line

            //add frequent renter points
            frequentRenterPoints++;
            //add bonus for a two day new release rental
            if ((each.getMovie().get_priceCode() == Movie.NEW_RELEASE) &&
                    each.get_daysRented() > 1) {
                frequentRenterPoints++;
            }
            //show figures for this rental
            result += "\t" + each.getMovie().get_title() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += totalAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned  " + String.valueOf(frequentRenterPoints) + "frequent renter points";
        return result;
    }

    private double amountFor(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().get_priceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.get_daysRented() > 2) {
                    thisAmount += (each.get_daysRented() - 2) * 1.5;
                    break;
                }
            case Movie.NEW_RELEASE:
                thisAmount += each.get_daysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.get_daysRented() > 3) {
                    thisAmount += (each.get_daysRented() - 3) * 1.5;
                    break;
                }
        }
        return thisAmount;
    }
}
