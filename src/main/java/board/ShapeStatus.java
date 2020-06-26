package board;

import board.snapshot.ShapeSnapshot;
import exception.board.ScoreStatusCreateException;
import frame.BowlingFrame;
import model.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static player.PlayerConstant.MAXIMUM_NAME_LENGTH;
import static player.PlayerConstant.MINIMUM_NAME_LENGTH;

public class ShapeStatus {

    private final List<ShapeSnapshot> SHAPE_STATUS = new ArrayList<>();

    public ShapeStatus(final String name, final List<BowlingFrame> bowlingFrames){
        verifyPlayerName(name);
        verifyBowlingFrames(bowlingFrames);

        SHAPE_STATUS.add(ShapeSnapshot.createSnapShotByName(name));
        SHAPE_STATUS.addAll(IntStream.range(1, bowlingFrames.size())
                .mapToObj(ShapeSnapshot::createSnapShotEmpty)
                .collect(Collectors.toList()));
    }

    private void verifyPlayerName(final String name){
        Objects.requireNonNull(name, "플레이어의 이름은 널이 될 수 없습니다.");

        if(name.length() < MINIMUM_NAME_LENGTH
                || name.length() > MAXIMUM_NAME_LENGTH){
            throw new ScoreStatusCreateException("플레이어의 이름은 세자리를 초과하거나 공백이 될 수 없습니다.");
        }
    }

    private void verifyBowlingFrames(final List<BowlingFrame> bowlingFrames) {
        Objects.requireNonNull(bowlingFrames, "볼링 점수 목록은 널이 될 수 없습니다.");

        if(bowlingFrames.size() < 10){
            throw new ScoreStatusCreateException("볼링 점수 프레임의 크기가 10 미만이기 때문에 점수 현황판을 생성할 수 없습니다.");
        }
    }

    public List<String> getShapeStatus() {
        return Collections.unmodifiableList(SHAPE_STATUS.stream()
                .flatMap(ShapeSnapshot::toStream)
                .collect(Collectors.toList()));
    }

    public List<ShapeSnapshot> getPartialShapeStatus(final Result result) {
        return Collections.unmodifiableList(
                IntStream.of(result.getPreviousFrameNumberByStep(2), result.getCurrentFrameNumber())
                        .filter(this::isIncludeRange)
                        .mapToObj(SHAPE_STATUS::get)
                        .collect(Collectors.toList()));
    }

    private boolean isIncludeRange(final int sequence) {
        return sequence >= 1;
    }

    public ShapeSnapshot fillShapeByFrameNumber(final int frameNumber){
        return SHAPE_STATUS.get(frameNumber);
    }
}
