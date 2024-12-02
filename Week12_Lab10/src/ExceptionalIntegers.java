import java.util.ArrayList;

public class ExceptionalIntegers {

    private static Integer convertToInteger(String input) throws NumberFormatException {
        int integerValue = Integer.parseInt(input);
        return Integer.valueOf(integerValue);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("WEEK 12 - LAB 10");

        ArrayList <Integer> myInfoList = new ArrayList<Integer>();

        for (String arg : args) {
            try {
                Integer validInteger = convertToInteger(arg);
                System.out.println("Converter method says Integer OK - " + validInteger);
                myInfoList.add(validInteger);
            }
            catch (NumberFormatException exception) {
                System.out.println("Catch block says the argument \"" + arg + "\" is ignored because " + arg);
            }
        }

        System.out.println("\nThe ArrayList contents are: ");

        for (int index = 0; index < myInfoList.size(); index++) {
            System.out.println("Item " + index + " is " + myInfoList.get(index));
        }
    }

}

