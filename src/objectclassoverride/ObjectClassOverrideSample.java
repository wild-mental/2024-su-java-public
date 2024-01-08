package objectclassoverride;

public class ObjectClassOverrideSample extends Object {
    int field1;
    String field2;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        // 비교 로직 추가

        return false;
    }

    @Override
    public int hashCode() {
        // 해시 코드 계산 로직 추가
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "field1=" + field1 +
                ", field2=" + field2 +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 복제 로직 추가
        return super.clone();
    }

    @Override
    protected void finalize() {
        try {
            System.out.println("객체를 더이상 사용하지 않기 때문에 GC에 회수를 요청합니다.");
            super.finalize();
        } catch (Throwable e) {
            System.err.println("finalize 호출 중 에러가 발생했습니다.");
        }
    }
}
