public class SubclassTicketAccess {

    static String classifyAccess(String m, String c) {

        if (m.equals("public"))
            return "ALLOWED";

        if (m.equals("private") || m.equals("default"))
            return (c.equals("SAME_CLASS") ||
                   (m.equals("default") && c.equals("SAME_PACKAGE")))
                   ? "ALLOWED" : "DENIED";

        if (m.equals("protected"))
            return (c.equals("SAME_CLASS") ||
                   c.equals("SAME_PACKAGE") ||
                   c.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"))
                   ? "ALLOWED" : "DENIED";

        return "DENIED";
    }

    public static void main(String[] args) {

        System.out.println(
            classifyAccess("protected",
            "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));

        System.out.println(
            classifyAccess("protected",
            "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}