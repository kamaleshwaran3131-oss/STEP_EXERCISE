class GymMember {

    protected int monthlyFee;
    private int feesPaid;

    private static int membersEnrolled = 0;

    public final String membershipNumber;

    public GymMember(int monthlyFee) {

        this.monthlyFee = monthlyFee;
        this.feesPaid = 0;

        membersEnrolled++;

        membershipNumber =
            "GYM-" + (2000 + membersEnrolled);
    }

    public void payFee(int amount) {
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {

        System.out.println(
            "Payment Mode: " + mode
        );

        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public static boolean isValidReferralCode(
            String code) {

        if (code == null || code.length() != 4) {
            return false;
        }

        if (code.charAt(0) != 'G') {
            return false;
        }

        if (!Character.isDigit(code.charAt(1))) {
            return false;
        }

        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }

        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }

        return true;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }
}

class GroupClassMember extends GymMember {

    private String className;

    public GroupClassMember(
            int monthlyFee,
            String className) {

        super(monthlyFee);
        this.className = className;
    }
}

public class GymSettlement {

    public static String processWeeklyCheckIn(
            GymMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMember member : members) {

            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof GroupClassMember) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | "
             + nullSkipped + " null skipped | "
             + group + " group | "
             + individual + " individual";
    }

    public static void main(String[] args) {

        GymMember m1 =
            new GymMember(1000);

        System.out.println(
            "Membership Number: "
            + m1.membershipNumber
        );

        System.out.println(
            "Members Enrolled: "
            + GymMember.getMembersEnrolled()
        );

        System.out.println(
            "G45B: "
            + GymMember.isValidReferralCode("G45B")
        );

        System.out.println(
            "G4B: "
            + GymMember.isValidReferralCode("G4B")
        );

        System.out.println(
            "X45B: "
            + GymMember.isValidReferralCode("X45B")
        );

        m1.payFee(500);
        m1.payFee(500, "UPI");

        System.out.println(
            "Fees Paid: " + m1.getFeesPaid()
        );

        GroupClassMember group =
            new GroupClassMember(1500, "Zumba");

        GymMember m2 =
            new GymMember(1000);

        GymMember[] members = {
            group, null, m2
        };

        System.out.println(
            GymSettlement.processWeeklyCheckIn(members)
        );
    }
}