package board;

import frame.BowlingFrame;
import model.Result;

import java.util.ArrayList;
import java.util.List;

public class BowlingBoard {

    private final FrameStatus frameStatus;
    private final ShapeStatus shapeStatus;
    private final ScoreStatus scoreStatus;

    public BowlingBoard(final String name, final List<BowlingFrame> bowlingFrames){
        frameStatus = new FrameStatus();
        shapeStatus = new ShapeStatus(name, bowlingFrames);
        scoreStatus = new ScoreStatus();
    }

    public List<List<String>> getBowingStatus(){
        final List<List<String>> status = new ArrayList<>();
        status.add(frameStatus.getFrameStatus());
        status.add(shapeStatus.getShapeStatus());
        status.add(scoreStatus.getScoreStatus());
        return status;
    }

    public Result fillScoreBoard(final Result result){
        shapeStatus.fillShapeByFrameNumber(result.getCurrentFrameNumber())
                .add(result);
        scoreStatus.fillScoreByResult(shapeStatus.getPartialShapeStatus(result), result);

        return result.attach(this);
    }
}
