package pokemoncharactergame;

public class PokemonLuncher3 {
    public static void main(String[] args) {
        // PokemonStruct 클래스의 객체 생성
        PokemonStruct pokemon = new PokemonStruct("근육몬", 1000, "4연속 펀치", 200);
        // private 필드의 값을 조회할 수 없음
//        System.out.println(pokemon.innateEvolutionChance);
        System.out.println(pokemon);

        // 주구장창 돌려보며 진화 시도
        tryEvolutionByChance(pokemon, 20);
    }

    static void tryEvolutionByChance(PokemonStruct pokemon, int tryReps) {
        for (int i = 0; i<tryReps; i++) {
            PokemonStruct evolvedPokemon = pokemon.evolveByInnateChance();
            System.out.println(evolvedPokemon);
            if (evolvedPokemon instanceof EvolvedPokemonStruct) {
                System.out.printf("[%d회의 시도만에 진화에 성공했습니다.]\n", i+1);
                break;
            }
        }
    }
}
