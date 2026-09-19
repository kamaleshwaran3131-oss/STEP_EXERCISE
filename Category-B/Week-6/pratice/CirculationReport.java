class LibraryMember {

    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    public LibraryMember(
            String memberId,
            int borrowLimit) {

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }

    public void borrowBook() {
        booksBorrowed++;
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public void displayInfo() {
        System.out.print(
            "General | Books: "
            + booksBorrowed
        );
    }
}

class StudentMember extends LibraryMember {

    private String course;

    public StudentMember(
            String memberId,
            int borrowLimit,
            String course) {

        super(memberId, borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void displayInfo() {
        System.out.print(
            "Student | Course: "
            + course
            + " | Books: "
            + booksBorrowed
        );
    }
}

public class CirculationReport {

    public static String batchPrint(
            LibraryMember[] members) {

        StringBuilder result =
            new StringBuilder();

        for (LibraryMember member : members) {

            member.displayInfo();

            if (member instanceof StudentMember) {

                StudentMember student =
                    (StudentMember) member;

                result.append(
                    "Student | Course: "
                    + student.getCourse()
                    + " | Books: "
                    + student.getBooksBorrowed()
                    + " [Course via downcast: "
                    + student.getCourse()
                    + "] | "
                );

            } else {

                result.append(
                    "General | Books: "
                    + member.getBooksBorrowed()
                    + " | "
                );
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        LibraryMember general =
            new LibraryMember("LB5", 3);

        StudentMember student =
            new StudentMember(
                "STU6", 3, "ECE"
            );

        LibraryMember[] members = {
            general, student
        };

        System.out.println();
        System.out.println(
            batchPrint(members)
        );
    }
}