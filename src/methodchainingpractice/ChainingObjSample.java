package methodchainingpractice;

public class ChainingObjSample {
    int chainCount = 0;
    public ChainingObjSample chainMethod() {
        this.chainCount += 1;
        System.out.printf("Current chainCount is %d\n", this.chainCount);
        return this;
    }

    public int endChaining() {
        this.chainCount += 1;
        System.out.printf("chaining ends at count %d\n", this.chainCount);
        return this.chainCount;
    }
}
