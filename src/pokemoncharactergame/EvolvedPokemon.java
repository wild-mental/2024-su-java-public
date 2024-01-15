package pokemoncharactergame;

public class EvolvedPokemon {
    private String monsterName;
    private int hp;
    private int maxHp;
    private String skill1Name;
    private int skill1Dmg;
    private String skill2Name;
    private int skill2Dmg;

    public EvolvedPokemon(String monsterName, int maxHp,
                          String skill1Name, int skill1Dmg,
                          String skill2Name, int skill2Dmg) {
        this.monsterName = monsterName;
        this.maxHp = maxHp;
        this.skill1Name = skill1Name;
        this.skill1Dmg = skill1Dmg;
        this.skill2Name = skill2Name;
        this.skill2Dmg = skill2Dmg;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public String getSkill1Name() {
        return skill1Name;
    }

    public void setSkill1Name(String skill1Name) {
        this.skill1Name = skill1Name;
    }

    public int getSkill1Dmg() {
        return skill1Dmg;
    }

    public void setSkill1Dmg(int skill1Dmg) {
        this.skill1Dmg = skill1Dmg;
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
