package primitiveandreference;

public class StringSample {
    public static void main(String[] args) {
        String myString = "myString";
        String byteString = "10";
        byte fromStringByte = Byte.parseByte(byteString);
        String falseString = "false";
        String trueString = "true";
        boolean fromStringBool = Boolean.parseBoolean(falseString);


        float fromLiteral = 10.123f;


        long fromLiteralLong = 10000000L;

        String floatString1 = "10.123";
        String floatString2 = "10.123";
        String floatString3 = "10.123";

        String floatString4 = new String("10.123");

        float fromStringFloat = Float.parseFloat(floatString1);




    }
}
