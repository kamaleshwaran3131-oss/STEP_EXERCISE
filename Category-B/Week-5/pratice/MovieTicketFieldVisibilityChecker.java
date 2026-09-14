class MovieTicket {
    private String seatNumber;
    String screenId;
    protected double ticketPrice;
    public String movieTitle;
}

public class MovieTicketFieldVisibilityChecker {

    static String classifyAccess(String m, String c) {
        if (m.equals("private"))
            return c.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";

        if (m.equals("default"))
            return (c.equals("SAME_CLASS") || c.equals("SAME_PACKAGE"))
                    ? "ALLOWED" : "DENIED";

        if (m.equals("protected"))
            return (c.equals("SAME_CLASS") || c.equals("SAME_PACKAGE"))
                    ? "ALLOWED" : "DENIED";

        return "ALLOWED";
    }

    static String summarizeBatch(String[][] a) {
        int yes = 0, no = 0;

        for (String[] x : a) {
            if (classifyAccess(x[0], x[1]).equals("ALLOWED"))
                yes++;
            else
                no++;
        }

        return "Allowed: " + yes + " | Denied: " + no;
    }

    public static void main(String[] args) {

        String[][] a = {
            {"default","SAME_PACKAGE"},
            {"default","DIFFERENT_PACKAGE"},
            {"public","DIFFERENT_PACKAGE"}
        };

        System.out.println(summarizeBatch(a));
    }
}