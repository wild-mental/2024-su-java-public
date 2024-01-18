package pokemoncharactergame;

// 자식 객체로 추상화하는 패턴
//  : Java 에서 지원하는 Interface 추상화의 기본 방향과 맞지 않음
// (1) 부모인 두 인터페이스 IFlyable 와 ISurfable 가 추상적인 수준에서 이미 crossOcean() 을 default 메서드로 구현했기 때문에,
//     이 클래스에서 crossOcean() 을 반드시 구현해야 함
// (2) crossOcean() 이 인스턴스 메서드로 선언된 상태이기에,
//     인스턴스가 어떤 타입인지에 따라 적절한 Interface 를 사용할 수 있는데,
//     ContinentCrossable 클래스의 인스턴스는 항상 IFlyable 이기도 하고 ISurfable 이기도 하므로 도저히 적절한 처리를 할 수 없음
//   => crossOcean 동작에 대한 적절한 구현 불가능
public class OceanCrossable implements IFlyable, ISurfable{
    @Override
    public void fly() {
    }

    @Override
    public void crossOcean() {
    }

    @Override
    public void surf() {
    }

    public void crossOcean(ICrossable crossable) {
        crossable.crossOcean();
    }
}
