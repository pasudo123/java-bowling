//package player;
//
//import exception.player.PlayerCreateException;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.*;
//import overturn.OverturnScore;
//import trial.TrialResult;
//import trial.TrialResultType;
//
//import java.util.stream.Stream;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@DisplayName("플레이어는")
//class PlayerTest {
//
//    @DisplayName("이름을 받아 생성된다.")
//    @ParameterizedTest
//    @ValueSource(strings = {"SON", "PAR", "ZUM", "KEE", "LEE"})
//    void create_ValidName_NotNull(final String name){
//        // when
//        final Player player = Player.create(name);
//
//        // then
//        assertThat(player).isNotNull();
//    }
//
//    @DisplayName("이름이 널일 시, 생성되지 못한다.")
//    @ParameterizedTest
//    @NullSource
//    void create_NullString_ExceptionThrown(final String name){
//        // when & then
//        assertThrows(NullPointerException.class, () -> Player.create(name));
//    }
//
//    @DisplayName("이름이 공백 또는 세자리를 넘어갈 시 생성되지 못한다.")
//    @ParameterizedTest
//    @CsvSource({
//        "'', PARK, SUNG, DONG"
//    })
//    void create_InValidName_ExceptionThrown(final String name){
//        // when & then
//        assertThrows(PlayerCreateException.class, () -> Player.create(name));
//    }
//
//    @DisplayName("볼링 게임을 수행한다.")
//    @ParameterizedTest
//    @MethodSource("provideOverturnScore")
//    void playBowlingForRound_success(final Player player, final OverturnScore overturnScore, final TrialResultType expectedResultType){
//        // when
//        final TrialResultType resultType = player.playBowlingForRound(overturnScore);
//
//        // then
//        assertThat(resultType).isEqualTo(expectedResultType);
//    }
//
//    private static Stream<Arguments> provideOverturnScore(){
//        return Stream.of(
//            Arguments.of(Player.create("SON"), new OverturnScore(0), TrialResultType.GUTTER),
//            Arguments.of(Player.create("SON"), new OverturnScore(1), TrialResultType.PROGRESS),
//            Arguments.of(Player.create("SON"), new OverturnScore(2), TrialResultType.PROGRESS),
//            Arguments.of(Player.create("SON"), new OverturnScore(3), TrialResultType.PROGRESS),
//            Arguments.of(Player.create("SON"), new OverturnScore(4), TrialResultType.PROGRESS),
//            Arguments.of(Player.create("SON"), new OverturnScore(5), TrialResultType.PROGRESS),
//            Arguments.of(Player.create("SON"), new OverturnScore(6), TrialResultType.PROGRESS),
//            Arguments.of(Player.create("SON"), new OverturnScore(7), TrialResultType.PROGRESS),
//            Arguments.of(Player.create("SON"), new OverturnScore(8), TrialResultType.PROGRESS),
//            Arguments.of(Player.create("SON"), new OverturnScore(9), TrialResultType.PROGRESS),
//            Arguments.of(Player.create("SON"), new OverturnScore(10), TrialResultType.STRIKE)
//        );
//    }
//}
