package board;

import frame.BowlingFrame;
import frame.impl.FinalFrame;
import frame.impl.NormalFrame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("점수 상태는")
class ShapeStatusTest {

    private static final int LAST_NUMBER_OF_FRAME = 10;

    @ParameterizedTest
    @MethodSource("provideScoreStatus")
    @DisplayName("new 예약어를 통해 생성된다.")
    public void constructor_UseNewKeyword_CreateSuccess(final String name, final List<BowlingFrame> bowlingFrames) {
        // when
        final ShapeStatus shapeStatus = new ShapeStatus(name, bowlingFrames);

        // then
        assertThat(shapeStatus).isNotNull();
    }

    private static Stream<Arguments> provideScoreStatus() {
        return Stream.of(
                Arguments.of("KOK", IntStream.rangeClosed(1, LAST_NUMBER_OF_FRAME)
                        .mapToObj(i -> (i == LAST_NUMBER_OF_FRAME) ? new FinalFrame() : new NormalFrame())
                        .collect(Collectors.toList()))

        );
    }
}
