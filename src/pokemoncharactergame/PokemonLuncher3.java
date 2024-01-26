package pokemoncharactergame;

import java.lang.reflect.Field;

import static java.lang.Math.round;

public class PokemonLuncher3 {
    public static void main(String[] args) {
        PokemonStruct muscleMon = new PokemonStruct("근육몬", "내 근육몬",1000, "4연속 펀치", 400, true);
//        muscleMon.innateEvolveChance;
        System.out.println(muscleMon);

        // 1. 클래스 정보를 (동적으로) 로딩
        Class<?> muscleMonClass = muscleMon.getClass();

        try {
            // 2. 클래스 내에 있는 멤버 정보를 로드.
            Field muscleMonInnateEvolveChance = muscleMonClass.getDeclaredField("innateEvolveChance");
            // 3. 접근 제어자를 임의로 변경할 수 있다.
            muscleMonInnateEvolveChance.setAccessible(true);
            // 4. 해당 필드 정보에 특정 객체를 집어넣고, 해당 객체가 가진 필드 정보를 받아온다.
            float myMuscleMonEvChance = (float) muscleMonInnateEvolveChance.get(muscleMon);
            System.out.println(round(myMuscleMonEvChance*6));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        repEvolveTry(muscleMon, 20);
    }

    static void repEvolveTry(PokemonStruct pokemon, int tryCount) {
        for (int i=0; i <tryCount; i++) {
            PokemonStruct evolveResult = pokemon.evolveByChance();
            System.out.println(evolveResult);
            System.out.println(evolveResult instanceof EvolvedPokemonStruct);
            System.out.println("-----------------------------");
            if (evolveResult instanceof EvolvedPokemonStruct) {
                System.out.println(++i+"차 시도 만에 진화에 성공했습니다.");
                return;
            }
        }
    }
}
