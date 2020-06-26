package model;

import board.BowlingBoard;
import frame.FrameNumber;
import overturn.OverturnScore;

public class Result {
    private final FrameNumber frameNumber;
    private final OverturnScore overturnScore;
    private final FrameResult frameResult;
    private final TrialOrder trialOrder;

    private BowlingBoard bowlingBoard;

    public Result(FrameNumber frameNumber,
                  OverturnScore overturnScore,
                  FrameResult frameResult,
                  TrialOrder trialOrder,
                  BowlingBoard bowlingBoard) {
        this(frameNumber, overturnScore, frameResult, trialOrder);
        this.bowlingBoard = bowlingBoard;
    }

    public Result(final FrameNumber frameNumber,
                  final OverturnScore overturnScore,
                  final FrameResult frameResult,
                  final TrialOrder trialOrder) {
        this.frameNumber = frameNumber;
        this.overturnScore = overturnScore;
        this.frameResult = frameResult;
        this.trialOrder = trialOrder;
    }

    public int getCurrentFrameNumber() {
        return frameNumber.number();
    }

    public int getPreviousFrameNumberByStep(final int step){
        return frameNumber.number() - step;
    }

    public String getScore() {
        return String.valueOf(overturnScore.getOverturnPins());
    }

    public Result attach(final BowlingBoard bowlingBoard) {
        return new Result(frameNumber, overturnScore, frameResult, trialOrder, bowlingBoard);
    }

    public BowlingBoard getCurrentBowlingBoard() {
        return bowlingBoard;
    }

    public boolean isStrike(){
        return frameResult.isStrike();
    }

    public boolean isSpare(){
        return frameResult.isSpare();
    }

    public boolean isNextRound() {
        return (frameResult.isStrike()
                || frameResult.isSpare()
                || this.isNormalFrameLastTrial());
    }

    public boolean isEnd() {
        return (isFinalFrameLastTrial() && (frameResult.isBonus() || frameResult.isNormal()));
    }

    private boolean isNormalFrameLastTrial() {
        return (trialOrder.getOrder() == 2 && frameNumber.number() != 10);
    }

    private boolean isFinalFrameLastTrial() {
        return (trialOrder.getOrder() == 2 && frameNumber.number() == 10);
    }
}
