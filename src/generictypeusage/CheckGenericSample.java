package generictypeusage;

public class CheckGenericSample {
    public static void main(String[] args) {
        // Non-generic 사용시 타입 불안
        checkNonGeneric();
        checkNonGenericHardCase();

        // Generic 사용시 타입 안정
        checkGeneric();
    }

    public static void checkNonGeneric() {
        System.out.println("--------------- Non Generic DTO (Easy Case)---------------");
        NonGenericDTO dto1 = new NonGenericDTO();
        dto1.setObject((int)1);
        NonGenericDTO dto2 = new NonGenericDTO();
        dto2.setObject((float)1.1234567f);
        NonGenericDTO dto3 = new NonGenericDTO();
        dto3.setObject((double)1.123456789012345d);

        int dto1Value = (int)dto1.getObject();
        float dto2Value = (float) dto2.getObject();
        double dto3Value = (double) dto3.getObject();

        System.out.printf("%d, %.7f, %.15f", dto1Value, dto2Value, dto3Value);
        System.out.println();
        System.out.println("----------------------------------------------------------");
    }

    public static void checkNonGenericHardCase() {
        System.out.println("--------------- Non Generic DTO (Hard Case) ---------------");
        NonGenericDTO dto1 = new NonGenericDTO();
        dto1.setObject((int)1);
        NonGenericDTO dto2 = new NonGenericDTO();
        dto2.setObject((float)1.1234567f);
        NonGenericDTO dto3 = new NonGenericDTO();
        dto3.setObject((double)1.123456789012345d);
        NonGenericDTO[] ngDtoArr = {dto1, dto2, dto3};

//        StringBuilder stringBuilder = new StringBuilder();
        String typeCheckResult = "";
        int dtoProcessCnt = 1;
        for (NonGenericDTO ngDto: ngDtoArr) {
            Object ngDtoObj = ngDto.getObject();
            String ngDtoType = NonGenericTypeChecker(ngDtoObj);
            switch (ngDtoType) {
                case "Integer": {
                    int dtoValue = (int)ngDtoObj;
                    typeCheckResult += String.format("%d", dtoValue);
//                    stringBuilder.append("dtovalue").append(dtoProcessCnt).append(": ").append(String.format("%d", dtoValue)).append("\n");
                    break;
                }
                case "Float": {
                    float dtoValue = (float)ngDtoObj;
                    typeCheckResult += String.format("%.7f", dtoValue);
//                    stringBuilder.append("dtovalue").append(dtoProcessCnt).append(": ").append(String.format("%.7f", dtoValue)).append("\n");
                    break;
                }
                case "Double": {
                    double dtoValue = (double)ngDtoObj;
                    typeCheckResult += String.format("%.15f", dtoValue);
//                    stringBuilder.append("dtovalue").append(dtoProcessCnt).append(": ").append(String.format("%.15f", dtoValue));
                    break;
                }
                default: {
                    continue;
                }
            }
            if (ngDtoArr.length > dtoProcessCnt) {
                typeCheckResult += ", ";
            }
            dtoProcessCnt++;
        }
        System.out.println(typeCheckResult);
//        System.out.println(stringBuilder);
        System.out.println("----------------------------------------------------------");
    }

    public static String NonGenericTypeChecker(Object obj) {
        if (obj instanceof Integer) {
            return "Integer";
        } else if (obj instanceof Float) {
            return "Float";
        } else if (obj instanceof Double) {
            return "Double";
        } else {
            return "Unknown obj type for NonGenericDTO";
        }
    }

    public static void checkGeneric() {
//        GenericDTO<Integer, Float, Double> threeTypeGeneric = new GenericDTO<>();
        System.out.println("----------------------- Generic DTO-----------------------");
        GenericDTO<Integer> genericDto1 = new GenericDTO<>();
        genericDto1.setObject(1);
        GenericDTO<Float> genericDto2 = new GenericDTO<>();
        genericDto2.setObject(1.1234567f);
        GenericDTO<Double> genericDto3 = new GenericDTO<>();
        genericDto3.setObject(1.123456789012345d);

        int genDtoValue1 = genericDto1.getObject();
        float genDtoValue2 = genericDto2.getObject();
        double genDtoValue3 = genericDto3.getObject();

        System.out.printf("%d, %.7f, %.15f", genDtoValue1, genDtoValue2, genDtoValue3);
        System.out.println();
        System.out.println("----------------------------------------------------------");
    }
}
