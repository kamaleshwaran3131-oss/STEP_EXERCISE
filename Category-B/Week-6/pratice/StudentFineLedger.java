class LibraryMember {

    private int[] fineHistory = new int[10];
    private int fineCount = 0;

    protected void chargeFine(int amount) {

        if (fineCount < fineHistory.length) {
            fineHistory[fineCount] = amount;
            fineCount++;
        }
    }

    public int[] getFineHistory() {

        int[] copy = new int[fineCount];

        for (int i = 0; i < fineCount; i++) {
            copy[i] = fineHistory[i];
        }

        return copy;
    }

    public int getTotalFine() {

        int total = 0;

        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }

        return total;
    }
}

class StudentMember extends LibraryMember {

    private String memberId;
    private int borrowLimit;
    private String course;

    public StudentMember(
            String memberId,
            int borrowLimit,
            String course) {

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.course = course;
    }

    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}

public class StudentFineLedger {

    public static void main(String[] args) {

        StudentMember s =
            new StudentMember(
                "STU5", 3, "CSE"
            );

        s.chargeFine(100);

        System.out.println(
            "Total Fine: "
            + s.getTotalFine()
        );

        int[] history = s.getFineHistory();

        history[0] = 999;

        int[] newHistory = s.getFineHistory();

        System.out.println(
            "Fine History: ["
            + newHistory[0] + "]"
        );
    }
}