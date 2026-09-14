import java.util.Arrays;

class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String id, String[] seats) {
        bookingId = id;
        seatNumbers = Arrays.copyOf(seats, seats.length);
    }

    String[] getSeatNumbers() {
        return Arrays.copyOf(seatNumbers, seatNumbers.length);
    }

    BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] x = getSeatNumbers();
        x[index] = newSeat;
        return new BookingReceipt(bookingId, x);
    }
}

class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;

    public GroupBookingReceipt(String id, String[] seats, int size) {
        super(id, seats);
        groupSize = size;
    }
}

public class BookingReceiptSettlement {

    static String processNightlySettlement(BookingReceipt[] a) {
        int processed = 0, skipped = 0, group = 0, individual = 0;

        for (BookingReceipt x : a) {
            if (x == null) {
                skipped++;
                continue;
            }

            processed++;

            if (x instanceof GroupBookingReceipt)
                group++;
            else
                individual++;
        }

        return processed + " processed | " + skipped +
               " null skipped | " + group + " group | " +
               individual + " individual";
    }

    public static void main(String[] args) {

        BookingReceipt[] a = {
            new GroupBookingReceipt(
                "CH-2002", new String[]{"B1","B2"}, 2),
            null,
            new BookingReceipt(
                "CH-3003", new String[]{"C1"})
        };

        System.out.println(processNightlySettlement(a));
    }
}