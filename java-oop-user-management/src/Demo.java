public class Demo {
    public static void main(String[] args) {

        AdminUser admin = new AdminUserImpl("rootAdmin");
        admin.login();

        admin.createUser("ivan", false);
        admin.createUser("maria", false);
        User georgiUser = admin.createUser("georgi", true);
        admin.createUser("elena", false);

        admin.createUser("ivan", true); // duplicate -> rejected

        admin.createUser("u1", false);
        admin.createUser("u2", false);
        admin.createUser("u3", false);
        admin.createUser("u4", false);
        admin.createUser("u5", false);
        admin.createUser("u6", false); // 11th -> database full

        admin.printAllUsers();

        System.out.println();

        admin.deleteUser("maria");
        admin.deleteUser("doesNotExist"); // not found

        System.out.println();
        admin.printAllUsers();

        // Polymorphism: georgi was created as admin -> can manage his own users
        if (georgiUser instanceof AdminUser) {
            AdminUser georgiAdmin = (AdminUser) georgiUser;

            georgiAdmin.createUser("newGuy", false);
            georgiAdmin.createUser("anotherGuy", false);

            System.out.println("\n--- Georgi's database ---");
            georgiAdmin.printAllUsers();
        }

        System.out.println("\n--- EMPTY DATABASE DELETE TEST ---");
        AdminUser emptyAdmin = new AdminUserImpl("emptyOwner");
        emptyAdmin.deleteUser("someone");
    }
}
