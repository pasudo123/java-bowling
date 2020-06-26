//package frame;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import overturn.OverturnScore;
//import player.Player;
//import trial.TrialResultType;
//
//import java.util.Map;
//import java.util.stream.Stream;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DisplayName("볼링 프레임은")
//class BowlingFramesTest {
//
//    @Test
//    @DisplayName("생성된다.")
//    void createTest() {
//        // when
//        final BowlingFrames bowlingFrames = BowlingFrames.create();
//
//        // then
//        assertThat(bowlingFrames).isNotNull();
//    }
//
//    @DisplayName("볼링을 넘어트리고 결과상태를 반환한다.")
//    @ParameterizedTest(name = "{0} 개의 볼링을 넘어트린다.")
//    @MethodSource("provideOverturnScore")
//    void overturnTest(final int number, final TrialResultType expectedResultType) {
//        // given
//        final int round = 1;
//
//        // when
//        final BowlingFrames bowlingFrames = BowlingFrames.create();
//        final Map<FrameNumber, TrialResultType> results = bowlingFrames.overturn(new OverturnScore(number));
//
//        // then
//        assertThat(results.get(new FrameNumber(1))).isSameAs(expectedResultType);
//    }
//
//    private static Stream<Arguments> provideOverturnScore(){
//        return Stream.of(
//                Arguments.of(0, TrialResultType.PROGRESS),
//                Arguments.of(1, TrialResultType.PROGRESS),
//                Arguments.of(2, TrialResultType.PROGRESS),
//                Arguments.of(3, TrialResultType.PROGRESS),
//                Arguments.of(4, TrialResultType.PROGRESS),
//                Arguments.of(5, TrialResultType.PROGRESS),
//                Arguments.of(6, TrialResultType.PROGRESS),
//                Arguments.of(7, TrialResultType.PROGRESS),
//                Arguments.of(8, TrialResultType.PROGRESS),
//                Arguments.of(9, TrialResultType.PROGRESS),
//                Arguments.of(10, TrialResultType.STRIKE)
//        );
//    }
//}
