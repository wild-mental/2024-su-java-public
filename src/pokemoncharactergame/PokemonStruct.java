package pokemoncharactergame;

import java.util.HashMap;
import java.util.Map;

public class PokemonStruct {

    public static final Map<String, PokemonStruct> pokeDex = new HashMap<>();
    static {
        pokeDex.put("Pikachu", new PokemonStruct("Pikachu", 50, "백만볼트", 20));
        pokeDex.put("Kkobugi", new PokemonStruct("Kkobugi", 60 ,"물대포", 15));
        pokeDex.put("Gugu", new PokemonStruct("Gugu", 30, "부리로 쪼기", 10));
        pokeDex.put("Kkoret", new PokemonStruct("kkoret", 40 ,"깨물기", 10));
        pokeDex.put("Ppippi", new PokemonStruct("Ppippi", 100, "손가락 흔들기", 0));
        pokeDex.put("Purin", new PokemonStruct("Purin", 100, "노래부르기", 0));
        pokeDex.put("Unibugi", new EvolvedPokemonStruct(
                "어니부기", 120,
                "물대포", 15,
                "거품광선", 30));
        pokeDex.put("Pixy", new EvolvedPokemonStruct(
                "Pixy", 200,
                "손가락 흔들기", 0,
                "최면 광선", 20));
        pokeDex.put("Pukrin", new EvolvedPokemonStruct(
                "Purin", 200,
                "노래부르기", 0,
                "낙서", 100));
    }
    public static final Map<String, String> pokeEvolveDex = new HashMap<>();
    static {
        pokeEvolveDex.put("Kkobugi", "Unuibugi");
        pokeEvolveDex.put("Ppippi", "Pixy");
        pokeEvolveDex.put("Purin", "Pukrin");
    }

    // 구체적인 사물을 중심으로 묶었더니 편리하더라
    // (능동 - 수동 구분을 할 필요가 없어지더라)
    private String monsterName;
    private String nickName;
    private int hp;
    private int maxHp;
    private String skill1Name;
    private int skill1Dmg;
//    private String skill2Name;
//    private int skill2Dmg;

    public PokemonStruct(String monsterName, int maxHp, String skill1Name, int skill1Dmg) {
        this.monsterName = monsterName;
        this.nickName = "";
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.skill1Name = skill1Name;
        this.skill1Dmg = skill1Dmg;
    };

    public PokemonStruct(String monsterName, String nickName, int maxHp, String skill1Name, int skill1Dmg) {
        this.monsterName = monsterName;
        this.nickName = nickName;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.skill1Name = skill1Name;
        this.skill1Dmg = skill1Dmg;
    };

    @Override
    public String toString() {
        return "PokemonStruct{" +
                "monsterName='" + monsterName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", hp=" + hp +
                ", maxHp=" + maxHp +
                ", skill1Name='" + skill1Name + '\'' +
                ", skill1Dmg=" + skill1Dmg +
                '}';
    }

    public void attack(PokemonStruct targetPokemon) {
        if (targetPokemon.hp > 0) {
            // 피카츄 공격 후 구구 Hp 표시
            System.out.println(this.monsterName + "(이)가" + targetPokemon.monsterName+ "을 공격합니다.");
            System.out.println(this.skill1Name + "기술을 사용합니다.");
            targetPokemon.hp -= this.skill1Dmg;
            System.out.println(targetPokemon.monsterName + "남은 HP:" + targetPokemon.hp);
            if (targetPokemon.hp <= 0) {
                System.out.println(targetPokemon.monsterName + "이 항복했습니다.");
            }
        }
        System.out.println("-------------------------------------");
    }

    public void visitHealingCenter() {
        this.hp = this.maxHp;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public String getSkill1Name() {
        return skill1Name;
    }

    public int getSkill1Dmg() {
        return skill1Dmg;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setSkill1Name(String skill1Name) {
        this.skill1Name = skill1Name;
    }

    public void setSkill1Dmg(int skill1Dmg) {
        this.skill1Dmg = skill1Dmg;
    }

    public EvolvedPokemonStruct evolve() {
        // 진화 전 : 진화 후  // key-value 쌍으로 된 데이터
//        this.monsterName;
//        this.maxHp;
        String newMonsterName = pokeEvolveDex.get(this.monsterName);
        EvolvedPokemonStruct targetEvolveResult;
        if (pokeDex.get(newMonsterName) instanceof EvolvedPokemonStruct) {
            targetEvolveResult = (EvolvedPokemonStruct) pokeDex.get(newMonsterName);
        } else {
            return null;  // 호출부에서 null 처리를 해야 합니다.
        }

        int newMaxHp = targetEvolveResult.getMaxHp();
        String skill2Name = targetEvolveResult.getSkill2Name();
        int skil2Dmg = targetEvolveResult.getSkill1Dmg();
        return new EvolvedPokemonStruct(
                newMonsterName, this.nickName, newMaxHp,
                this.skill1Name, this.skill1Dmg,
                skill2Name, skil2Dmg
        );
    }

//    public String getSkill2Name() {
//        return skill2Name;
//    }
//
//    public void setSkill2Name(String skill2Name) {
//        this.skill2Name = skill2Name;
//    }
//
//    public int getSkill2Dmg() {
//        return skill2Dmg;
//    }
//
//    public void setSkill2Dmg(int skill2Dmg) {
//        this.skill2Dmg = skill2Dmg;
//    }
}
