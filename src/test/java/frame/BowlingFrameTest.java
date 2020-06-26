//package frame;
//
//import frame.impl.FinalFrame;
//import frame.impl.NormalFrame;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import overturn.OverturnScore;
//import trial.TrialResult;
//import trial.TrialResultType;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Stream;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.params.provider.Arguments.arguments;
//
//@DisplayName("볼링 프레임은")
//class BowlingFrameTest {
//
//    @DisplayName("1 ~ 9 프레임에 있는 핀을 넘어트리고 결과를 반환한다.")
//    @ParameterizedTest
//    @MethodSource("provideOverturnScore")
//    void decreasePinsAndGetResult_NormalFrameTest(final int overturnScore, final TrialResultType expectedTrialResultType) {
//        // given
//        final BowlingFrame bowlingFrame = new NormalFrame();
//
//        // when
//        final TrialResult trialResult = bowlingFrame.decreasePinsAndGetResult(new OverturnScore(overturnScore));
//
//        // then
//        assertThat(trialResult.getTrialResultType()).isEqualTo(expectedTrialResultType);
//    }
//
//    @DisplayName("10 프레임에 있는 핀을 넘어트리고 결과를 반환한다.")
//    @ParameterizedTest
//    @MethodSource("provideOverturnScore")
//    void decreasePinsAndGetResult_FinalFrameTest(final int overturnScore, final TrialResultType expectedTrialResultType) {
//        // given
//        final BowlingFrame bowlingFrame = new FinalFrame();
//
//        // when
//        final TrialResult trialResult = bowlingFrame.decreasePinsAndGetResult(new OverturnScore(overturnScore));
//
//        // then
//        assertThat(trialResult.getTrialResultType()).isEqualTo(expectedTrialResultType);
//    }
//
//    @DisplayName("10 프레임에 있는 핀을 넘어트려 보너스까지 획득한다.")
//    @ParameterizedTest
//    @MethodSource("provideOverturnScores")
//    void decreasePinsAndGetResult_FinalFrame_ReturnBonusTest(final List<OverturnScore> overturnScoreList, final List<TrialResultType> expectedTrialResultTypes){
//        // given
//        final BowlingFrame bowlingFrame = new FinalFrame();
//
//        final int index = 0;
//
//        // when & then
//        for(int i = index; i < overturnScoreList.size(); i++){
//            final TrialResult trialResult = bowlingFrame.decreasePinsAndGetResult(overturnScoreList.get(i));
//            assertThat(trialResult.getTrialResultType()).isEqualTo(expectedTrialResultTypes.get(i));
//        }
//    }
//
//    @DisplayName("10 프레임의 보너스 핀까지 넘어트린다.")
//    @ParameterizedTest
//    @MethodSource("provideOverturnBonusScore")
//    void decreasePinsAndGetResult_FinalFrame_BonusOverturn(){
//
//    }
//
//    private static Stream<Arguments> provideOverturnScore(){
//        return Stream.of(
//                arguments(0, TrialResultType.PROGRESS),
//                arguments(1, TrialResultType.PROGRESS),
//                arguments(2, TrialResultType.PROGRESS),
//                arguments(3, TrialResultType.PROGRESS),
//                arguments(4, TrialResultType.PROGRESS),
//                arguments(5, TrialResultType.PROGRESS),
//                arguments(6, TrialResultType.PROGRESS),
//                arguments(7, TrialResultType.PROGRESS),
//                arguments(8, TrialResultType.PROGRESS),
//                arguments(9, TrialResultType.PROGRESS),
//                arguments(10, TrialResultType.BONUS)
//        );
//    }
//
//    private static Stream<Arguments> provideOverturnScores(){
//        return Stream.of(
//                arguments(Arrays.asList(new OverturnScore(5), new OverturnScore(5)),
//                        Arrays.asList(TrialResultType.PROGRESS, TrialResultType.BONUS)),
//
//                arguments(Collections.singletonList(new OverturnScore(10)),
//                        Collections.singletonList(TrialResultType.BONUS))
//        );
//    }
//}
