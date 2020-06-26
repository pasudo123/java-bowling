package board;

import board.snapshot.ScoreSnapshot;
import board.snapshot.ShapeSnapshot;
import model.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScoreStatus {

    private static final List<ScoreSnapshot> SCORE_STATUS = new ArrayList<>();

    static {
        SCORE_STATUS.add(new ScoreSnapshot());
        SCORE_STATUS.addAll(IntStream.rangeClosed(1, 10)
                .mapToObj(ScoreSnapshot::new)
                .collect(Collectors.toList()));
    }

    public List<String> getScoreStatus() {
        return Collections.unmodifiableList(SCORE_STATUS.stream()
                .map(ScoreSnapshot::getScore)
                .collect(Collectors.toList()));
    }

    public List<ScoreSnapshot> fillScoreByResult(final List<ShapeSnapshot> shapeList, final Result result) {

        if(!result.isNextRound()){
           return null;
        }

        final List<ShapeSnapshot> shapeSnapshots = new ArrayList<>(shapeList);
        final List<ScoreSnapshot> scoreSnapshots = IntStream.of(result.getPreviousFrameNumberByStep(2), result.getCurrentFrameNumber())
                .filter(this::isIncludeRange)
                .mapToObj(SCORE_STATUS::get)
                .collect(Collectors.toList());



        return Collections.emptyList();
    }

    private boolean isIncludeRange(final int sequence){
        return sequence >= 1;
    }
}
