class GymMember {
    protected String memberId;
    protected int monthlyFee;

    private int[] lateFeeHistory = new int[10];
    private int feeCount = 0;

    public GymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    protected void chargeLateFee(int amount) {

        if (feeCount < lateFeeHistory.length) {
            lateFeeHistory[feeCount] = amount;
            feeCount++;
        }
    }

    public int[] getLateFeeHistory() {

        int[] copy = new int[feeCount];

        for (int i = 0; i < feeCount; i++) {
            copy[i] = lateFeeHistory[i];
        }

        return copy;
    }

    public int getTotalLateFees() {

        int total = 0;

        for (int i = 0; i < feeCount; i++) {
            total += lateFeeHistory[i];
        }

        return total;
    }
}

class PremiumMember extends GymMember {

    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee,
                         String trainerName) {

        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}

public class PremiumLateFee {

    public static void main(String[] args) {

        PremiumMember p =
            new PremiumMember(
                "MEM5", 2000, "Coach Riya"
            );

        p.chargeLateFee(200);

        System.out.println(
            "Total Late Fee: "
            + p.getTotalLateFees()
        );

        int[] history = p.getLateFeeHistory();

        history[0] = 999;

        int[] newHistory = p.getLateFeeHistory();

        System.out.println(
            "Fee History: ["
            + newHistory[0] + "]"
        );
    }
}