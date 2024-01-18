package pokemoncharactergame;

public class EvolvedPokemonStruct extends PokemonStruct {  // is a 관계를 밝혀준다.
    private String skill2Name;
    private int skill2Dmg;

    public EvolvedPokemonStruct(String monsterName, int maxHp,
                                String skill1Name, int skill1Dmg,
                                String skill2Name, int skill2Dmg) {
        // 원래 있었던 부모를 지칭하는 키워드 super 로 코드 재사용이 가능해졌다.
        super(monsterName, maxHp, skill1Name, skill1Dmg);
        this.skill2Name = skill2Name;
        this.skill2Dmg = skill2Dmg;
    }

    public EvolvedPokemonStruct(String monsterName, String nickName, int maxHp,
                                String skill1Name, int skill1Dmg,
                                String skill2Name, int skill2Dmg) {
        // 원래 있었던 부모를 지칭하는 키워드 super 로 코드 재사용이 가능해졌다.
        super(monsterName, nickName, maxHp, skill1Name, skill1Dmg);
        this.skill2Name = skill2Name;
        this.skill2Dmg = skill2Dmg;
    }

    // 진화 후의 클래스에 위치하면 부적절함 => 여기를 거치지 않고 PokemonStructObj.evolve() 를 직접 사용할 수 있음
//    public EvolvedPokemonStruct pokemonStructEvolve(PokemonStruct beforeEvolution) {
//        EvolvedPokemonStruct afterEvolution = beforeEvolution.evolve();
//        return afterEvolution;
//    }

    @Override
    public String toString() {
        String beforeEvolutionInfo = super.toString();
        return "EvolvedPokemonStruct{" + beforeEvolutionInfo +
                ", skill2Name='" + skill2Name + '\'' +
                ", skill2Dmg=" + skill2Dmg +
                "}";
    }

    public String getSkill2Name() {
        return skill2Name;
    }

    public void setSkill2Name(String skill2Name) {
        this.skill2Name = skill2Name;
    }

    public int getSkill2Dmg() {
        return skill2Dmg;
    }

    public void setSkill2Dmg(int skill2Dmg) {
        this.skill2Dmg = skill2Dmg;
    }

    // 객체 다형성을 일일이 검사해 처리하는 메서드
//    public void crossOcean() {
//        if (this instanceof EvolvedSurfablePokemon) {
//            ((EvolvedSurfablePokemon) this).surf();
//        } else if (this instanceof EvolvedFlyablePokemon) {
//            ((EvolvedFlyablePokemon) this).fly();
//        } else {
//            System.out.println(this.getNickName() +"(은)는 바다를 건널 수 없습니다.");
//        }
//    }

    // 객체 다형성을 일일이 검사해 처리하는 메서드 2
    public static void crossOceanOptions(EvolvedPokemonStruct pokemon) {
        // 객체의 다형성을 가지고 여러가지 수단을 통해 달성될 수 있는 한가지 기능을 처리하는 방법
        if (pokemon instanceof EvolvedSurfablePokemon) {
            ((EvolvedSurfablePokemon) pokemon).surf();
        } else if (pokemon instanceof EvolvedFlyablePokemon) {
            ((EvolvedFlyablePokemon) pokemon).fly();
        } else {
            System.out.println(pokemon.getNickName() +"(은)는 바다를 건널 수 없습니다.");
        }
    }

    // 인터페이스 다형성을 메서드 파라미터 선언에 효과적으로 사용
    public static void crossOcean(ICrossable crossablePokemon) {
        // 인터페이스 추상화 : 동작의 이름을 합의하는 과정임
        crossablePokemon.crossOcean();
    }
}
