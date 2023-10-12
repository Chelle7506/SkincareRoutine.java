public class Help {
    protected static String description;

    public Help(String description){

        this.description = description;
    }

    public static String about() {

        return description;

    }

}
