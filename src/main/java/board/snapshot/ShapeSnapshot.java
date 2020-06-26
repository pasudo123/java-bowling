package board.snapshot;

import model.Result;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static board.snapshot.ShapeSnapshot.Snapshot.*;

public final class ShapeSnapshot {

    private final List<String> snapshot;
    private final boolean isNameSnapShot;

    private ShapeSnapshot(final List<String> snapshot, final boolean isNameSnapShot){
        this.snapshot = snapshot;
        this.isNameSnapShot = isNameSnapShot;
    }

    public static ShapeSnapshot createSnapShotByName(final String name){
        return new ShapeSnapshot(Collections.singletonList(name), true);
    }

    public static ShapeSnapshot createSnapShotEmpty(final int round){
        return new ShapeSnapshot(new ArrayList(){{ add(StringUtils.EMPTY); }}, false);
    }

    public Stream<String> toStream(){
        if(isNameSnapShot){
            return Stream.of(String.join(BAR, snapshot));
        }

        return normalFrameToStream();
    }

    private Stream<String> normalFrameToStream(){
        final List<String> drawSnapshot = new ArrayList<>(snapshot);

        if(sumEq(10)){
            if(drawSnapshot.size() == 1){
                drawSnapshot.remove(0);
                drawSnapshot.add(X);
            } else {
                assert (drawSnapshot.size() == 2);
                drawSnapshot.remove(drawSnapshot.size() - 1);
                drawSnapshot.add(SLASH);
            }
        } else {
            // final frame 은 여기 들어옴.
            for(int i = 0; i < drawSnapshot.size(); i++){
                String snapshot = drawSnapshot.get(i);
                if("0".equals(snapshot)){
                    drawSnapshot.set(i, DASH);
                    continue;
                }

                if("10".equals(snapshot)){
                    drawSnapshot.set(i, X);
                }
            }
        }

        if(drawSnapshot.size() == 3
                && Integer.parseInt(drawSnapshot.get(0)) + Integer.parseInt(drawSnapshot.get(1)) == 10){
            drawSnapshot.set(1, SLASH);
        }

        return Stream.of(String.join(BAR, drawSnapshot));
    }

    public void add(final Result result){
        this.removeFirstEmptySnapshotIfExist();
        snapshot.add(result.getScore());
    }

    private void removeFirstEmptySnapshotIfExist(){
        if(snapshot.size() == 0) {
            return;
        }

        if(StringUtils.EMPTY.equals(snapshot.get(0))){
            snapshot.remove(0);
        }
    }

    private boolean sumEq(int sum){
        return sum == snapshot.stream()
                .filter(this::isNoneEmpty)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private boolean isNoneEmpty(final String element){
        return !StringUtils.isEmpty(element);
    }

    class Snapshot{
        static final String BAR = "|";
        static final String X = "X";
        static final String DASH = "-";
        static final String SLASH = "/";
    }
}
