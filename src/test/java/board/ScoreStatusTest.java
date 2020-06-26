package board;

import model.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("스코어 상태판은")
class ScoreStatusTest {

    @Test
    @DisplayName("생성된다.")
    public void constructorTest(){
        final ScoreStatus scoreStatus = new ScoreStatus();
        assertThat(scoreStatus).isNotNull();
    }

    @Test
    @DisplayName("생성되고, 11개의 모양판이 만들어진다.")
    public void constructorTest_ShouldReturn_11(){
        final ScoreStatus scoreStatus = new ScoreStatus();

    }

    @Test
    @DisplayName("점수 현황판을 채운다.")
    public void fillScoreByResultTest(){
//        final Result result = new Result();
    }
}
