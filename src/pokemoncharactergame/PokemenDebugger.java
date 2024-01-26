package pokemoncharactergame;

import java.lang.reflect.Field;

import static java.lang.Math.round;

public class PokemenDebugger {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        // PokemonStruct 클래스의 객체 생성
        PokemonStruct pokemon = new PokemonStruct("근육몬", 1000, "4연속 펀치", 200);
        System.out.println(pokemon);
        // PokemonStruct 클래스의 Class 객체 가져오기
        Class<?> pokemonClass = pokemon.getClass();
        // private 필드인 innateEvolutionChance에 접근하기 위해 Field 객체 가져오기
        Field innateEvolutionChanceField = pokemonClass.getDeclaredField("innateEvolutionChance");
        // private 필드에 접근 가능하도록 설정
        innateEvolutionChanceField.setAccessible(true);
        // private 필드의 값을 가져오기
        float innateEvolutionChanceValue = innateEvolutionChanceField.getFloat(pokemon);
        // 결과 출력
        System.out.println("innateEvolutionChance 값: " + innateEvolutionChanceValue);
        System.out.println("innateEvolutionChance 에 따른 minumumDiceNeeded 값: " + round(innateEvolutionChanceValue*6));

        PokemonLuncher3.tryEvolutionByChance(pokemon, 20);
    }
}
