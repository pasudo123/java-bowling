package board.snapshot;

import model.Result;
import org.apache.commons.lang3.StringUtils;

public class ScoreSnapshot {
    private static final int NONE = -1;

    private final int frameNumber;
    private int currentScore = NONE;

    public ScoreSnapshot(){
        this.frameNumber = 0;
    }

    public ScoreSnapshot(final int frameNumber) {
        this.frameNumber = frameNumber;
    }

    public void add(final Result result) {
    }

    public String getScore(){
        return (currentScore == NONE)
                ? StringUtils.EMPTY
                : String.valueOf(currentScore);
    }
}
