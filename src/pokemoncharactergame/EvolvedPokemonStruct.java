package pokemoncharactergame;

public class EvolvedPokemonStruct extends PokemonStruct{  // is a 관계를 밝혀준다.
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

    public EvolvedPokemonStruct pokemonStructEvolve(PokemonStruct beforeEvolution) {
        EvolvedPokemonStruct afterEvolution = beforeEvolution.evolve();
        return afterEvolution;
    }

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
}
