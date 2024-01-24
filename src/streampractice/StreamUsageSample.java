package streampractice;

import pokemoncharactergame.PokemonStruct;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamUsageSample {
    public static void main(String[] args) {
        int[] values = { -1, -2, -3, -4, -5, 0, 1, 2, 3, 4, 5 };
        IntStream intStream = Arrays.stream(values);
        // 일괄적으로 메서드를 (클래스 단위가 아니라) 동작 단위로 핸들링 한다.
        IntPredicate a2 = x ->  x > 0;
        int naturalNumCnt = (int)intStream.filter(a2).count();

        List<Integer> valuesList = Arrays.asList( -1, -2, -3, -4, -5, 0, 1, 2, 3, 4, 5 );
        Stream<Integer> integerStream2 = valuesList.stream();
        Predicate<Integer> a1 = x ->  x > 0;
        Stream<Integer> integerStream2_1 = integerStream2.filter(a1);

        List<PokemonStruct> pokemonList = new ArrayList<>();
        pokemonList.add(new PokemonStruct("myPokemon", 1, "mySkill", 1));
        Stream<PokemonStruct> pokemonStream = pokemonList.stream();
        Predicate<PokemonStruct> pokemonStructPredicate = pokemonStruct -> pokemonStruct.getHp() > 0;
        Stream<PokemonStruct> filteredPokemon = pokemonStream.filter(pokemonStructPredicate);

        System.out.println(naturalNumCnt);
        List<Integer> numbers = Arrays.asList( -10, -20, -30, -40, -50, 0, 10, 20, 30, 40, 50 );
        Stream<Integer> integerStream = numbers.stream();
        List<Integer> negativeNumList = integerStream.filter(x -> x < 0).collect(Collectors.toList());
        System.out.println(negativeNumList);

        Map<String, Integer> dataMap = new HashMap<>();
        dataMap.put("One", 1);
        dataMap.put("Two", 2);
        dataMap.put("Three", 3);
        dataMap.put("Four", 4);
        dataMap.put("Five", 5);
        Map<Integer, String> reversedMap = dataMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 3)
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        System.out.println(reversedMap);
        reversedMap.entrySet().forEach(System.out::println);
    }
}
