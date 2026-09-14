class CineScreen {
    private int seatsTotal;
    private int seatsAvailable;

    CineScreen(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Invalid seats");
        seatsTotal = n;
        seatsAvailable = n;
    }

    void bookSeat() {
        if (seatsAvailable > 0)
            seatsAvailable--;
    }

    void cancelBooking() {
        if (seatsAvailable < seatsTotal)
            seatsAvailable++;
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }
}

public class SeatBookingEncapsulationGuard {
    public static void main(String[] args) {

        CineScreen c = new CineScreen(2);

        c.bookSeat();
        c.bookSeat();
        c.bookSeat();

        System.out.println(c.getSeatsAvailable());

        c.cancelBooking();
        c.cancelBooking();
        c.cancelBooking();

        System.out.println(c.getSeatsAvailable());
    }
}