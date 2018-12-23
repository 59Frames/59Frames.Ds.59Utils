import ca.krasnay.sqlbuilder.InsertBuilder;
import ca.krasnay.sqlbuilder.SelectBuilder;

public class Test {
    public static void main(String[] args) {
        SelectBuilder builder = new SelectBuilder();
        InsertBuilder insertBuilder = new InsertBuilder("users");

        insertBuilder.set("firstName", "'Daniel'");
        insertBuilder.set("lastName", "'Seifert'");

        System.out.println(insertBuilder.toString());

        String query = builder.from("users").column("*").where("firstName = 'Daniel'").and("lastName = 'Seifert'").toString();

        System.out.println(query);
    }
}
