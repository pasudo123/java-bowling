//package frame;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import trial.TrialResult;
//import trial.TrialResultType;
//
//import java.util.stream.Stream;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.params.provider.Arguments.arguments;
//
//@DisplayName("프레임 번호는")
//class FrameNumberTest {
//
//    @DisplayName("볼링을 결과 타입에 따라서 현재 프레임 번호를 증가시킨다.")
//    @ParameterizedTest
//    @MethodSource("provideTrialResultType")
//    public void increaseByTrialTypeTest(final int frameIndex, final TrialResultType trialResultType, final int expectedFrameIndex){
//
//        // given
//        final FrameNumber frameNumber = new FrameNumber(frameIndex);
//
//        // when
//        frameNumber.increaseByTrialType(trialResultType);
//
//        // then
//        assertThat(frameNumber.get()).isSameAs(expectedFrameIndex);
//    }
//
//    private static Stream<Arguments> provideTrialResultType(){
//        return Stream.of(
//            arguments(0, TrialResultType.PROGRESS, 0),
//            arguments(0, TrialResultType.SPARE, 1),
//            arguments(0, TrialResultType.STRIKE, 1)
//        );
//    }
//}
